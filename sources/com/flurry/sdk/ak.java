package com.flurry.sdk;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
final class ak implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(".flurryagent.");
    }
}
