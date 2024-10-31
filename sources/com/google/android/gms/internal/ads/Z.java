package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Z implements InterfaceC0951ja {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(Y y) {
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzavb zzavbVar = c0965ka.f12252f;
        if (zzavbVar != null) {
            zzavbVar.onRewardedVideoAdLoaded();
        }
    }
}
