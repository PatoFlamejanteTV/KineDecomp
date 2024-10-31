package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.internal.zzoy;

/* loaded from: classes.dex */
final class a extends Api.zza<zzoy, Address.AddressOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzoy zza(Context context, Looper looper, zzf zzfVar, Address.AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.b(context instanceof Activity, "An Activity must be used for Address APIs");
        if (addressOptions == null) {
            addressOptions = new Address.AddressOptions();
        }
        return new zzoy((Activity) context, looper, zzfVar, addressOptions.f1418a, connectionCallbacks, onConnectionFailedListener);
    }
}
