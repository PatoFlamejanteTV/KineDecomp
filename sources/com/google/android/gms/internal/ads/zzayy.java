package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
/* loaded from: classes2.dex */
public class zzayy extends zzayw {
    @Override // com.google.android.gms.internal.ads.zzayw, com.google.android.gms.internal.ads.zzayp
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final ViewGroup.LayoutParams zzzz() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
