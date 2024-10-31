package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzii f1521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(zzii zziiVar) {
        this.f1521a = zziiVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0012 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r2 = this;
            com.google.android.gms.internal.zzii r0 = r2.f1521a
            java.lang.Object r1 = com.google.android.gms.internal.zzii.zza(r0)
            monitor-enter(r1)
            java.lang.String r0 = "Suspending the looper thread"
            com.google.android.gms.ads.internal.util.client.zzb.d(r0)     // Catch: java.lang.Throwable -> L2a
        Lc:
            com.google.android.gms.internal.zzii r0 = r2.f1521a     // Catch: java.lang.Throwable -> L2a
            int r0 = com.google.android.gms.internal.zzii.zzb(r0)     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L2d
            com.google.android.gms.internal.zzii r0 = r2.f1521a     // Catch: java.lang.InterruptedException -> L23 java.lang.Throwable -> L2a
            java.lang.Object r0 = com.google.android.gms.internal.zzii.zza(r0)     // Catch: java.lang.InterruptedException -> L23 java.lang.Throwable -> L2a
            r0.wait()     // Catch: java.lang.InterruptedException -> L23 java.lang.Throwable -> L2a
            java.lang.String r0 = "Looper thread resumed"
            com.google.android.gms.ads.internal.util.client.zzb.d(r0)     // Catch: java.lang.InterruptedException -> L23 java.lang.Throwable -> L2a
            goto Lc
        L23:
            r0 = move-exception
            java.lang.String r0 = "Looper thread interrupted."
            com.google.android.gms.ads.internal.util.client.zzb.d(r0)     // Catch: java.lang.Throwable -> L2a
            goto Lc
        L2a:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            throw r0
        L2d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.eb.run():void");
    }
}
