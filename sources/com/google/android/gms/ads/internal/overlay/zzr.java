package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;

@zzark
/* loaded from: classes.dex */
public final class zzr extends zzd {
    public zzr(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzd, com.google.android.gms.internal.ads.zzaop
    public final void onCreate(Bundle bundle) {
        zzaxz.v("AdOverlayParcel is null or does not contain valid overlay type.");
        this.n = 3;
        this.f10127b.finish();
    }
}
