package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaa;

/* loaded from: classes.dex */
public final class InterstitialAd {

    /* renamed from: a */
    private final zzaa f518a;

    public InterstitialAd(Context context) {
        this.f518a = new zzaa(context);
    }

    public void a() {
        this.f518a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(AdListener adListener) {
        this.f518a.a(adListener);
        if (adListener != 0 && (adListener instanceof com.google.android.gms.ads.internal.client.zza)) {
            this.f518a.a((com.google.android.gms.ads.internal.client.zza) adListener);
        } else if (adListener == 0) {
            this.f518a.a((com.google.android.gms.ads.internal.client.zza) null);
        }
    }

    public void a(AdRequest adRequest) {
        this.f518a.a(adRequest.a());
    }

    public void a(String str) {
        this.f518a.a(str);
    }
}
