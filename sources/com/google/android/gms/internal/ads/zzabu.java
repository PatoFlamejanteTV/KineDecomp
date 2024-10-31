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
public final class zzabu extends zzadu implements zzacg {
    private Bundle mExtras;
    private Object mLock = new Object();
    private String zzdaw;
    private List<zzabr> zzdax;
    private String zzday;
    private String zzdba;
    private zzabm zzdbe;
    private zzyp zzdbf;
    private View zzdbg;
    private IObjectWrapper zzdbh;
    private String zzdbi;
    private zzacd zzdbj;
    private zzadb zzdbl;
    private String zzdbm;

    public zzabu(String str, List<zzabr> list, String str2, zzadb zzadbVar, String str3, String str4, zzabm zzabmVar, Bundle bundle, zzyp zzypVar, View view, IObjectWrapper iObjectWrapper, String str5) {
        this.zzdaw = str;
        this.zzdax = list;
        this.zzday = str2;
        this.zzdbl = zzadbVar;
        this.zzdba = str3;
        this.zzdbm = str4;
        this.zzdbe = zzabmVar;
        this.mExtras = bundle;
        this.zzdbf = zzypVar;
        this.zzdbg = view;
        this.zzdbh = iObjectWrapper;
        this.zzdbi = str5;
    }

    public static /* synthetic */ zzacd zza(zzabu zzabuVar, zzacd zzacdVar) {
        zzabuVar.zzdbj = null;
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final void destroy() {
        zzayh.zzelc.post(new RunnableC1020o(this));
        this.zzdaw = null;
        this.zzdax = null;
        this.zzday = null;
        this.zzdbl = null;
        this.zzdba = null;
        this.zzdbm = null;
        this.zzdbe = null;
        this.mExtras = null;
        this.mLock = null;
        this.zzdbf = null;
        this.zzdbg = null;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final String getAdvertiser() {
        return this.zzdbm;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final String getBody() {
        return this.zzday;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final String getCallToAction() {
        return this.zzdba;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final String getHeadline() {
        return this.zzdaw;
    }

    @Override // com.google.android.gms.internal.ads.zzadt, com.google.android.gms.internal.ads.zzacg
    public final List getImages() {
        return this.zzdax;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final String getMediationAdapterClassName() {
        return this.zzdbi;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final zzyp getVideoController() {
        return this.zzdbf;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.zzdbj.performClick(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final boolean recordImpression(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.zzdbj.recordImpression(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.zzdbj.reportTouchEvent(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb(zzacd zzacdVar) {
        synchronized (this.mLock) {
            this.zzdbj = zzacdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String zzrv() {
        return "1";
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzabm zzrw() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final View zzrx() {
        return this.zzdbg;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final IObjectWrapper zzsc() {
        return ObjectWrapper.a(this.zzdbj);
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final IObjectWrapper zzsd() {
        return this.zzdbh;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final zzacx zzse() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final zzadb zzsf() {
        return this.zzdbl;
    }
}
