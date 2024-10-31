package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
final class a extends Api.zza<zzro, Wallet.WalletOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzro zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Wallet.WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (walletOptions == null) {
            walletOptions = new Wallet.WalletOptions((a) null);
        }
        return new zzro(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, walletOptions.f2295a, walletOptions.b);
    }
}
