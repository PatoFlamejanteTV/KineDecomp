package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzyz;

/* loaded from: classes.dex */
public final class AdView extends a {
    public AdView(Context context) {
        super(context, 0);
        Preconditions.a(context, "Context cannot be null");
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void a(AdRequest adRequest) {
        super.a(adRequest);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    public final VideoController getVideoController() {
        zzyz zzyzVar = this.f9953a;
        if (zzyzVar != null) {
            return zzyzVar.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }
}
