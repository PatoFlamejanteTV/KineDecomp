package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzmi;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdRequestParcel f581a;
    final /* synthetic */ zzi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzi zziVar, AdRequestParcel adRequestParcel) {
        this.b = zziVar;
        this.f581a = adRequestParcel;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        zzcw zzcwVar;
        zzcx zzcxVar;
        zzmi<String, zzcz> zzmiVar;
        com.google.android.gms.ads.internal.client.zzo zzoVar;
        zzmi<String, zzcy> zzmiVar2;
        List<String> d;
        NativeAdOptionsParcel nativeAdOptionsParcel;
        obj = this.b.m;
        synchronized (obj) {
            zzn c = this.b.c();
            this.b.l = new WeakReference(c);
            zzcwVar = this.b.d;
            c.a(zzcwVar);
            zzcxVar = this.b.e;
            c.a(zzcxVar);
            zzmiVar = this.b.f;
            c.a(zzmiVar);
            zzoVar = this.b.b;
            c.zza(zzoVar);
            zzmiVar2 = this.b.g;
            c.b(zzmiVar2);
            d = this.b.d();
            c.a(d);
            nativeAdOptionsParcel = this.b.h;
            c.a(nativeAdOptionsParcel);
            c.zzb(this.f581a);
        }
    }
}
