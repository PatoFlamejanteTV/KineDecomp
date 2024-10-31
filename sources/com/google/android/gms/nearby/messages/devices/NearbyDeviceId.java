package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class NearbyDeviceId implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceId> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    public static final NearbyDeviceId f2107a = new NearbyDeviceId();
    final int b;
    final byte[] c;
    private final int d;
    private final zzb e;
    private final zzd f;

    private NearbyDeviceId() {
        this(1, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyDeviceId(int i, int i2, byte[] bArr) {
        this.b = i;
        this.d = i2;
        this.c = bArr;
        this.e = i2 == 2 ? new zzb(bArr) : null;
        this.f = i2 == 3 ? new zzd(bArr) : null;
    }

    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyDeviceId)) {
            return false;
        }
        NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) obj;
        return zzw.a(Integer.valueOf(this.d), Integer.valueOf(nearbyDeviceId.d)) && zzw.a(this.c, nearbyDeviceId.c);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.d), this.c);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NearbyDeviceId{");
        switch (this.d) {
            case 1:
                append.append("UNKNOWN");
                break;
            case 2:
                append.append("eddystoneUid=").append(this.e);
                break;
            case 3:
                append.append("iBeaconId=").append(this.f);
                break;
        }
        append.append("}");
        return append.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
