package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f2087a;
    private final Device b;
    private final zzpp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisconnectRequest(int i, Device device, IBinder iBinder) {
        this.f2087a = i;
        this.b = (Device) zzx.a(device);
        zzx.a(iBinder);
        this.c = zzpp.zza.zzde(iBinder);
    }

    public Device a() {
        return this.b;
    }

    public IBinder b() {
        return this.c.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.a(this, parcel, i);
    }
}
