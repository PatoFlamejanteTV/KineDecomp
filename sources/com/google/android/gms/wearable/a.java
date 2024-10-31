package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.internal.zzbo;

/* loaded from: classes.dex */
final class a extends Api.zza<zzbo, Wearable.WearableOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzbo zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Wearable.WearableOptions wearableOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (wearableOptions == null) {
            new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
        return new zzbo(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
    }
}
