package com.google.android.gms.wearable;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class DataMap {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Object> f2326a = new HashMap<>();

    private static boolean a(Asset asset, Asset asset2) {
        return (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.b()) ? asset.b().equals(asset2.b()) : Arrays.equals(asset.a(), asset2.a());
    }

    private static boolean a(DataMap dataMap, DataMap dataMap2) {
        if (dataMap.a() != dataMap2.a()) {
            return false;
        }
        for (String str : dataMap.b()) {
            Object a2 = dataMap.a(str);
            Object a3 = dataMap2.a(str);
            if (a2 instanceof Asset) {
                if (!(a3 instanceof Asset) || !a((Asset) a2, (Asset) a3)) {
                    return false;
                }
            } else if (a2 instanceof String[]) {
                if (!(a3 instanceof String[]) || !Arrays.equals((String[]) a2, (String[]) a3)) {
                    return false;
                }
            } else if (a2 instanceof long[]) {
                if (!(a3 instanceof long[]) || !Arrays.equals((long[]) a2, (long[]) a3)) {
                    return false;
                }
            } else if (a2 instanceof float[]) {
                if (!(a3 instanceof float[]) || !Arrays.equals((float[]) a2, (float[]) a3)) {
                    return false;
                }
            } else if (a2 instanceof byte[]) {
                if (!(a3 instanceof byte[]) || !Arrays.equals((byte[]) a2, (byte[]) a3)) {
                    return false;
                }
            } else {
                if (a2 == null || a3 == null) {
                    return a2 == a3;
                }
                if (!a2.equals(a3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int a() {
        return this.f2326a.size();
    }

    public <T> T a(String str) {
        return (T) this.f2326a.get(str);
    }

    public void a(String str, byte b) {
        this.f2326a.put(str, Byte.valueOf(b));
    }

    public void a(String str, double d) {
        this.f2326a.put(str, Double.valueOf(d));
    }

    public void a(String str, float f) {
        this.f2326a.put(str, Float.valueOf(f));
    }

    public void a(String str, int i) {
        this.f2326a.put(str, Integer.valueOf(i));
    }

    public void a(String str, long j) {
        this.f2326a.put(str, Long.valueOf(j));
    }

    public void a(String str, Asset asset) {
        this.f2326a.put(str, asset);
    }

    public void a(String str, DataMap dataMap) {
        this.f2326a.put(str, dataMap);
    }

    public void a(String str, String str2) {
        this.f2326a.put(str, str2);
    }

    public void a(String str, ArrayList<DataMap> arrayList) {
        this.f2326a.put(str, arrayList);
    }

    public void a(String str, boolean z) {
        this.f2326a.put(str, Boolean.valueOf(z));
    }

    public void a(String str, byte[] bArr) {
        this.f2326a.put(str, bArr);
    }

    public void a(String str, float[] fArr) {
        this.f2326a.put(str, fArr);
    }

    public void a(String str, long[] jArr) {
        this.f2326a.put(str, jArr);
    }

    public void a(String str, String[] strArr) {
        this.f2326a.put(str, strArr);
    }

    public Set<String> b() {
        return this.f2326a.keySet();
    }

    public void b(String str, ArrayList<Integer> arrayList) {
        this.f2326a.put(str, arrayList);
    }

    public void c(String str, ArrayList<String> arrayList) {
        this.f2326a.put(str, arrayList);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataMap) {
            return a(this, (DataMap) obj);
        }
        return false;
    }

    public int hashCode() {
        return this.f2326a.hashCode() * 29;
    }

    public String toString() {
        return this.f2326a.toString();
    }
}
