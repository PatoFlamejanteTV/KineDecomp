package com.google.android.gms.internal.config;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;

/* loaded from: classes2.dex */
public final class zzv extends GoogleApi<Api.ApiOptions.NoOptions> {
    public zzv(Context context) {
        super(context, zze.API, (Api.ApiOptions) null, new ApiExceptionMapper());
    }
}
