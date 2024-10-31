package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzml;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzmj<T extends zzml> implements zzlv, zzlw, zzpg<zzme> {
    private final int zzawn;
    long zzaxj;
    private long zzaxk;
    boolean zzaxm;
    private final int zzbac;
    private final int[] zzbad;
    private final boolean[] zzbae;
    private final T zzbaf;
    private final zzlx<zzmj<T>> zzbag;
    private final zzkt zzbah;
    private final zzls zzbal;
    private final zzls[] zzbam;
    private final C1171yl zzban;
    private zzfs zzbao;
    private final zzpf zzawt = new zzpf("Loader:ChunkSampleStream");
    private final zzmi zzbai = new zzmi();
    private final LinkedList<zzmc> zzbaj = new LinkedList<>();
    private final List<zzmc> zzbak = Collections.unmodifiableList(this.zzbaj);

    public zzmj(int i, int[] iArr, T t, zzlx<zzmj<T>> zzlxVar, zzot zzotVar, long j, int i2, zzkt zzktVar) {
        this.zzbac = i;
        this.zzbad = iArr;
        this.zzbaf = t;
        this.zzbag = zzlxVar;
        this.zzbah = zzktVar;
        this.zzawn = i2;
        int i3 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.zzbam = new zzls[length];
        this.zzbae = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        zzls[] zzlsVarArr = new zzls[i4];
        this.zzbal = new zzls(zzotVar);
        iArr2[0] = i;
        zzlsVarArr[0] = this.zzbal;
        while (i3 < length) {
            zzls zzlsVar = new zzls(zzotVar);
            this.zzbam[i3] = zzlsVar;
            int i5 = i3 + 1;
            zzlsVarArr[i5] = zzlsVar;
            iArr2[i5] = iArr[i3];
            i3 = i5;
        }
        this.zzban = new C1171yl(iArr2, zzlsVarArr);
        this.zzaxk = j;
        this.zzaxj = j;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        if (this.zzaxm) {
            return true;
        }
        return !zzfd() && this.zzbal.zzfm();
    }

    public final void release() {
        this.zzbal.disable();
        for (zzls zzlsVar : this.zzbam) {
            zzlsVar.disable();
        }
        this.zzawt.zza((Runnable) null);
    }

    public final zzmk zza(long j, int i) {
        for (int i2 = 0; i2 < this.zzbam.length; i2++) {
            if (this.zzbad[i2] == i) {
                zzpo.checkState(!this.zzbae[i2]);
                this.zzbae[i2] = true;
                this.zzbam[i2].zze(j, true);
                return new zzmk(this, this, this.zzbam[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public final void zzaf(long j) {
        int i = 0;
        while (true) {
            zzls[] zzlsVarArr = this.zzbam;
            if (i >= zzlsVarArr.length) {
                return;
            }
            if (!this.zzbae[i]) {
                zzlsVarArr[i].zze(j, true);
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[LOOP:0: B:10:0x0022->B:14:0x003e, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzag(long r7) {
        /*
            r6 = this;
            r6.zzaxj = r7
            boolean r0 = r6.zzfd()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1f
            com.google.android.gms.internal.ads.zzls r0 = r6.zzbal
            long r3 = r6.zzeu()
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L16
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            boolean r0 = r0.zze(r7, r3)
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L52
        L22:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzmc> r0 = r6.zzbaj
            int r0 = r0.size()
            if (r0 <= r2) goto L44
            java.util.LinkedList<com.google.android.gms.internal.ads.zzmc> r0 = r6.zzbaj
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzmc r0 = (com.google.android.gms.internal.ads.zzmc) r0
            int r0 = r0.zzav(r1)
            com.google.android.gms.internal.ads.zzls r3 = r6.zzbal
            int r3 = r3.zzfl()
            if (r0 > r3) goto L44
            java.util.LinkedList<com.google.android.gms.internal.ads.zzmc> r0 = r6.zzbaj
            r0.removeFirst()
            goto L22
        L44:
            com.google.android.gms.internal.ads.zzls[] r0 = r6.zzbam
            int r3 = r0.length
        L47:
            if (r1 >= r3) goto L51
            r4 = r0[r1]
            r4.zze(r7, r2)
            int r1 = r1 + 1
            goto L47
        L51:
            return
        L52:
            r6.zzaxk = r7
            r6.zzaxm = r1
            java.util.LinkedList<com.google.android.gms.internal.ads.zzmc> r7 = r6.zzbaj
            r7.clear()
            com.google.android.gms.internal.ads.zzpf r7 = r6.zzawt
            boolean r7 = r7.isLoading()
            if (r7 == 0) goto L69
            com.google.android.gms.internal.ads.zzpf r7 = r6.zzawt
            r7.zzgy()
            return
        L69:
            com.google.android.gms.internal.ads.zzls r7 = r6.zzbal
            r7.zzh(r2)
            com.google.android.gms.internal.ads.zzls[] r7 = r6.zzbam
            int r8 = r7.length
        L71:
            if (r1 >= r8) goto L7b
            r0 = r7[r1]
            r0.zzh(r2)
            int r1 = r1 + 1
            goto L71
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmj.zzag(long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfuVar, zzho zzhoVar, boolean z) {
        if (zzfd()) {
            return -3;
        }
        int zzfl = this.zzbal.zzfl();
        if (!this.zzbaj.isEmpty()) {
            while (this.zzbaj.size() > 1 && this.zzbaj.get(1).zzav(0) <= zzfl) {
                this.zzbaj.removeFirst();
            }
            zzmc first = this.zzbaj.getFirst();
            zzfs zzfsVar = first.zzazp;
            if (!zzfsVar.equals(this.zzbao)) {
                this.zzbah.zzb(this.zzbac, zzfsVar, first.zzazq, first.zzazr, first.zzazs);
            }
            this.zzbao = zzfsVar;
        }
        return this.zzbal.zza(zzfuVar, zzhoVar, z, this.zzaxm, this.zzaxj);
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        if (zzfd()) {
            return this.zzaxk;
        }
        if (this.zzaxm) {
            return Long.MIN_VALUE;
        }
        return this.zzbaj.getLast().zzazt;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
        this.zzawt.zzbi(Integer.MIN_VALUE);
        if (this.zzawt.isLoading()) {
            return;
        }
        this.zzbaf.zzev();
    }

    public final long zzez() {
        if (this.zzaxm) {
            return Long.MIN_VALUE;
        }
        if (zzfd()) {
            return this.zzaxk;
        }
        long j = this.zzaxj;
        zzmc last = this.zzbaj.getLast();
        if (!last.zzga()) {
            if (this.zzbaj.size() > 1) {
                last = this.zzbaj.get(r2.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j = Math.max(j, last.zzazt);
        }
        return Math.max(j, this.zzbal.zzfc());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzfd() {
        return this.zzaxk != -9223372036854775807L;
    }

    public final T zzfy() {
        return this.zzbaf;
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        if (this.zzaxm || this.zzawt.isLoading()) {
            return false;
        }
        T t = this.zzbaf;
        zzmc last = this.zzbaj.isEmpty() ? null : this.zzbaj.getLast();
        long j2 = this.zzaxk;
        if (j2 == -9223372036854775807L) {
            j2 = j;
        }
        t.zza(last, j2, this.zzbai);
        zzmi zzmiVar = this.zzbai;
        boolean z = zzmiVar.zzbab;
        zzme zzmeVar = zzmiVar.zzbaa;
        zzmiVar.zzbaa = null;
        zzmiVar.zzbab = false;
        if (z) {
            this.zzaxk = -9223372036854775807L;
            this.zzaxm = true;
            return true;
        }
        if (zzmeVar == null) {
            return false;
        }
        if (zzmeVar instanceof zzmc) {
            this.zzaxk = -9223372036854775807L;
            zzmc zzmcVar = (zzmc) zzmeVar;
            zzmcVar.zza(this.zzban);
            this.zzbaj.add(zzmcVar);
        }
        this.zzbah.zzb(zzmeVar.zzazo, zzmeVar.type, this.zzbac, zzmeVar.zzazp, zzmeVar.zzazq, zzmeVar.zzazr, zzmeVar.zzazs, zzmeVar.zzazt, this.zzawt.zza(zzmeVar, this, this.zzawn));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        if (this.zzaxm && j > this.zzbal.zzfc()) {
            this.zzbal.zzfp();
        } else {
            this.zzbal.zze(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ int zza(zzme zzmeVar, long j, long j2, IOException iOException) {
        boolean z;
        zzme zzmeVar2 = zzmeVar;
        long zzfv = zzmeVar2.zzfv();
        boolean z2 = zzmeVar2 instanceof zzmc;
        if (this.zzbaf.zza(zzmeVar2, !z2 || zzfv == 0 || this.zzbaj.size() > 1, iOException)) {
            if (z2) {
                zzmc removeLast = this.zzbaj.removeLast();
                zzpo.checkState(removeLast == zzmeVar2);
                this.zzbal.zzar(removeLast.zzav(0));
                int i = 0;
                while (true) {
                    zzls[] zzlsVarArr = this.zzbam;
                    if (i >= zzlsVarArr.length) {
                        break;
                    }
                    zzls zzlsVar = zzlsVarArr[i];
                    i++;
                    zzlsVar.zzar(removeLast.zzav(i));
                }
                if (this.zzbaj.isEmpty()) {
                    this.zzaxk = this.zzaxj;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.zzbah.zzb(zzmeVar2.zzazo, zzmeVar2.type, this.zzbac, zzmeVar2.zzazp, zzmeVar2.zzazq, zzmeVar2.zzazr, zzmeVar2.zzazs, zzmeVar2.zzazt, j, j2, zzfv, iOException, z);
        if (!z) {
            return 0;
        }
        this.zzbag.zza(this);
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzme zzmeVar, long j, long j2, boolean z) {
        zzme zzmeVar2 = zzmeVar;
        this.zzbah.zzd(zzmeVar2.zzazo, zzmeVar2.type, this.zzbac, zzmeVar2.zzazp, zzmeVar2.zzazq, zzmeVar2.zzazr, zzmeVar2.zzazs, zzmeVar2.zzazt, j, j2, zzmeVar2.zzfv());
        if (z) {
            return;
        }
        this.zzbal.zzh(true);
        for (zzls zzlsVar : this.zzbam) {
            zzlsVar.zzh(true);
        }
        this.zzbag.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzme zzmeVar, long j, long j2) {
        zzme zzmeVar2 = zzmeVar;
        this.zzbaf.zza(zzmeVar2);
        this.zzbah.zzc(zzmeVar2.zzazo, zzmeVar2.type, this.zzbac, zzmeVar2.zzazp, zzmeVar2.zzazq, zzmeVar2.zzazr, zzmeVar2.zzazs, zzmeVar2.zzazt, j, j2, zzmeVar2.zzfv());
        this.zzbag.zza(this);
    }
}
