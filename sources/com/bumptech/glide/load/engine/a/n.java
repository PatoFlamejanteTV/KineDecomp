package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;

/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
/* synthetic */ class n {

    /* renamed from: a */
    static final /* synthetic */ int[] f8823a = new int[Bitmap.Config.values().length];

    static {
        try {
            f8823a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8823a[Bitmap.Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8823a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8823a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
