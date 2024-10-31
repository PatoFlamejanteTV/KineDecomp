package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
final class D extends zzafq {

    /* renamed from: a */
    private final /* synthetic */ zzbcl f11452a;

    public D(C c2, zzbcl zzbclVar) {
        this.f11452a = zzbclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafp
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.f11452a.set(parcelFileDescriptor);
    }
}
