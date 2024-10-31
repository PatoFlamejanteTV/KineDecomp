package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzb;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zzg;

/* loaded from: classes.dex */
public final class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    final int f2116a;
    public final zzb b;
    public final Strategy c;
    public final zzc d;
    public final MessageFilter e;
    public final PendingIntent f;
    public final int g;
    public final String h;
    public final String i;
    public final byte[] j;
    public final boolean k;
    public final zzg l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3) {
        this.f2116a = i;
        this.b = zzb.zza.a(iBinder);
        this.c = strategy;
        this.d = zzc.zza.a(iBinder2);
        this.e = messageFilter;
        this.f = pendingIntent;
        this.g = i2;
        this.h = str;
        this.i = str2;
        this.j = bArr;
        this.k = z;
        this.l = iBinder3 == null ? null : zzg.zza.a(iBinder3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder c() {
        if (this.l == null) {
            return null;
        }
        return this.l.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.a(this, parcel, i);
    }
}
