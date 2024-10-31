package com.bumptech.glide.g;

import android.graphics.Bitmap;

/* compiled from: Util.java */
/* loaded from: classes.dex */
/* synthetic */ class m {

    /* renamed from: a */
    static final /* synthetic */ int[] f8518a = new int[Bitmap.Config.values().length];

    static {
        try {
            f8518a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8518a[Bitmap.Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8518a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8518a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f8518a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
