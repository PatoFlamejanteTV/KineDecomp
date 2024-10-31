package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Random;

/* renamed from: com.google.android.gms.internal.ads.la, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class BinderC0979la extends zzxb {

    /* renamed from: a, reason: collision with root package name */
    private final zzxa f12289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC0979la(zzxa zzxaVar) {
        this.f12289a = zzxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClicked() throws RemoteException {
        this.f12289a.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClosed() throws RemoteException {
        if (C1062ra.a()) {
            int intValue = ((Integer) zzwu.zzpz().zzd(zzaan.zzcsh)).intValue();
            int intValue2 = ((Integer) zzwu.zzpz().zzd(zzaan.zzcsi)).intValue();
            if (intValue > 0 && intValue2 >= 0) {
                zzayh.zzelc.postDelayed(RunnableC0993ma.f12319a, intValue + new Random().nextInt(intValue2 + 1));
            } else {
                com.google.android.gms.ads.internal.zzbv.s().zzth();
            }
        }
        this.f12289a.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.f12289a.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdImpression() throws RemoteException {
        this.f12289a.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLeftApplication() throws RemoteException {
        this.f12289a.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLoaded() throws RemoteException {
        this.f12289a.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdOpened() throws RemoteException {
        this.f12289a.onAdOpened();
    }
}
