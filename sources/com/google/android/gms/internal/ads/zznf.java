package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zznf implements zzmq {
    private final zzov zzagy;
    private final zzpk zzbaz;
    private zznj zzbbd;
    private final int[] zzbbf;
    private final long zzbbx;
    private final zzom zzbcf;
    private final zznh[] zzbcg;
    private final int zzbch;
    private IOException zzbci;
    private boolean zzbcj;
    private final int zzwg;
    private int zzyr;

    public zznf(zzpk zzpkVar, zznj zznjVar, int i, int[] iArr, zzom zzomVar, int i2, zzov zzovVar, long j, int i3, boolean z, boolean z2) {
        this.zzbaz = zzpkVar;
        this.zzbbd = zznjVar;
        this.zzbbf = iArr;
        this.zzbcf = zzomVar;
        this.zzwg = i2;
        this.zzagy = zzovVar;
        this.zzyr = i;
        this.zzbbx = j;
        this.zzbch = i3;
        long zzbb = zznjVar.zzbb(i);
        ArrayList<zznp> zzgf = zzgf();
        this.zzbcg = new zznh[zzomVar.length()];
        for (int i4 = 0; i4 < this.zzbcg.length; i4++) {
            this.zzbcg[i4] = new zznh(zzbb, zzgf.get(zzomVar.zzbd(i4)), z, z2);
        }
    }

    private final ArrayList<zznp> zzgf() {
        List<zzni> list = this.zzbbd.zzba(this.zzyr).zzbbe;
        ArrayList<zznp> arrayList = new ArrayList<>();
        for (int i : this.zzbbf) {
            arrayList.addAll(list.get(i).zzbcn);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final void zza(zznj zznjVar, int i) {
        try {
            this.zzbbd = zznjVar;
            this.zzyr = i;
            long zzbb = this.zzbbd.zzbb(this.zzyr);
            ArrayList<zznp> zzgf = zzgf();
            for (int i2 = 0; i2 < this.zzbcg.length; i2++) {
                this.zzbcg[i2].zza(zzbb, zzgf.get(this.zzbcf.zzbd(i2)));
            }
        } catch (zzkz e2) {
            this.zzbci = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzev() throws IOException {
        IOException iOException = this.zzbci;
        if (iOException == null) {
            this.zzbaz.zzev();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zza(zzmo zzmoVar, long j, zzmi zzmiVar) {
        long currentTimeMillis;
        int i;
        int zzfz;
        boolean z;
        zzme zzmmVar;
        zzno zznoVar;
        zznf zznfVar = this;
        if (zznfVar.zzbci != null) {
            return;
        }
        zznfVar.zzbcf.zzak(zzmoVar != null ? zzmoVar.zzazt - j : 0L);
        zznh zznhVar = zznfVar.zzbcg[zznfVar.zzbcf.zzgm()];
        zzmf zzmfVar = zznhVar.zzbat;
        if (zzmfVar != null) {
            zznp zznpVar = zznhVar.zzbck;
            zzno zzgh = zzmfVar.zzfx() == null ? zznpVar.zzgh() : null;
            zzno zzgi = zznhVar.zzbcl == null ? zznpVar.zzgi() : null;
            if (zzgh != null || zzgi != null) {
                zzov zzovVar = zznfVar.zzagy;
                zzfs zzgl = zznfVar.zzbcf.zzgl();
                int zzgn = zznfVar.zzbcf.zzgn();
                Object zzgo = zznfVar.zzbcf.zzgo();
                String str = zznhVar.zzbck.zzbde;
                if (zzgh != null) {
                    zznoVar = zzgh.zza(zzgi, str);
                    if (zznoVar == null) {
                        zznoVar = zzgh;
                    }
                } else {
                    zznoVar = zzgi;
                }
                zzmiVar.zzbaa = new zzmn(zzovVar, new zzoz(zznoVar.zzy(str), zznoVar.zzbdk, zznoVar.zzcc, zznhVar.zzbck.zzf()), zzgl, zzgn, zzgo, zznhVar.zzbat);
                return;
            }
        }
        if (zznfVar.zzbbx != 0) {
            currentTimeMillis = SystemClock.elapsedRealtime() + zznfVar.zzbbx;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        long j2 = currentTimeMillis * 1000;
        int zzgg = zznhVar.zzgg();
        boolean z2 = true;
        if (zzgg == 0) {
            zznj zznjVar = zznfVar.zzbbd;
            if (zznjVar.zzbcs && zznfVar.zzyr >= zznjVar.zzcl() - 1) {
                z2 = false;
            }
            zzmiVar.zzbab = z2;
            return;
        }
        int zzgd = zznhVar.zzgd();
        if (zzgg == -1) {
            zznj zznjVar2 = zznfVar.zzbbd;
            long j3 = (j2 - (zznjVar2.zzbcq * 1000)) - (zznjVar2.zzba(zznfVar.zzyr).zzbdj * 1000);
            long j4 = zznfVar.zzbbd.zzbcu;
            if (j4 != -9223372036854775807L) {
                zzgd = Math.max(zzgd, zznhVar.zzaj(j3 - (j4 * 1000)));
            }
            i = zznhVar.zzaj(j3) - 1;
        } else {
            i = (zzgg + zzgd) - 1;
        }
        if (zzmoVar == null) {
            zzfz = zzqe.zzd(zznhVar.zzaj(j), zzgd, i);
        } else {
            zzfz = zzmoVar.zzfz();
            if (zzfz < zzgd) {
                zznfVar.zzbci = new zzkz();
                return;
            }
        }
        int i2 = zzfz;
        if (i2 > i) {
            zznfVar = this;
        } else if (!zznfVar.zzbcj || i2 < i) {
            int min = Math.min(zznfVar.zzbch, (i - i2) + 1);
            zzov zzovVar2 = zznfVar.zzagy;
            int i3 = zznfVar.zzwg;
            zzfs zzgl2 = zznfVar.zzbcf.zzgl();
            int zzgn2 = zznfVar.zzbcf.zzgn();
            Object zzgo2 = zznfVar.zzbcf.zzgo();
            zznp zznpVar2 = zznhVar.zzbck;
            long zzay = zznhVar.zzay(i2);
            zzno zzax = zznhVar.zzax(i2);
            String str2 = zznpVar2.zzbde;
            if (zznhVar.zzbat == null) {
                zzmmVar = new zzmp(zzovVar2, new zzoz(zzax.zzy(str2), zzax.zzbdk, zzax.zzcc, zznpVar2.zzf()), zzgl2, zzgn2, zzgo2, zzay, zznhVar.zzaz(i2), i2, i3, zzgl2);
            } else {
                int i4 = 1;
                int i5 = 1;
                while (i4 < min) {
                    zzno zza = zzax.zza(zznhVar.zzax(i2 + i4), str2);
                    if (zza == null) {
                        break;
                    }
                    i5++;
                    i4++;
                    zzax = zza;
                }
                zzmmVar = new zzmm(zzovVar2, new zzoz(zzax.zzy(str2), zzax.zzbdk, zzax.zzcc, zznpVar2.zzf()), zzgl2, zzgn2, zzgo2, zzay, zznhVar.zzaz((i2 + i5) - 1), i2, i5, -zznpVar2.zzbdn, zznhVar.zzbat);
            }
            zzmiVar.zzbaa = zzmmVar;
            return;
        }
        zznj zznjVar3 = zznfVar.zzbbd;
        if (zznjVar3.zzbcs) {
            z = true;
            if (zznfVar.zzyr >= zznjVar3.zzcl() - 1) {
                z = false;
            }
        } else {
            z = true;
        }
        zzmiVar.zzbab = z;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zza(zzme zzmeVar) {
        zzig zzfw;
        if (zzmeVar instanceof zzmn) {
            zznh zznhVar = this.zzbcg[this.zzbcf.zzi(((zzmn) zzmeVar).zzazp)];
            if (zznhVar.zzbcl != null || (zzfw = zznhVar.zzbat.zzfw()) == null) {
                return;
            }
            zznhVar.zzbcl = new zzne((zzhw) zzfw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final boolean zza(zzme zzmeVar, boolean z, Exception exc) {
        int i;
        zznh zznhVar;
        int zzgg;
        boolean z2 = false;
        if (!z) {
            return false;
        }
        boolean z3 = true;
        if (!this.zzbbd.zzbcs && (zzmeVar instanceof zzmo) && (exc instanceof zzpd) && ((zzpd) exc).responseCode == 404 && (zzgg = (zznhVar = this.zzbcg[this.zzbcf.zzi(zzmeVar.zzazp)]).zzgg()) != -1 && zzgg != 0) {
            if (((zzmo) zzmeVar).zzfz() > (zznhVar.zzgd() + zzgg) - 1) {
                this.zzbcj = true;
                return true;
            }
        }
        zzom zzomVar = this.zzbcf;
        int zzi = zzomVar.zzi(zzmeVar.zzazp);
        if (!(exc instanceof zzpd) || ((i = ((zzpd) exc).responseCode) != 404 && i != 410)) {
            z3 = false;
        }
        if (z3) {
            z2 = zzomVar.zzf(zzi, 60000L);
            int i2 = ((zzpd) exc).responseCode;
            if (z2) {
                String valueOf = String.valueOf(zzomVar.zzat(zzi));
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 77);
                sb.append("Blacklisted: duration=60000, responseCode=");
                sb.append(i2);
                sb.append(", format=");
                sb.append(valueOf);
                Log.w("ChunkedTrackBlacklist", sb.toString());
            } else {
                String valueOf2 = String.valueOf(zzomVar.zzat(zzi));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 92);
                sb2.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
                sb2.append(i2);
                sb2.append(", format=");
                sb2.append(valueOf2);
                Log.w("ChunkedTrackBlacklist", sb2.toString());
            }
        }
        return z2;
    }
}
