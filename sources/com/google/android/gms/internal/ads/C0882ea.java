package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0882ea implements InterfaceC0951ja {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaur f12134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0882ea(Y y, zzaur zzaurVar) {
        this.f12134a = zzaurVar;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzavb zzavbVar = c0965ka.f12252f;
        if (zzavbVar != null) {
            zzavbVar.zza(this.f12134a);
        }
    }
}
