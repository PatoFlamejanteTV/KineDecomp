package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* loaded from: classes.dex */
class f extends zzv.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f1937a;
    final /* synthetic */ SupportStreetViewPanoramaFragment.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SupportStreetViewPanoramaFragment.a aVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.b = aVar;
        this.f1937a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
        this.f1937a.a(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
