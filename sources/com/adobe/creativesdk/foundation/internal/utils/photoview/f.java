package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public /* synthetic */ class f {

    /* renamed from: a */
    static final /* synthetic */ int[] f6896a = new int[ImageView.ScaleType.values().length];

    static {
        try {
            f6896a[ImageView.ScaleType.MATRIX.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6896a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6896a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6896a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6896a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
