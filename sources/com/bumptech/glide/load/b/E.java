package com.bumptech.glide.load.b;

import android.net.Uri;
import com.bumptech.glide.load.b.u;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class E<Data> implements u<Uri, Data> {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f8584a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b, reason: collision with root package name */
    private final u<l, Data> f8585b;

    /* compiled from: UrlUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements v<Uri, InputStream> {
        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new E(yVar.a(l.class, InputStream.class));
        }
    }

    public E(u<l, Data> uVar) {
        this.f8585b = uVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.load.g gVar) {
        return this.f8585b.a(new l(uri.toString()), i, i2, gVar);
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return f8584a.contains(uri.getScheme());
    }
}
