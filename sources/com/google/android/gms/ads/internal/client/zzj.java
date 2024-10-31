package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzj extends zzu.zza {

    /* renamed from: a, reason: collision with root package name */
    private final AppEventListener f543a;

    public zzj(AppEventListener appEventListener) {
        this.f543a = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void a(String str, String str2) {
        this.f543a.a(str, str2);
    }
}
