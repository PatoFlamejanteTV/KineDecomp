package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class J extends ContentObserver {

    /* renamed from: a */
    private final /* synthetic */ zzrx f13376a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(zzrx zzrxVar, Handler handler) {
        super(null);
        this.f13376a = zzrxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f13376a.zztl();
    }
}
