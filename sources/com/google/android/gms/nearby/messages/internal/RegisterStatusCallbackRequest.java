package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zzf;

/* loaded from: classes.dex */
public final class RegisterStatusCallbackRequest implements SafeParcelable {
    public static final Parcelable.Creator<RegisterStatusCallbackRequest> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    final int f2115a;
    public final zzc b;
    public final zzf c;
    public boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegisterStatusCallbackRequest(int i, IBinder iBinder, IBinder iBinder2, boolean z) {
        this.f2115a = i;
        this.b = zzc.zza.a(iBinder);
        this.c = zzf.zza.a(iBinder2);
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.b.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return this.c.asBinder();
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
