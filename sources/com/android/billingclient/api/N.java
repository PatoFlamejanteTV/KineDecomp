package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.H;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PurchaseApiResponseChecker.java */
/* loaded from: classes.dex */
public final class N {
    public static H a(Bundle bundle, String str, String str2) {
        H h2 = I.k;
        if (bundle == null) {
            c.b.a.a.a.b(str, String.format("%s got null owned items list", str2));
            return h2;
        }
        int b2 = c.b.a.a.a.b(bundle, str);
        String a2 = c.b.a.a.a.a(bundle, str);
        H.a b3 = H.b();
        b3.a(b2);
        b3.a(a2);
        H a3 = b3.a();
        if (b2 != 0) {
            c.b.a.a.a.b(str, String.format("%s failed. Response code: %s", str2, Integer.valueOf(b2)));
            return a3;
        }
        if (bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                c.b.a.a.a.b(str, String.format("Bundle returned from %s contains null SKUs list.", str2));
                return h2;
            }
            if (stringArrayList2 == null) {
                c.b.a.a.a.b(str, String.format("Bundle returned from %s contains null purchases list.", str2));
                return h2;
            }
            if (stringArrayList3 == null) {
                c.b.a.a.a.b(str, String.format("Bundle returned from %s contains null signatures list.", str2));
                return h2;
            }
            return I.o;
        }
        c.b.a.a.a.b(str, String.format("Bundle returned from %s doesn't contain required fields.", str2));
        return h2;
    }
}
