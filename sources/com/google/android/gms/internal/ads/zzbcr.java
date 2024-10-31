package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzark
/* loaded from: classes2.dex */
public class zzbcr<T> implements zzbcn<T> {
    private final Object mLock = new Object();
    private int zzdiz = 0;
    private final BlockingQueue<C1164ye> zzepy = new LinkedBlockingQueue();
    private T zzepz;

    public final int getStatus() {
        return this.zzdiz;
    }

    public final void reject() {
        synchronized (this.mLock) {
            if (this.zzdiz == 0) {
                this.zzdiz = -1;
                Iterator it = this.zzepy.iterator();
                while (it.hasNext()) {
                    ((C1164ye) it.next()).f12684b.run();
                }
                this.zzepy.clear();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zza(zzbcq<T> zzbcqVar, zzbco zzbcoVar) {
        synchronized (this.mLock) {
            if (this.zzdiz == 1) {
                zzbcqVar.zzh(this.zzepz);
            } else if (this.zzdiz == -1) {
                zzbcoVar.run();
            } else if (this.zzdiz == 0) {
                this.zzepy.add(new C1164ye(this, zzbcqVar, zzbcoVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzo(T t) {
        synchronized (this.mLock) {
            if (this.zzdiz == 0) {
                this.zzepz = t;
                this.zzdiz = 1;
                Iterator it = this.zzepy.iterator();
                while (it.hasNext()) {
                    ((C1164ye) it.next()).f12683a.zzh(t);
                }
                this.zzepy.clear();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
