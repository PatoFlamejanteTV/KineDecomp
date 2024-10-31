package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
/* loaded from: classes2.dex */
public class zzayw extends zzayv {
    @Override // com.google.android.gms.internal.ads.zzayp
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final int zzzy() {
        return 14;
    }
}
