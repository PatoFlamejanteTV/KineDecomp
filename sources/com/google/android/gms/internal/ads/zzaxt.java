package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzark
/* loaded from: classes2.dex */
public final class zzaxt implements zzsw {
    private final zzayb zzejz;

    @VisibleForTesting
    private final zzaxp zzekb;
    private final Object lock = new Object();

    @VisibleForTesting
    private final HashSet<zzaxh> zzekc = new HashSet<>();

    @VisibleForTesting
    private final HashSet<zzaxs> zzekd = new HashSet<>();
    private final zzaxr zzeka = new zzaxr();

    public zzaxt(String str, zzayb zzaybVar) {
        this.zzekb = new zzaxp(str, zzaybVar);
        this.zzejz = zzaybVar;
    }

    public final void zza(zzaxs zzaxsVar) {
        synchronized (this.lock) {
            this.zzekd.add(zzaxsVar);
        }
    }

    public final void zzb(zzaxh zzaxhVar) {
        synchronized (this.lock) {
            this.zzekc.add(zzaxhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzs(boolean z) {
        long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
        if (z) {
            if (a2 - this.zzejz.zzzj() > ((Long) zzwu.zzpz().zzd(zzaan.zzcrn)).longValue()) {
                this.zzekb.zzejp = -1;
                return;
            } else {
                this.zzekb.zzejp = this.zzejz.zzzk();
                return;
            }
        }
        this.zzejz.zzau(a2);
        this.zzejz.zzcw(this.zzekb.zzejp);
    }

    public final void zzxv() {
        synchronized (this.lock) {
            this.zzekb.zzxv();
        }
    }

    public final void zzxw() {
        synchronized (this.lock) {
            this.zzekb.zzxw();
        }
    }

    public final Bundle zza(Context context, zzaxq zzaxqVar) {
        HashSet<zzaxh> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzekc);
            this.zzekc.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzekb.zzl(context, this.zzeka.zzyw()));
        Bundle bundle2 = new Bundle();
        Iterator<zzaxs> it = this.zzekd.iterator();
        while (it.hasNext()) {
            zzaxs next = it.next();
            bundle2.putBundle(next.zzyx(), next.toBundle());
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzaxh> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzaxqVar.zza(hashSet);
        return bundle;
    }

    public final void zzb(HashSet<zzaxh> hashSet) {
        synchronized (this.lock) {
            this.zzekc.addAll(hashSet);
        }
    }

    public final void zzb(zzwb zzwbVar, long j) {
        synchronized (this.lock) {
            this.zzekb.zzb(zzwbVar, j);
        }
    }

    public final zzaxh zza(Clock clock, String str) {
        return new zzaxh(clock, this, this.zzeka.zzyv(), str);
    }
}
