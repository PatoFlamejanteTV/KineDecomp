package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.internal.p001authapiphone.zzi;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi {
    private static final Api.ClientKey<zzi> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new a();
    private static final Api<Api.ApiOptions.NoOptions> API = new Api<>("SmsRetriever.API", CLIENT_BUILDER, CLIENT_KEY);

    public SmsRetrieverClient(Activity activity) {
        super(activity, (Api<Api.ApiOptions>) API, (Api.ApiOptions) null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public SmsRetrieverClient(Context context) {
        super(context, API, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    public abstract Task<Void> startSmsRetriever();
}
