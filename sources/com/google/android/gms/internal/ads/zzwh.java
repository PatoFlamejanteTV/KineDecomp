package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzark
/* loaded from: classes2.dex */
public final class zzwh extends zzxu {
    private final AppEventListener zzblk;

    public zzwh(AppEventListener appEventListener) {
        this.zzblk = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzblk;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final void onAppEvent(String str, String str2) {
        this.zzblk.onAppEvent(str, str2);
    }
}
