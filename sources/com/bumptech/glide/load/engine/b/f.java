package com.bumptech.glide.load.engine.b;

import android.content.Context;
import com.bumptech.glide.load.engine.b.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
class f implements d.a {

    /* renamed from: a */
    final /* synthetic */ Context f8847a;

    /* renamed from: b */
    final /* synthetic */ String f8848b;

    public f(Context context, String str) {
        this.f8847a = context;
        this.f8848b = str;
    }

    @Override // com.bumptech.glide.load.engine.b.d.a
    public File a() {
        File cacheDir = this.f8847a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.f8848b;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }
}
