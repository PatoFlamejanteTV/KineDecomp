package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.internal.zzeq;
import java.util.ArrayList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzev extends zzeq.zza {
    private final NativeAppInstallAdMapper zzzN;

    public zzev(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzzN = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.zzeq
    public String getBody() {
        return this.zzzN.g();
    }

    @Override // com.google.android.gms.internal.zzeq
    public String getCallToAction() {
        return this.zzzN.i();
    }

    @Override // com.google.android.gms.internal.zzeq
    public Bundle getExtras() {
        return this.zzzN.c();
    }

    @Override // com.google.android.gms.internal.zzeq
    public String getHeadline() {
        return this.zzzN.e();
    }

    @Override // com.google.android.gms.internal.zzeq
    public List getImages() {
        List<NativeAd.Image> f = this.zzzN.f();
        if (f == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : f) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzeq
    public boolean getOverrideClickHandling() {
        return this.zzzN.b();
    }

    @Override // com.google.android.gms.internal.zzeq
    public boolean getOverrideImpressionRecording() {
        return this.zzzN.a();
    }

    @Override // com.google.android.gms.internal.zzeq
    public String getPrice() {
        return this.zzzN.l();
    }

    @Override // com.google.android.gms.internal.zzeq
    public double getStarRating() {
        return this.zzzN.j();
    }

    @Override // com.google.android.gms.internal.zzeq
    public String getStore() {
        return this.zzzN.k();
    }

    @Override // com.google.android.gms.internal.zzeq
    public void recordImpression() {
        this.zzzN.d();
    }

    @Override // com.google.android.gms.internal.zzeq
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzzN.b((View) com.google.android.gms.dynamic.zze.a(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzeq
    public void zzd(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzzN.a((View) com.google.android.gms.dynamic.zze.a(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzeq
    public zzcm zzdw() {
        NativeAd.Image h = this.zzzN.h();
        if (h != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(h.getDrawable(), h.getUri(), h.getScale());
        }
        return null;
    }
}
