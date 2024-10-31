package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ProxyResponse implements SafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f802a;
    public final int b;
    public final PendingIntent c;
    public final int d;
    final Bundle e;
    public final byte[] f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f802a = i;
        this.b = i2;
        this.d = i3;
        this.e = bundle;
        this.f = bArr;
        this.c = pendingIntent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
