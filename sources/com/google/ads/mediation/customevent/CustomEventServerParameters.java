package com.google.ads.mediation.customevent;

import com.facebook.BuildConfig;
import com.google.ads.mediation.MediationServerParameters;

/* loaded from: classes.dex */
public final class CustomEventServerParameters extends MediationServerParameters {

    /* renamed from: a, reason: collision with root package name */
    @MediationServerParameters.Parameter(a = "label", b = true)
    public String f510a;

    @MediationServerParameters.Parameter(a = "class_name", b = true)
    public String b;

    @MediationServerParameters.Parameter(a = "parameter", b = BuildConfig.DEBUG)
    public String c = null;
}
