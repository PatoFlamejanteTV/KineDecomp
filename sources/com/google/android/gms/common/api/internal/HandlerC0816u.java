package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0816u extends zap {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaaw f10859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0816u(zaaw zaawVar, Looper looper) {
        super(looper);
        this.f10859a = zaawVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f10859a.q();
            return;
        }
        if (i != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GoogleApiClientImpl", sb.toString());
            return;
        }
        this.f10859a.o();
    }
}
