package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class x implements com.bumptech.glide.load.h<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements E<Bitmap> {

        /* renamed from: a */
        private final Bitmap f9057a;

        a(Bitmap bitmap) {
            this.f9057a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.E
        public int a() {
            return com.bumptech.glide.g.n.a(this.f9057a);
        }

        @Override // com.bumptech.glide.load.engine.E
        public void b() {
        }

        @Override // com.bumptech.glide.load.engine.E
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.E
        public Bitmap get() {
            return this.f9057a;
        }
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(Bitmap bitmap, com.bumptech.glide.load.g gVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(Bitmap bitmap, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new a(bitmap);
    }
}
