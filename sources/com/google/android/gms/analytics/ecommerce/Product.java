package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Product {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f694a = new HashMap();

    public Product a(double d) {
        a("pr", Double.toString(d));
        return this;
    }

    public Product a(int i) {
        a("ps", Integer.toString(i));
        return this;
    }

    public Product a(int i, int i2) {
        a(zzc.k(i), Integer.toString(i2));
        return this;
    }

    public Product a(int i, String str) {
        a(zzc.j(i), str);
        return this;
    }

    public Product a(String str) {
        a(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    void a(String str, String str2) {
        zzx.a(str, (Object) "Name should be non-null");
        this.f694a.put(str, str2);
    }

    public Product b(int i) {
        a("qt", Integer.toString(i));
        return this;
    }

    public Product b(String str) {
        a("nm", str);
        return this;
    }

    public Product c(String str) {
        a("br", str);
        return this;
    }

    public Product d(String str) {
        a("ca", str);
        return this;
    }

    public Product e(String str) {
        a("va", str);
        return this;
    }

    public Product f(String str) {
        a("cc", str);
        return this;
    }

    public Map<String, String> g(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f694a.entrySet()) {
            hashMap.put(str + entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return zze.zzH(this.f694a);
    }
}
