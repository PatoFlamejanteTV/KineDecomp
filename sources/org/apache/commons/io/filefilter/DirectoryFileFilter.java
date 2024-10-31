package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DirectoryFileFilter extends a implements Serializable {
    public static final d DIRECTORY = new DirectoryFileFilter();
    public static final d INSTANCE = DIRECTORY;

    protected DirectoryFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.d, java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
