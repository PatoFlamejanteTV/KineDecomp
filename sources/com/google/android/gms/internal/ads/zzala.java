package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzark
/* loaded from: classes2.dex */
public final class zzala implements zzakp {
    private final Context mContext;
    private final long mStartTime;
    private final zzalg zzbma;
    private final boolean zzbum;
    private final zzakr zzdmn;
    private final boolean zzdms;
    private final boolean zzdmt;
    private final zzasi zzdnh;
    private final long zzdni;
    private final String zzdnm;
    private final Object mLock = new Object();
    private boolean zzdnk = false;
    private final Map<zzbcb<zzakx>, zzaku> zzdnl = new HashMap();
    private List<zzakx> zzdnn = new ArrayList();
    private final int zzdnj = 2;

    public zzala(Context context, zzasi zzasiVar, zzalg zzalgVar, zzakr zzakrVar, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.mContext = context;
        this.zzdnh = zzasiVar;
        this.zzbma = zzalgVar;
        this.zzdmn = zzakrVar;
        this.zzbum = z;
        this.zzdms = z2;
        this.zzdnm = str;
        this.mStartTime = j;
        this.zzdni = j2;
        this.zzdmt = z3;
    }

    private final void zza(zzbcb<zzakx> zzbcbVar) {
        zzayh.zzelc.post(new RunnableC0994mb(this, zzbcbVar));
    }

    private final zzakx zzi(List<zzbcb<zzakx>> list) {
        synchronized (this.mLock) {
            if (this.zzdnk) {
                return new zzakx(-1);
            }
            for (zzbcb<zzakx> zzbcbVar : list) {
                try {
                    zzakx zzakxVar = zzbcbVar.get();
                    this.zzdnn.add(zzakxVar);
                    if (zzakxVar != null && zzakxVar.zzdna == 0) {
                        zza(zzbcbVar);
                        return zzakxVar;
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    zzbbd.zzc("Exception while processing an adapter; continuing with other adapters", e2);
                }
            }
            zza((zzbcb<zzakx>) null);
            return new zzakx(1);
        }
    }

    private final zzakx zzj(List<zzbcb<zzakx>> list) {
        zzakx zzakxVar;
        zzalp zzalpVar;
        synchronized (this.mLock) {
            if (this.zzdnk) {
                return new zzakx(-1);
            }
            long j = this.zzdmn.zzdmb;
            if (j == -1) {
                j = 10000;
            }
            zzbcb<zzakx> zzbcbVar = null;
            long j2 = j;
            zzakx zzakxVar2 = null;
            int i = -1;
            for (zzbcb<zzakx> zzbcbVar2 : list) {
                long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
                if (j2 == 0) {
                    try {
                        try {
                        } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e2) {
                            zzbbd.zzc("Exception while processing an adapter; continuing with other adapters", e2);
                        }
                        if (zzbcbVar2.isDone()) {
                            zzakxVar = zzbcbVar2.get();
                            this.zzdnn.add(zzakxVar);
                            if (zzakxVar != null && zzakxVar.zzdna == 0 && (zzalpVar = zzakxVar.zzdnf) != null && zzalpVar.zzur() > i) {
                                i = zzalpVar.zzur();
                                zzbcbVar = zzbcbVar2;
                                zzakxVar2 = zzakxVar;
                            }
                        }
                    } finally {
                        Math.max(j2 - (com.google.android.gms.ads.internal.zzbv.l().a() - a2), 0L);
                    }
                }
                zzakxVar = zzbcbVar2.get(j2, TimeUnit.MILLISECONDS);
                this.zzdnn.add(zzakxVar);
                if (zzakxVar != null) {
                    i = zzalpVar.zzur();
                    zzbcbVar = zzbcbVar2;
                    zzakxVar2 = zzakxVar;
                }
            }
            zza(zzbcbVar);
            return zzakxVar2 == null ? new zzakx(1) : zzakxVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzdnk = true;
            Iterator<zzaku> it = this.zzdnl.values().iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final zzakx zzh(List<zzakq> list) {
        zzbbd.zzdn("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzwf zzwfVar = this.zzdnh.zzbst;
        int[] iArr = new int[2];
        if (zzwfVar.zzckm != null) {
            com.google.android.gms.ads.internal.zzbv.y();
            if (zzakz.zza(this.zzdnm, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                zzwf[] zzwfVarArr = zzwfVar.zzckm;
                int length = zzwfVarArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    zzwf zzwfVar2 = zzwfVarArr[i];
                    if (i2 == zzwfVar2.width && i3 == zzwfVar2.height) {
                        zzwfVar = zzwfVar2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<zzakq> it = list.iterator();
        while (it.hasNext()) {
            zzakq next = it.next();
            String valueOf = String.valueOf(next.zzdkv);
            zzbbd.zzen(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            for (Iterator<String> it2 = next.zzdkw.iterator(); it2.hasNext(); it2 = it2) {
                String next2 = it2.next();
                Context context = this.mContext;
                zzalg zzalgVar = this.zzbma;
                zzakr zzakrVar = this.zzdmn;
                zzasi zzasiVar = this.zzdnh;
                ArrayList arrayList2 = arrayList;
                zzaku zzakuVar = new zzaku(context, next2, zzalgVar, zzakrVar, next, zzasiVar.zzdwg, zzwfVar, zzasiVar.zzbsp, this.zzbum, this.zzdms, zzasiVar.zzbti, zzasiVar.zzbtt, zzasiVar.zzdwu, zzasiVar.zzdxp, this.zzdmt);
                zzbcb<zzakx> zza = zzayf.zza(new CallableC0980lb(this, zzakuVar));
                this.zzdnl.put(zza, zzakuVar);
                arrayList2.add(zza);
                it = it;
                arrayList = arrayList2;
            }
        }
        ArrayList arrayList3 = arrayList;
        if (this.zzdnj != 2) {
            return zzi(arrayList3);
        }
        return zzj(arrayList3);
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final List<zzakx> zzui() {
        return this.zzdnn;
    }
}
