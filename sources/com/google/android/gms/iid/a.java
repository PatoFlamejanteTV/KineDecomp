package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InstanceIDListenerService f1426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InstanceIDListenerService instanceIDListenerService, Looper looper) {
        super(looper);
        this.f1426a = instanceIDListenerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f1426a.a(message, MessengerCompat.a(message));
    }
}
