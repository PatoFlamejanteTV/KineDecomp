package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetImageDimensions.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ma */
/* loaded from: classes.dex */
public class C0582ma {

    /* renamed from: a */
    public float f7348a;

    /* renamed from: b */
    public float f7349b;

    public C0582ma(float f2, float f3) {
        this.f7348a = f2;
        this.f7349b = f3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0582ma)) {
            return false;
        }
        C0582ma c0582ma = (C0582ma) obj;
        return c0582ma.f7348a == this.f7348a && c0582ma.f7349b == this.f7349b;
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "[" + this.f7348a + "," + this.f7349b + "]";
    }
}
