package com.adobe.creativesdk.foundation.internal.cache;

import java.io.File;
import java.io.FileFilter;

/* compiled from: AdobeCommonCache.java */
/* loaded from: classes.dex */
public class b implements FileFilter {

    /* renamed from: a */
    final /* synthetic */ d f4941a;

    public b(d dVar) {
        this.f4941a = dVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.isHidden();
    }
}
