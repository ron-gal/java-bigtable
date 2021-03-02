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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/admin/v2/table.proto

package com.google.bigtable.admin.v2;

public interface GcRuleOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.bigtable.admin.v2.GcRule)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Delete all cells in a column except the most recent N.
   * </pre>
   *
   * <code>int32 max_num_versions = 1;</code>
   *
   * @return Whether the maxNumVersions field is set.
   */
  boolean hasMaxNumVersions();
  /**
   *
   *
   * <pre>
   * Delete all cells in a column except the most recent N.
   * </pre>
   *
   * <code>int32 max_num_versions = 1;</code>
   *
   * @return The maxNumVersions.
   */
  int getMaxNumVersions();

  /**
   *
   *
   * <pre>
   * Delete cells in a column older than the given age.
   * Values must be at least one millisecond, and will be truncated to
   * microsecond granularity.
   * </pre>
   *
   * <code>.google.protobuf.Duration max_age = 2;</code>
   *
   * @return Whether the maxAge field is set.
   */
  boolean hasMaxAge();
  /**
   *
   *
   * <pre>
   * Delete cells in a column older than the given age.
   * Values must be at least one millisecond, and will be truncated to
   * microsecond granularity.
   * </pre>
   *
   * <code>.google.protobuf.Duration max_age = 2;</code>
   *
   * @return The maxAge.
   */
  com.google.protobuf.Duration getMaxAge();
  /**
   *
   *
   * <pre>
   * Delete cells in a column older than the given age.
   * Values must be at least one millisecond, and will be truncated to
   * microsecond granularity.
   * </pre>
   *
   * <code>.google.protobuf.Duration max_age = 2;</code>
   */
  com.google.protobuf.DurationOrBuilder getMaxAgeOrBuilder();

  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by every nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Intersection intersection = 3;</code>
   *
   * @return Whether the intersection field is set.
   */
  boolean hasIntersection();
  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by every nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Intersection intersection = 3;</code>
   *
   * @return The intersection.
   */
  com.google.bigtable.admin.v2.GcRule.Intersection getIntersection();
  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by every nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Intersection intersection = 3;</code>
   */
  com.google.bigtable.admin.v2.GcRule.IntersectionOrBuilder getIntersectionOrBuilder();

  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by any nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Union union = 4;</code>
   *
   * @return Whether the union field is set.
   */
  boolean hasUnion();
  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by any nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Union union = 4;</code>
   *
   * @return The union.
   */
  com.google.bigtable.admin.v2.GcRule.Union getUnion();
  /**
   *
   *
   * <pre>
   * Delete cells that would be deleted by any nested rule.
   * </pre>
   *
   * <code>.google.bigtable.admin.v2.GcRule.Union union = 4;</code>
   */
  com.google.bigtable.admin.v2.GcRule.UnionOrBuilder getUnionOrBuilder();

  public com.google.bigtable.admin.v2.GcRule.RuleCase getRuleCase();
}
