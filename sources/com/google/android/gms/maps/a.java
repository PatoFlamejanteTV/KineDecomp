package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* loaded from: classes.dex */
class a extends zzl.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnMapReadyCallback f1932a;
    final /* synthetic */ MapFragment.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MapFragment.a aVar, OnMapReadyCallback onMapReadyCallback) {
        this.b = aVar;
        this.f1932a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzl
    public void a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.f1932a.a(new GoogleMap(iGoogleMapDelegate));
    }
}
