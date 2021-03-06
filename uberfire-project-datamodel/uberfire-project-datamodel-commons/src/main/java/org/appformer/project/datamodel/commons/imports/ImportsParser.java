/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.appformer.project.datamodel.commons.imports;

import org.appformer.project.datamodel.imports.Import;
import org.appformer.project.datamodel.imports.Imports;

/**
 * Utility methods to parse an Imports Config
 */
public final class ImportsParser {

    private static final String KEYWORD = "import ";

    private ImportsParser() {
    }

    public static Imports parseImports(final String content) {
        Imports imports = new Imports();

        if (content == null || content.trim().equals("")) {
            return imports;
        } else {
            final String[] lines = content.split("\\n");

            for (String line1 : lines) {
                String line = line1.trim();
                if (line.startsWith(KEYWORD)) {
                    line = line.substring(KEYWORD.length()).trim();
                    if (line.endsWith(";")) {
                        line = line.substring(0,
                                              line.length() - 1);
                    }
                    imports.addImport(new Import(line));
                }
            }

            return imports;
        }
    }
}
