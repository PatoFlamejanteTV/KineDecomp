package com.google.android.gms.appinvite;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjw;

/* loaded from: classes.dex */
public final class AppInvite {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzjw> f776a = new Api.zzc<>();
    private static final Api.zza<zzjw, Api.ApiOptions.NoOptions> d = new a();
    public static final Api<Api.ApiOptions.NoOptions> b = new Api<>("AppInvite.API", d, f776a);
    public static final AppInviteApi c = new zzjv();

    private AppInvite() {
    }
}
