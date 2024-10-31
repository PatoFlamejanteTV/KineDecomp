package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zze {
    private static final Api.ClientKey<zzw> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zze = new c();
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Config.API", zze, CLIENT_KEY);
    public static final zzg zzf = new zzo();
}
