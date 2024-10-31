package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {

    /* renamed from: a */
    private final b f8793a = new b();

    /* renamed from: b */
    private final h<a, Bitmap> f8794b = new h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    public static class b extends d<a> {
        b() {
        }

        a a(int i, int i2, Bitmap.Config config) {
            a b2 = b();
            b2.a(i, i2, config);
            return b2;
        }

        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap bitmap) {
        this.f8794b.a(this.f8793a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.g.n.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap removeLast() {
        return this.f8794b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f8794b;
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + FragmentC2201x.f23219a + i2 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    public static class a implements m {

        /* renamed from: a */
        private final b f8795a;

        /* renamed from: b */
        private int f8796b;

        /* renamed from: c */
        private int f8797c;

        /* renamed from: d */
        private Bitmap.Config f8798d;

        public a(b bVar) {
            this.f8795a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f8796b = i;
            this.f8797c = i2;
            this.f8798d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8796b == aVar.f8796b && this.f8797c == aVar.f8797c && this.f8798d == aVar.f8798d;
        }

        public int hashCode() {
            int i = ((this.f8796b * 31) + this.f8797c) * 31;
            Bitmap.Config config = this.f8798d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f8796b, this.f8797c, this.f8798d);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f8795a.a(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f8794b.a((h<a, Bitmap>) this.f8793a.a(i, i2, config));
    }
}
