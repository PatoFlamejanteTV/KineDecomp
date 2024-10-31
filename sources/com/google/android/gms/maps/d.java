package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.StreetViewPanoramaView;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* loaded from: classes.dex */
class d extends zzv.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f1935a;
    final /* synthetic */ StreetViewPanoramaView.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StreetViewPanoramaView.a aVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.b = aVar;
        this.f1935a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
        this.f1935a.a(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
