package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class l implements e<InputStream> {

    /* renamed from: a */
    private final RecyclableBufferedInputStream f8568a;

    /* compiled from: InputStreamRewinder.java */
    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a */
        private final com.bumptech.glide.load.engine.a.b f8569a;

        public a(com.bumptech.glide.load.engine.a.b bVar) {
            this.f8569a = bVar;
        }

        @Override // com.bumptech.glide.load.a.e.a
        public e<InputStream> a(InputStream inputStream) {
            return new l(inputStream, this.f8569a);
        }

        @Override // com.bumptech.glide.load.a.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    l(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this.f8568a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f8568a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.a.e
    public void b() {
        this.f8568a.b();
    }

    @Override // com.bumptech.glide.load.a.e
    public InputStream a() throws IOException {
        this.f8568a.reset();
        return this.f8568a;
    }
}
