package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f2136a;
    public long b;
    public zzc c;

    StopProvidingContentRequest() {
        this.f2136a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StopProvidingContentRequest(int i, long j, IBinder iBinder) {
        this.f2136a = i;
        this.b = j;
        this.c = zzc.zza.a(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.c.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
