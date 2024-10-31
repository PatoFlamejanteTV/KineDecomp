package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class L implements InterfaceC0951ja {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f11651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(J j, int i) {
        this.f11651a = i;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzxa zzxaVar = c0965ka.f12247a;
        if (zzxaVar != null) {
            zzxaVar.onAdFailedToLoad(this.f11651a);
        }
    }
}
