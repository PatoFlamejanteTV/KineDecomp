package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzi {
    public int a(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("Unexpected type for intent response code. " + obj.getClass().getName());
        return 5;
    }

    public int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("Unexpected type for intent response code. " + obj.getClass().getName());
        return 5;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("developerPayload");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to parse purchase data");
            return null;
        }
    }

    public void a(Context context) {
        b bVar = new b(this, context);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, bVar, 1);
    }

    public void a(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.a(intent, gInAppPurchaseManagerInfoParcel);
        zzp.e().zzb(context, intent);
    }

    public String b(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("purchaseToken");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to parse purchase data");
            return null;
        }
    }

    public String c(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
