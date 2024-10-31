package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;

/* loaded from: classes.dex */
public final class SafetyNet {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzqo> f2189a = new Api.zzc<>();
    public static final Api.zza<zzqo, Api.ApiOptions.NoOptions> b = new a();
    public static final Api<Api.ApiOptions.NoOptions> c = new Api<>("SafetyNet.API", b, f2189a);
    public static final SafetyNetApi d = new zzqn();
    public static final zzc e = new zzqp();

    private SafetyNet() {
    }
}
