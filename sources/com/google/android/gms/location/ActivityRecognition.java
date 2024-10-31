package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.location.internal.zzl;

/* loaded from: classes.dex */
public class ActivityRecognition {
    private static final Api.zzc<zzl> c = new Api.zzc<>();
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> d = new a();

    /* renamed from: a, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f1836a = new Api<>("ActivityRecognition.API", d, c);
    public static final ActivityRecognitionApi b = new com.google.android.gms.location.internal.zza();

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzlb.zza<R, zzl> {
    }

    private ActivityRecognition() {
    }
}
