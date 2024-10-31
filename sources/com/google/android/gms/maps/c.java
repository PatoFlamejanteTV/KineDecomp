package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* loaded from: classes.dex */
class c extends zzv.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f1934a;
    final /* synthetic */ StreetViewPanoramaFragment.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(StreetViewPanoramaFragment.a aVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.b = aVar;
        this.f1934a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
        this.f1934a.a(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
