package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class X implements InterfaceC0951ja {
    public X(W w) {
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzwx zzwxVar = c0965ka.f12251e;
        if (zzwxVar != null) {
            zzwxVar.onAdClicked();
        }
    }
}
