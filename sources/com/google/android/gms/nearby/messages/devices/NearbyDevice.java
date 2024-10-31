package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class NearbyDevice implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDevice> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    public static final NearbyDevice f2105a = new NearbyDevice(NearbyDeviceId.f2107a);
    final int b;
    private final NearbyDeviceId c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyDevice(int i, NearbyDeviceId nearbyDeviceId) {
        this.b = i;
        this.c = nearbyDeviceId;
    }

    public NearbyDevice(NearbyDeviceId nearbyDeviceId) {
        this(1, nearbyDeviceId);
    }

    public NearbyDeviceId a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NearbyDevice) {
            return zzw.a(this.c, ((NearbyDevice) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.c);
    }

    public String toString() {
        return "NearbyDevice{id=" + this.c + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
