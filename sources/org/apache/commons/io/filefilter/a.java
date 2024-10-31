package org.apache.commons.io.filefilter;

import java.io.File;

/* compiled from: AbstractFileFilter.java */
/* loaded from: classes3.dex */
public abstract class a implements d {
    @Override // org.apache.commons.io.filefilter.d, java.io.FileFilter
    public abstract boolean accept(File file);

    @Override // org.apache.commons.io.filefilter.d, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
