package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
final class J extends zzxb {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ I f11617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(I i) {
        this.f11617a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClicked() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new Q(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClosed() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new K(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new L(this, i));
        zzaxz.v("Pooled interstitial failed to load.");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdImpression() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new P(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLeftApplication() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new M(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLoaded() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new N(this));
        zzaxz.v("Pooled interstitial loaded.");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdOpened() throws RemoteException {
        List list;
        list = this.f11617a.f11588a;
        list.add(new O(this));
    }
}
