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

package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListHotTabletsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListLogicalViewsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListMaterializedViewsPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.Cluster;
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
import com.google.bigtable.admin.v2.Instance;
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
import com.google.bigtable.admin.v2.MaterializedView;
import com.google.bigtable.admin.v2.PartialUpdateClusterMetadata;
import com.google.bigtable.admin.v2.PartialUpdateClusterRequest;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewRequest;
import com.google.bigtable.admin.v2.UpdateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.UpdateMaterializedViewRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public abstract class BigtableInstanceAdminStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<Instance, Instance> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: partialUpdateInstanceOperationCallable()");
  }

  public UnaryCallable<PartialUpdateInstanceRequest, Operation> partialUpdateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: partialUpdateInstanceCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterOperationCallable()");
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterCallable()");
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getClusterCallable()");
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersCallable()");
  }

  public OperationCallable<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterOperationCallable()");
  }

  public UnaryCallable<Cluster, Operation> updateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterCallable()");
  }

  public OperationCallable<PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
      partialUpdateClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: partialUpdateClusterOperationCallable()");
  }

  public UnaryCallable<PartialUpdateClusterRequest, Operation> partialUpdateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: partialUpdateClusterCallable()");
  }

  public UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterCallable()");
  }

  public UnaryCallable<CreateAppProfileRequest, AppProfile> createAppProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createAppProfileCallable()");
  }

  public UnaryCallable<GetAppProfileRequest, AppProfile> getAppProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getAppProfileCallable()");
  }

  public UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      listAppProfilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppProfilesPagedCallable()");
  }

  public UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse> listAppProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAppProfilesCallable()");
  }

  public OperationCallable<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAppProfileOperationCallable()");
  }

  public UnaryCallable<UpdateAppProfileRequest, Operation> updateAppProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAppProfileCallable()");
  }

  public UnaryCallable<DeleteAppProfileRequest, Empty> deleteAppProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAppProfileCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public UnaryCallable<ListHotTabletsRequest, ListHotTabletsPagedResponse>
      listHotTabletsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHotTabletsPagedCallable()");
  }

  public UnaryCallable<ListHotTabletsRequest, ListHotTabletsResponse> listHotTabletsCallable() {
    throw new UnsupportedOperationException("Not implemented: listHotTabletsCallable()");
  }

  public OperationCallable<CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
      createLogicalViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createLogicalViewOperationCallable()");
  }

  public UnaryCallable<CreateLogicalViewRequest, Operation> createLogicalViewCallable() {
    throw new UnsupportedOperationException("Not implemented: createLogicalViewCallable()");
  }

  public UnaryCallable<GetLogicalViewRequest, LogicalView> getLogicalViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getLogicalViewCallable()");
  }

  public UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsPagedResponse>
      listLogicalViewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogicalViewsPagedCallable()");
  }

  public UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsResponse>
      listLogicalViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogicalViewsCallable()");
  }

  public OperationCallable<UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
      updateLogicalViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateLogicalViewOperationCallable()");
  }

  public UnaryCallable<UpdateLogicalViewRequest, Operation> updateLogicalViewCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLogicalViewCallable()");
  }

  public UnaryCallable<DeleteLogicalViewRequest, Empty> deleteLogicalViewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLogicalViewCallable()");
  }

  public OperationCallable<
          CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMaterializedViewOperationCallable()");
  }

  public UnaryCallable<CreateMaterializedViewRequest, Operation> createMaterializedViewCallable() {
    throw new UnsupportedOperationException("Not implemented: createMaterializedViewCallable()");
  }

  public UnaryCallable<GetMaterializedViewRequest, MaterializedView> getMaterializedViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getMaterializedViewCallable()");
  }

  public UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsPagedResponse>
      listMaterializedViewsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMaterializedViewsPagedCallable()");
  }

  public UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsResponse>
      listMaterializedViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMaterializedViewsCallable()");
  }

  public OperationCallable<
          UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMaterializedViewOperationCallable()");
  }

  public UnaryCallable<UpdateMaterializedViewRequest, Operation> updateMaterializedViewCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMaterializedViewCallable()");
  }

  public UnaryCallable<DeleteMaterializedViewRequest, Empty> deleteMaterializedViewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMaterializedViewCallable()");
  }

  @Override
  public abstract void close();
}
