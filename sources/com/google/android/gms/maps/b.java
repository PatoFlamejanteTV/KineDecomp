package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* loaded from: classes.dex */
class b extends zzl.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnMapReadyCallback f1933a;
    final /* synthetic */ MapView.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MapView.a aVar, OnMapReadyCallback onMapReadyCallback) {
        this.b = aVar;
        this.f1933a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzl
    public void a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.f1933a.a(new GoogleMap(iGoogleMapDelegate));
    }
}
