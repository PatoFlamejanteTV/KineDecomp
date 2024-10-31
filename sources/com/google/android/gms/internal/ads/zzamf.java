package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzamf extends zzalt {
    private final NativeAppInstallAdMapper zzdod;

    public zzamf(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdod = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getBody() {
        return this.zzdod.i();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getCallToAction() {
        return this.zzdod.j();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final Bundle getExtras() {
        return this.zzdod.b();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getHeadline() {
        return this.zzdod.k();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final List getImages() {
        List<NativeAd.Image> m = this.zzdod.m();
        if (m == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : m) {
            arrayList.add(new zzabr(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final boolean getOverrideClickHandling() {
        return this.zzdod.c();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final boolean getOverrideImpressionRecording() {
        return this.zzdod.d();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getPrice() {
        return this.zzdod.n();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final double getStarRating() {
        return this.zzdod.o();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getStore() {
        return this.zzdod.p();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzyp getVideoController() {
        if (this.zzdod.e() != null) {
            return this.zzdod.e().b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void recordImpression() {
        this.zzdod.g();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdod.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.zzdod.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzdod.b((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzdod.c((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzadb zzsb() {
        NativeAd.Image l = this.zzdod.l();
        if (l != null) {
            return new zzabr(l.getDrawable(), l.getUri(), l.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzacx zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzvb() {
        View a2 = this.zzdod.a();
        if (a2 == null) {
            return null;
        }
        return ObjectWrapper.a(a2);
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzvc() {
        View h2 = this.zzdod.h();
        if (h2 == null) {
            return null;
        }
        return ObjectWrapper.a(h2);
    }
}
