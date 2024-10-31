package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzmu implements zzlo {
    private Handler handler;
    private zzov zzagy;
    private final int zzawn;
    private zzlp zzawp;
    private zzpf zzawt;
    private final zzkt zzbah;
    private final zzmr zzbax;
    private zznj zzbbd;
    private final boolean zzbbk;
    private final zzow zzbbl;
    private final long zzbbm;
    private final zzpm<? extends zznj> zzbbn;
    private final Gl zzbbo;
    private final Object zzbbp;
    private final SparseArray<Al> zzbbq;
    private final Runnable zzbbr;
    private final Runnable zzbbs;
    private zzpk zzbbt;
    private Uri zzbbu;
    private long zzbbv;
    private long zzbbw;
    private long zzbbx;
    private int zzbby;

    public zzmu(Uri uri, zzow zzowVar, zzmr zzmrVar, Handler handler, zzks zzksVar) {
        this(uri, zzowVar, zzmrVar, 3, -1L, handler, null);
    }

    private final void zzah(long j) {
        this.zzbbx = j;
        zzi(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgb() {
        Uri uri;
        synchronized (this.zzbbp) {
            uri = this.zzbbu;
        }
        zza(new zzpl(this.zzagy, uri, 4, this.zzbbn), this.zzbbo, this.zzawn);
    }

    private final void zzgc() {
        zznj zznjVar = this.zzbbd;
        if (zznjVar.zzbcs) {
            long j = zznjVar.zzbct;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.zzbbr, Math.max(0L, (this.zzbbv + j) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(boolean z) {
        long j;
        boolean z2;
        long zzg;
        long zzbb;
        for (int i = 0; i < this.zzbbq.size(); i++) {
            int keyAt = this.zzbbq.keyAt(i);
            if (keyAt >= this.zzbby) {
                this.zzbbq.valueAt(i).a(this.zzbbd, keyAt - this.zzbby);
            }
        }
        int zzcl = this.zzbbd.zzcl() - 1;
        Hl a2 = Hl.a(this.zzbbd.zzba(0), this.zzbbd.zzbb(0));
        Hl a3 = Hl.a(this.zzbbd.zzba(zzcl), this.zzbbd.zzbb(zzcl));
        long j2 = a2.f11584b;
        long j3 = a3.f11585c;
        long j4 = 0;
        if (!this.zzbbd.zzbcs || a3.f11583a) {
            j = j2;
            z2 = false;
        } else {
            if (this.zzbbx != 0) {
                zzg = zzfe.zzg(SystemClock.elapsedRealtime() + this.zzbbx);
            } else {
                zzg = zzfe.zzg(System.currentTimeMillis());
            }
            j3 = Math.min((zzg - zzfe.zzg(this.zzbbd.zzbcq)) - zzfe.zzg(this.zzbbd.zzba(zzcl).zzbdj), j3);
            long j5 = this.zzbbd.zzbcu;
            if (j5 != -9223372036854775807L) {
                long zzg2 = j3 - zzfe.zzg(j5);
                while (zzg2 < 0 && zzcl > 0) {
                    zzcl--;
                    zzg2 += this.zzbbd.zzbb(zzcl);
                }
                if (zzcl == 0) {
                    zzbb = Math.max(j2, zzg2);
                } else {
                    zzbb = this.zzbbd.zzbb(0);
                }
                j2 = zzbb;
            }
            j = j2;
            z2 = true;
        }
        long j6 = j3 - j;
        for (int i2 = 0; i2 < this.zzbbd.zzcl() - 1; i2++) {
            j6 += this.zzbbd.zzbb(i2);
        }
        zznj zznjVar = this.zzbbd;
        if (zznjVar.zzbcs) {
            long j7 = this.zzbbm;
            if (j7 == -1) {
                long j8 = zznjVar.zzbcv;
                if (j8 == -9223372036854775807L) {
                    j8 = com.umeng.commonsdk.proguard.c.f26227d;
                }
                j7 = j8;
            }
            j4 = j6 - zzfe.zzg(j7);
            if (j4 < 5000000) {
                j4 = Math.min(5000000L, j6 / 2);
            }
        }
        zznj zznjVar2 = this.zzbbd;
        long zzf = zznjVar2.zzbcq + zznjVar2.zzba(0).zzbdj + zzfe.zzf(j);
        zznj zznjVar3 = this.zzbbd;
        this.zzawp.zzb(new El(zznjVar3.zzbcq, zzf, this.zzbby, j, j6, j4, zznjVar3), this.zzbbd);
        this.handler.removeCallbacks(this.zzbbs);
        if (z2) {
            this.handler.postDelayed(this.zzbbs, 5000L);
        }
        if (z) {
            zzgc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzfg zzfgVar, boolean z, zzlp zzlpVar) {
        this.zzawp = zzlpVar;
        this.zzagy = this.zzbbl.zzgs();
        this.zzawt = new zzpf("Loader:DashMediaSource");
        this.zzbbt = this.zzawt;
        this.handler = new Handler();
        zzgb();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzb(zzlm zzlmVar) {
        Al al = (Al) zzlmVar;
        al.a();
        this.zzbbq.remove(al.f11383a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzpl<?> zzplVar, long j, long j2) {
        this.zzbah.zzb(zzplVar.zzazo, zzplVar.type, j, j2, zzplVar.zzfv());
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzfg() throws IOException {
        this.zzbbt.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzfh() {
        this.zzagy = null;
        this.zzbbt = null;
        zzpf zzpfVar = this.zzawt;
        if (zzpfVar != null) {
            zzpfVar.zza((Runnable) null);
            this.zzawt = null;
        }
        this.zzbbv = 0L;
        this.zzbbw = 0L;
        this.zzbbd = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.zzbbx = 0L;
        this.zzbbq.clear();
    }

    private zzmu(Uri uri, zzow zzowVar, zzmr zzmrVar, int i, long j, Handler handler, zzks zzksVar) {
        this(uri, zzowVar, new zznk(), zzmrVar, 3, -1L, handler, null);
    }

    private zzmu(Uri uri, zzow zzowVar, zzpm<? extends zznj> zzpmVar, zzmr zzmrVar, int i, long j, Handler handler, zzks zzksVar) {
        this(null, uri, zzowVar, zzpmVar, zzmrVar, 3, -1L, handler, zzksVar);
    }

    private zzmu(zznj zznjVar, Uri uri, zzow zzowVar, zzpm<? extends zznj> zzpmVar, zzmr zzmrVar, int i, long j, Handler handler, zzks zzksVar) {
        this.zzbbd = null;
        this.zzbbu = uri;
        this.zzbbl = zzowVar;
        this.zzbbn = zzpmVar;
        this.zzbax = zzmrVar;
        this.zzawn = i;
        this.zzbbm = j;
        this.zzbbk = false;
        this.zzbah = new zzkt(handler, zzksVar);
        this.zzbbp = new Object();
        this.zzbbq = new SparseArray<>();
        this.zzbbo = new Gl(this, null);
        this.zzbbr = new Cl(this);
        this.zzbbs = new Dl(this);
    }

    private final void zzc(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        zzi(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzpl<Long> zzplVar, long j, long j2) {
        this.zzbah.zza(zzplVar.zzazo, zzplVar.type, j, j2, zzplVar.zzfv());
        zzah(zzplVar.getResult().longValue() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzlm zza(int i, zzot zzotVar) {
        Al al = new Al(this.zzbby + i, this.zzbbd, i, this.zzbax, this.zzawn, this.zzbah.zzw(this.zzbbd.zzba(i).zzbdj), this.zzbbx, this.zzbbt, zzotVar);
        this.zzbbq.put(al.f11383a, al);
        return al;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(zzpl<Long> zzplVar, long j, long j2, IOException iOException) {
        this.zzbah.zza(zzplVar.zzazo, zzplVar.type, j, j2, zzplVar.zzfv(), iOException, true);
        zzc(iOException);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzpl<zznj> zzplVar, long j, long j2) {
        this.zzbah.zza(zzplVar.zzazo, zzplVar.type, j, j2, zzplVar.zzfv());
        zznj result = zzplVar.getResult();
        zznj zznjVar = this.zzbbd;
        int i = 0;
        int zzcl = zznjVar == null ? 0 : zznjVar.zzcl();
        long j3 = result.zzba(0).zzbdj;
        while (i < zzcl && this.zzbbd.zzba(i).zzbdj < j3) {
            i++;
        }
        if (zzcl - i > result.zzcl()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            zzgc();
            return;
        }
        this.zzbbd = result;
        this.zzbbv = j - j2;
        this.zzbbw = j;
        if (this.zzbbd.zzbcx != null) {
            synchronized (this.zzbbp) {
                if (zzplVar.zzazo.uri == this.zzbbu) {
                    this.zzbbu = this.zzbbd.zzbcx;
                }
            }
        }
        if (zzcl == 0) {
            zzob zzobVar = this.zzbbd.zzbcw;
            if (zzobVar != null) {
                String str = zzobVar.zzbdi;
                if (!zzqe.zza(str, "urn:mpeg:dash:utc:direct:2014") && !zzqe.zza(str, "urn:mpeg:dash:utc:direct:2012")) {
                    Cl cl = null;
                    if (!zzqe.zza(str, "urn:mpeg:dash:utc:http-iso:2014") && !zzqe.zza(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                        if (!zzqe.zza(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !zzqe.zza(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                            zzc(new IOException("Unsupported UTC timing scheme"));
                            return;
                        } else {
                            zza(zzobVar, new Jl(cl));
                            return;
                        }
                    }
                    zza(zzobVar, new Fl(cl));
                    return;
                }
                try {
                    zzah(zzqe.zzal(zzobVar.value) - this.zzbbw);
                    return;
                } catch (zzfx e2) {
                    zzc(e2);
                    return;
                }
            }
            zzi(true);
            return;
        }
        this.zzbby += i;
        zzi(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza(zzpl<zznj> zzplVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof zzfx;
        this.zzbah.zza(zzplVar.zzazo, zzplVar.type, j, j2, zzplVar.zzfv(), iOException, z);
        return z ? 3 : 0;
    }

    private final void zza(zzob zzobVar, zzpm<Long> zzpmVar) {
        zza(new zzpl(this.zzagy, Uri.parse(zzobVar.value), 5, zzpmVar), new Il(this, null), 1);
    }

    private final <T> void zza(zzpl<T> zzplVar, zzpg<zzpl<T>> zzpgVar, int i) {
        this.zzbah.zza(zzplVar.zzazo, zzplVar.type, this.zzawt.zza(zzplVar, zzpgVar, i));
    }
}
