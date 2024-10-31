package com.adobe.creativesdk.foundation.internal.cache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f4959a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f4960b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeCommonCacheHitLocation f4961c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o f4962d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(o oVar, e eVar, Object obj, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        this.f4962d = oVar;
        this.f4959a = eVar;
        this.f4960b = obj;
        this.f4961c = adobeCommonCacheHitLocation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4959a.a(this.f4960b, this.f4961c);
    }
}
