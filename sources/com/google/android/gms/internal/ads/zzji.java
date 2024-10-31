package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzji implements zzhz {
    private static final zzic zzahq = new Rk();
    private static final int zzaps = zzqe.zzam("seig");
    private static final byte[] zzapt = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaan;
    private final zzpx zzahx;
    private int zzajm;
    private int zzajn;
    private zzib zzajq;
    private final zzjs zzapu;
    private final SparseArray<Tk> zzapv;
    private final zzpx zzapw;
    private final zzpx zzapx;
    private final zzpx zzapy;
    private final zzqb zzapz;
    private final zzpx zzaqa;
    private final byte[] zzaqb;
    private final Stack<Fk> zzaqc;
    private final LinkedList<Sk> zzaqd;
    private int zzaqe;
    private int zzaqf;
    private long zzaqg;
    private int zzaqh;
    private zzpx zzaqi;
    private long zzaqj;
    private int zzaqk;
    private long zzaql;
    private Tk zzaqm;
    private int zzaqn;
    private boolean zzaqo;
    private zzii zzaqp;
    private zzii[] zzaqq;
    private boolean zzaqr;

    public zzji() {
        this(0);
    }

    private static zzhp zzb(List<Gk> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Gk gk = list.get(i);
            if (gk.Pa == Ek.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = gk.Qa.data;
                UUID zze = zzjq.zze(bArr);
                if (zze == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzhp.zza(zze, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzhp(arrayList);
    }

    private final void zzei() {
        this.zzaqe = 0;
        this.zzaqh = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0650  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzt(long r55) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 1782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzji.zzt(long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zziaVar) throws IOException, InterruptedException {
        return Xk.a(zziaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        int size = this.zzapv.size();
        for (int i = 0; i < size; i++) {
            this.zzapv.valueAt(i).a();
        }
        this.zzaqd.clear();
        this.zzaqk = 0;
        this.zzaqc.clear();
        zzei();
    }

    public zzji(int i) {
        this(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzibVar) {
        this.zzajq = zzibVar;
    }

    private zzji(int i, zzqb zzqbVar) {
        this(i, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x05c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0004 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzia r26, com.google.android.gms.internal.ads.zzif r27) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzji.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }

    private zzji(int i, zzqb zzqbVar, zzjs zzjsVar) {
        this.flags = i;
        this.zzapz = null;
        this.zzapu = null;
        this.zzaqa = new zzpx(16);
        this.zzahx = new zzpx(zzpu.zzbhi);
        this.zzapw = new zzpx(5);
        this.zzapx = new zzpx();
        this.zzapy = new zzpx(1);
        this.zzaqb = new byte[16];
        this.zzaqc = new Stack<>();
        this.zzaqd = new LinkedList<>();
        this.zzapv = new SparseArray<>();
        this.zzaan = -9223372036854775807L;
        this.zzaql = -9223372036854775807L;
        zzei();
    }

    private static void zza(zzpx zzpxVar, int i, Yk yk) throws zzfx {
        zzpxVar.setPosition(i + 8);
        int b2 = Ek.b(zzpxVar.readInt());
        if ((b2 & 1) == 0) {
            boolean z = (b2 & 2) != 0;
            int zzhg = zzpxVar.zzhg();
            int i2 = yk.f11993f;
            if (zzhg == i2) {
                Arrays.fill(yk.n, 0, zzhg, z);
                yk.a(zzpxVar.zzhb());
                zzpxVar.zze(yk.q.data, 0, yk.p);
                yk.q.setPosition(0);
                yk.r = false;
                return;
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzhg);
            sb.append(", ");
            sb.append(i2);
            throw new zzfx(sb.toString());
        }
        throw new zzfx("Overriding TrackEncryptionBox parameters is unsupported.");
    }
}
