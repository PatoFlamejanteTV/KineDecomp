package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzamx extends zzalz {
    private final UnifiedNativeAdMapper zzdom;

    public zzamx(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdom = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getAdvertiser() {
        return this.zzdom.b();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getBody() {
        return this.zzdom.c();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getCallToAction() {
        return this.zzdom.d();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final Bundle getExtras() {
        return this.zzdom.e();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getHeadline() {
        return this.zzdom.f();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final List getImages() {
        List<NativeAd.Image> h2 = this.zzdom.h();
        ArrayList arrayList = new ArrayList();
        if (h2 != null) {
            for (NativeAd.Image image : h2) {
                arrayList.add(new zzabr(image.getDrawable(), image.getUri(), image.getScale()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final boolean getOverrideClickHandling() {
        return this.zzdom.i();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final boolean getOverrideImpressionRecording() {
        return this.zzdom.j();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getPrice() {
        return this.zzdom.k();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final double getStarRating() {
        if (this.zzdom.l() != null) {
            return this.zzdom.l().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final String getStore() {
        return this.zzdom.m();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final zzyp getVideoController() {
        if (this.zzdom.n() != null) {
            return this.zzdom.n().b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void recordImpression() {
        this.zzdom.p();
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdom.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.zzdom.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzdom.b((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final zzadb zzsb() {
        NativeAd.Image g2 = this.zzdom.g();
        if (g2 != null) {
            return new zzabr(g2.getDrawable(), g2.getUri(), g2.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final IObjectWrapper zzsd() {
        Object r = this.zzdom.r();
        if (r == null) {
            return null;
        }
        return ObjectWrapper.a(r);
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final zzacx zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final IObjectWrapper zzvb() {
        View a2 = this.zzdom.a();
        if (a2 == null) {
            return null;
        }
        return ObjectWrapper.a(a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final IObjectWrapper zzvc() {
        View q = this.zzdom.q();
        if (q == null) {
            return null;
        }
        return ObjectWrapper.a(q);
    }
}
