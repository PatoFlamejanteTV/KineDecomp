package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfu;

@zzgr
/* loaded from: classes.dex */
public final class zzfy extends com.google.android.gms.dynamic.zzg<zzfu> {
    private static final zzfy zzDb = new zzfy();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzfy() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static zzft zze(Activity activity) {
        zzft zzf;
        try {
            if (zzc(activity)) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Using AdOverlay from the client jar.");
                zzf = new com.google.android.gms.ads.internal.purchase.zze(activity);
            } else {
                zzf = zzDb.zzf(activity);
            }
            return zzf;
        } catch (zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.e(e.getMessage());
            return null;
        }
    }

    private zzft zzf(Activity activity) {
        try {
            return zzft.zza.zzQ(zzas(activity).zzf(com.google.android.gms.dynamic.zze.a(activity)));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzU, reason: merged with bridge method [inline-methods] */
    public zzfu zzd(IBinder iBinder) {
        return zzfu.zza.zzR(iBinder);
    }
}
