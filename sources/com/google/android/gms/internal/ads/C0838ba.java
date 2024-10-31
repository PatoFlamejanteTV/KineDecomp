package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0838ba implements InterfaceC0951ja {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0838ba(Y y) {
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzavb zzavbVar = c0965ka.f12252f;
        if (zzavbVar != null) {
            zzavbVar.onRewardedVideoAdOpened();
        }
    }
}
