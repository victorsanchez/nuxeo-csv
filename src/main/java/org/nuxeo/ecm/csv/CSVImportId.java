/*
 * (C) Copyright 2012 Nuxeo SA (http://nuxeo.com/) and others.
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
 *
 * Contributors:
 *     Thomas Roger
 */

package org.nuxeo.ecm.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Helper class to compute a unique id for an import task.
 *
 * @since 5.7.3
 */
public class CSVImportId {

    private static final Log log = LogFactory.getLog(CSVImportId.class);

    private CSVImportId() {
        // utility class
    }

    public static String create(String repositoryName, String path, File csvFile) {
        return create(repositoryName, path, computeDigest(csvFile));
    }

    public static String create(String repositoryName, String path, String csvBlobDigest) {
        return repositoryName + ':' + path + ":csvImport:" + csvBlobDigest;
    }

    protected static String computeDigest(File file) {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            return DigestUtils.md5Hex(in);
        } catch (IOException e) {
            log.error(e, e);
            return "";
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

}
