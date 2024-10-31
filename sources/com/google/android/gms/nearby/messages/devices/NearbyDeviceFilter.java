package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class NearbyDeviceFilter implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceFilter> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2106a;
    final int b;
    final byte[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyDeviceFilter(int i, int i2, byte[] bArr) {
        this.f2106a = i;
        this.b = i2;
        this.c = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
