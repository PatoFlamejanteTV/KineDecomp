package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzss {
    private int zzbxn;
    private final Object mLock = new Object();
    private List<zzsr> zzbxo = new LinkedList();

    public final boolean zza(zzsr zzsrVar) {
        synchronized (this.mLock) {
            return this.zzbxo.contains(zzsrVar);
        }
    }

    public final boolean zzb(zzsr zzsrVar) {
        synchronized (this.mLock) {
            Iterator<zzsr> it = this.zzbxo.iterator();
            while (it.hasNext()) {
                zzsr next = it.next();
                if (!com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzc()) {
                    if (zzsrVar != next && next.zznj().equals(zzsrVar.zznj())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.zzbv.i().zzyq().zzze() && zzsrVar != next && next.zznl().equals(zzsrVar.zznl())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzsr zzsrVar) {
        synchronized (this.mLock) {
            if (this.zzbxo.size() >= 10) {
                int size = this.zzbxo.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzbbd.zzdn(sb.toString());
                this.zzbxo.remove(0);
            }
            int i = this.zzbxn;
            this.zzbxn = i + 1;
            zzsrVar.zzbx(i);
            this.zzbxo.add(zzsrVar);
        }
    }

    public final zzsr zznr() {
        synchronized (this.mLock) {
            zzsr zzsrVar = null;
            if (this.zzbxo.size() == 0) {
                zzbbd.zzdn("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzbxo.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzsr zzsrVar2 : this.zzbxo) {
                    int score = zzsrVar2.getScore();
                    if (score > i2) {
                        i = i3;
                        zzsrVar = zzsrVar2;
                        i2 = score;
                    }
                    i3++;
                }
                this.zzbxo.remove(i);
                return zzsrVar;
            }
            zzsr zzsrVar3 = this.zzbxo.get(0);
            zzsrVar3.zznm();
            return zzsrVar3;
        }
    }
}
