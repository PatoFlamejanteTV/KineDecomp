package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.MessagesOptions;

/* loaded from: classes.dex */
final class c extends Api.zza<a, MessagesOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new a(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar, messagesOptions);
    }

    @Override // com.google.android.gms.common.api.Api.zza
    public int getPriority() {
        return Integer.MAX_VALUE;
    }
}
