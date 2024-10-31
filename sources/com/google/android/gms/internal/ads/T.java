package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class T implements InterfaceC0951ja {

    /* renamed from: a */
    private final /* synthetic */ String f11837a;

    /* renamed from: b */
    private final /* synthetic */ String f11838b;

    public T(S s, String str, String str2) {
        this.f11837a = str;
        this.f11838b = str2;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0951ja
    public final void a(C0965ka c0965ka) throws RemoteException {
        zzxt zzxtVar = c0965ka.f12249c;
        if (zzxtVar != null) {
            zzxtVar.onAppEvent(this.f11837a, this.f11838b);
        }
    }
}
