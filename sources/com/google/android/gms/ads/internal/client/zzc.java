package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzc extends zzo.zza {

    /* renamed from: a, reason: collision with root package name */
    private final AdListener f539a;

    public zzc(AdListener adListener) {
        this.f539a = adListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void a() {
        this.f539a.c();
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void a(int i) {
        this.f539a.a(i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void b() {
        this.f539a.d();
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void c() {
        this.f539a.a();
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void d() {
        this.f539a.b();
    }
}
