package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class O implements InterfaceC0951ja {
    /* JADX INFO: Access modifiers changed from: package-private */
    public O(J j) {
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzxa zzxaVar = c0965ka.f12247a;
        if (zzxaVar != null) {
            zzxaVar.onAdOpened();
        }
    }
}
