package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class FalseFileFilter implements d, Serializable {
    public static final d FALSE = new FalseFileFilter();
    public static final d INSTANCE = FALSE;

    protected FalseFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.d, java.io.FileFilter
    public boolean accept(File file) {
        return false;
    }

    @Override // org.apache.commons.io.filefilter.d, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return false;
    }
}
