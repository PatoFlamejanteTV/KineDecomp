package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();

    /* renamed from: a */
    public static final int f10531a = 0;

    /* renamed from: b */
    public static final int f10532b = 1;

    /* renamed from: c */
    public static final int f10533c = 2;

    /* renamed from: d */
    public static final int f10534d = 3;

    /* renamed from: e */
    public static final int f10535e = 4;

    /* renamed from: f */
    public static final int f10536f = 5;

    /* renamed from: g */
    public static final int f10537g = 6;

    /* renamed from: h */
    public static final int f10538h = 7;
    public static final int i = 7;
    private final int j;
    public final String k;
    public final int l;
    public final long m;
    public final byte[] n;
    private Bundle o;

    @KeepForSdkWithMembers
    /* loaded from: classes.dex */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public ProxyRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.j = i2;
        this.k = str;
        this.l = i3;
        this.m = j;
        this.n = bArr;
        this.o = bundle;
    }

    public String toString() {
        String str = this.k;
        int i2 = this.l;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i2);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.k, false);
        SafeParcelWriter.a(parcel, 2, this.l);
        SafeParcelWriter.a(parcel, 3, this.m);
        SafeParcelWriter.a(parcel, 4, this.n, false);
        SafeParcelWriter.a(parcel, 5, this.o, false);
        SafeParcelWriter.a(parcel, 1000, this.j);
        SafeParcelWriter.a(parcel, a2);
    }
}
