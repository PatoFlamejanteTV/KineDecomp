package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Promotion {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f696a = new HashMap();

    public Promotion a(String str) {
        a(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    void a(String str, String str2) {
        zzx.a(str, (Object) "Name should be non-null");
        this.f696a.put(str, str2);
    }

    public Promotion b(String str) {
        a("nm", str);
        return this;
    }

    public Promotion c(String str) {
        a("cr", str);
        return this;
    }

    public Promotion d(String str) {
        a("ps", str);
        return this;
    }

    public Map<String, String> e(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f696a.entrySet()) {
            hashMap.put(str + entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return zze.zzH(this.f696a);
    }
}
