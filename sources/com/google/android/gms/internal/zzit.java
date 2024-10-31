package com.google.android.gms.internal;

import com.google.android.gms.internal.zzis;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgr
/* loaded from: classes.dex */
public class zzit<T> implements zzis<T> {
    protected T zzJN;
    private final Object zzpd = new Object();
    protected int zzys = 0;
    protected final BlockingQueue<zzit<T>.a> zzJM = new LinkedBlockingQueue();

    /* loaded from: classes.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        public final zzis.zzc<T> f1727a;
        public final zzis.zza b;

        public a(zzis.zzc<T> zzcVar, zzis.zza zzaVar) {
            this.f1727a = zzcVar;
            this.b = zzaVar;
        }
    }

    public int getStatus() {
        return this.zzys;
    }

    public void reject() {
        synchronized (this.zzpd) {
            if (this.zzys != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzys = -1;
            Iterator it = this.zzJM.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b.run();
            }
            this.zzJM.clear();
        }
    }

    public void zza(zzis.zzc<T> zzcVar, zzis.zza zzaVar) {
        synchronized (this.zzpd) {
            if (this.zzys == 1) {
                zzcVar.zzc(this.zzJN);
            } else if (this.zzys == -1) {
                zzaVar.run();
            } else if (this.zzys == 0) {
                this.zzJM.add(new a(zzcVar, zzaVar));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzpd) {
            if (this.zzys != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzJN = t;
            this.zzys = 1;
            Iterator it = this.zzJM.iterator();
            while (it.hasNext()) {
                ((a) it.next()).f1727a.zzc(t);
            }
            this.zzJM.clear();
        }
    }
}
