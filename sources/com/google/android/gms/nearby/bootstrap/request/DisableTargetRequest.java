package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;

/* loaded from: classes.dex */
public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f2086a;
    private final zzpp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisableTargetRequest(int i, IBinder iBinder) {
        this.f2086a = i;
        zzx.a(iBinder);
        this.b = zzpp.zza.zzde(iBinder);
    }

    public IBinder a() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.a(this, parcel, i);
    }
}
