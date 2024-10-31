package com.google.ads.mediation;

import com.google.ads.mediation.MediationServerParameters;

@Deprecated
/* loaded from: classes.dex */
public interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters> {
    void a();

    Class<ADDITIONAL_PARAMETERS> b();

    Class<SERVER_PARAMETERS> c();
}
