package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListenerCallQueue.java */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class s<L> implements Runnable {

    /* renamed from: a */
    private static final Logger f16214a = Logger.getLogger(s.class.getName());

    /* renamed from: b */
    private final L f16215b;

    /* renamed from: c */
    private final Executor f16216c;

    /* renamed from: d */
    private final Queue<a<L>> f16217d;

    /* renamed from: e */
    private boolean f16218e;

    /* compiled from: ListenerCallQueue.java */
    /* loaded from: classes2.dex */
    public static abstract class a<L> {

        /* renamed from: a */
        private final String f16219a;

        public a(String str) {
            this.f16219a = str;
        }

        abstract void a(L l);

        public void a(Iterable<s<L>> iterable) {
            Iterator<s<L>> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    synchronized void a(a<L> aVar) {
        this.f16217d.add(aVar);
    }

    public void b() {
        boolean z;
        synchronized (this) {
            z = true;
            if (this.f16218e) {
                z = false;
            } else {
                this.f16218e = true;
            }
        }
        if (z) {
            try {
                this.f16216c.execute(this);
            } catch (RuntimeException e2) {
                synchronized (this) {
                    this.f16218e = false;
                    f16214a.log(Level.SEVERE, "Exception while running callbacks for " + this.f16215b + " on " + this.f16216c, (Throwable) e2);
                    throw e2;
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:28:0x0049
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r8 = this;
        L0:
            r0 = 0
            r1 = 1
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L4c
            boolean r2 = r8.f16218e     // Catch: java.lang.Throwable -> L49
            com.google.common.base.Preconditions.b(r2)     // Catch: java.lang.Throwable -> L49
            java.util.Queue<com.google.common.util.concurrent.s$a<L>> r2 = r8.f16217d     // Catch: java.lang.Throwable -> L49
            java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L49
            com.google.common.util.concurrent.s$a r2 = (com.google.common.util.concurrent.s.a) r2     // Catch: java.lang.Throwable -> L49
            if (r2 != 0) goto L1a
            r8.f16218e = r0     // Catch: java.lang.Throwable -> L49
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L16
            return
        L16:
            r1 = move-exception
            r2 = r1
            r1 = 0
            goto L4a
        L1a:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L49
            L r3 = r8.f16215b     // Catch: java.lang.RuntimeException -> L21 java.lang.Throwable -> L4c
            r2.a(r3)     // Catch: java.lang.RuntimeException -> L21 java.lang.Throwable -> L4c
            goto L0
        L21:
            r3 = move-exception
            java.util.logging.Logger r4 = com.google.common.util.concurrent.s.f16214a     // Catch: java.lang.Throwable -> L4c
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L4c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r6.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r7 = "Exception while executing callback: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L4c
            L r7 = r8.f16215b     // Catch: java.lang.Throwable -> L4c
            r6.append(r7)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r7 = "."
            r6.append(r7)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r2 = com.google.common.util.concurrent.s.a.a(r2)     // Catch: java.lang.Throwable -> L4c
            r6.append(r2)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L4c
            r4.log(r5, r2, r3)     // Catch: java.lang.Throwable -> L4c
            goto L0
        L49:
            r2 = move-exception
        L4a:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L49
            throw r2     // Catch: java.lang.Throwable -> L4c
        L4c:
            r2 = move-exception
            if (r1 == 0) goto L57
            monitor-enter(r8)
            r8.f16218e = r0     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L54
            goto L57
        L54:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L54
            throw r0
        L57:
            goto L59
        L58:
            throw r2
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.s.run():void");
    }
}
