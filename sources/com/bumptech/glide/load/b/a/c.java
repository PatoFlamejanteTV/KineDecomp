package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.g;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class c implements u<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8595a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements v<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8597a;

        public a(Context context) {
            this.f8597a = context;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Uri, InputStream> a(y yVar) {
            return new c(this.f8597a);
        }
    }

    public c(Context context) {
        this.f8595a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<InputStream> a(Uri uri, int i, int i2, g gVar) {
        if (com.bumptech.glide.load.a.a.b.a(i, i2)) {
            return new u.a<>(new com.bumptech.glide.f.c(uri), com.bumptech.glide.load.a.a.c.a(this.f8595a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Uri uri) {
        return com.bumptech.glide.load.a.a.b.a(uri);
    }
}
