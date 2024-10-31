package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* loaded from: classes.dex */
class e extends zzl.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnMapReadyCallback f1936a;
    final /* synthetic */ SupportMapFragment.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SupportMapFragment.a aVar, OnMapReadyCallback onMapReadyCallback) {
        this.b = aVar;
        this.f1936a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzl
    public void a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.f1936a.a(new GoogleMap(iGoogleMapDelegate));
    }
}
