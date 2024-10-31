package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ProxyGrpcRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProxyGrpcRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f800a;
    public final String b;
    public final int c;
    public final long d;
    public final byte[] e;
    public final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyGrpcRequest(int i, String str, int i2, long j, byte[] bArr, String str2) {
        this.f800a = i;
        this.b = str;
        this.c = i2;
        this.d = j;
        this.e = bArr;
        this.f = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
