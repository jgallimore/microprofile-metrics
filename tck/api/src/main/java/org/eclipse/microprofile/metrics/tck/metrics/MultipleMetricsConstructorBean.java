/**
 **********************************************************************
 * Copyright (c) 2013, 2022 Contributors to the Eclipse Foundation
 * Copyright © 2013 Antonin Stefanutti (antonin.stefanutti@gmail.com)
 * 
 * See the NOTICES file(s) distributed with this work for additional
 * information regarding copyright ownership.
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
package org.eclipse.microprofile.metrics.tck.metrics;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import jakarta.enterprise.context.Dependent;

@Dependent
public class MultipleMetricsConstructorBean {

    @Counted(name = "counter")
    @Timed(name = "timer")
    public MultipleMetricsConstructorBean() {
    }
}
