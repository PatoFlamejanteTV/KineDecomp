package c.b.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.C0688b;
import com.android.billingclient.api.F;
import com.android.billingclient.api.H;
import com.android.billingclient.api.K;
import com.android.billingclient.api.M;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* compiled from: BillingHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static int f3458a = Runtime.getRuntime().availableProcessors();

    public static void a(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    private static M c(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return new M(str, str2);
            } catch (JSONException e2) {
                b("BillingHelper", "Got JSONException while parsing purchase data: " + e2);
                return null;
            }
        }
        b("BillingHelper", "Received a bad purchase data.");
        return null;
    }

    public static H a(Intent intent, String str) {
        if (intent == null) {
            b("BillingHelper", "Got null intent!");
            H.a b2 = H.b();
            b2.a(6);
            b2.a("An internal error occurred.");
            return b2.a();
        }
        H.a b3 = H.b();
        b3.a(b(intent.getExtras(), str));
        b3.a(a(intent.getExtras(), str));
        return b3.a();
    }

    public static int b(Intent intent, String str) {
        return a(intent, str).a();
    }

    public static int b(Bundle bundle, String str) {
        if (bundle == null) {
            b(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            a(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        b(str, "Unexpected type for bundle response code: " + obj.getClass().getName());
        return 6;
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            b(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            a(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        b(str, "Unexpected type for debug message: " + obj.getClass().getName());
        return "";
    }

    public static List<M> a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList != null && stringArrayList2 != null) {
            for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
                M c2 = c(stringArrayList.get(i), stringArrayList2.get(i));
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
        } else {
            b("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
            M c3 = c(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (c3 == null) {
                b("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(c3);
        }
        return arrayList;
    }

    public static Bundle a(F f2, boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (f2.d() != 0) {
            bundle.putInt("prorationMode", f2.d());
        }
        if (f2.a() != null) {
            bundle.putString("accountId", f2.a());
        }
        if (f2.h()) {
            bundle.putBoolean("vr", true);
        }
        if (f2.c() != null) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(f2.c())));
        }
        if (f2.b() != null) {
            bundle.putString("developerId", f2.b());
        }
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Bundle a(boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Bundle a(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Bundle a(K k, boolean z) {
        Bundle bundle = new Bundle();
        if (z && k.a() != null) {
            bundle.putString("developerPayload", k.a());
        }
        return bundle;
    }

    public static Bundle a(C0688b c0688b) {
        Bundle bundle = new Bundle();
        String a2 = c0688b.a();
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString("developerPayload", a2);
        }
        return bundle;
    }
}
