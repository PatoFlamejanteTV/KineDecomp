package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.internal.phenotype.zze;

@KeepForSdk
/* loaded from: classes2.dex */
public final class Phenotype {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zze> f14101a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> f14102b = new f();

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final Api<Api.ApiOptions.NoOptions> f14103c = new Api<>("Phenotype.API", f14102b, f14101a);

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    private static final zzm f14104d = new zzd();

    private Phenotype() {
    }

    @KeepForSdk
    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
