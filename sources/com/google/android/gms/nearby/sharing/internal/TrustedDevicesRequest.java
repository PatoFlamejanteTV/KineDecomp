package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f2137a;
    public String b;
    public byte[] c;
    public zzc d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrustedDevicesRequest(int i, String str, byte[] bArr, IBinder iBinder) {
        this.f2137a = i;
        this.b = (String) zzx.a(str);
        this.c = (byte[]) zzx.a(bArr);
        this.d = zzc.zza.a(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.d.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
