/**
 * ********************************************************************
 *  Copyright (c) 2019 Contributors to the Eclipse Foundation
 *
 *  See the NOTICES file(s) distributed with this work for additional
 *  information regarding copyright ownership.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  SPDX-License-Identifier: Apache-2.0
 * ********************************************************************
 *
 */
package io.astefanutti.metrics.cdi.se;

import io.astefanutti.metrics.cdi.se.util.BeanWithControlledInvocation;
import org.eclipse.microprofile.metrics.annotation.ConcurrentGauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CountDownLatch;

@ApplicationScoped
public class ConcurrentGaugeFunctionalBean implements BeanWithControlledInvocation {

    @Override
    @ConcurrentGauge(name = "mygauge", absolute = true)
    public void controlledMethod(CountDownLatch startMarker, CountDownLatch endCommand) {
        startMarker.countDown();
        try {
            endCommand.await();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
