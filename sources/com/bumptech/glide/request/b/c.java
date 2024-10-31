package com.bumptech.glide.request.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class c implements g<Drawable> {

    /* renamed from: a */
    private final int f9101a;

    /* renamed from: b */
    private final boolean f9102b;

    /* renamed from: c */
    private d f9103c;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final int f9104a;

        /* renamed from: b */
        private boolean f9105b;

        public a() {
            this(300);
        }

        public c a() {
            return new c(this.f9104a, this.f9105b);
        }

        public a(int i) {
            this.f9104a = i;
        }
    }

    protected c(int i, boolean z) {
        this.f9101a = i;
        this.f9102b = z;
    }

    @Override // com.bumptech.glide.request.b.g
    public f<Drawable> a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? e.a() : a();
    }

    private f<Drawable> a() {
        if (this.f9103c == null) {
            this.f9103c = new d(this.f9101a, this.f9102b);
        }
        return this.f9103c;
    }
}
