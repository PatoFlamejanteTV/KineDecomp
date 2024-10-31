package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabz extends zzaex implements zzacg {
    private Bundle mExtras;
    private String zzdaw;
    private List<zzabr> zzdax;
    private String zzday;
    private zzadb zzdaz;
    private String zzdba;
    private double zzdbb;
    private String zzdbc;
    private String zzdbd;
    private zzabm zzdbe;
    private zzyp zzdbf;
    private View zzdbg;
    private IObjectWrapper zzdbh;
    private String zzdbi;
    private zzacd zzdbj;
    private String zzdbm;
    private final Object mLock = new Object();
    private List<Object> zzdbs = null;
    private boolean zzdbt = false;

    public zzabz(String str, List<zzabr> list, String str2, zzadb zzadbVar, String str3, String str4, double d2, String str5, String str6, zzabm zzabmVar, zzyp zzypVar, View view, IObjectWrapper iObjectWrapper, String str7, Bundle bundle) {
        this.zzdaw = str;
        this.zzdax = list;
        this.zzday = str2;
        this.zzdaz = zzadbVar;
        this.zzdba = str3;
        this.zzdbm = str4;
        this.zzdbb = d2;
        this.zzdbc = str5;
        this.zzdbd = str6;
        this.zzdbe = zzabmVar;
        this.zzdbf = zzypVar;
        this.zzdbg = view;
        this.zzdbh = iObjectWrapper;
        this.zzdbi = str7;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void cancelUnconfirmedClick() {
        this.zzdbj.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() {
        zzayh.zzelc.post(new r(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getAdvertiser() {
        return this.zzdbm;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getBody() {
        return this.zzday;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getCallToAction() {
        return this.zzdba;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getHeadline() {
        return this.zzdaw;
    }

    @Override // com.google.android.gms.internal.ads.zzaew, com.google.android.gms.internal.ads.zzacg
    public final List getImages() {
        return this.zzdax;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getMediationAdapterClassName() {
        return this.zzdbi;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getMuteThisAdReasons() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getPrice() {
        return this.zzdbd;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double getStarRating() {
        return this.zzdbb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() {
        return this.zzdbc;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzyp getVideoController() {
        return this.zzdbf;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean isCustomMuteThisAdEnabled() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.zzdbj.performClick(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void recordCustomClickGesture() {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return;
            }
            this.zzdbj.recordCustomClickGesture();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean recordImpression(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.zzdbj.recordImpression(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.zzdbj.reportTouchEvent(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzaet zzaetVar) {
        this.zzdbj.zza(zzaetVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyh zzyhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyl zzylVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb(zzacd zzacdVar) {
        synchronized (this.mLock) {
            this.zzdbj = zzacdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String zzrv() {
        return "6";
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzabm zzrw() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final View zzrx() {
        return this.zzdbg;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzadb zzsb() {
        return this.zzdaz;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsc() {
        return ObjectWrapper.a(this.zzdbj);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsd() {
        return this.zzdbh;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzacx zzse() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzsi() {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return;
            }
            this.zzdbj.zzsi();
        }
    }

    public static /* synthetic */ zzacd zza(zzabz zzabzVar, zzacd zzacdVar) {
        zzabzVar.zzdbj = null;
        return null;
    }
}
