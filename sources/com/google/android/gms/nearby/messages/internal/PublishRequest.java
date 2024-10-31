package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zze;

/* loaded from: classes.dex */
public final class PublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<PublishRequest> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    final int f2114a;
    public final MessageWrapper b;
    public final Strategy c;
    public final zzc d;
    public final String e;
    public final String f;
    public final boolean g;
    public final zze h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublishRequest(int i, MessageWrapper messageWrapper, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2) {
        this.f2114a = i;
        this.b = messageWrapper;
        this.c = strategy;
        this.d = zzc.zza.a(iBinder);
        this.e = str;
        this.f = str2;
        this.g = z;
        this.h = iBinder2 == null ? null : zze.zza.a(iBinder2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        if (this.h == null) {
            return null;
        }
        return this.h.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
