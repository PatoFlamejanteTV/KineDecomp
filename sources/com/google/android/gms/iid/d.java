package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f1428a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zzc zzcVar, Looper looper) {
        super(looper);
        this.f1428a = zzcVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f1428a.a(message);
    }
}
