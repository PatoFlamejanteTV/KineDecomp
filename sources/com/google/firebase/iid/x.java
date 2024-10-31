package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a */
    final Intent f17395a;

    /* renamed from: b */
    private final BroadcastReceiver.PendingResult f17396b;

    /* renamed from: c */
    private boolean f17397c = false;

    /* renamed from: d */
    private final ScheduledFuture<?> f17398d;

    public x(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f17395a = intent;
        this.f17396b = pendingResult;
        this.f17398d = scheduledExecutorService.schedule(new Runnable(this, intent) { // from class: com.google.firebase.iid.y

            /* renamed from: a, reason: collision with root package name */
            private final x f17399a;

            /* renamed from: b, reason: collision with root package name */
            private final Intent f17400b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17399a = this;
                this.f17400b = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f17399a;
                String action = this.f17400b.getAction();
                StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                sb.append("Service took too long to process intent: ");
                sb.append(action);
                sb.append(" App may get closed.");
                Log.w("EnhancedIntentService", sb.toString());
                xVar.a();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
    }

    public final synchronized void a() {
        if (!this.f17397c) {
            this.f17396b.finish();
            this.f17398d.cancel(false);
            this.f17397c = true;
        }
    }
}
