package com.squareup.okhttp.a;

import java.io.IOException;

/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ f f25148a;

    public b(f fVar) {
        this.f25148a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        boolean s;
        synchronized (this.f25148a) {
            z = this.f25148a.p;
            boolean z3 = !z;
            z2 = this.f25148a.q;
            if (z3 || z2) {
                return;
            }
            try {
                this.f25148a.y();
                s = this.f25148a.s();
                if (s) {
                    this.f25148a.x();
                    this.f25148a.n = 0;
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
