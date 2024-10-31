package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzauk {
    private static final zzalf zzedx = new zzalf();
    private final zzalg zzedy;
    private final zzbw zzedz;
    private final Map<String, zzavy> zzeea = new HashMap();
    private final zzavr zzeeb;
    private final com.google.android.gms.ads.internal.gmsg.zzb zzeec;
    private final zzapm zzeed;

    public zzauk(zzbw zzbwVar, zzalg zzalgVar, zzavr zzavrVar, com.google.android.gms.ads.internal.gmsg.zzb zzbVar, zzapm zzapmVar) {
        this.zzedz = zzbwVar;
        this.zzedy = zzalgVar;
        this.zzeeb = zzavrVar;
        this.zzeec = zzbVar;
        this.zzeed = zzapmVar;
    }

    public static boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        return true;
    }

    public final void destroy() {
        Preconditions.a("destroy must be called on the main UI thread.");
        Iterator<String> it = this.zzeea.keySet().iterator();
        while (it.hasNext()) {
            try {
                zzavy zzavyVar = this.zzeea.get(it.next());
                if (zzavyVar != null && zzavyVar.zzxn() != null) {
                    zzavyVar.zzxn().destroy();
                }
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onContextChanged(Context context) {
        Iterator<zzavy> it = this.zzeea.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().zzxn().zzj(ObjectWrapper.a(context));
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call Adapter.onContextChanged.", e2);
            }
        }
    }

    public final void pause() {
        Preconditions.a("pause must be called on the main UI thread.");
        Iterator<String> it = this.zzeea.keySet().iterator();
        while (it.hasNext()) {
            try {
                zzavy zzavyVar = this.zzeea.get(it.next());
                if (zzavyVar != null && zzavyVar.zzxn() != null) {
                    zzavyVar.zzxn().pause();
                }
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void resume() {
        Preconditions.a("resume must be called on the main UI thread.");
        Iterator<String> it = this.zzeea.keySet().iterator();
        while (it.hasNext()) {
            try {
                zzavy zzavyVar = this.zzeea.get(it.next());
                if (zzavyVar != null && zzavyVar.zzxn() != null) {
                    zzavyVar.zzxn().resume();
                }
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void zzah(boolean z) {
        zzavy zzdd = zzdd(this.zzedz.j.zzdnd);
        if (zzdd == null || zzdd.zzxn() == null) {
            return;
        }
        try {
            zzdd.zzxn().setImmersiveMode(z);
            zzdd.zzxn().showVideo();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final zzawd zzd(zzawd zzawdVar) {
        zzakr zzakrVar;
        zzaxf zzaxfVar = this.zzedz.j;
        if (zzaxfVar != null && (zzakrVar = zzaxfVar.zzehj) != null && !TextUtils.isEmpty(zzakrVar.zzdly)) {
            zzakr zzakrVar2 = this.zzedz.j.zzehj;
            zzawdVar = new zzawd(zzakrVar2.zzdly, zzakrVar2.zzdlz);
        }
        zzaxf zzaxfVar2 = this.zzedz.j;
        if (zzaxfVar2 != null && zzaxfVar2.zzdnb != null) {
            com.google.android.gms.ads.internal.zzbv.y();
            zzbw zzbwVar = this.zzedz;
            zzakz.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzbwVar.j.zzdnb.zzdlg, zzbwVar.G, zzbwVar.H, zzawdVar);
        }
        return zzawdVar;
    }

    public final zzavy zzdd(String str) {
        zzavy zzavyVar = this.zzeea.get(str);
        if (zzavyVar != null) {
            return zzavyVar;
        }
        try {
            zzalg zzalgVar = this.zzedy;
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzalgVar = zzedx;
            }
            zzavy zzavyVar2 = new zzavy(zzalgVar.zzcp(str), this.zzeeb);
            try {
                this.zzeea.put(str, zzavyVar2);
                return zzavyVar2;
            } catch (Exception e2) {
                e = e2;
                zzavyVar = zzavyVar2;
                String valueOf = String.valueOf(str);
                zzbbd.zzc(valueOf.length() != 0 ? "Fail to instantiate adapter ".concat(valueOf) : new String("Fail to instantiate adapter "), e);
                return zzavyVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final com.google.android.gms.ads.internal.gmsg.zzb zzxb() {
        return this.zzeec;
    }

    public final zzapm zzxc() {
        return this.zzeed;
    }

    public final void zzxd() {
        zzbw zzbwVar = this.zzedz;
        zzbwVar.L = 0;
        com.google.android.gms.ads.internal.zzbv.d();
        zzbw zzbwVar2 = this.zzedz;
        zzavu zzavuVar = new zzavu(zzbwVar2.f10251c, zzbwVar2.k, this);
        String valueOf = String.valueOf(zzavu.class.getName());
        zzbbd.zzdn(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzavuVar.zzwa();
        zzbwVar.f10256h = zzavuVar;
    }

    public final void zzxe() {
        zzaxf zzaxfVar = this.zzedz.j;
        if (zzaxfVar == null || zzaxfVar.zzdnb == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.y();
        zzbw zzbwVar = this.zzedz;
        Context context = zzbwVar.f10251c;
        String str = zzbwVar.f10253e.zzdp;
        zzaxf zzaxfVar2 = zzbwVar.j;
        zzakz.zza(context, str, zzaxfVar2, zzbwVar.f10250b, false, zzaxfVar2.zzdnb.zzdlf);
    }

    public final void zzxf() {
        zzaxf zzaxfVar = this.zzedz.j;
        if (zzaxfVar == null || zzaxfVar.zzdnb == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.y();
        zzbw zzbwVar = this.zzedz;
        Context context = zzbwVar.f10251c;
        String str = zzbwVar.f10253e.zzdp;
        zzaxf zzaxfVar2 = zzbwVar.j;
        zzakz.zza(context, str, zzaxfVar2, zzbwVar.f10250b, false, zzaxfVar2.zzdnb.zzdlh);
    }
}
