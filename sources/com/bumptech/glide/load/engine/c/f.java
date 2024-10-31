package com.bumptech.glide.load.engine.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
class f implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ Pattern f8881a;

    public f(Pattern pattern) {
        this.f8881a = pattern;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f8881a.matcher(str).matches();
    }
}
