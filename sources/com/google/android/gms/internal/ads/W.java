package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
final class W extends zzwy {

    /* renamed from: a */
    private final /* synthetic */ I f11914a;

    public W(I i) {
        this.f11914a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdClicked() throws RemoteException {
        List list;
        list = this.f11914a.f11588a;
        list.add(new X(this));
    }
}
