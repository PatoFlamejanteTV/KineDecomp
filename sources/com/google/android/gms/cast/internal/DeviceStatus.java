package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class DeviceStatus implements SafeParcelable {
    public static final Parcelable.Creator<DeviceStatus> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    private final int f845a;
    private double b;
    private boolean c;
    private int d;
    private ApplicationMetadata e;
    private int f;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceStatus(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.f845a = i;
        this.b = d;
        this.c = z;
        this.d = i2;
        this.e = applicationMetadata;
        this.f = i3;
    }

    public int a() {
        return this.f845a;
    }

    public double b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.b == deviceStatus.b && this.c == deviceStatus.c && this.d == deviceStatus.d && zzf.a(this.e, deviceStatus.e) && this.f == deviceStatus.f;
    }

    public ApplicationMetadata f() {
        return this.e;
    }

    public int hashCode() {
        return zzw.a(Double.valueOf(this.b), Boolean.valueOf(this.c), Integer.valueOf(this.d), this.e, Integer.valueOf(this.f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
