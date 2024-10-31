package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc;

/* loaded from: classes.dex */
public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionStatusRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2111a;
    public final zzc b;
    public final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetPermissionStatusRequest(int i, IBinder iBinder, String str) {
        this.f2111a = i;
        this.b = zzc.zza.a(iBinder);
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
