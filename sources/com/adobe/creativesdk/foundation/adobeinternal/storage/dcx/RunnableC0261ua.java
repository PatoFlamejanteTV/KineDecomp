package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ua, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0261ua implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Aa f4458a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ nb f4459b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4460c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0261ua(Aa aa, Aa aa2, nb nbVar) {
        this.f4460c = aa;
        this.f4458a = aa2;
        this.f4459b = nbVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:            r1 = r9.f4458a.d(r1);        r3 = r9.f4458a;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:            monitor-enter(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:            r4.l = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:            monitor-exit(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0033, code lost:            r0 = false;     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r9 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r0 = r9.f4458a
            java.util.Map r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r0)
            java.util.ArrayList r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r0)
            java.util.Iterator r0 = r0.iterator()
        Le:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L52
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r4 = r9.f4460c
            java.util.Map r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r4)
            java.lang.Object r4 = r4.get(r1)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb r4 = (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb) r4
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r5 = r9.f4458a
            monitor-enter(r5)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r6 = r9.f4458a     // Catch: java.lang.Throwable -> L4f
            boolean r6 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.g(r6)     // Catch: java.lang.Throwable -> L4f
            if (r6 == 0) goto L36
            r0 = 0
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4f
            goto L53
        L36:
            long r6 = r4.l     // Catch: java.lang.Throwable -> L4f
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L3e
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4f
            goto Le
        L3e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4f
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r2 = r9.f4458a
            long r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r2, r1)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r3 = r9.f4458a
            monitor-enter(r3)
            r4.l = r1     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4c
            goto Le
        L4c:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4c
            throw r0
        L4f:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4f
            throw r0
        L52:
            r0 = 1
        L53:
            if (r0 == 0) goto La5
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r0 = r9.f4458a
            monitor-enter(r0)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r1 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            java.util.Map r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r1)     // Catch: java.lang.Throwable -> La2
            java.util.ArrayList r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r1)     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r4 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r4, r2)     // Catch: java.lang.Throwable -> La2
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La2
        L6b:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto L92
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> La2
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r3 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            java.util.Map r3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb r2 = (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb) r2     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r3 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r4 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            long r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.h(r4)     // Catch: java.lang.Throwable -> La2
            long r6 = r2.l     // Catch: java.lang.Throwable -> La2
            long r4 = r4 + r6
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r3, r4)     // Catch: java.lang.Throwable -> La2
            goto L6b
        L92:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.nb r1 = r9.f4459b     // Catch: java.lang.Throwable -> La2
            if (r1 == 0) goto La0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r1 = r9.f4458a     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ta r2 = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ta     // Catch: java.lang.Throwable -> La2
            r2.<init>(r9)     // Catch: java.lang.Throwable -> La2
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.a(r1, r2)     // Catch: java.lang.Throwable -> La2
        La0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La2
            goto La5
        La2:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La2
            throw r1
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.RunnableC0261ua.run():void");
    }
}
