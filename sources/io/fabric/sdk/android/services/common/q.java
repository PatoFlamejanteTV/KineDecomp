package io.fabric.sdk.android.services.common;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes3.dex */
class q extends j {

    /* renamed from: a */
    final /* synthetic */ String f26902a;

    /* renamed from: b */
    final /* synthetic */ ExecutorService f26903b;

    /* renamed from: c */
    final /* synthetic */ long f26904c;

    /* renamed from: d */
    final /* synthetic */ TimeUnit f26905d;

    public q(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f26902a = str;
        this.f26903b = executorService;
        this.f26904c = j;
        this.f26905d = timeUnit;
    }

    @Override // io.fabric.sdk.android.services.common.j
    public void onRun() {
        try {
            io.fabric.sdk.android.f.f().d("Fabric", "Executing shutdown hook for " + this.f26902a);
            this.f26903b.shutdown();
            if (this.f26903b.awaitTermination(this.f26904c, this.f26905d)) {
                return;
            }
            io.fabric.sdk.android.f.f().d("Fabric", this.f26902a + " did not shut down in the allocated time. Requesting immediate shutdown.");
            this.f26903b.shutdownNow();
        } catch (InterruptedException unused) {
            io.fabric.sdk.android.f.f().d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f26902a));
            this.f26903b.shutdownNow();
        }
    }
}
