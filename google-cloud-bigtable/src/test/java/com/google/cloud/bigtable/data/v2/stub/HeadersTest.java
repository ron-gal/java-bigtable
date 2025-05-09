/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.PrepareQueryRequest;
import com.google.bigtable.v2.PrepareQueryResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.rpc.Status;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HeadersTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";

  private static final String INSTANCE_NAME =
      "projects%2F" + PROJECT_ID + "%2Finstances%2F" + INSTANCE_ID;
  private static final String TABLE_NAME = INSTANCE_NAME + "%2Ftables%2F" + TABLE_ID;
  private static final String APP_PROFILE_ID = "fake-profile";
  private static final String TEST_FIXED_HEADER_STRING = "test_fixed_header";

  private static final Metadata.Key<String> X_GOOG_REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> API_CLIENT_HEADER_KEY =
      Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> TEST_FIXED_HEADER =
      Metadata.Key.of(TEST_FIXED_HEADER_STRING, Metadata.ASCII_STRING_MARSHALLER);

  private Server server;
  private BlockingQueue<Metadata> sentMetadata = new ArrayBlockingQueue<>(10);

  private BigtableDataClient client;

  @Before
  public void setUp() throws Exception {
    server =
        FakeServiceBuilder.create(new FakeBigtableService())
            .intercept(new MetadataInterceptor())
            .start();

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID);

    HeaderProvider headerProvider =
        FixedHeaderProvider.create(TEST_FIXED_HEADER_STRING, "test_header_value");

    // Force immediate flush
    settings
        .stubSettings()
        .setHeaderProvider(headerProvider)
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            settings.stubSettings().bulkMutateRowsSettings().getBatchingSettings().toBuilder()
                .setElementCountThreshold(1L)
                .build());

    client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() throws Exception {
    client.close();
    server.shutdown();
  }

  @Test
  public void readRowsTest() {
    client.readRows(Query.create(TABLE_ID));
    verifyHeaderSent();
  }

  @Test
  public void sampleRowKeysTest() {
    client.sampleRowKeysAsync(TABLE_ID);
    verifyHeaderSent();
  }

  @Test
  public void mutateRowTest() {
    client.mutateRowAsync(RowMutation.create(TABLE_ID, "fake-key").deleteRow());
    verifyHeaderSent();
  }

  @Test
  public void mutateRowsTest() throws InterruptedException {
    try (Batcher<RowMutationEntry, Void> batcher = client.newBulkMutationBatcher(TABLE_ID)) {
      batcher.add(RowMutationEntry.create("fake-key").deleteRow());
    } catch (RuntimeException e) {
      // Ignore the errors: none of the methods are actually implemented
    }
    verifyHeaderSent();
  }

  @Test
  public void checkAndMutateRowTest() {
    client.checkAndMutateRowAsync(
        ConditionalRowMutation.create(TABLE_ID, "fake-key").then(Mutation.create().deleteRow()));
    verifyHeaderSent();
  }

  @Test
  public void readModifyWriteTest() {
    client.readModifyWriteRowAsync(
        ReadModifyWriteRow.create(TABLE_ID, "fake-key").increment("cf", "q", 1));
    verifyHeaderSent();
  }

  @Test
  public void executeQueryTest() {
    PreparedStatement preparedStatement =
        preparedStatement(metadata(columnMetadata("foo", stringType())));
    client.executeQuery(preparedStatement.bind().build());
    verifyHeaderSent(true);
  }

  @Test
  public void prepareQueryTest() {
    client.prepareStatement("SELECT * FROM table", new HashMap<>());
    verifyHeaderSent(true);
  }

  private void verifyHeaderSent() {
    verifyHeaderSent(false);
  }

  private void verifyHeaderSent(boolean useInstance) {
    Metadata metadata;
    try {
      metadata = sentMetadata.take();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    String requestParamsvalue = metadata.get(X_GOOG_REQUEST_PARAMS_KEY);
    if (useInstance) {
      assertThat(requestParamsvalue).containsMatch("(^|.*&)name=" + INSTANCE_NAME + "($|&.*)");
    } else {
      assertThat(requestParamsvalue).containsMatch("(^|.*&)table_name=" + TABLE_NAME + "($|&.*)");
    }
    assertThat(requestParamsvalue)
        .containsMatch("(^|.*&)app_profile_id=" + APP_PROFILE_ID + "($|&.*)");

    String apiClientValue = metadata.get(API_CLIENT_HEADER_KEY);
    assertThat(apiClientValue).containsMatch("gl-java/[.\\d_]+");
    assertThat(apiClientValue).containsMatch("gax/[.\\d_]+");
    assertThat(apiClientValue).containsMatch("grpc/[.\\d_]+");

    String fixedHeader = metadata.get(TEST_FIXED_HEADER);
    assertThat(fixedHeader).isEqualTo("test_header_value");
  }

  private class MetadataInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      sentMetadata.add(metadata);

      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  private static class FakeBigtableService extends BigtableGrpc.BigtableImplBase {
    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      responseObserver.onCompleted();
    }

    @Override
    public void sampleRowKeys(
        SampleRowKeysRequest request, StreamObserver<SampleRowKeysResponse> responseObserver) {
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      responseObserver.onNext(
          MutateRowsResponse.newBuilder()
              .addEntries(
                  MutateRowsResponse.Entry.newBuilder()
                      .setIndex(0)
                      .setStatus(Status.getDefaultInstance()))
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request,
        StreamObserver<CheckAndMutateRowResponse> responseObserver) {
      responseObserver.onNext(CheckAndMutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request,
        StreamObserver<ReadModifyWriteRowResponse> responseObserver) {
      responseObserver.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void prepareQuery(
        PrepareQueryRequest request, StreamObserver<PrepareQueryResponse> responseObserver) {
      responseObserver.onNext(
          // Need to set metadata for response to parse
          PrepareQueryResponse.newBuilder()
              .setMetadata(metadata(columnMetadata("foo", stringType())))
              .build());
      responseObserver.onCompleted();
    }
  }
}
