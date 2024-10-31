package com.adobe.creativesdk.foundation.internal.cache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f4975a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f4976b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o oVar, e eVar) {
        this.f4976b = oVar;
        this.f4975a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar = this.f4975a;
        if (eVar != null) {
            eVar.a();
        }
    }
}
