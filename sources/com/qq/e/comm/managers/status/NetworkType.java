package com.qq.e.comm.managers.status;

/* loaded from: classes3.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");


    /* renamed from: a */
    private int f25013a;

    /* renamed from: b */
    private int f25014b;

    /* renamed from: c */
    private String f25015c;

    NetworkType(int i, int i2, String str) {
        this.f25013a = i;
        this.f25014b = i2;
        this.f25015c = str;
    }

    public final int getConnValue() {
        return this.f25013a;
    }

    public final String getNameValue() {
        return this.f25015c;
    }

    public final int getPermValue() {
        return this.f25014b;
    }
}
