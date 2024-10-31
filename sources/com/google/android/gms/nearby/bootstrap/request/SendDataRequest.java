package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    final int f2089a;
    private final Device b;
    private final byte[] c;
    private final zzpp d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SendDataRequest(int i, Device device, byte[] bArr, IBinder iBinder) {
        this.f2089a = i;
        this.b = (Device) zzx.a(device);
        this.c = (byte[]) zzx.a(bArr);
        zzx.a(iBinder);
        this.d = zzpp.zza.zzde(iBinder);
    }

    public Device a() {
        return this.b;
    }

    public byte[] b() {
        return this.c;
    }

    public IBinder c() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzf zzfVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf zzfVar = CREATOR;
        zzf.a(this, parcel, i);
    }
}
