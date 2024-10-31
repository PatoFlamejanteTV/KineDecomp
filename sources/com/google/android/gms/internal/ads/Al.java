package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Al implements zzlm, zzlx<zzmj<zzmq>> {

    /* renamed from: a, reason: collision with root package name */
    final int f11383a;

    /* renamed from: b, reason: collision with root package name */
    private final zzmr f11384b;

    /* renamed from: c, reason: collision with root package name */
    private final int f11385c;

    /* renamed from: d, reason: collision with root package name */
    private final zzkt f11386d;

    /* renamed from: e, reason: collision with root package name */
    private final long f11387e;

    /* renamed from: f, reason: collision with root package name */
    private final zzpk f11388f;

    /* renamed from: g, reason: collision with root package name */
    private final zzot f11389g;

    /* renamed from: h, reason: collision with root package name */
    private final zzma f11390h;
    private final Bl[] i;
    private zzln j;
    private zzmj<zzmq>[] k = new zzmj[0];
    private zzla l = new zzla(this.k);
    private zznj m;
    private int n;
    private List<zzni> o;

    public Al(int i, zznj zznjVar, int i2, zzmr zzmrVar, int i3, zzkt zzktVar, long j, zzpk zzpkVar, zzot zzotVar) {
        int i4;
        int i5;
        boolean z;
        boolean z2;
        zznm zznmVar;
        int i6;
        this.f11383a = i;
        this.m = zznjVar;
        this.n = i2;
        this.f11384b = zzmrVar;
        this.f11385c = i3;
        this.f11386d = zzktVar;
        this.f11387e = j;
        this.f11388f = zzpkVar;
        this.f11389g = zzotVar;
        this.o = zznjVar.zzba(i2).zzbbe;
        List<zzni> list = this.o;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i7 = 0; i7 < size; i7++) {
            sparseIntArray.put(list.get(i7).id, i7);
        }
        int[][] iArr = new int[size];
        boolean[] zArr = new boolean[size];
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            if (!zArr[i9]) {
                zArr[i9] = true;
                List<zznm> list2 = list.get(i9).zzbcp;
                int i10 = 0;
                while (true) {
                    if (i10 >= list2.size()) {
                        zznmVar = null;
                        break;
                    }
                    zznm zznmVar2 = list2.get(i10);
                    if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(zznmVar2.zzbdi)) {
                        zznmVar = zznmVar2;
                        break;
                    }
                    i10++;
                }
                if (zznmVar == null) {
                    i6 = i8 + 1;
                    int[] iArr2 = new int[1];
                    iArr2[0] = i9;
                    iArr[i8] = iArr2;
                } else {
                    String[] split = zznmVar.value.split(",");
                    int[] iArr3 = new int[split.length + 1];
                    iArr3[0] = i9;
                    int i11 = 0;
                    while (i11 < split.length) {
                        int i12 = sparseIntArray.get(Integer.parseInt(split[i11]));
                        zArr[i12] = true;
                        i11++;
                        iArr3[i11] = i12;
                    }
                    i6 = i8 + 1;
                    iArr[i8] = iArr3;
                }
                i8 = i6;
            }
        }
        iArr = i8 < size ? (int[][]) Arrays.copyOf(iArr, i8) : iArr;
        int length = iArr.length;
        boolean[] zArr2 = new boolean[length];
        boolean[] zArr3 = new boolean[length];
        int i13 = length;
        for (int i14 = 0; i14 < length; i14++) {
            int[] iArr4 = iArr[i14];
            int length2 = iArr4.length;
            int i15 = 0;
            while (true) {
                if (i15 >= length2) {
                    z = false;
                    break;
                }
                List<zznp> list3 = list.get(iArr4[i15]).zzbcn;
                for (int i16 = 0; i16 < list3.size(); i16++) {
                    if (!list3.get(i16).zzbdo.isEmpty()) {
                        z = true;
                        break;
                    }
                }
                i15++;
            }
            if (z) {
                zArr2[i14] = true;
                i13++;
            }
            int[] iArr5 = iArr[i14];
            int length3 = iArr5.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    z2 = false;
                    break;
                }
                List<zznm> list4 = list.get(iArr5[i17]).zzbco;
                for (int i18 = 0; i18 < list4.size(); i18++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list4.get(i18).zzbdi)) {
                        z2 = true;
                        break;
                    }
                }
                i17++;
            }
            if (z2) {
                zArr3[i14] = true;
                i13++;
            }
        }
        zzlz[] zzlzVarArr = new zzlz[i13];
        Bl[] blArr = new Bl[i13];
        int i19 = 0;
        int i20 = 0;
        while (i19 < length) {
            int[] iArr6 = iArr[i19];
            ArrayList arrayList = new ArrayList();
            for (int i21 : iArr6) {
                arrayList.addAll(list.get(i21).zzbcn);
            }
            zzfs[] zzfsVarArr = new zzfs[arrayList.size()];
            for (int i22 = 0; i22 < zzfsVarArr.length; i22++) {
                zzfsVarArr[i22] = ((zznp) arrayList.get(i22)).zzaad;
            }
            zzni zzniVar = list.get(iArr6[0]);
            boolean z3 = zArr2[i19];
            boolean z4 = zArr3[i19];
            zzlzVarArr[i20] = new zzlz(zzfsVarArr);
            int i23 = i20 + 1;
            blArr[i20] = new Bl(zzniVar.type, iArr6, i20, true, z3, z4);
            if (z3) {
                int i24 = zzniVar.id;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i24);
                sb.append(":emsg");
                zzlzVarArr[i23] = new zzlz(zzfs.zza(sb.toString(), "application/x-emsg", null, -1, null));
                i4 = i23 + 1;
                blArr[i23] = new Bl(4, iArr6, i20, false, false, false);
            } else {
                i4 = i23;
            }
            if (z4) {
                int i25 = zzniVar.id;
                StringBuilder sb2 = new StringBuilder(18);
                sb2.append(i25);
                sb2.append(":cea608");
                zzlzVarArr[i4] = new zzlz(zzfs.zza(sb2.toString(), "application/cea-608", (String) null, -1, 0, (String) null, (zzhp) null));
                i5 = i4 + 1;
                blArr[i4] = new Bl(3, iArr6, i20, false, false, false);
            } else {
                i5 = i4;
            }
            i19++;
            i20 = i5;
        }
        Pair create = Pair.create(new zzma(zzlzVarArr), blArr);
        this.f11390h = (zzma) create.first;
        this.i = (Bl[]) create.second;
    }

    public final void a(zznj zznjVar, int i) {
        this.m = zznjVar;
        this.n = i;
        this.o = zznjVar.zzba(i).zzbbe;
        zzmj<zzmq>[] zzmjVarArr = this.k;
        if (zzmjVarArr != null) {
            for (zzmj<zzmq> zzmjVar : zzmjVarArr) {
                zzmjVar.zzfy().zza(zznjVar, i);
            }
            this.j.zza((zzln) this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zza(zzln zzlnVar, long j) {
        this.j = zzlnVar;
        zzlnVar.zza((zzlm) this);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzaa(long j) {
        for (zzmj<zzmq> zzmjVar : this.k) {
            zzmjVar.zzaf(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzab(long j) {
        for (zzmj<zzmq> zzmjVar : this.k) {
            zzmjVar.zzag(j);
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlm, com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        return this.l.zzeu();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzew() throws IOException {
        this.f11388f.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final zzma zzex() {
        return this.f11390h;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzey() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzez() {
        long j = Long.MAX_VALUE;
        for (zzmj<zzmq> zzmjVar : this.k) {
            long zzez = zzmjVar.zzez();
            if (zzez != Long.MIN_VALUE) {
                j = Math.min(j, zzez);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlm, com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        return this.l.zzy(j);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zza(zzom[] zzomVarArr, boolean[] zArr, zzlv[] zzlvVarArr, boolean[] zArr2, long j) {
        boolean z;
        zzlv zza;
        int i;
        int i2;
        HashMap hashMap = new HashMap();
        char c2 = 0;
        int i3 = 0;
        while (i3 < zzomVarArr.length) {
            if (zzlvVarArr[i3] instanceof zzmj) {
                zzmj zzmjVar = (zzmj) zzlvVarArr[i3];
                if (zzomVarArr[i3] != null && zArr[i3]) {
                    hashMap.put(Integer.valueOf(this.f11390h.zza(zzomVarArr[i3].zzgk())), zzmjVar);
                } else {
                    zzmjVar.release();
                    zzlvVarArr[i3] = null;
                }
            }
            if (zzlvVarArr[i3] == null && zzomVarArr[i3] != null) {
                int zza2 = this.f11390h.zza(zzomVarArr[i3].zzgk());
                Bl bl = this.i[zza2];
                if (bl.f11419c) {
                    zzom zzomVar = zzomVarArr[i3];
                    int[] iArr = new int[2];
                    boolean z2 = bl.f11421e;
                    if (z2) {
                        iArr[c2] = 4;
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    boolean z3 = bl.f11422f;
                    if (z3) {
                        iArr[i2] = 3;
                        i2++;
                    }
                    if (i2 < 2) {
                        iArr = Arrays.copyOf(iArr, i2);
                    }
                    i = i3;
                    zzmj zzmjVar2 = new zzmj(bl.f11418b, iArr, this.f11384b.zza(this.f11388f, this.m, this.n, bl.f11417a, zzomVar, bl.f11418b, this.f11387e, z2, z3), this, this.f11389g, j, this.f11385c, this.f11386d);
                    hashMap.put(Integer.valueOf(zza2), zzmjVar2);
                    zzlvVarArr[i] = zzmjVar2;
                    zArr2[i] = true;
                    i3 = i + 1;
                    c2 = 0;
                }
            }
            i = i3;
            i3 = i + 1;
            c2 = 0;
        }
        for (int i4 = 0; i4 < zzomVarArr.length; i4++) {
            if (((zzlvVarArr[i4] instanceof zzmk) || (zzlvVarArr[i4] instanceof zzlb)) && (zzomVarArr[i4] == null || !zArr[i4])) {
                a(zzlvVarArr[i4]);
                zzlvVarArr[i4] = null;
            }
            if (zzomVarArr[i4] != null) {
                Bl bl2 = this.i[this.f11390h.zza(zzomVarArr[i4].zzgk())];
                if (!bl2.f11419c) {
                    zzmj zzmjVar3 = (zzmj) hashMap.get(Integer.valueOf(bl2.f11420d));
                    zzlv zzlvVar = zzlvVarArr[i4];
                    if (zzmjVar3 == null) {
                        z = zzlvVar instanceof zzlb;
                    } else {
                        z = (zzlvVar instanceof zzmk) && ((zzmk) zzlvVar).zzbap == zzmjVar3;
                    }
                    if (!z) {
                        a(zzlvVar);
                        if (zzmjVar3 == null) {
                            zza = new zzlb();
                        } else {
                            zza = zzmjVar3.zza(j, bl2.f11418b);
                        }
                        zzlvVarArr[i4] = zza;
                        zArr2[i4] = true;
                    }
                }
            }
        }
        this.k = new zzmj[hashMap.size()];
        hashMap.values().toArray(this.k);
        this.l = new zzla(this.k);
        return j;
    }

    public final void a() {
        for (zzmj<zzmq> zzmjVar : this.k) {
            zzmjVar.release();
        }
    }

    private static void a(zzlv zzlvVar) {
        if (zzlvVar instanceof zzmk) {
            ((zzmk) zzlvVar).release();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final /* synthetic */ void zza(zzmj<zzmq> zzmjVar) {
        this.j.zza((zzln) this);
    }
}
