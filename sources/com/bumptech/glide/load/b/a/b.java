package com.bumptech.glide.load.b.a;

import android.net.Uri;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.g;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* loaded from: classes.dex */
public class b implements u<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f8592a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b, reason: collision with root package name */
    private final u<l, InputStream> f8593b;

    /* compiled from: HttpUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements v<Uri, InputStream> {
        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new b(yVar.a(l.class, InputStream.class));
        }
    }

    public b(u<l, InputStream> uVar) {
        this.f8593b = uVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<InputStream> a(Uri uri, int i, int i2, g gVar) {
        return this.f8593b.a(new l(uri.toString()), i, i2, gVar);
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return f8592a.contains(uri.getScheme());
    }
}
