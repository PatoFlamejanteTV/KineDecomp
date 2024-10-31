package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ProductAction {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f695a = new HashMap();

    public ProductAction(String str) {
        a("&pa", str);
    }

    public ProductAction a(double d) {
        a("&tr", Double.toString(d));
        return this;
    }

    public ProductAction a(int i) {
        a("&cos", Integer.toString(i));
        return this;
    }

    public ProductAction a(String str) {
        a("&ti", str);
        return this;
    }

    public Map<String, String> a() {
        return new HashMap(this.f695a);
    }

    void a(String str, String str2) {
        zzx.a(str, (Object) "Name should be non-null");
        this.f695a.put(str, str2);
    }

    public ProductAction b(double d) {
        a("&tt", Double.toString(d));
        return this;
    }

    public ProductAction b(String str) {
        a("&ta", str);
        return this;
    }

    public ProductAction c(double d) {
        a("&ts", Double.toString(d));
        return this;
    }

    public ProductAction c(String str) {
        a("&tcc", str);
        return this;
    }

    public ProductAction d(String str) {
        a("&col", str);
        return this;
    }

    public ProductAction e(String str) {
        a("&pal", str);
        return this;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f695a.entrySet()) {
            if (entry.getKey().startsWith("&")) {
                hashMap.put(entry.getKey().substring(1), entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return zze.zzH(hashMap);
    }
}
