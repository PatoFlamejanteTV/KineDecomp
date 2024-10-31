package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
final class Vj extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Uj f11912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vj(Uj uj, Looper looper) {
        super(looper);
        this.f11912a = uj;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f11912a.a(message);
    }
}
