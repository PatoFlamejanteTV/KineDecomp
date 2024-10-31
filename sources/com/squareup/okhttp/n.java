package com.squareup.okhttp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPool.java */
/* loaded from: classes3.dex */
public class n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ o f25510a;

    public n(o oVar) {
        this.f25510a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            long a2 = this.f25510a.a(System.nanoTime());
            if (a2 == -1) {
                return;
            }
            if (a2 > 0) {
                long j = a2 / 1000000;
                long j2 = a2 - (1000000 * j);
                synchronized (this.f25510a) {
                    try {
                        this.f25510a.wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
