package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();

    /* renamed from: a */
    private final int f10539a;

    /* renamed from: b */
    public final int f10540b;

    /* renamed from: c */
    public final PendingIntent f10541c;

    /* renamed from: d */
    public final int f10542d;

    /* renamed from: e */
    private final Bundle f10543e;

    /* renamed from: f */
    public final byte[] f10544f;

    @SafeParcelable.Constructor
    public ProxyResponse(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr) {
        this.f10539a = i;
        this.f10540b = i2;
        this.f10542d = i3;
        this.f10543e = bundle;
        this.f10544f = bArr;
        this.f10541c = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10540b);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.f10541c, i, false);
        SafeParcelWriter.a(parcel, 3, this.f10542d);
        SafeParcelWriter.a(parcel, 4, this.f10543e, false);
        SafeParcelWriter.a(parcel, 5, this.f10544f, false);
        SafeParcelWriter.a(parcel, 1000, this.f10539a);
        SafeParcelWriter.a(parcel, a2);
    }
}
