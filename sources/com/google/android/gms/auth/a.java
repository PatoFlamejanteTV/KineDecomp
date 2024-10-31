package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements b<TokenData> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Account f10410a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f10411b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Bundle f10412c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Account account, String str, Bundle bundle) {
        this.f10410a = account;
        this.f10411b = str;
        this.f10412c = bundle;
    }

    @Override // com.google.android.gms.auth.b
    public final /* synthetic */ TokenData a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Logger logger;
        Bundle zza = zzf.zza(iBinder).zza(this.f10410a, this.f10411b, this.f10412c);
        zzd.a(zza);
        Bundle bundle = zza;
        TokenData a2 = TokenData.a(bundle, "tokenDetails");
        if (a2 != null) {
            return a2;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (!zzay.zza(zzc)) {
            if (zzay.NETWORK_ERROR.equals(zzc) || zzay.SERVICE_UNAVAILABLE.equals(zzc) || zzay.INTNERNAL_ERROR.equals(zzc)) {
                throw new IOException(string);
            }
            throw new GoogleAuthException(string);
        }
        logger = zzd.f10617e;
        String valueOf = String.valueOf(zzc);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("isUserRecoverableError status: ");
        sb.append(valueOf);
        logger.e("GoogleAuthUtil", sb.toString());
        throw new UserRecoverableAuthException(string, intent);
    }
}
