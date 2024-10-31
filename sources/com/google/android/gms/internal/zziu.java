package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public class zziu {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new ef(view, onGlobalLayoutListener).a();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new eg(view, onScrollChangedListener).a();
    }
}
