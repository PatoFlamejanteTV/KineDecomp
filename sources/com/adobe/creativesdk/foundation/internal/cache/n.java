package com.adobe.creativesdk.foundation.internal.cache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f4977a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f4978b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeCommonCacheHitLocation f4979c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o f4980d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar, e eVar, Object obj, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        this.f4980d = oVar;
        this.f4977a = eVar;
        this.f4978b = obj;
        this.f4979c = adobeCommonCacheHitLocation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4977a.a(this.f4978b, this.f4979c);
    }
}
