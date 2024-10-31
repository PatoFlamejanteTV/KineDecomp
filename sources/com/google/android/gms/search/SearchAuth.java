package com.google.android.gms.search;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqt;

/* loaded from: classes.dex */
public class SearchAuth {
    private static final Api.zza<zzqs, Api.ApiOptions.NoOptions> d = new a();

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzqs> f2191a = new Api.zzc<>();
    public static final Api<Api.ApiOptions.NoOptions> b = new Api<>("SearchAuth.API", d, f2191a);
    public static final SearchAuthApi c = new zzqt();

    /* loaded from: classes.dex */
    public static class StatusCodes {
    }

    private SearchAuth() {
    }
}
