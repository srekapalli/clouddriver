/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spinnaker.clouddriver.event.exceptions

import com.netflix.spinnaker.kork.exceptions.SystemException

/**
 * Thrown when one or more [SpinEvent] have been rejected from being committed to an [Aggregate].
 *
 * The process which originated the event must be retryable.
 */
class AggregateChangeRejectedException(
  aggregateVersion: Long,
  originatingVersion: Long
) : SystemException(
  "Attempting to save new events against an old aggregate version " +
    "(version: $aggregateVersion, originatingVersion: $originatingVersion)"
) {
  init {
    retryable = false
  }
}
