package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* loaded from: classes.dex */
public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    private final int f1257a;
    private final zzow b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListClaimedBleDevicesRequest(int i, IBinder iBinder) {
        this.f1257a = i;
        this.b = zzow.zza.zzbL(iBinder);
    }

    public ListClaimedBleDevicesRequest(zzow zzowVar) {
        this.f1257a = 2;
        this.b = zzowVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1257a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
