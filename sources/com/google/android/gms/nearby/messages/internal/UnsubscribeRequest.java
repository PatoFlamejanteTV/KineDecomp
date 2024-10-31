package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzb;
import com.google.android.gms.nearby.messages.internal.zzc;

/* loaded from: classes.dex */
public final class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    final int f2118a;
    public final zzb b;
    public final zzc c;
    public final PendingIntent d;
    public final int e;
    public final String f;
    public final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsubscribeRequest(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2) {
        this.f2118a = i;
        this.b = zzb.zza.a(iBinder);
        this.c = zzc.zza.a(iBinder2);
        this.d = pendingIntent;
        this.e = i2;
        this.f = str;
        this.g = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.a(this, parcel, i);
    }
}
