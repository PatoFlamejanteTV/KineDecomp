package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzc extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zze> f17285a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> f17286b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final Api<Api.ApiOptions.NoOptions> f17287c = new Api<>("DynamicLinks.API", f17286b, f17285a);

    @VisibleForTesting
    public zzc(Context context) {
        super(context, f17287c, (Api.ApiOptions) null, GoogleApi.Settings.f10684a);
    }
}
