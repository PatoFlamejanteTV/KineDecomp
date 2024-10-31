package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;

/* loaded from: classes.dex */
public interface MediationBannerAdapter extends MediationAdapter {
    void a(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2);

    View d();
}
