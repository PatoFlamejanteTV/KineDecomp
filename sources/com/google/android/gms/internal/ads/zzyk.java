package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* loaded from: classes2.dex */
public final class zzyk extends zzyi {
    private final MuteThisAdListener zzclv;

    public zzyk(MuteThisAdListener muteThisAdListener) {
        this.zzclv = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void onAdMuted() {
        this.zzclv.onAdMuted();
    }
}
