package com.google.android.gms.panorama;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqa;

/* loaded from: classes2.dex */
public final class Panorama {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzqa> f2143a = new Api.zzc<>();
    static final Api.zza<zzqa, Api.ApiOptions.NoOptions> b = new a();
    public static final Api<Api.ApiOptions.NoOptions> c = new Api<>("Panorama.API", b, f2143a);
    public static final PanoramaApi d = new zzpz();

    private Panorama() {
    }
}
