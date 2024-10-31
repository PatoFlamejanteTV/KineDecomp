package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.FacebookSdk;
import java.util.ArrayList;

/* compiled from: InAppPurchaseActivityLifecycleTracker.java */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar) {
        this.f9193a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Context applicationContext = FacebookSdk.getApplicationContext();
        obj = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
        ArrayList<String> purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, obj);
        if (purchasesInapp.isEmpty()) {
            obj2 = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
            purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, obj2);
        }
        InAppPurchaseActivityLifecycleTracker.logPurchaseInapp(applicationContext, purchasesInapp);
    }
}
