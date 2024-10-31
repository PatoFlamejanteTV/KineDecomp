package com.google.android.gms.ads.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;

/* loaded from: classes.dex */
public interface MediationRewardedVideoAdAdapter extends MediationAdapter {
    void a(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2);

    void a(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2);

    void d();

    boolean e();
}