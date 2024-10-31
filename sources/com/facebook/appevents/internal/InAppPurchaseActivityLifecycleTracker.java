package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker";
    private static Application.ActivityLifecycleCallbacks callbacks;
    private static Object inAppBillingObj;
    private static Intent intent;
    private static ServiceConnection serviceConnection;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static Boolean hasBillingService = null;
    private static Boolean hasBiillingActivity = null;

    private static void initializeIfNotInitialized() {
        if (hasBillingService != null) {
            return;
        }
        try {
            Class.forName(SERVICE_INTERFACE_NAME);
            hasBillingService = true;
            try {
                Class.forName(BILLING_ACTIVITY_NAME);
                hasBiillingActivity = true;
            } catch (ClassNotFoundException unused) {
                hasBiillingActivity = false;
            }
            InAppPurchaseEventManager.clearSkuDetailsCache();
            intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
            serviceConnection = new g();
            callbacks = new j();
        } catch (ClassNotFoundException unused2) {
            hasBillingService = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logPurchaseInapp(Context context, ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                String string = new JSONObject(next).getString("productId");
                hashMap.put(string, next);
                arrayList2.add(string);
            } catch (JSONException e2) {
                Log.e(TAG, "Error parsing in-app purchase data.", e2);
            }
        }
        Map<String, String> skuDetails = InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, false);
        for (String str : skuDetails.keySet()) {
            AutomaticAnalyticsLogger.logPurchaseInapp((String) hashMap.get(str), skuDetails.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logPurchaseSubs(Context context, Map<String, SubscriptionType> map) {
        if (map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            try {
                String string = new JSONObject(str).getString("productId");
                arrayList.add(string);
                hashMap.put(string, str);
            } catch (JSONException e2) {
                Log.e(TAG, "Error parsing in-app purchase data.", e2);
            }
        }
        Map<String, String> skuDetails = InAppPurchaseEventManager.getSkuDetails(context, arrayList, inAppBillingObj, true);
        for (String str2 : skuDetails.keySet()) {
            String str3 = (String) hashMap.get(str2);
            AutomaticAnalyticsLogger.logPurchaseSubs(map.get(str3), str3, skuDetails.get(str2));
        }
    }

    private static void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(callbacks);
                applicationContext.bindService(intent, serviceConnection, 1);
            }
        }
    }

    public static void update() {
        initializeIfNotInitialized();
        if (hasBillingService.booleanValue() && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            startTracking();
        }
    }
}
