package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.A;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: classes.dex */
public class d implements u<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8598a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8599a;

        public a(Context context) {
            this.f8599a = context;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new d(this.f8599a);
        }
    }

    public d(Context context) {
        this.f8598a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<InputStream> a(Uri uri, int i, int i2, g gVar) {
        if (com.bumptech.glide.load.a.a.b.a(i, i2) && a(gVar)) {
            return new u.a<>(new com.bumptech.glide.f.c(uri), com.bumptech.glide.load.a.a.c.b(this.f8598a, uri));
        }
        return null;
    }

    private boolean a(g gVar) {
        Long l = (Long) gVar.a(A.f8990a);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return com.bumptech.glide.load.a.a.b.c(uri);
    }
}
