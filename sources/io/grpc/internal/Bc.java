package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: SerializeReentrantCallsDirectExecutor.java */
/* loaded from: classes3.dex */
class Bc implements Executor {

    /* renamed from: a */
    private static final Logger f27208a = Logger.getLogger(Bc.class.getName());

    /* renamed from: b */
    private boolean f27209b;

    /* renamed from: c */
    private ArrayDeque<Runnable> f27210c;

    private void a() {
        while (true) {
            Runnable poll = this.f27210c.poll();
            if (poll == null) {
                return;
            }
            try {
                poll.run();
            } catch (Throwable th) {
                f27208a.log(Level.SEVERE, "Exception while executing runnable " + poll, th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:            if (r6.f27210c == null) goto L37;     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "'task' must not be null."
            com.google.common.base.Preconditions.a(r7, r0)
            boolean r0 = r6.f27209b
            if (r0 != 0) goto L44
            r0 = 1
            r6.f27209b = r0
            r0 = 0
            r7.run()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.f27210c
            if (r7 == 0) goto L17
        L14:
            r6.a()
        L17:
            r6.f27209b = r0
            goto L47
        L1a:
            r7 = move-exception
            goto L3a
        L1c:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.Bc.f27208a     // Catch: java.lang.Throwable -> L1a
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L1a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r4.<init>()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "Exception while executing runnable "
            r4.append(r5)     // Catch: java.lang.Throwable -> L1a
            r4.append(r7)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L1a
            r2.log(r3, r7, r1)     // Catch: java.lang.Throwable -> L1a
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.f27210c
            if (r7 == 0) goto L17
            goto L14
        L3a:
            java.util.ArrayDeque<java.lang.Runnable> r1 = r6.f27210c
            if (r1 == 0) goto L41
            r6.a()
        L41:
            r6.f27209b = r0
            throw r7
        L44:
            r6.a(r7)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Bc.execute(java.lang.Runnable):void");
    }

    private void a(Runnable runnable) {
        if (this.f27210c == null) {
            this.f27210c = new ArrayDeque<>(4);
        }
        this.f27210c.add(runnable);
    }
}
