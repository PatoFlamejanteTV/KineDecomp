package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.Map;

/* compiled from: InAppPurchaseActivityLifecycleTracker.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar) {
        this.f9192a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Context applicationContext = FacebookSdk.getApplicationContext();
        obj = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
        InAppPurchaseActivityLifecycleTracker.logPurchaseInapp(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, obj));
        obj2 = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
        Map<String, SubscriptionType> purchasesSubs = InAppPurchaseEventManager.getPurchasesSubs(applicationContext, obj2);
        obj3 = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
        Iterator<String> it = InAppPurchaseEventManager.getPurchasesSubsExpire(applicationContext, obj3).iterator();
        while (it.hasNext()) {
            purchasesSubs.put(it.next(), SubscriptionType.EXPIRE);
        }
        InAppPurchaseActivityLifecycleTracker.logPurchaseSubs(applicationContext, purchasesSubs);
    }
}
