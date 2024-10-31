package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;

/* loaded from: classes.dex */
public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f2085a;
    private final String b;
    private final zzpp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContinueConnectRequest(int i, String str, IBinder iBinder) {
        this.f2085a = i;
        this.b = (String) zzx.a(str);
        this.c = zzpp.zza.zzde(iBinder);
    }

    public String a() {
        return this.b;
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.a(this, parcel, i);
    }
}
