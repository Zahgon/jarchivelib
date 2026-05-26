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

import java.io.IOException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.arj.ArjArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/**
 * Adapter for accessing mode flags from the different types of ArchiveEntries.
 *
 * @param <E> the type of ArchiveEntry
 */
abstract class AttributeAccessor<E extends ArchiveEntry> {

    private E entry;

    public AttributeAccessor(E entry) {
        this.entry = entry;
    }

    /**
     * Returns the entry that is being accessed
     *
     * @return the entry
     */
    public E getEntry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the unix file mode.
     *
     * @return unix file mode flags
     * @throws java.io.IOException
     */
    public abstract int getMode() throws IOException;

    /**
     * Detects the type of the given ArchiveEntry and returns an appropriate AttributeAccessor for it.
     *
     * @param entry the adaptee
     * @return a new attribute accessor instance
     */
    public static AttributeAccessor<?> create(ArchiveEntry entry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class FallbackAttributeAccessor extends AttributeAccessor<ArchiveEntry> {

        protected FallbackAttributeAccessor(ArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TarAttributeAccessor extends AttributeAccessor<TarArchiveEntry> {

        public TarAttributeAccessor(TarArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class ZipAttributeAccessor extends AttributeAccessor<ZipArchiveEntry> {

        public ZipAttributeAccessor(ZipArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class CpioAttributeAccessor extends AttributeAccessor<CpioArchiveEntry> {

        public CpioAttributeAccessor(CpioArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class ArjAttributeAccessor extends AttributeAccessor<ArjArchiveEntry> {

        public ArjAttributeAccessor(ArjArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class ArAttributeAccessor extends AttributeAccessor<ArArchiveEntry> {

        public ArAttributeAccessor(ArArchiveEntry entry) {
            super(entry);
        }

        @Override
        public int getMode() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
