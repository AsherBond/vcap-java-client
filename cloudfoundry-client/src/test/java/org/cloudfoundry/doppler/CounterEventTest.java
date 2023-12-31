/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.doppler;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

final class CounterEventTest {

    @Test
    void dropsonde() {
        CounterEvent.from(
                new org.cloudfoundry.dropsonde.events.CounterEvent.Builder()
                        .delta(0L)
                        .name("test-name")
                        .build());
    }

    @Test
    void noDelta() {
        assertThrows(
                IllegalStateException.class,
                () -> {
                    CounterEvent.builder().name("test-name").build();
                });
    }

    @Test
    void noName() {
        assertThrows(
                IllegalStateException.class,
                () -> {
                    CounterEvent.builder().delta(0L).build();
                });
    }

    @Test
    void valid() {
        CounterEvent.builder().delta(0L).name("test-name").build();
    }
}
