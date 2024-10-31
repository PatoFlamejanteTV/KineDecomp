package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class Product {

    /* renamed from: a */
    private Map<String, String> f10352a = new HashMap();

    public final Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f10352a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return zzi.zza((Map) this.f10352a);
    }
}
