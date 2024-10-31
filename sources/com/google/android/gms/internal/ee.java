package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class ee {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1524a = new Object();
    private final List<Runnable> b = new ArrayList();
    private final List<Runnable> c = new ArrayList();
    private boolean d = false;

    private void c(Runnable runnable) {
        zzic.zza(runnable);
    }

    private void d(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(runnable);
    }

    public void a() {
        synchronized (this.f1524a) {
            if (this.d) {
                return;
            }
            Iterator<Runnable> it = this.b.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            Iterator<Runnable> it2 = this.c.iterator();
            while (it2.hasNext()) {
                d(it2.next());
            }
            this.b.clear();
            this.c.clear();
            this.d = true;
        }
    }

    public void a(Runnable runnable) {
        synchronized (this.f1524a) {
            if (this.d) {
                c(runnable);
            } else {
                this.b.add(runnable);
            }
        }
    }

    public void b(Runnable runnable) {
        synchronized (this.f1524a) {
            if (this.d) {
                d(runnable);
            } else {
                this.c.add(runnable);
            }
        }
    }
}
