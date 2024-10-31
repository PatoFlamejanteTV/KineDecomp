package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class NativeAd {

    /* loaded from: classes.dex */
    public static abstract class Image {
        public abstract Drawable getDrawable();

        public abstract double getScale();

        public abstract Uri getUri();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzaH();
}
