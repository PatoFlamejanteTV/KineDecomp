package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzamg extends zzalw {
    private final NativeContentAdMapper zzdoe;

    public zzamg(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdoe = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getAdvertiser() {
        return this.zzdoe.i();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getBody() {
        return this.zzdoe.j();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getCallToAction() {
        return this.zzdoe.k();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final Bundle getExtras() {
        return this.zzdoe.b();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getHeadline() {
        return this.zzdoe.l();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final List getImages() {
        List<NativeAd.Image> m = this.zzdoe.m();
        if (m == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : m) {
            arrayList.add(new zzabr(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final boolean getOverrideClickHandling() {
        return this.zzdoe.c();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final boolean getOverrideImpressionRecording() {
        return this.zzdoe.d();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzyp getVideoController() {
        if (this.zzdoe.e() != null) {
            return this.zzdoe.e().b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void recordImpression() {
        this.zzdoe.g();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdoe.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.zzdoe.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzdoe.b((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzdoe.c((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzacx zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzadb zzsf() {
        NativeAd.Image n = this.zzdoe.n();
        if (n != null) {
            return new zzabr(n.getDrawable(), n.getUri(), n.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzvb() {
        View a2 = this.zzdoe.a();
        if (a2 == null) {
            return null;
        }
        return ObjectWrapper.a(a2);
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzvc() {
        View h2 = this.zzdoe.h();
        if (h2 == null) {
            return null;
        }
        return ObjectWrapper.a(h2);
    }
}
