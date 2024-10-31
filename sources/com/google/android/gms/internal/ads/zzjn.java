package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class zzjn implements zzhz, zzig {
    private static final zzic zzahq = new Vk();
    private static final int zzasf = zzqe.zzam("qt  ");
    private long zzaan;
    private int zzajm;
    private int zzajn;
    private zzib zzajq;
    private int zzaqe;
    private int zzaqf;
    private long zzaqg;
    private int zzaqh;
    private zzpx zzaqi;
    private Wk[] zzasg;
    private boolean zzash;
    private final zzpx zzaqa = new zzpx(16);
    private final Stack<Fk> zzaqc = new Stack<>();
    private final zzpx zzahx = new zzpx(zzpu.zzbhi);
    private final zzpx zzahy = new zzpx(4);

    private final void zzei() {
        this.zzaqe = 0;
        this.zzaqh = 0;
    }

    private final void zzt(long j) throws zzfx {
        zzjs a2;
        while (!this.zzaqc.isEmpty() && this.zzaqc.peek().Qa == j) {
            Fk pop = this.zzaqc.pop();
            if (pop.Pa == Ek.B) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                zzki zzkiVar = null;
                zzid zzidVar = new zzid();
                Gk d2 = pop.d(Ek.Aa);
                if (d2 != null && (zzkiVar = Hk.a(d2, this.zzash)) != null) {
                    zzidVar.zzb(zzkiVar);
                }
                for (int i = 0; i < pop.Sa.size(); i++) {
                    Fk fk = pop.Sa.get(i);
                    if (fk.Pa == Ek.D && (a2 = Hk.a(fk, pop.d(Ek.C), -9223372036854775807L, (zzhp) null, this.zzash)) != null) {
                        Zk a3 = Hk.a(a2, fk.e(Ek.E).e(Ek.F).e(Ek.G), zzidVar);
                        if (a3.f12013a != 0) {
                            Wk wk = new Wk(a2, a3, this.zzajq.zzb(i, a2.type));
                            zzfs zzj = a2.zzaad.zzj(a3.f12016d + 30);
                            if (a2.type == 1) {
                                if (zzidVar.zzea()) {
                                    zzj = zzj.zza(zzidVar.zzzw, zzidVar.zzzx);
                                }
                                if (zzkiVar != null) {
                                    zzj = zzj.zza(zzkiVar);
                                }
                            }
                            wk.f11944c.zzf(zzj);
                            j2 = Math.max(j2, a2.zzaan);
                            arrayList.add(wk);
                        }
                    }
                }
                this.zzaan = j2;
                this.zzasg = (Wk[]) arrayList.toArray(new Wk[arrayList.size()]);
                this.zzajq.zzdy();
                this.zzajq.zza(this);
                this.zzaqc.clear();
                this.zzaqe = 2;
            } else if (!this.zzaqc.isEmpty()) {
                this.zzaqc.peek().a(pop);
            }
        }
        if (this.zzaqe != 2) {
            zzei();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long getDurationUs() {
        return this.zzaan;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zziaVar) throws IOException, InterruptedException {
        return Xk.b(zziaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzaqc.clear();
        this.zzaqh = 0;
        this.zzajn = 0;
        this.zzajm = 0;
        if (j == 0) {
            zzei();
            return;
        }
        Wk[] wkArr = this.zzasg;
        if (wkArr != null) {
            for (Wk wk : wkArr) {
                Zk zk = wk.f11943b;
                int a2 = zk.a(j2);
                if (a2 == -1) {
                    a2 = zk.b(j2);
                }
                wk.f11945d = a2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzdw() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long zzr(long j) {
        long j2 = Long.MAX_VALUE;
        for (Wk wk : this.zzasg) {
            Zk zk = wk.f11943b;
            int a2 = zk.a(j);
            if (a2 == -1) {
                a2 = zk.b(j);
            }
            long j3 = zk.f12014b[a2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzibVar) {
        this.zzajq = zzibVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x029b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzia r24, com.google.android.gms.internal.ads.zzif r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjn.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }
}
