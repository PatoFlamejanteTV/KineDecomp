package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public final class ReceiveContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2135a;
    public IBinder b;
    public zza c;
    public String d;
    public zzc e;

    ReceiveContentRequest() {
        this.f2135a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReceiveContentRequest(int i, IBinder iBinder, IBinder iBinder2, String str, IBinder iBinder3) {
        this.f2135a = i;
        this.b = iBinder;
        this.c = zza.AbstractBinderC0043zza.a(iBinder2);
        this.d = str;
        this.e = zzc.zza.a(iBinder3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return this.e.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
