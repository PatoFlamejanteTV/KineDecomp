package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class Value implements SafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzt();

    /* renamed from: a, reason: collision with root package name */
    private final int f1235a;
    private final int b;
    private boolean c;
    private float d;
    private String e;
    private Map<String, MapValue> f;
    private int[] g;
    private float[] h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Value(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr) {
        this.f1235a = i;
        this.b = i2;
        this.c = z;
        this.d = f;
        this.e = str;
        this.f = a(bundle);
        this.g = iArr;
        this.h = fArr;
    }

    private static Map<String, MapValue> a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        a aVar = new a(bundle.size());
        for (String str : bundle.keySet()) {
            aVar.put(str, bundle.getParcelable(str));
        }
        return aVar;
    }

    private boolean a(Value value) {
        if (this.b != value.b || this.c != value.c) {
            return false;
        }
        switch (this.b) {
            case 1:
                return c() == value.c();
            case 2:
                return d() == value.d();
            case 3:
                return e().equals(value.e());
            case 4:
                return h().equals(value.h());
            case 5:
                return f().equals(value.f());
            case 6:
                return g().equals(value.g());
            default:
                return this.d == value.d;
        }
    }

    public boolean a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        zzx.a(this.b == 1, "Value is not in int format");
        return Float.floatToRawIntBits(this.d);
    }

    public float d() {
        zzx.a(this.b == 2, "Value is not in float format");
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        zzx.a(this.b == 3, "Value is not in string format");
        return this.e;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && a((Value) obj));
    }

    public int[] f() {
        zzx.a(this.b == 5, "Value is not in int list format");
        return this.g;
    }

    public float[] g() {
        zzx.a(this.b == 6, "Value is not in float list format");
        return this.h;
    }

    public Map<String, MapValue> h() {
        zzx.a(this.b == 4, "Value is not in float map format");
        return this.f == null ? Collections.emptyMap() : this.f;
    }

    public int hashCode() {
        return zzw.a(Float.valueOf(this.d), this.e, this.f, this.g, this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1235a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle l() {
        if (this.f == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.f.size());
        for (Map.Entry<String, MapValue> entry : this.f.entrySet()) {
            bundle.putParcelable(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] n() {
        return this.h;
    }

    public String toString() {
        if (!this.c) {
            return "unset";
        }
        switch (this.b) {
            case 1:
                return Integer.toString(c());
            case 2:
                return Float.toString(d());
            case 3:
                return this.e;
            case 4:
                return new TreeMap(this.f).toString();
            case 5:
                return f().toString();
            case 6:
                return g().toString();
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt.a(this, parcel, i);
    }
}
