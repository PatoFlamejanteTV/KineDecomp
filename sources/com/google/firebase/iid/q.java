package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public final class q extends com.google.android.gms.internal.firebase_messaging.zza {

    /* renamed from: a */
    private final /* synthetic */ C1619p f17374a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(C1619p c1619p, Looper looper) {
        super(looper);
        this.f17374a = c1619p;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f17374a.a(message);
    }
}
