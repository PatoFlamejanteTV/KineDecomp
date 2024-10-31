package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class zzqu {
    public static final Api.zzc<com.google.android.gms.signin.internal.zzi> zzRk = new Api.zzc<>();
    public static final Api.zzc<com.google.android.gms.signin.internal.zzi> zzapF = new Api.zzc<>();
    public static final Api.zza<com.google.android.gms.signin.internal.zzi, zzqx> zzRl = new jb();
    static final Api.zza<com.google.android.gms.signin.internal.zzi, Api.ApiOptions.NoOptions> zzaUX = new jc();
    public static final Scope zzTe = new Scope("profile");
    public static final Scope zzTf = new Scope("email");
    public static final Api<zzqx> API = new Api<>("SignIn.API", zzRl, zzRk);
    public static final Api<Api.ApiOptions.NoOptions> zzaiH = new Api<>("SignIn.INTERNAL_API", zzaUX, zzapF);
    public static final zzqv zzaUY = new com.google.android.gms.signin.internal.zzh();
}
