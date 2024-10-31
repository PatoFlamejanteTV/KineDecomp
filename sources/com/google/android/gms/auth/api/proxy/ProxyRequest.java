package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ProxyRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public static final int f801a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 7;
    final int j;
    public final String k;
    public final int l;
    public final long m;
    public final byte[] n;
    Bundle o;

    /* loaded from: classes.dex */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyRequest(int i2, String str, int i3, long j, byte[] bArr, Bundle bundle) {
        this.j = i2;
        this.k = str;
        this.l = i3;
        this.m = j;
        this.n = bArr;
        this.o = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.k + ", method: " + this.l + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zzb.a(this, parcel, i2);
    }
}
