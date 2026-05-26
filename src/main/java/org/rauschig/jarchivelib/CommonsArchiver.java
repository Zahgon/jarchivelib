/**
 *    Copyright 2013 Thomas Rausch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.rauschig.jarchivelib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

/**
 * Implementation of an {@link Archiver} that uses {@link ArchiveStreamFactory} to generate archive streams by a given
 * archiver name passed when creating the {@code GenericArchiver}. Thus, it can be used for all archive formats the
 * {@code org.apache.commons.compress} library supports.
 */
class CommonsArchiver implements Archiver {

    private final ArchiveFormat archiveFormat;

    CommonsArchiver(ArchiveFormat archiveFormat) {
        this.archiveFormat = archiveFormat;
    }

    public ArchiveFormat getArchiveFormat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public File create(String archive, File destination, File source) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public File create(String archive, File destination, File... sources) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void extract(File archive, File destination) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void extract(InputStream archive, File destination) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void extract(ArchiveInputStream input, File destination) throws IOException {
        ArchiveEntry entry;
        while ((entry = input.getNextEntry()) != null) {
            File file = new File(destination, entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
                IOUtils.copy(input, file);
            }
            FileModeMapper.map(entry, file);
        }
    }

    @Override
    public ArchiveStream stream(File archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getFilenameExtension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new ArchiveInputStream for reading archives. Subclasses can override this to return their own custom
     * implementation.
     *
     * @param archive the archive file to stream from
     * @return a new ArchiveInputStream for the given archive file
     * @throws IOException propagated IO exceptions
     */
    protected ArchiveInputStream createArchiveInputStream(File archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new ArchiveInputStream for reading archives. Subclasses can override this to return their own custom
     * implementation.
     *
     * @param archive the archive contents to stream from
     * @return a new ArchiveInputStream for the given archive file
     * @throws IOException propagated IO exceptions
     */
    protected ArchiveInputStream createArchiveInputStream(InputStream archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new ArchiveOutputStream for creating archives. Subclasses can override this to return their own custom
     * implementation.
     *
     * @param archiveFile the archive file to stream to
     * @return a new ArchiveOutputStream for the given archive file.
     * @throws IOException propagated IO exceptions
     */
    protected ArchiveOutputStream createArchiveOutputStream(File archiveFile) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Asserts that the given File object is a readable file that can be used to extract from.
     *
     * @param archive the file to check
     * @throws FileNotFoundException if the file does not exist
     * @throws IllegalArgumentException if the file is a directory or not readable
     */
    protected void assertExtractSource(File archive) throws FileNotFoundException, IllegalArgumentException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new File in the given destination. The resulting name will always be "archive"."fileExtension". If the
     * archive name parameter already ends with the given file name extension, it is not additionally appended.
     *
     * @param archive the name of the archive
     * @param extension the file extension (e.g. ".tar")
     * @param destination the parent path
     * @return the newly created file
     * @throws IOException if an I/O error occurred while creating the file
     */
    protected File createNewArchiveFile(String archive, String extension, File destination) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Recursion entry point for {@link #writeToArchive(File, File[], ArchiveOutputStream)}.
     * <br>
     * Recursively writes all given source {@link File}s into the given {@link ArchiveOutputStream}.
     *
     * @param sources the files to write in to the archive
     * @param archive the archive to write into
     * @throws IOException when an I/O error occurs
     */
    protected void writeToArchive(File[] sources, ArchiveOutputStream archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Recursively writes all given source {@link File}s into the given {@link ArchiveOutputStream}. The paths of the
     * sources in the archive will be relative to the given parent {@code File}.
     *
     * @param parent the parent file node for computing a relative path (see {@link IOUtils#relativePath(File, File)})
     * @param sources the files to write in to the archive
     * @param archive the archive to write into
     * @throws IOException when an I/O error occurs
     */
    protected void writeToArchive(File parent, File[] sources, ArchiveOutputStream archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new {@link ArchiveEntry} in the given {@link ArchiveOutputStream}, and copies the given {@link File}
     * into the new entry.
     *
     * @param file the file to add to the archive
     * @param entryName the name of the archive entry
     * @param archive the archive to write to
     * @throws IOException when an I/O error occurs during FileInputStream creation or during copying
     */
    protected void createArchiveEntry(File file, String entryName, ArchiveOutputStream archive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
