package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpr;

/* loaded from: classes.dex */
public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2090a;
    private final zzpr b;
    private final zzpp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.f2090a = i;
        zzx.a(iBinder);
        this.b = zzpr.zza.zzdg(iBinder);
        zzx.a(iBinder2);
        this.c = zzpp.zza.zzde(iBinder2);
    }

    public IBinder a() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzg zzgVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg zzgVar = CREATOR;
        zzg.a(this, parcel, i);
    }
}
