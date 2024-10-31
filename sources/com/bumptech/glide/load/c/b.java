package com.bumptech.glide.load.c;

import android.content.Context;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.j;
import java.security.MessageDigest;

/* compiled from: UnitTransformation.java */
/* loaded from: classes.dex */
public final class b<T> implements j<T> {

    /* renamed from: a */
    private static final j<?> f8681a = new b();

    private b() {
    }

    public static <T> b<T> a() {
        return (b) f8681a;
    }

    @Override // com.bumptech.glide.load.j
    public E<T> a(Context context, E<T> e2, int i, int i2) {
        return e2;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
    }
}
