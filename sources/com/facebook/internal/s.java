package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
class s implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !str.startsWith("buffer");
    }
}
