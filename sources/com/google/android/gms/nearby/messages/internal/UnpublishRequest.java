package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc;

/* loaded from: classes.dex */
public final class UnpublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzq();

    /* renamed from: a, reason: collision with root package name */
    final int f2117a;
    public final MessageWrapper b;
    public final zzc c;
    public final String d;
    public final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpublishRequest(int i, MessageWrapper messageWrapper, IBinder iBinder, String str, String str2) {
        this.f2117a = i;
        this.b = messageWrapper;
        this.c = zzc.zza.a(iBinder);
        this.d = str;
        this.e = str2;
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
        zzq.a(this, parcel, i);
    }
}
