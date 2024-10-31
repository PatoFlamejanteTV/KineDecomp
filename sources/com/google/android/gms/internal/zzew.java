package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.internal.zzer;
import java.util.ArrayList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzew extends zzer.zza {
    private final NativeContentAdMapper zzzO;

    public zzew(NativeContentAdMapper nativeContentAdMapper) {
        this.zzzO = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.zzer
    public String getAdvertiser() {
        return this.zzzO.j();
    }

    @Override // com.google.android.gms.internal.zzer
    public String getBody() {
        return this.zzzO.g();
    }

    @Override // com.google.android.gms.internal.zzer
    public String getCallToAction() {
        return this.zzzO.i();
    }

    @Override // com.google.android.gms.internal.zzer
    public Bundle getExtras() {
        return this.zzzO.c();
    }

    @Override // com.google.android.gms.internal.zzer
    public String getHeadline() {
        return this.zzzO.e();
    }

    @Override // com.google.android.gms.internal.zzer
    public List getImages() {
        List<NativeAd.Image> f = this.zzzO.f();
        if (f == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : f) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzer
    public boolean getOverrideClickHandling() {
        return this.zzzO.b();
    }

    @Override // com.google.android.gms.internal.zzer
    public boolean getOverrideImpressionRecording() {
        return this.zzzO.a();
    }

    @Override // com.google.android.gms.internal.zzer
    public void recordImpression() {
        this.zzzO.d();
    }

    @Override // com.google.android.gms.internal.zzer
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzzO.b((View) com.google.android.gms.dynamic.zze.a(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzer
    public void zzd(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzzO.a((View) com.google.android.gms.dynamic.zze.a(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzer
    public zzcm zzdA() {
        NativeAd.Image h = this.zzzO.h();
        if (h != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(h.getDrawable(), h.getUri(), h.getScale());
        }
        return null;
    }
}
