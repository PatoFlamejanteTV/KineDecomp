package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0910ga implements InterfaceC0951ja {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f12169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0910ga(Y y, int i) {
        this.f12169a = i;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzavb zzavbVar = c0965ka.f12252f;
        if (zzavbVar != null) {
            zzavbVar.onRewardedVideoAdFailedToLoad(this.f12169a);
        }
    }
}
