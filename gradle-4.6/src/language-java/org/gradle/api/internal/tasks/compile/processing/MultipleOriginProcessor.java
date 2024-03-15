/*
 * Copyright 2018 the original author or authors.
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

package org.gradle.api.internal.tasks.compile.processing;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;


/**
 * A single origin processor must provide at least one originating element
 * for each file it generates.
 */
public class MultipleOriginProcessor extends IncrementalProcessor {

    public MultipleOriginProcessor(Processor delegate) {
        super(delegate);
    }

    @Override
    IncrementalFiler wrapFiler(Filer filer, Messager messager) {
        return new MultipleOriginFiler(filer, messager);
    }
}
