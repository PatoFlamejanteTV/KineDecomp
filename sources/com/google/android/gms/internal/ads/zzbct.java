package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

@zzark
/* loaded from: classes2.dex */
public final class zzbct {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new ViewTreeObserverOnGlobalLayoutListenerC1178ze(view, onGlobalLayoutListener).a();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new Ae(view, onScrollChangedListener).a();
    }
}
