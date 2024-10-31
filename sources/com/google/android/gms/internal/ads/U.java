package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
final class U extends zzabh {

    /* renamed from: a */
    private final /* synthetic */ I f11867a;

    public U(I i) {
        this.f11867a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzabg
    public final void zza(zzabd zzabdVar) throws RemoteException {
        List list;
        list = this.f11867a.f11588a;
        list.add(new V(this, zzabdVar));
    }
}
