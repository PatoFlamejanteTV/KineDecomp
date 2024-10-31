package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

/* loaded from: classes.dex */
public class LocationServices {
    private static final Api.zzc<zzl> e = new Api.zzc<>();
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> f = new c();

    /* renamed from: a, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f1846a = new Api<>("LocationServices.API", f, e);
    public static final FusedLocationProviderApi b = new com.google.android.gms.location.internal.zzd();
    public static final GeofencingApi c = new com.google.android.gms.location.internal.zzf();
    public static final SettingsApi d = new zzq();

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzlb.zza<R, zzl> {
    }

    private LocationServices() {
    }
}
