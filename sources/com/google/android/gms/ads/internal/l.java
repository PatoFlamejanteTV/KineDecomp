package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaxg f10000a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzawr f10001b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzaba f10002c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzh f10003d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(zzh zzhVar, zzaxg zzaxgVar, zzawr zzawrVar, zzaba zzabaVar) {
        this.f10003d = zzhVar;
        this.f10000a = zzaxgVar;
        this.f10001b = zzawrVar;
        this.f10002c = zzabaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasm zzasmVar = this.f10000a.zzehy;
        if (zzasmVar.zzdym && this.f10003d.zzbls.D != null) {
            String str = null;
            if (zzasmVar.zzbde != null) {
                zzbv.e();
                str = zzayh.zzdx(this.f10000a.zzehy.zzbde);
            }
            zzabb zzabbVar = new zzabb(this.f10003d, str, this.f10000a.zzehy.zzdyb);
            zzh zzhVar = this.f10003d;
            zzbw zzbwVar = zzhVar.zzbls;
            zzbwVar.L = 1;
            try {
                zzhVar.zzblq = false;
                zzbwVar.D.zza(zzabbVar);
                return;
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
                this.f10003d.zzblq = true;
            }
        }
        zzw zzwVar = new zzw(this.f10003d.zzbls.f10251c, this.f10001b, this.f10000a.zzehy.zzdyv);
        try {
            zzbgg a2 = this.f10003d.a(this.f10000a, zzwVar, this.f10001b);
            a2.zzay(this.f10003d.zzbls.k.zzehy.zzdzf);
            a2.setOnTouchListener(new N(this, zzwVar));
            a2.setOnClickListener(new O(this, zzwVar));
            zzbw zzbwVar2 = this.f10003d.zzbls;
            zzbwVar2.L = 0;
            zzbv.d();
            zzh zzhVar2 = this.f10003d;
            zzbw zzbwVar3 = zzhVar2.zzbls;
            zzbwVar2.f10256h = zzapl.zza(zzbwVar3.f10251c, zzhVar2, this.f10000a, zzbwVar3.f10252d, a2, zzhVar2.zzbma, zzhVar2, this.f10002c);
        } catch (zzbgq e3) {
            zzbbd.zzb("Could not obtain webview.", e3);
            zzayh.zzelc.post(new M(this));
        }
    }
}
