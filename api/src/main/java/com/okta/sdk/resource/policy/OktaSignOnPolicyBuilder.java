/*
 * Copyright 2020-Present Okta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okta.sdk.resource.policy;

import com.okta.commons.lang.Classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface OktaSignOnPolicyBuilder extends PolicyBuilder<OktaSignOnPolicyBuilder> {

    static OktaSignOnPolicyBuilder instance() {
        return Classes.newInstance("com.okta.sdk.impl.resource.DefaultOktaSignOnPolicyBuilder");
    }

    default OktaSignOnPolicyBuilder setGroups(String... groupIds) {
        return setGroups(Arrays.stream(groupIds).collect(Collectors.toList()));
    }

    OktaSignOnPolicyBuilder setGroups(List<String> groupIds);

    OktaSignOnPolicyBuilder addGroup(String groupId);

    default OktaSignOnPolicyBuilder setUsers(String... userIds) {
        return setGroups(Arrays.stream(userIds).collect(Collectors.toList()));
    }

    OktaSignOnPolicyBuilder setUsers(List<String> userIds);

    OktaSignOnPolicyBuilder addUser(String userId);

}
