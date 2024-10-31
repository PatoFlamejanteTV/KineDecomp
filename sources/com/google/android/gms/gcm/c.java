package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleCloudMessaging f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(GoogleCloudMessaging googleCloudMessaging, Looper looper) {
        super(looper);
        this.f1414a = googleCloudMessaging;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean b;
        Context context;
        Context context2;
        BlockingQueue blockingQueue;
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            blockingQueue = this.f1414a.j;
            blockingQueue.add(intent);
            return;
        }
        b = this.f1414a.b(intent);
        if (b) {
            return;
        }
        context = this.f1414a.f;
        intent.setPackage(context.getPackageName());
        context2 = this.f1414a.f;
        context2.sendBroadcast(intent);
    }
}
