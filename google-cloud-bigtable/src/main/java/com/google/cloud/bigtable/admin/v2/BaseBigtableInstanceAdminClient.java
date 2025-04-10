/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.CreateLogicalViewMetadata;
import com.google.bigtable.admin.v2.CreateLogicalViewRequest;
import com.google.bigtable.admin.v2.CreateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.CreateMaterializedViewRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.DeleteLogicalViewRequest;
import com.google.bigtable.admin.v2.DeleteMaterializedViewRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.GetLogicalViewRequest;
import com.google.bigtable.admin.v2.GetMaterializedViewRequest;
import com.google.bigtable.admin.v2.HotTablet;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListHotTabletsRequest;
import com.google.bigtable.admin.v2.ListHotTabletsResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.ListLogicalViewsRequest;
import com.google.bigtable.admin.v2.ListLogicalViewsResponse;
import com.google.bigtable.admin.v2.ListMaterializedViewsRequest;
import com.google.bigtable.admin.v2.ListMaterializedViewsResponse;
import com.google.bigtable.admin.v2.LogicalView;
import com.google.bigtable.admin.v2.LogicalViewName;
import com.google.bigtable.admin.v2.MaterializedView;
import com.google.bigtable.admin.v2.MaterializedViewName;
import com.google.bigtable.admin.v2.PartialUpdateClusterMetadata;
import com.google.bigtable.admin.v2.PartialUpdateClusterRequest;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewRequest;
import com.google.bigtable.admin.v2.UpdateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.UpdateMaterializedViewRequest;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class BaseBigtableInstanceAdminClient implements BackgroundResource {
  private final BaseBigtableInstanceAdminSettings settings;
  private final BigtableInstanceAdminStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of BaseBigtableInstanceAdminClient with default settings. */
  public static final BaseBigtableInstanceAdminClient create() throws IOException {
    return create(BaseBigtableInstanceAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BaseBigtableInstanceAdminClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final BaseBigtableInstanceAdminClient create(
      BaseBigtableInstanceAdminSettings settings) throws IOException {
    return new BaseBigtableInstanceAdminClient(settings);
  }

  /**
   * Constructs an instance of BaseBigtableInstanceAdminClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(BaseBigtableInstanceAdminSettings).
   */
  public static final BaseBigtableInstanceAdminClient create(BigtableInstanceAdminStub stub) {
    return new BaseBigtableInstanceAdminClient(stub);
  }

  /**
   * Constructs an instance of BaseBigtableInstanceAdminClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BaseBigtableInstanceAdminClient(BaseBigtableInstanceAdminSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BigtableInstanceAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected BaseBigtableInstanceAdminClient(BigtableInstanceAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final BaseBigtableInstanceAdminSettings getSettings() {
    return settings;
  }

  public BigtableInstanceAdminStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an instance within a project.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String instanceId = "instanceId902024336";
   *   Instance instance = Instance.newBuilder().build();
   *   Map<String, Cluster> clusters = new HashMap<>();
   *   Instance response =
   *       baseBigtableInstanceAdminClient
   *           .createInstanceAsync(parent, instanceId, instance, clusters)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the project in which to create the new instance.
   *     Values are of the form `projects/{project}`.
   * @param instanceId Required. The ID to be used when referring to the new instance within its
   *     project, e.g., just `myinstance` rather than `projects/myproject/instances/myinstance`.
   * @param instance Required. The instance to create. Fields marked `OutputOnly` must be left
   *     blank.
   * @param clusters Required. The clusters to be created within the instance, mapped by desired
   *     cluster ID, e.g., just `mycluster` rather than
   *     `projects/myproject/instances/myinstance/clusters/mycluster`. Fields marked `OutputOnly`
   *     must be left blank.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, CreateInstanceMetadata> createInstanceAsync(
      ProjectName parent, String instanceId, Instance instance, Map<String, Cluster> clusters) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstanceId(instanceId)
            .setInstance(instance)
            .putAllClusters(clusters)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an instance within a project.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String instanceId = "instanceId902024336";
   *   Instance instance = Instance.newBuilder().build();
   *   Map<String, Cluster> clusters = new HashMap<>();
   *   Instance response =
   *       baseBigtableInstanceAdminClient
   *           .createInstanceAsync(parent, instanceId, instance, clusters)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the project in which to create the new instance.
   *     Values are of the form `projects/{project}`.
   * @param instanceId Required. The ID to be used when referring to the new instance within its
   *     project, e.g., just `myinstance` rather than `projects/myproject/instances/myinstance`.
   * @param instance Required. The instance to create. Fields marked `OutputOnly` must be left
   *     blank.
   * @param clusters Required. The clusters to be created within the instance, mapped by desired
   *     cluster ID, e.g., just `mycluster` rather than
   *     `projects/myproject/instances/myinstance/clusters/mycluster`. Fields marked `OutputOnly`
   *     must be left blank.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, CreateInstanceMetadata> createInstanceAsync(
      String parent, String instanceId, Instance instance, Map<String, Cluster> clusters) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .putAllClusters(clusters)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an instance within a project.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .putAllClusters(new HashMap<String, Cluster>())
   *           .build();
   *   Instance response = baseBigtableInstanceAdminClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, CreateInstanceMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an instance within a project.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .putAllClusters(new HashMap<String, Cluster>())
   *           .build();
   *   OperationFuture<Instance, CreateInstanceMetadata> future =
   *       baseBigtableInstanceAdminClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an instance within a project.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .putAllClusters(new HashMap<String, Cluster>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   Instance response = baseBigtableInstanceAdminClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested instance. Values are of the form
   *     `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   Instance response = baseBigtableInstanceAdminClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested instance. Values are of the form
   *     `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = baseBigtableInstanceAdminClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future =
   *       baseBigtableInstanceAdminClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListInstancesResponse response = baseBigtableInstanceAdminClient.listInstances(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the project for which a list of instances is
   *     requested. Values are of the form `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(ProjectName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   ListInstancesResponse response = baseBigtableInstanceAdminClient.listInstances(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the project for which a list of instances is
   *     requested. Values are of the form `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ListInstancesResponse response = baseBigtableInstanceAdminClient.listInstances(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(ListInstancesRequest request) {
    return listInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ListInstancesResponse> future =
   *       baseBigtableInstanceAdminClient.listInstancesCallable().futureCall(request);
   *   // Do something.
   *   ListInstancesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance within a project. This method updates only the display name and type for an
   * Instance. To update other Instance properties, such as labels, use PartialUpdateInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Instance request =
   *       Instance.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setCreateTime(Timestamp.newBuilder().build())
   *           .setSatisfiesPzs(true)
   *           .setSatisfiesPzi(true)
   *           .build();
   *   Instance response = baseBigtableInstanceAdminClient.updateInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance updateInstance(Instance request) {
    return updateInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance within a project. This method updates only the display name and type for an
   * Instance. To update other Instance properties, such as labels, use PartialUpdateInstance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Instance request =
   *       Instance.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .putAllLabels(new HashMap<String, String>())
   *           .setCreateTime(Timestamp.newBuilder().build())
   *           .setSatisfiesPzs(true)
   *           .setSatisfiesPzi(true)
   *           .build();
   *   ApiFuture<Instance> future =
   *       baseBigtableInstanceAdminClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Instance, Instance> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates an instance within a project. This method can modify all fields of an
   * Instance and is the preferred way to update an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response =
   *       baseBigtableInstanceAdminClient.partialUpdateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The Instance which will (partially) replace the current value.
   * @param updateMask Required. The subset of Instance fields which should be replaced. Must be
   *     explicitly set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, UpdateInstanceMetadata> partialUpdateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    PartialUpdateInstanceRequest request =
        PartialUpdateInstanceRequest.newBuilder()
            .setInstance(instance)
            .setUpdateMask(updateMask)
            .build();
    return partialUpdateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates an instance within a project. This method can modify all fields of an
   * Instance and is the preferred way to update an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateInstanceRequest request =
   *       PartialUpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Instance response = baseBigtableInstanceAdminClient.partialUpdateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, UpdateInstanceMetadata> partialUpdateInstanceAsync(
      PartialUpdateInstanceRequest request) {
    return partialUpdateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates an instance within a project. This method can modify all fields of an
   * Instance and is the preferred way to update an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateInstanceRequest request =
   *       PartialUpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, UpdateInstanceMetadata> future =
   *       baseBigtableInstanceAdminClient
   *           .partialUpdateInstanceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationCallable() {
    return stub.partialUpdateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates an instance within a project. This method can modify all fields of an
   * Instance and is the preferred way to update an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateInstanceRequest request =
   *       PartialUpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.partialUpdateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceCallable() {
    return stub.partialUpdateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   baseBigtableInstanceAdminClient.deleteInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the instance to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstance(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   baseBigtableInstanceAdminClient.deleteInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the instance to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstance(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    deleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   baseBigtableInstanceAdminClient.deleteInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstance(DeleteInstanceRequest request) {
    deleteInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       baseBigtableInstanceAdminClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster within an instance.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String clusterId = "clusterId561939637";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Cluster response =
   *       baseBigtableInstanceAdminClient.createClusterAsync(parent, clusterId, cluster).get();
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance in which to create the new cluster.
   *     Values are of the form `projects/{project}/instances/{instance}`.
   * @param clusterId Required. The ID to be used when referring to the new cluster within its
   *     instance, e.g., just `mycluster` rather than
   *     `projects/myproject/instances/myinstance/clusters/mycluster`.
   * @param cluster Required. The cluster to be created. Fields marked `OutputOnly` must be left
   *     blank.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, CreateClusterMetadata> createClusterAsync(
      InstanceName parent, String clusterId, Cluster cluster) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClusterId(clusterId)
            .setCluster(cluster)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster within an instance.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String clusterId = "clusterId561939637";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Cluster response =
   *       baseBigtableInstanceAdminClient.createClusterAsync(parent, clusterId, cluster).get();
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance in which to create the new cluster.
   *     Values are of the form `projects/{project}/instances/{instance}`.
   * @param clusterId Required. The ID to be used when referring to the new cluster within its
   *     instance, e.g., just `mycluster` rather than
   *     `projects/myproject/instances/myinstance/clusters/mycluster`.
   * @param cluster Required. The cluster to be created. Fields marked `OutputOnly` must be left
   *     blank.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, CreateClusterMetadata> createClusterAsync(
      String parent, String clusterId, Cluster cluster) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
            .setClusterId(clusterId)
            .setCluster(cluster)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster within an instance.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .build();
   *   Cluster response = baseBigtableInstanceAdminClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, CreateClusterMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster within an instance.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .build();
   *   OperationFuture<Cluster, CreateClusterMetadata> future =
   *       baseBigtableInstanceAdminClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster within an instance.
   *
   * <p>Note that exactly one of Cluster.serve_nodes and
   * Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to
   * non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is
   * non-empty, then autoscaling is enabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   Cluster response = baseBigtableInstanceAdminClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested cluster. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString();
   *   Cluster response = baseBigtableInstanceAdminClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested cluster. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .build();
   *   Cluster response = baseBigtableInstanceAdminClient.getCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<Cluster> future =
   *       baseBigtableInstanceAdminClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListClustersResponse response = baseBigtableInstanceAdminClient.listClusters(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which a list of clusters is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`. Use
   *     `{instance} = '-'` to list Clusters for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(InstanceName parent) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   ListClustersResponse response = baseBigtableInstanceAdminClient.listClusters(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which a list of clusters is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`. Use
   *     `{instance} = '-'` to list Clusters for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ListClustersResponse response = baseBigtableInstanceAdminClient.listClusters(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(ListClustersRequest request) {
    return listClustersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ListClustersResponse> future =
   *       baseBigtableInstanceAdminClient.listClustersCallable().futureCall(request);
   *   // Do something.
   *   ListClustersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster within an instance.
   *
   * <p>Note that UpdateCluster does not support updating cluster_config.cluster_autoscaling_config.
   * In order to update it, you must use PartialUpdateCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Cluster request =
   *       Cluster.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServeNodes(-1288838783)
   *           .setDefaultStorageType(StorageType.forNumber(0))
   *           .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
   *           .build();
   *   Cluster response = baseBigtableInstanceAdminClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, UpdateClusterMetadata> updateClusterAsync(Cluster request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster within an instance.
   *
   * <p>Note that UpdateCluster does not support updating cluster_config.cluster_autoscaling_config.
   * In order to update it, you must use PartialUpdateCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Cluster request =
   *       Cluster.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServeNodes(-1288838783)
   *           .setDefaultStorageType(StorageType.forNumber(0))
   *           .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Cluster, UpdateClusterMetadata> future =
   *       baseBigtableInstanceAdminClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster within an instance.
   *
   * <p>Note that UpdateCluster does not support updating cluster_config.cluster_autoscaling_config.
   * In order to update it, you must use PartialUpdateCluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Cluster request =
   *       Cluster.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServeNodes(-1288838783)
   *           .setDefaultStorageType(StorageType.forNumber(0))
   *           .setEncryptionConfig(Cluster.EncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Cluster, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a cluster within a project. This method is the preferred way to update a
   * Cluster.
   *
   * <p>To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When
   * autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to
   * it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and
   * cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the
   * update_mask.
   *
   * <p>To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set
   * a serve_node count via the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response =
   *       baseBigtableInstanceAdminClient.partialUpdateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. The Cluster which contains the partial updates to be applied, subject
   *     to the update_mask.
   * @param updateMask Required. The subset of Cluster fields which should be replaced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, PartialUpdateClusterMetadata> partialUpdateClusterAsync(
      Cluster cluster, FieldMask updateMask) {
    PartialUpdateClusterRequest request =
        PartialUpdateClusterRequest.newBuilder()
            .setCluster(cluster)
            .setUpdateMask(updateMask)
            .build();
    return partialUpdateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a cluster within a project. This method is the preferred way to update a
   * Cluster.
   *
   * <p>To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When
   * autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to
   * it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and
   * cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the
   * update_mask.
   *
   * <p>To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set
   * a serve_node count via the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateClusterRequest request =
   *       PartialUpdateClusterRequest.newBuilder()
   *           .setCluster(Cluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Cluster response = baseBigtableInstanceAdminClient.partialUpdateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, PartialUpdateClusterMetadata> partialUpdateClusterAsync(
      PartialUpdateClusterRequest request) {
    return partialUpdateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a cluster within a project. This method is the preferred way to update a
   * Cluster.
   *
   * <p>To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When
   * autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to
   * it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and
   * cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the
   * update_mask.
   *
   * <p>To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set
   * a serve_node count via the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateClusterRequest request =
   *       PartialUpdateClusterRequest.newBuilder()
   *           .setCluster(Cluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Cluster, PartialUpdateClusterMetadata> future =
   *       baseBigtableInstanceAdminClient
   *           .partialUpdateClusterOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
      partialUpdateClusterOperationCallable() {
    return stub.partialUpdateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a cluster within a project. This method is the preferred way to update a
   * Cluster.
   *
   * <p>To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When
   * autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to
   * it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and
   * cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the
   * update_mask.
   *
   * <p>To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set
   * a serve_node count via the update_mask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   PartialUpdateClusterRequest request =
   *       PartialUpdateClusterRequest.newBuilder()
   *           .setCluster(Cluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.partialUpdateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PartialUpdateClusterRequest, Operation>
      partialUpdateClusterCallable() {
    return stub.partialUpdateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   baseBigtableInstanceAdminClient.deleteCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the cluster to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCluster(ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString();
   *   baseBigtableInstanceAdminClient.deleteCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the cluster to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCluster(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    deleteCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .build();
   *   baseBigtableInstanceAdminClient.deleteCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCluster(DeleteClusterRequest request) {
    deleteClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       baseBigtableInstanceAdminClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String appProfileId = "appProfileId704923523";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   AppProfile response =
   *       baseBigtableInstanceAdminClient.createAppProfile(parent, appProfileId, appProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance in which to create the new app profile.
   *     Values are of the form `projects/{project}/instances/{instance}`.
   * @param appProfileId Required. The ID to be used when referring to the new app profile within
   *     its instance, e.g., just `myprofile` rather than
   *     `projects/myproject/instances/myinstance/appProfiles/myprofile`.
   * @param appProfile Required. The app profile to be created. Fields marked `OutputOnly` will be
   *     ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(
      InstanceName parent, String appProfileId, AppProfile appProfile) {
    CreateAppProfileRequest request =
        CreateAppProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppProfileId(appProfileId)
            .setAppProfile(appProfile)
            .build();
    return createAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String appProfileId = "appProfileId704923523";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   AppProfile response =
   *       baseBigtableInstanceAdminClient.createAppProfile(parent, appProfileId, appProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance in which to create the new app profile.
   *     Values are of the form `projects/{project}/instances/{instance}`.
   * @param appProfileId Required. The ID to be used when referring to the new app profile within
   *     its instance, e.g., just `myprofile` rather than
   *     `projects/myproject/instances/myinstance/appProfiles/myprofile`.
   * @param appProfile Required. The app profile to be created. Fields marked `OutputOnly` will be
   *     ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(
      String parent, String appProfileId, AppProfile appProfile) {
    CreateAppProfileRequest request =
        CreateAppProfileRequest.newBuilder()
            .setParent(parent)
            .setAppProfileId(appProfileId)
            .setAppProfile(appProfile)
            .build();
    return createAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateAppProfileRequest request =
   *       CreateAppProfileRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setAppProfileId("appProfileId704923523")
   *           .setAppProfile(AppProfile.newBuilder().build())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   AppProfile response = baseBigtableInstanceAdminClient.createAppProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(CreateAppProfileRequest request) {
    return createAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateAppProfileRequest request =
   *       CreateAppProfileRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setAppProfileId("appProfileId704923523")
   *           .setAppProfile(AppProfile.newBuilder().build())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   ApiFuture<AppProfile> future =
   *       baseBigtableInstanceAdminClient.createAppProfileCallable().futureCall(request);
   *   // Do something.
   *   AppProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppProfileRequest, AppProfile> createAppProfileCallable() {
    return stub.createAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   AppProfile response = baseBigtableInstanceAdminClient.getAppProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested app profile. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile getAppProfile(AppProfileName name) {
    GetAppProfileRequest request =
        GetAppProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   AppProfile response = baseBigtableInstanceAdminClient.getAppProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested app profile. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile getAppProfile(String name) {
    GetAppProfileRequest request = GetAppProfileRequest.newBuilder().setName(name).build();
    return getAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetAppProfileRequest request =
   *       GetAppProfileRequest.newBuilder()
   *           .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
   *           .build();
   *   AppProfile response = baseBigtableInstanceAdminClient.getAppProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile getAppProfile(GetAppProfileRequest request) {
    return getAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetAppProfileRequest request =
   *       GetAppProfileRequest.newBuilder()
   *           .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
   *           .build();
   *   ApiFuture<AppProfile> future =
   *       baseBigtableInstanceAdminClient.getAppProfileCallable().futureCall(request);
   *   // Do something.
   *   AppProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppProfileRequest, AppProfile> getAppProfileCallable() {
    return stub.getAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (AppProfile element :
   *       baseBigtableInstanceAdminClient.listAppProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which a list of app profiles is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`. Use
   *     `{instance} = '-'` to list AppProfiles for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(InstanceName parent) {
    ListAppProfilesRequest request =
        ListAppProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (AppProfile element :
   *       baseBigtableInstanceAdminClient.listAppProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which a list of app profiles is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`. Use
   *     `{instance} = '-'` to list AppProfiles for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(String parent) {
    ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder().setParent(parent).build();
    return listAppProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListAppProfilesRequest request =
   *       ListAppProfilesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AppProfile element :
   *       baseBigtableInstanceAdminClient.listAppProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(ListAppProfilesRequest request) {
    return listAppProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListAppProfilesRequest request =
   *       ListAppProfilesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AppProfile> future =
   *       baseBigtableInstanceAdminClient.listAppProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AppProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      listAppProfilesPagedCallable() {
    return stub.listAppProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListAppProfilesRequest request =
   *       ListAppProfilesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAppProfilesResponse response =
   *         baseBigtableInstanceAdminClient.listAppProfilesCallable().call(request);
   *     for (AppProfile element : response.getAppProfilesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse>
      listAppProfilesCallable() {
    return stub.listAppProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AppProfile response =
   *       baseBigtableInstanceAdminClient.updateAppProfileAsync(appProfile, updateMask).get();
   * }
   * }</pre>
   *
   * @param appProfile Required. The app profile which will (partially) replace the current value.
   * @param updateMask Required. The subset of app profile fields which should be replaced. If
   *     unset, all fields will be replaced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppProfile, UpdateAppProfileMetadata> updateAppProfileAsync(
      AppProfile appProfile, FieldMask updateMask) {
    UpdateAppProfileRequest request =
        UpdateAppProfileRequest.newBuilder()
            .setAppProfile(appProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateAppProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateAppProfileRequest request =
   *       UpdateAppProfileRequest.newBuilder()
   *           .setAppProfile(AppProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   AppProfile response = baseBigtableInstanceAdminClient.updateAppProfileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppProfile, UpdateAppProfileMetadata> updateAppProfileAsync(
      UpdateAppProfileRequest request) {
    return updateAppProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateAppProfileRequest request =
   *       UpdateAppProfileRequest.newBuilder()
   *           .setAppProfile(AppProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   OperationFuture<AppProfile, UpdateAppProfileMetadata> future =
   *       baseBigtableInstanceAdminClient.updateAppProfileOperationCallable().futureCall(request);
   *   // Do something.
   *   AppProfile response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationCallable() {
    return stub.updateAppProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateAppProfileRequest request =
   *       UpdateAppProfileRequest.newBuilder()
   *           .setAppProfile(AppProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.updateAppProfileCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAppProfileRequest, Operation> updateAppProfileCallable() {
    return stub.updateAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   baseBigtableInstanceAdminClient.deleteAppProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the app profile to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(AppProfileName name) {
    DeleteAppProfileRequest request =
        DeleteAppProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   baseBigtableInstanceAdminClient.deleteAppProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the app profile to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(String name) {
    DeleteAppProfileRequest request = DeleteAppProfileRequest.newBuilder().setName(name).build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   boolean ignoreWarnings = true;
   *   baseBigtableInstanceAdminClient.deleteAppProfile(name, ignoreWarnings);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the app profile to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @param ignoreWarnings Required. If true, ignore safety checks when deleting the app profile.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(AppProfileName name, boolean ignoreWarnings) {
    DeleteAppProfileRequest request =
        DeleteAppProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setIgnoreWarnings(ignoreWarnings)
            .build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   boolean ignoreWarnings = true;
   *   baseBigtableInstanceAdminClient.deleteAppProfile(name, ignoreWarnings);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the app profile to be deleted. Values are of the form
   *     `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.
   * @param ignoreWarnings Required. If true, ignore safety checks when deleting the app profile.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(String name, boolean ignoreWarnings) {
    DeleteAppProfileRequest request =
        DeleteAppProfileRequest.newBuilder()
            .setName(name)
            .setIgnoreWarnings(ignoreWarnings)
            .build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteAppProfileRequest request =
   *       DeleteAppProfileRequest.newBuilder()
   *           .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   baseBigtableInstanceAdminClient.deleteAppProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(DeleteAppProfileRequest request) {
    deleteAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteAppProfileRequest request =
   *       DeleteAppProfileRequest.newBuilder()
   *           .setName(AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString())
   *           .setIgnoreWarnings(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       baseBigtableInstanceAdminClient.deleteAppProfileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppProfileRequest, Empty> deleteAppProfileCallable() {
    return stub.deleteAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an instance resource. Returns an empty policy if an instance
   * exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   Policy response = baseBigtableInstanceAdminClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an instance resource. Returns an empty policy if an instance
   * exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   Policy response = baseBigtableInstanceAdminClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an instance resource. Returns an empty policy if an instance
   * exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = baseBigtableInstanceAdminClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an instance resource. Returns an empty policy if an instance
   * exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       baseBigtableInstanceAdminClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = baseBigtableInstanceAdminClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = baseBigtableInstanceAdminClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = baseBigtableInstanceAdminClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       baseBigtableInstanceAdminClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ResourceName resource = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       baseBigtableInstanceAdminClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String resource = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       baseBigtableInstanceAdminClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       baseBigtableInstanceAdminClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       baseBigtableInstanceAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based
   * on CPU usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   for (HotTablet element :
   *       baseBigtableInstanceAdminClient.listHotTablets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The cluster name to list hot tablets. Value is in the following form:
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHotTabletsPagedResponse listHotTablets(ClusterName parent) {
    ListHotTabletsRequest request =
        ListHotTabletsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHotTablets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based
   * on CPU usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString();
   *   for (HotTablet element :
   *       baseBigtableInstanceAdminClient.listHotTablets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The cluster name to list hot tablets. Value is in the following form:
   *     `projects/{project}/instances/{instance}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHotTabletsPagedResponse listHotTablets(String parent) {
    ListHotTabletsRequest request = ListHotTabletsRequest.newBuilder().setParent(parent).build();
    return listHotTablets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based
   * on CPU usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListHotTabletsRequest request =
   *       ListHotTabletsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HotTablet element :
   *       baseBigtableInstanceAdminClient.listHotTablets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHotTabletsPagedResponse listHotTablets(ListHotTabletsRequest request) {
    return listHotTabletsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based
   * on CPU usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListHotTabletsRequest request =
   *       ListHotTabletsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HotTablet> future =
   *       baseBigtableInstanceAdminClient.listHotTabletsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HotTablet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHotTabletsRequest, ListHotTabletsPagedResponse>
      listHotTabletsPagedCallable() {
    return stub.listHotTabletsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based
   * on CPU usage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListHotTabletsRequest request =
   *       ListHotTabletsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]").toString())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHotTabletsResponse response =
   *         baseBigtableInstanceAdminClient.listHotTabletsCallable().call(request);
   *     for (HotTablet element : response.getHotTabletsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHotTabletsRequest, ListHotTabletsResponse>
      listHotTabletsCallable() {
    return stub.listHotTabletsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   LogicalView logicalView = LogicalView.newBuilder().build();
   *   String logicalViewId = "logicalViewId-1408054263";
   *   LogicalView response =
   *       baseBigtableInstanceAdminClient
   *           .createLogicalViewAsync(parent, logicalView, logicalViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent instance where this logical view will be created. Format:
   *     `projects/{project}/instances/{instance}`.
   * @param logicalView Required. The logical view to create.
   * @param logicalViewId Required. The ID to use for the logical view, which will become the final
   *     component of the logical view's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogicalView, CreateLogicalViewMetadata> createLogicalViewAsync(
      InstanceName parent, LogicalView logicalView, String logicalViewId) {
    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLogicalView(logicalView)
            .setLogicalViewId(logicalViewId)
            .build();
    return createLogicalViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   LogicalView logicalView = LogicalView.newBuilder().build();
   *   String logicalViewId = "logicalViewId-1408054263";
   *   LogicalView response =
   *       baseBigtableInstanceAdminClient
   *           .createLogicalViewAsync(parent, logicalView, logicalViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent instance where this logical view will be created. Format:
   *     `projects/{project}/instances/{instance}`.
   * @param logicalView Required. The logical view to create.
   * @param logicalViewId Required. The ID to use for the logical view, which will become the final
   *     component of the logical view's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogicalView, CreateLogicalViewMetadata> createLogicalViewAsync(
      String parent, LogicalView logicalView, String logicalViewId) {
    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.newBuilder()
            .setParent(parent)
            .setLogicalView(logicalView)
            .setLogicalViewId(logicalViewId)
            .build();
    return createLogicalViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateLogicalViewRequest request =
   *       CreateLogicalViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setLogicalViewId("logicalViewId-1408054263")
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .build();
   *   LogicalView response = baseBigtableInstanceAdminClient.createLogicalViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogicalView, CreateLogicalViewMetadata> createLogicalViewAsync(
      CreateLogicalViewRequest request) {
    return createLogicalViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateLogicalViewRequest request =
   *       CreateLogicalViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setLogicalViewId("logicalViewId-1408054263")
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .build();
   *   OperationFuture<LogicalView, CreateLogicalViewMetadata> future =
   *       baseBigtableInstanceAdminClient.createLogicalViewOperationCallable().futureCall(request);
   *   // Do something.
   *   LogicalView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
      createLogicalViewOperationCallable() {
    return stub.createLogicalViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateLogicalViewRequest request =
   *       CreateLogicalViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setLogicalViewId("logicalViewId-1408054263")
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.createLogicalViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLogicalViewRequest, Operation> createLogicalViewCallable() {
    return stub.createLogicalViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a logical view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");
   *   LogicalView response = baseBigtableInstanceAdminClient.getLogicalView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested logical view. Values are of the form
   *     `projects/{project}/instances/{instance}/logicalViews/{logical_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalView getLogicalView(LogicalViewName name) {
    GetLogicalViewRequest request =
        GetLogicalViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLogicalView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a logical view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString();
   *   LogicalView response = baseBigtableInstanceAdminClient.getLogicalView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested logical view. Values are of the form
   *     `projects/{project}/instances/{instance}/logicalViews/{logical_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalView getLogicalView(String name) {
    GetLogicalViewRequest request = GetLogicalViewRequest.newBuilder().setName(name).build();
    return getLogicalView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a logical view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetLogicalViewRequest request =
   *       GetLogicalViewRequest.newBuilder()
   *           .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
   *           .build();
   *   LogicalView response = baseBigtableInstanceAdminClient.getLogicalView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogicalView getLogicalView(GetLogicalViewRequest request) {
    return getLogicalViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a logical view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetLogicalViewRequest request =
   *       GetLogicalViewRequest.newBuilder()
   *           .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
   *           .build();
   *   ApiFuture<LogicalView> future =
   *       baseBigtableInstanceAdminClient.getLogicalViewCallable().futureCall(request);
   *   // Do something.
   *   LogicalView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLogicalViewRequest, LogicalView> getLogicalViewCallable() {
    return stub.getLogicalViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about logical views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (LogicalView element :
   *       baseBigtableInstanceAdminClient.listLogicalViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which the list of logical views is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalViewsPagedResponse listLogicalViews(InstanceName parent) {
    ListLogicalViewsRequest request =
        ListLogicalViewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLogicalViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about logical views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (LogicalView element :
   *       baseBigtableInstanceAdminClient.listLogicalViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which the list of logical views is
   *     requested. Values are of the form `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalViewsPagedResponse listLogicalViews(String parent) {
    ListLogicalViewsRequest request =
        ListLogicalViewsRequest.newBuilder().setParent(parent).build();
    return listLogicalViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about logical views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListLogicalViewsRequest request =
   *       ListLogicalViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LogicalView element :
   *       baseBigtableInstanceAdminClient.listLogicalViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogicalViewsPagedResponse listLogicalViews(ListLogicalViewsRequest request) {
    return listLogicalViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about logical views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListLogicalViewsRequest request =
   *       ListLogicalViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LogicalView> future =
   *       baseBigtableInstanceAdminClient.listLogicalViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogicalView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsPagedResponse>
      listLogicalViewsPagedCallable() {
    return stub.listLogicalViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about logical views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListLogicalViewsRequest request =
   *       ListLogicalViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogicalViewsResponse response =
   *         baseBigtableInstanceAdminClient.listLogicalViewsCallable().call(request);
   *     for (LogicalView element : response.getLogicalViewsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsResponse>
      listLogicalViewsCallable() {
    return stub.listLogicalViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   LogicalView logicalView = LogicalView.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LogicalView response =
   *       baseBigtableInstanceAdminClient.updateLogicalViewAsync(logicalView, updateMask).get();
   * }
   * }</pre>
   *
   * @param logicalView Required. The logical view to update.
   *     <p>The logical view's `name` field is used to identify the view to update. Format:
   *     `projects/{project}/instances/{instance}/logicalViews/{logical_view}`.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogicalView, UpdateLogicalViewMetadata> updateLogicalViewAsync(
      LogicalView logicalView, FieldMask updateMask) {
    UpdateLogicalViewRequest request =
        UpdateLogicalViewRequest.newBuilder()
            .setLogicalView(logicalView)
            .setUpdateMask(updateMask)
            .build();
    return updateLogicalViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateLogicalViewRequest request =
   *       UpdateLogicalViewRequest.newBuilder()
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogicalView response = baseBigtableInstanceAdminClient.updateLogicalViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogicalView, UpdateLogicalViewMetadata> updateLogicalViewAsync(
      UpdateLogicalViewRequest request) {
    return updateLogicalViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateLogicalViewRequest request =
   *       UpdateLogicalViewRequest.newBuilder()
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<LogicalView, UpdateLogicalViewMetadata> future =
   *       baseBigtableInstanceAdminClient.updateLogicalViewOperationCallable().futureCall(request);
   *   // Do something.
   *   LogicalView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
      updateLogicalViewOperationCallable() {
    return stub.updateLogicalViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a logical view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateLogicalViewRequest request =
   *       UpdateLogicalViewRequest.newBuilder()
   *           .setLogicalView(LogicalView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.updateLogicalViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLogicalViewRequest, Operation> updateLogicalViewCallable() {
    return stub.updateLogicalViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logical view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   LogicalViewName name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]");
   *   baseBigtableInstanceAdminClient.deleteLogicalView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the logical view to be deleted. Format:
   *     `projects/{project}/instances/{instance}/logicalViews/{logical_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogicalView(LogicalViewName name) {
    DeleteLogicalViewRequest request =
        DeleteLogicalViewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteLogicalView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logical view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name = LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString();
   *   baseBigtableInstanceAdminClient.deleteLogicalView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the logical view to be deleted. Format:
   *     `projects/{project}/instances/{instance}/logicalViews/{logical_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogicalView(String name) {
    DeleteLogicalViewRequest request = DeleteLogicalViewRequest.newBuilder().setName(name).build();
    deleteLogicalView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logical view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteLogicalViewRequest request =
   *       DeleteLogicalViewRequest.newBuilder()
   *           .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   baseBigtableInstanceAdminClient.deleteLogicalView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLogicalView(DeleteLogicalViewRequest request) {
    deleteLogicalViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a logical view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteLogicalViewRequest request =
   *       DeleteLogicalViewRequest.newBuilder()
   *           .setName(LogicalViewName.of("[PROJECT]", "[INSTANCE]", "[LOGICAL_VIEW]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       baseBigtableInstanceAdminClient.deleteLogicalViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLogicalViewRequest, Empty> deleteLogicalViewCallable() {
    return stub.deleteLogicalViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   MaterializedView materializedView = MaterializedView.newBuilder().build();
   *   String materializedViewId = "materializedViewId682270903";
   *   MaterializedView response =
   *       baseBigtableInstanceAdminClient
   *           .createMaterializedViewAsync(parent, materializedView, materializedViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent instance where this materialized view will be created.
   *     Format: `projects/{project}/instances/{instance}`.
   * @param materializedView Required. The materialized view to create.
   * @param materializedViewId Required. The ID to use for the materialized view, which will become
   *     the final component of the materialized view's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewAsync(
          InstanceName parent, MaterializedView materializedView, String materializedViewId) {
    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMaterializedView(materializedView)
            .setMaterializedViewId(materializedViewId)
            .build();
    return createMaterializedViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   MaterializedView materializedView = MaterializedView.newBuilder().build();
   *   String materializedViewId = "materializedViewId682270903";
   *   MaterializedView response =
   *       baseBigtableInstanceAdminClient
   *           .createMaterializedViewAsync(parent, materializedView, materializedViewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent instance where this materialized view will be created.
   *     Format: `projects/{project}/instances/{instance}`.
   * @param materializedView Required. The materialized view to create.
   * @param materializedViewId Required. The ID to use for the materialized view, which will become
   *     the final component of the materialized view's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewAsync(
          String parent, MaterializedView materializedView, String materializedViewId) {
    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.newBuilder()
            .setParent(parent)
            .setMaterializedView(materializedView)
            .setMaterializedViewId(materializedViewId)
            .build();
    return createMaterializedViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateMaterializedViewRequest request =
   *       CreateMaterializedViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setMaterializedViewId("materializedViewId682270903")
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .build();
   *   MaterializedView response =
   *       baseBigtableInstanceAdminClient.createMaterializedViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewAsync(CreateMaterializedViewRequest request) {
    return createMaterializedViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateMaterializedViewRequest request =
   *       CreateMaterializedViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setMaterializedViewId("materializedViewId682270903")
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .build();
   *   OperationFuture<MaterializedView, CreateMaterializedViewMetadata> future =
   *       baseBigtableInstanceAdminClient
   *           .createMaterializedViewOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MaterializedView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewOperationCallable() {
    return stub.createMaterializedViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   CreateMaterializedViewRequest request =
   *       CreateMaterializedViewRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setMaterializedViewId("materializedViewId682270903")
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.createMaterializedViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMaterializedViewRequest, Operation>
      createMaterializedViewCallable() {
    return stub.createMaterializedViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a materialized view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   MaterializedViewName name =
   *       MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");
   *   MaterializedView response = baseBigtableInstanceAdminClient.getMaterializedView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested materialized view. Values are of the
   *     form `projects/{project}/instances/{instance}/materializedViews/{materialized_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MaterializedView getMaterializedView(MaterializedViewName name) {
    GetMaterializedViewRequest request =
        GetMaterializedViewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMaterializedView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a materialized view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name =
   *       MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]").toString();
   *   MaterializedView response = baseBigtableInstanceAdminClient.getMaterializedView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the requested materialized view. Values are of the
   *     form `projects/{project}/instances/{instance}/materializedViews/{materialized_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MaterializedView getMaterializedView(String name) {
    GetMaterializedViewRequest request =
        GetMaterializedViewRequest.newBuilder().setName(name).build();
    return getMaterializedView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a materialized view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetMaterializedViewRequest request =
   *       GetMaterializedViewRequest.newBuilder()
   *           .setName(
   *               MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
   *                   .toString())
   *           .build();
   *   MaterializedView response = baseBigtableInstanceAdminClient.getMaterializedView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MaterializedView getMaterializedView(GetMaterializedViewRequest request) {
    return getMaterializedViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a materialized view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   GetMaterializedViewRequest request =
   *       GetMaterializedViewRequest.newBuilder()
   *           .setName(
   *               MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MaterializedView> future =
   *       baseBigtableInstanceAdminClient.getMaterializedViewCallable().futureCall(request);
   *   // Do something.
   *   MaterializedView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMaterializedViewRequest, MaterializedView>
      getMaterializedViewCallable() {
    return stub.getMaterializedViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about materialized views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (MaterializedView element :
   *       baseBigtableInstanceAdminClient.listMaterializedViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which the list of materialized
   *     views is requested. Values are of the form `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMaterializedViewsPagedResponse listMaterializedViews(InstanceName parent) {
    ListMaterializedViewsRequest request =
        ListMaterializedViewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMaterializedViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about materialized views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (MaterializedView element :
   *       baseBigtableInstanceAdminClient.listMaterializedViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The unique name of the instance for which the list of materialized
   *     views is requested. Values are of the form `projects/{project}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMaterializedViewsPagedResponse listMaterializedViews(String parent) {
    ListMaterializedViewsRequest request =
        ListMaterializedViewsRequest.newBuilder().setParent(parent).build();
    return listMaterializedViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about materialized views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListMaterializedViewsRequest request =
   *       ListMaterializedViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MaterializedView element :
   *       baseBigtableInstanceAdminClient.listMaterializedViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMaterializedViewsPagedResponse listMaterializedViews(
      ListMaterializedViewsRequest request) {
    return listMaterializedViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about materialized views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListMaterializedViewsRequest request =
   *       ListMaterializedViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MaterializedView> future =
   *       baseBigtableInstanceAdminClient.listMaterializedViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MaterializedView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsPagedResponse>
      listMaterializedViewsPagedCallable() {
    return stub.listMaterializedViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about materialized views in an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   ListMaterializedViewsRequest request =
   *       ListMaterializedViewsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMaterializedViewsResponse response =
   *         baseBigtableInstanceAdminClient.listMaterializedViewsCallable().call(request);
   *     for (MaterializedView element : response.getMaterializedViewsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsResponse>
      listMaterializedViewsCallable() {
    return stub.listMaterializedViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   MaterializedView materializedView = MaterializedView.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MaterializedView response =
   *       baseBigtableInstanceAdminClient
   *           .updateMaterializedViewAsync(materializedView, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param materializedView Required. The materialized view to update.
   *     <p>The materialized view's `name` field is used to identify the view to update. Format:
   *     `projects/{project}/instances/{instance}/materializedViews/{materialized_view}`.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewAsync(MaterializedView materializedView, FieldMask updateMask) {
    UpdateMaterializedViewRequest request =
        UpdateMaterializedViewRequest.newBuilder()
            .setMaterializedView(materializedView)
            .setUpdateMask(updateMask)
            .build();
    return updateMaterializedViewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateMaterializedViewRequest request =
   *       UpdateMaterializedViewRequest.newBuilder()
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MaterializedView response =
   *       baseBigtableInstanceAdminClient.updateMaterializedViewAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewAsync(UpdateMaterializedViewRequest request) {
    return updateMaterializedViewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateMaterializedViewRequest request =
   *       UpdateMaterializedViewRequest.newBuilder()
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<MaterializedView, UpdateMaterializedViewMetadata> future =
   *       baseBigtableInstanceAdminClient
   *           .updateMaterializedViewOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MaterializedView response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewOperationCallable() {
    return stub.updateMaterializedViewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a materialized view within an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   UpdateMaterializedViewRequest request =
   *       UpdateMaterializedViewRequest.newBuilder()
   *           .setMaterializedView(MaterializedView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       baseBigtableInstanceAdminClient.updateMaterializedViewCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMaterializedViewRequest, Operation>
      updateMaterializedViewCallable() {
    return stub.updateMaterializedViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a materialized view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   MaterializedViewName name =
   *       MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]");
   *   baseBigtableInstanceAdminClient.deleteMaterializedView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the materialized view to be deleted. Format:
   *     `projects/{project}/instances/{instance}/materializedViews/{materialized_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMaterializedView(MaterializedViewName name) {
    DeleteMaterializedViewRequest request =
        DeleteMaterializedViewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMaterializedView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a materialized view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   String name =
   *       MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]").toString();
   *   baseBigtableInstanceAdminClient.deleteMaterializedView(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique name of the materialized view to be deleted. Format:
   *     `projects/{project}/instances/{instance}/materializedViews/{materialized_view}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMaterializedView(String name) {
    DeleteMaterializedViewRequest request =
        DeleteMaterializedViewRequest.newBuilder().setName(name).build();
    deleteMaterializedView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a materialized view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteMaterializedViewRequest request =
   *       DeleteMaterializedViewRequest.newBuilder()
   *           .setName(
   *               MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   baseBigtableInstanceAdminClient.deleteMaterializedView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMaterializedView(DeleteMaterializedViewRequest request) {
    deleteMaterializedViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a materialized view from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BaseBigtableInstanceAdminClient baseBigtableInstanceAdminClient =
   *     BaseBigtableInstanceAdminClient.create()) {
   *   DeleteMaterializedViewRequest request =
   *       DeleteMaterializedViewRequest.newBuilder()
   *           .setName(
   *               MaterializedViewName.of("[PROJECT]", "[INSTANCE]", "[MATERIALIZED_VIEW]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       baseBigtableInstanceAdminClient.deleteMaterializedViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMaterializedViewRequest, Empty>
      deleteMaterializedViewCallable() {
    return stub.deleteMaterializedViewCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListAppProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListAppProfilesRequest,
          ListAppProfilesResponse,
          AppProfile,
          ListAppProfilesPage,
          ListAppProfilesFixedSizeCollection> {

    public static ApiFuture<ListAppProfilesPagedResponse> createAsync(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ApiFuture<ListAppProfilesResponse> futureResponse) {
      ApiFuture<ListAppProfilesPage> futurePage =
          ListAppProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAppProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAppProfilesPagedResponse(ListAppProfilesPage page) {
      super(page, ListAppProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppProfilesPage
      extends AbstractPage<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile, ListAppProfilesPage> {

    private ListAppProfilesPage(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ListAppProfilesResponse response) {
      super(context, response);
    }

    private static ListAppProfilesPage createEmptyPage() {
      return new ListAppProfilesPage(null, null);
    }

    @Override
    protected ListAppProfilesPage createPage(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ListAppProfilesResponse response) {
      return new ListAppProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListAppProfilesPage> createPageAsync(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ApiFuture<ListAppProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppProfilesRequest,
          ListAppProfilesResponse,
          AppProfile,
          ListAppProfilesPage,
          ListAppProfilesFixedSizeCollection> {

    private ListAppProfilesFixedSizeCollection(
        List<ListAppProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppProfilesFixedSizeCollection createEmptyCollection() {
      return new ListAppProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppProfilesFixedSizeCollection createCollection(
        List<ListAppProfilesPage> pages, int collectionSize) {
      return new ListAppProfilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHotTabletsPagedResponse
      extends AbstractPagedListResponse<
          ListHotTabletsRequest,
          ListHotTabletsResponse,
          HotTablet,
          ListHotTabletsPage,
          ListHotTabletsFixedSizeCollection> {

    public static ApiFuture<ListHotTabletsPagedResponse> createAsync(
        PageContext<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet> context,
        ApiFuture<ListHotTabletsResponse> futureResponse) {
      ApiFuture<ListHotTabletsPage> futurePage =
          ListHotTabletsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHotTabletsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHotTabletsPagedResponse(ListHotTabletsPage page) {
      super(page, ListHotTabletsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHotTabletsPage
      extends AbstractPage<
          ListHotTabletsRequest, ListHotTabletsResponse, HotTablet, ListHotTabletsPage> {

    private ListHotTabletsPage(
        PageContext<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet> context,
        ListHotTabletsResponse response) {
      super(context, response);
    }

    private static ListHotTabletsPage createEmptyPage() {
      return new ListHotTabletsPage(null, null);
    }

    @Override
    protected ListHotTabletsPage createPage(
        PageContext<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet> context,
        ListHotTabletsResponse response) {
      return new ListHotTabletsPage(context, response);
    }

    @Override
    public ApiFuture<ListHotTabletsPage> createPageAsync(
        PageContext<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet> context,
        ApiFuture<ListHotTabletsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHotTabletsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHotTabletsRequest,
          ListHotTabletsResponse,
          HotTablet,
          ListHotTabletsPage,
          ListHotTabletsFixedSizeCollection> {

    private ListHotTabletsFixedSizeCollection(List<ListHotTabletsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHotTabletsFixedSizeCollection createEmptyCollection() {
      return new ListHotTabletsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHotTabletsFixedSizeCollection createCollection(
        List<ListHotTabletsPage> pages, int collectionSize) {
      return new ListHotTabletsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogicalViewsPagedResponse
      extends AbstractPagedListResponse<
          ListLogicalViewsRequest,
          ListLogicalViewsResponse,
          LogicalView,
          ListLogicalViewsPage,
          ListLogicalViewsFixedSizeCollection> {

    public static ApiFuture<ListLogicalViewsPagedResponse> createAsync(
        PageContext<ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView> context,
        ApiFuture<ListLogicalViewsResponse> futureResponse) {
      ApiFuture<ListLogicalViewsPage> futurePage =
          ListLogicalViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogicalViewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogicalViewsPagedResponse(ListLogicalViewsPage page) {
      super(page, ListLogicalViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogicalViewsPage
      extends AbstractPage<
          ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView, ListLogicalViewsPage> {

    private ListLogicalViewsPage(
        PageContext<ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView> context,
        ListLogicalViewsResponse response) {
      super(context, response);
    }

    private static ListLogicalViewsPage createEmptyPage() {
      return new ListLogicalViewsPage(null, null);
    }

    @Override
    protected ListLogicalViewsPage createPage(
        PageContext<ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView> context,
        ListLogicalViewsResponse response) {
      return new ListLogicalViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListLogicalViewsPage> createPageAsync(
        PageContext<ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView> context,
        ApiFuture<ListLogicalViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogicalViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogicalViewsRequest,
          ListLogicalViewsResponse,
          LogicalView,
          ListLogicalViewsPage,
          ListLogicalViewsFixedSizeCollection> {

    private ListLogicalViewsFixedSizeCollection(
        List<ListLogicalViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogicalViewsFixedSizeCollection createEmptyCollection() {
      return new ListLogicalViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogicalViewsFixedSizeCollection createCollection(
        List<ListLogicalViewsPage> pages, int collectionSize) {
      return new ListLogicalViewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMaterializedViewsPagedResponse
      extends AbstractPagedListResponse<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          MaterializedView,
          ListMaterializedViewsPage,
          ListMaterializedViewsFixedSizeCollection> {

    public static ApiFuture<ListMaterializedViewsPagedResponse> createAsync(
        PageContext<ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
            context,
        ApiFuture<ListMaterializedViewsResponse> futureResponse) {
      ApiFuture<ListMaterializedViewsPage> futurePage =
          ListMaterializedViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMaterializedViewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMaterializedViewsPagedResponse(ListMaterializedViewsPage page) {
      super(page, ListMaterializedViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMaterializedViewsPage
      extends AbstractPage<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          MaterializedView,
          ListMaterializedViewsPage> {

    private ListMaterializedViewsPage(
        PageContext<ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
            context,
        ListMaterializedViewsResponse response) {
      super(context, response);
    }

    private static ListMaterializedViewsPage createEmptyPage() {
      return new ListMaterializedViewsPage(null, null);
    }

    @Override
    protected ListMaterializedViewsPage createPage(
        PageContext<ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
            context,
        ListMaterializedViewsResponse response) {
      return new ListMaterializedViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListMaterializedViewsPage> createPageAsync(
        PageContext<ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
            context,
        ApiFuture<ListMaterializedViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMaterializedViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          MaterializedView,
          ListMaterializedViewsPage,
          ListMaterializedViewsFixedSizeCollection> {

    private ListMaterializedViewsFixedSizeCollection(
        List<ListMaterializedViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMaterializedViewsFixedSizeCollection createEmptyCollection() {
      return new ListMaterializedViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMaterializedViewsFixedSizeCollection createCollection(
        List<ListMaterializedViewsPage> pages, int collectionSize) {
      return new ListMaterializedViewsFixedSizeCollection(pages, collectionSize);
    }
  }
}
