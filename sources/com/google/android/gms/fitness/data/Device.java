package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzom;

/* loaded from: classes.dex */
public final class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f1224a;
    private final String b;
    private final String c;
    private final String d = "";
    private final String e;
    private final int f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.f1224a = i;
        this.b = (String) zzx.a(str);
        this.c = (String) zzx.a(str2);
        this.e = (String) zzx.a(str4);
        this.f = i2;
        this.g = i3;
    }

    private boolean a(Device device) {
        return zzw.a(this.b, device.b) && zzw.a(this.c, device.c) && zzw.a(this.d, device.d) && zzw.a(this.e, device.e) && this.f == device.f && this.g == device.g;
    }

    private boolean j() {
        return f() == 1;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && a((Device) obj));
    }

    public int f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return String.format("%s:%s:%s", this.b, this.c, this.e);
    }

    public String h() {
        return j() ? this.e : zzom.zzcU(this.e);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, this.d, this.e, Integer.valueOf(this.f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1224a;
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", g(), this.d, Integer.valueOf(this.f), Integer.valueOf(this.g));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
