package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.g;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class e implements u<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final u<l, InputStream> f8600a;

    /* compiled from: UrlLoader.java */
    /* loaded from: classes.dex */
    public static class a implements v<URL, InputStream> {
        @Override // com.bumptech.glide.load.b.v
        public u<URL, InputStream> a(y yVar) {
            return new e(yVar.a(l.class, InputStream.class));
        }
    }

    public e(u<l, InputStream> uVar) {
        this.f8600a = uVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<InputStream> a(URL url, int i, int i2, g gVar) {
        return this.f8600a.a(new l(url), i, i2, gVar);
    }
}
