package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;

/* loaded from: classes.dex */
public interface CustomEventInterstitial extends CustomEvent {
    void a(Context context, CustomEventInterstitialListener customEventInterstitialListener, String str, MediationAdRequest mediationAdRequest, Bundle bundle);

    void d();
}
