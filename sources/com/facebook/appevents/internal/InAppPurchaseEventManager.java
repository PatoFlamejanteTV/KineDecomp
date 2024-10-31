package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400;
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseEventManager";
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
    private static final SharedPreferences purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_SUBS_STORE, 0);

    public static Object asInterface(Context context, IBinder iBinder) {
        Method method;
        Class<?> cls = getClass(context, IN_APP_BILLING_SERVICE_STUB);
        if (cls == null || (method = getMethod(cls, AS_INTERFACE)) == null) {
            return null;
        }
        Object[] objArr = {iBinder};
        Utility.logd(TAG, "In-app billing service connected");
        return invokeMethod(cls, method, null, objArr);
    }

    public static void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0L);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
    }

    private static ArrayList<String> filterPurchasesInapp(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException e2) {
                Log.e(TAG, "parsing purchase failure: ", e2);
            }
        }
        edit.apply();
        return arrayList2;
    }

    private static Class<?> getClass(Context context, String str) {
        Class<?> cls = classMap.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            classMap.put(str, cls);
            return cls;
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, str + " is not available, please add " + str + " to the project.", e2);
            return cls;
        }
    }

    private static Method getMethod(Class<?> cls, String str) {
        Method method = methodMap.get(str);
        if (method != null) {
            return method;
        }
        Class<?>[] clsArr = null;
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals(GET_PURCHASES)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals(IS_BILLING_SUPPORTED)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals(AS_INTERFACE)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals(GET_PURCHASE_HISTORY)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals(GET_SKU_DETAILS)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (c2 == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (c2 == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (c2 == 3) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            } else if (c2 == 4) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            }
            method = cls.getDeclaredMethod(str, clsArr);
            methodMap.put(str, method);
            return method;
        } catch (NoSuchMethodException e2) {
            Log.e(TAG, cls.getName() + "." + str + " method not found", e2);
            return method;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, Class<?> cls, Method method, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            char c2 = 0;
            Boolean bool = false;
            String str2 = null;
            int i = 0;
            while (true) {
                Object cast = cls.cast(obj);
                Object[] objArr = new Object[5];
                objArr[c2] = 6;
                objArr[1] = PACKAGE_NAME;
                objArr[2] = str;
                objArr[3] = str2;
                objArr[4] = new Bundle();
                Object invokeMethod = invokeMethod(cls, method, cast, objArr);
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Iterator<String> it = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            try {
                            } catch (JSONException e2) {
                                Log.e(TAG, "parsing purchase failure: ", e2);
                            }
                            if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                bool = true;
                                break;
                            }
                            arrayList.add(next);
                            i++;
                        }
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        if (i < 30 || str2 == null || bool.booleanValue()) {
                            break;
                            break;
                        }
                        c2 = 0;
                    }
                }
                str2 = null;
                if (i < 30) {
                    break;
                }
                c2 = 0;
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        Method method;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, GET_PURCHASE_HISTORY)) == null) ? arrayList : filterPurchasesInapp(getPurchaseHistory(context, obj, cls, method, INAPP));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[EDGE_INSN: B:16:0x0059->B:19:0x0059 BREAK  A[LOOP:0: B:4:0x0013->B:15:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r9, java.lang.Object r10, java.lang.Class<?> r11, java.lang.reflect.Method r12, java.lang.String r13) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Boolean r9 = isBillingSupported(r9, r10, r13)
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L59
            r9 = 0
            r1 = 0
            r2 = r1
            r3 = 0
        L13:
            java.lang.Object r4 = r11.cast(r10)
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5[r9] = r7
            r7 = 1
            java.lang.String r8 = com.facebook.appevents.internal.InAppPurchaseEventManager.PACKAGE_NAME
            r5[r7] = r8
            r7 = 2
            r5[r7] = r13
            r5[r6] = r2
            java.lang.Object r2 = invokeMethod(r11, r12, r4, r5)
            if (r2 == 0) goto L52
            android.os.Bundle r2 = (android.os.Bundle) r2
            java.lang.String r4 = "RESPONSE_CODE"
            int r4 = r2.getInt(r4)
            if (r4 != 0) goto L52
            java.lang.String r4 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r4 = r2.getStringArrayList(r4)
            if (r4 == 0) goto L59
            int r5 = r4.size()
            int r3 = r3 + r5
            r0.addAll(r4)
            java.lang.String r4 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r2 = r2.getString(r4)
            goto L53
        L52:
            r2 = r1
        L53:
            r4 = 30
            if (r3 >= r4) goto L59
            if (r2 != 0) goto L13
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.Class, java.lang.reflect.Method, java.lang.String):java.util.ArrayList");
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        Class<?> cls;
        Method method;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, GET_PURCHASES)) == null) ? arrayList : filterPurchasesInapp(getPurchases(context, obj, cls, method, INAPP));
    }

    public static Map<String, SubscriptionType> getPurchasesSubs(Context context, Object obj) {
        Class<?> cls;
        Method method;
        HashMap hashMap = new HashMap();
        if (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, GET_PURCHASES)) == null) {
            return hashMap;
        }
        Iterator<String> it = getPurchases(context, obj, cls, method, SUBSCRIPTION).iterator();
        while (it.hasNext()) {
            String next = it.next();
            SubscriptionType subsType = getSubsType(next);
            if (subsType != SubscriptionType.DUPLICATED && subsType != SubscriptionType.UNKNOWN) {
                hashMap.put(next, subsType);
            }
        }
        return hashMap;
    }

    public static ArrayList<String> getPurchasesSubsExpire(Context context, Object obj) {
        Class<?> cls;
        Method method;
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, GET_PURCHASES)) == null) {
            return arrayList;
        }
        Map<String, ?> all = purchaseSubsSharedPrefs.getAll();
        if (all.isEmpty()) {
            return arrayList;
        }
        ArrayList<String> purchases = getPurchases(context, obj, cls, method, SUBSCRIPTION);
        HashSet hashSet = new HashSet();
        Iterator<String> it = purchases.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject(it.next()).getString("productId"));
            } catch (JSONException e2) {
                Log.e(TAG, "Error parsing purchase json", e2);
            }
        }
        HashSet<String> hashSet2 = new HashSet();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next().getKey();
            if (!hashSet.contains(key)) {
                hashSet2.add(key);
            }
        }
        SharedPreferences.Editor edit = purchaseSubsSharedPrefs.edit();
        for (String str : hashSet2) {
            String string = purchaseSubsSharedPrefs.getString(str, "");
            edit.remove(str);
            if (!string.isEmpty()) {
                arrayList.add(purchaseSubsSharedPrefs.getString(str, ""));
            }
        }
        edit.apply();
        return arrayList;
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Class<?> cls;
        Method method;
        HashMap hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty() || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, GET_SKU_DETAILS)) == null) {
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
        Object cast = cls.cast(obj);
        Object[] objArr = new Object[4];
        objArr[0] = 3;
        objArr[1] = PACKAGE_NAME;
        objArr[2] = z ? SUBSCRIPTION : INAPP;
        objArr[3] = bundle;
        Object invokeMethod = invokeMethod(cls, method, cast, objArr);
        if (invokeMethod != null) {
            Bundle bundle2 = (Bundle) invokeMethod;
            if (bundle2.getInt(RESPONSE_CODE) == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        hashMap.put(arrayList.get(i), stringArrayList.get(i));
                    }
                }
                writeSkuDetailsToCache(hashMap);
            }
        }
        return hashMap;
    }

    private static SubscriptionType getSubsType(String str) {
        SubscriptionType subscriptionType = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("productId");
            String string2 = purchaseSubsSharedPrefs.getString(string, "");
            JSONObject jSONObject2 = string2.isEmpty() ? new JSONObject() : new JSONObject(string2);
            if (!jSONObject2.optString("purchaseToken").equals(jSONObject.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                boolean z = jSONObject2.getBoolean("autoRenewing");
                boolean z2 = jSONObject.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                if (currentTimeMillis - jSONObject2.getLong(LAST_LOGGED_TIME_SEC) > SUBSCRIPTION_HARTBEAT_INTERVAL) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject.put(LAST_LOGGED_TIME_SEC, currentTimeMillis);
                purchaseSubsSharedPrefs.edit().putString(string, jSONObject.toString()).apply();
            }
            return subscriptionType;
        } catch (JSONException e2) {
            Log.e(TAG, "parsing purchase failure: ", e2);
            return SubscriptionType.UNKNOWN;
        }
    }

    private static Object invokeMethod(Class cls, Method method, Object obj, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "Illegal access to method " + cls.getName() + "." + method.getName(), e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e(TAG, "Invocation target exception in " + cls.getName() + "." + method.getName(), e3);
            return null;
        }
    }

    public static Boolean isBillingSupported(Context context, Object obj, String str) {
        Class<?> cls;
        Method method;
        boolean z = false;
        if (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || (method = getMethod(cls, IS_BILLING_SUPPORTED)) == null) {
            return false;
        }
        Object invokeMethod = invokeMethod(cls, method, cls.cast(obj), new Object[]{3, PACKAGE_NAME, str});
        if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = skuDetailSharedPrefs.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (String str : map.keySet()) {
            edit.putString(str, currentTimeMillis + ";" + map.get(str));
        }
        edit.apply();
    }
}
