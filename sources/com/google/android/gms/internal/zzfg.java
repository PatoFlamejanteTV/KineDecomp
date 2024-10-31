package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzff;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzfg extends zzfh implements zzdk {
    private final Context mContext;
    private final zzbq zzAA;
    DisplayMetrics zzAB;
    private float zzAC;
    int zzAD;
    int zzAE;
    private int zzAF;
    int zzAG;
    int zzAH;
    int zzAI;
    int zzAJ;
    private final zziz zzoM;
    private final WindowManager zzri;

    public zzfg(zziz zzizVar, Context context, zzbq zzbqVar) {
        super(zzizVar);
        this.zzAD = -1;
        this.zzAE = -1;
        this.zzAG = -1;
        this.zzAH = -1;
        this.zzAI = -1;
        this.zzAJ = -1;
        this.zzoM = zzizVar;
        this.mContext = context;
        this.zzAA = zzbqVar;
        this.zzri = (WindowManager) context.getSystemService("window");
    }

    private void zzei() {
        this.zzAB = new DisplayMetrics();
        Display defaultDisplay = this.zzri.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzAB);
        this.zzAC = this.zzAB.density;
        this.zzAF = defaultDisplay.getRotation();
    }

    private void zzen() {
        int[] iArr = new int[2];
        this.zzoM.getLocationOnScreen(iArr);
        zze(com.google.android.gms.ads.internal.client.zzl.a().b(this.mContext, iArr[0]), com.google.android.gms.ads.internal.client.zzl.a().b(this.mContext, iArr[1]));
    }

    private zzff zzeq() {
        return new zzff.zza().zzp(this.zzAA.zzcW()).zzo(this.zzAA.zzcX()).zzq(this.zzAA.zzdb()).zzr(this.zzAA.zzcY()).zzs(this.zzAA.zzcZ()).zzeh();
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zzel();
    }

    public void zze(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzp.e().zzj((Activity) this.mContext)[0] : 0), this.zzAI, this.zzAJ);
        this.zzoM.zzhe().zzd(i, i2);
    }

    void zzej() {
        this.zzAD = com.google.android.gms.ads.internal.client.zzl.a().b(this.zzAB, this.zzAB.widthPixels);
        this.zzAE = com.google.android.gms.ads.internal.client.zzl.a().b(this.zzAB, this.zzAB.heightPixels);
        Activity zzgZ = this.zzoM.zzgZ();
        if (zzgZ == null || zzgZ.getWindow() == null) {
            this.zzAG = this.zzAD;
            this.zzAH = this.zzAE;
        } else {
            int[] zzg = com.google.android.gms.ads.internal.zzp.e().zzg(zzgZ);
            this.zzAG = com.google.android.gms.ads.internal.client.zzl.a().b(this.zzAB, zzg[0]);
            this.zzAH = com.google.android.gms.ads.internal.client.zzl.a().b(this.zzAB, zzg[1]);
        }
    }

    void zzek() {
        if (this.zzoM.zzaN().e) {
            this.zzAI = this.zzAD;
            this.zzAJ = this.zzAE;
        } else {
            this.zzoM.measure(0, 0);
            this.zzAI = com.google.android.gms.ads.internal.client.zzl.a().b(this.mContext, this.zzoM.getMeasuredWidth());
            this.zzAJ = com.google.android.gms.ads.internal.client.zzl.a().b(this.mContext, this.zzoM.getMeasuredHeight());
        }
    }

    public void zzel() {
        zzei();
        zzej();
        zzek();
        zzeo();
        zzep();
        zzen();
        zzem();
    }

    void zzem() {
        if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Dispatching Ready Event.");
        }
        zzal(this.zzoM.zzhh().b);
    }

    void zzeo() {
        zza(this.zzAD, this.zzAE, this.zzAG, this.zzAH, this.zzAC, this.zzAF);
    }

    void zzep() {
        this.zzoM.zzb("onDeviceFeaturesReceived", zzeq().toJson());
    }
}
