/*
 * Copyright 2011 William Bernardet
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
package com.googlecode.japi.checker.rules;

import com.googlecode.japi.checker.Reporter;
import com.googlecode.japi.checker.Rule;
import com.googlecode.japi.checker.Scope;
import com.googlecode.japi.checker.Severity;
import com.googlecode.japi.checker.Reporter.Report;
import com.googlecode.japi.checker.model.JavaItem;
import com.googlecode.japi.checker.model.MethodData;

public class CheckMethodChangedToStatic implements Rule {

    @Override
    public void checkBackwardCompatibility(Reporter reporter,
            JavaItem reference, JavaItem newItem) {
        if (reference instanceof MethodData) {
        	if (reference.getVisibility().isMoreVisibleThan(Scope.NO_SCOPE)) {
                if (!reference.isStatic() && newItem.isStatic()) {
                	reporter.report(new Report(Severity.ERROR, "The " + reference + " has been made static.", reference, newItem));
                } else if (reference.isStatic() && !newItem.isStatic()) {
                	reporter.report(new Report(Severity.ERROR,  "The " + reference + " is not static anymore.", reference, newItem));
                }
            }
        }
    }

}
