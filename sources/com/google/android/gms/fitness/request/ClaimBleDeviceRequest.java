package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<ClaimBleDeviceRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1241a;
    private final String b;
    private final BleDevice c;
    private final zzoj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClaimBleDeviceRequest(int i, String str, BleDevice bleDevice, IBinder iBinder) {
        this.f1241a = i;
        this.b = str;
        this.c = bleDevice;
        this.d = zzoj.zza.zzbJ(iBinder);
    }

    public ClaimBleDeviceRequest(String str, BleDevice bleDevice, zzoj zzojVar) {
        this.f1241a = 4;
        this.b = str;
        this.c = bleDevice;
        this.d = zzojVar;
    }

    public String a() {
        return this.b;
    }

    public BleDevice b() {
        return this.c;
    }

    public IBinder c() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1241a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", this.b, this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
