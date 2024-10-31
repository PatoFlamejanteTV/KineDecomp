package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TrueFileFilter implements d, Serializable {
    public static final d TRUE = new TrueFileFilter();
    public static final d INSTANCE = TRUE;

    protected TrueFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.d, java.io.FileFilter
    public boolean accept(File file) {
        return true;
    }

    @Override // org.apache.commons.io.filefilter.d, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return true;
    }
}
