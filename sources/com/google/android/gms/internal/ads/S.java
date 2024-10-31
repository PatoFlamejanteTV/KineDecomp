package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
final class S extends zzxu {

    /* renamed from: a */
    private final /* synthetic */ I f11818a;

    public S(I i) {
        this.f11818a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final void onAppEvent(String str, String str2) throws RemoteException {
        List list;
        list = this.f11818a.f11588a;
        list.add(new T(this, str, str2));
    }
}
