package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;

/* loaded from: classes.dex */
public final class CustomEventServerParameters extends MediationServerParameters {

    /* renamed from: a */
    @MediationServerParameters.Parameter(name = "label", required = true)
    public String f9921a;

    /* renamed from: b */
    @MediationServerParameters.Parameter(name = "class_name", required = true)
    public String f9922b;

    /* renamed from: c */
    @MediationServerParameters.Parameter(name = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, required = false)
    public String f9923c = null;
}
