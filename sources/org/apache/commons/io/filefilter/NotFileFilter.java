package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class NotFileFilter extends a implements Serializable {
    private final d filter;

    public NotFileFilter(d dVar) {
        if (dVar != null) {
            this.filter = dVar;
            return;
        }
        throw new IllegalArgumentException("The filter must not be null");
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.d, java.io.FileFilter
    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    @Override // org.apache.commons.io.filefilter.a
    public String toString() {
        return super.toString() + "(" + this.filter.toString() + ")";
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.d, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !this.filter.accept(file, str);
    }
}
