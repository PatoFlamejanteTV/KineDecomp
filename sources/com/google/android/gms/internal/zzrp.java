package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* loaded from: classes.dex */
public class zzrp extends com.google.android.gms.dynamic.zzg<zzrk> {
    private static zzrp zzbeB;

    protected zzrp() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzrp zzEH() {
        if (zzbeB == null) {
            zzbeB = new zzrp();
        }
        return zzbeB;
    }

    public static zzrh zza(Activity activity, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzri zzriVar) throws GooglePlayServicesNotAvailableException {
        int a2 = GooglePlayServicesUtil.a(activity);
        if (a2 != 0) {
            throw new GooglePlayServicesNotAvailableException(a2);
        }
        try {
            return zzEH().zzas(activity).zza(com.google.android.gms.dynamic.zze.a(activity), zzcVar, walletFragmentOptions, zzriVar);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (zzg.zza e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzec, reason: merged with bridge method [inline-methods] */
    public zzrk zzd(IBinder iBinder) {
        return zzrk.zza.zzdY(iBinder);
    }
}
