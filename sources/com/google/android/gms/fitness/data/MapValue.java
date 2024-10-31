package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class MapValue implements SafeParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    private final int f1226a;
    private final int b;
    private final float c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapValue(int i, int i2, float f) {
        this.f1226a = i;
        this.b = i2;
        this.c = f;
    }

    private boolean a(MapValue mapValue) {
        if (this.b != mapValue.b) {
            return false;
        }
        switch (this.b) {
            case 2:
                return a() == mapValue.a();
            default:
                return this.c == mapValue.c;
        }
    }

    public float a() {
        zzx.a(this.b == 2, "Value is not in float format");
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1226a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MapValue) && a((MapValue) obj));
    }

    public int hashCode() {
        return (int) this.c;
    }

    public String toString() {
        switch (this.b) {
            case 2:
                return Float.toString(a());
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
