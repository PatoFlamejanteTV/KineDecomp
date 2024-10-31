package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;

/* loaded from: classes.dex */
public class zzrn implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        googleApiClient.zza((GoogleApiClient) new ji(this, googleApiClient, str, str2, i));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        googleApiClient.zza((GoogleApiClient) new jf(this, googleApiClient, i));
    }

    public void isNewUser(GoogleApiClient googleApiClient, int i) {
        googleApiClient.zza((GoogleApiClient) new jk(this, googleApiClient, i));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        googleApiClient.zza((GoogleApiClient) new jh(this, googleApiClient, fullWalletRequest, i));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        googleApiClient.zza((GoogleApiClient) new jg(this, googleApiClient, maskedWalletRequest, i));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza((GoogleApiClient) new jj(this, googleApiClient, notifyTransactionStatusRequest));
    }
}
