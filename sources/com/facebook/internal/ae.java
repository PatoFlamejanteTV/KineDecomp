package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: Utility.java */
/* loaded from: classes.dex */
final class ae implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }
}
