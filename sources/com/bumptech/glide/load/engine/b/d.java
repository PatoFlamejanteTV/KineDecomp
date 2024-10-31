package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.load.engine.b.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0055a {

    /* renamed from: a */
    private final long f8840a;

    /* renamed from: b */
    private final a f8841b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f8840a = j;
        this.f8841b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.b.a.InterfaceC0055a
    public com.bumptech.glide.load.engine.b.a build() {
        File a2 = this.f8841b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f8840a);
        }
        return null;
    }
}
