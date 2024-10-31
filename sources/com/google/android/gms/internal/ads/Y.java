package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
final class Y extends zzavc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ I f11971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(I i) {
        this.f11971a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0868da(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0910ga(this, i));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0896fa(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new Z(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0838ba(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoCompleted() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0924ha(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoStarted() throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0853ca(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zza(zzaur zzaurVar) throws RemoteException {
        List list;
        list = this.f11971a.f11588a;
        list.add(new C0882ea(this, zzaurVar));
    }
}
