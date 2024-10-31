package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzis;

@zzgr
/* loaded from: classes.dex */
public class zzdz {
    private final Context mContext;
    private final VersionInfoParcel zzpb;
    private final Object zzpd;
    private final String zzyo;
    private zzb<zzbb> zzyp;
    private zzb<zzbb> zzyq;
    private zze zzyr;
    private int zzys;

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static int f1704a = 60000;
        static int b = 10000;
    }

    /* loaded from: classes.dex */
    public interface zzb<T> {
        void zzc(T t);
    }

    /* loaded from: classes.dex */
    public static class zzc<T> implements zzb<T> {
        @Override // com.google.android.gms.internal.zzdz.zzb
        public void zzc(T t) {
        }
    }

    /* loaded from: classes.dex */
    public static class zzd extends zzit<zzbe> {
        private final Object zzpd = new Object();
        private final zze zzyE;
        private boolean zzyF;

        public zzd(zze zzeVar) {
            this.zzyE = zzeVar;
        }

        public void release() {
            synchronized (this.zzpd) {
                if (this.zzyF) {
                    return;
                }
                this.zzyF = true;
                zza(new bj(this), new zzis.zzb());
                zza(new bk(this), new bl(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zze extends zzit<zzbb> {
        private final Object zzpd = new Object();
        private boolean zzyH = false;
        private int zzyI = 0;
        private zzb<zzbb> zzyq;

        public zze(zzb<zzbb> zzbVar) {
            this.zzyq = zzbVar;
        }

        public zzd zzdP() {
            zzd zzdVar = new zzd(this);
            synchronized (this.zzpd) {
                zza(new bm(this, zzdVar), new bn(this, zzdVar));
                com.google.android.gms.common.internal.zzx.a(this.zzyI >= 0);
                this.zzyI++;
            }
            return zzdVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzdQ() {
            synchronized (this.zzpd) {
                com.google.android.gms.common.internal.zzx.a(this.zzyI >= 1);
                com.google.android.gms.ads.internal.util.client.zzb.d("Releasing 1 reference for JS Engine");
                this.zzyI--;
                zzdS();
            }
        }

        public void zzdR() {
            synchronized (this.zzpd) {
                com.google.android.gms.common.internal.zzx.a(this.zzyI >= 0);
                com.google.android.gms.ads.internal.util.client.zzb.d("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzyH = true;
                zzdS();
            }
        }

        protected void zzdS() {
            synchronized (this.zzpd) {
                com.google.android.gms.common.internal.zzx.a(this.zzyI >= 0);
                if (this.zzyH && this.zzyI == 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.d("No reference is left (including root). Cleaning up engine.");
                    zza(new bo(this), new zzis.zzb());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.d("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzdz(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzpd = new Object();
        this.zzys = 1;
        this.zzyo = str;
        this.mContext = context.getApplicationContext();
        this.zzpb = versionInfoParcel;
        this.zzyp = new zzc();
        this.zzyq = new zzc();
    }

    public zzdz(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> zzbVar, zzb<zzbb> zzbVar2) {
        this(context, versionInfoParcel, str);
        this.zzyp = zzbVar;
        this.zzyq = zzbVar2;
    }

    private zze zzdM() {
        zze zzeVar = new zze(this.zzyq);
        zzid.runOnUiThread(new az(this, zzeVar));
        return zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zze zzdN() {
        zze zzdM = zzdM();
        zzdM.zza(new bh(this, zzdM), new bi(this, zzdM));
        return zzdM;
    }

    public zzd zzdO() {
        zzd zzdP;
        synchronized (this.zzpd) {
            if (this.zzyr == null || this.zzyr.getStatus() == -1) {
                this.zzys = 2;
                this.zzyr = zzdN();
                zzdP = this.zzyr.zzdP();
            } else if (this.zzys == 0) {
                zzdP = this.zzyr.zzdP();
            } else if (this.zzys == 1) {
                this.zzys = 2;
                zzdN();
                zzdP = this.zzyr.zzdP();
            } else {
                zzdP = this.zzys == 2 ? this.zzyr.zzdP() : this.zzyr.zzdP();
            }
        }
        return zzdP;
    }
}
