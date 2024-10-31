package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzv();

    /* renamed from: a */
    private final int f10441a;

    /* renamed from: b */
    private boolean f10442b;

    /* renamed from: c */
    private long f10443c;

    /* renamed from: d */
    private final boolean f10444d;

    @SafeParcelable.Constructor
    public DeviceMetaData(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) boolean z2) {
        this.f10441a = i;
        this.f10442b = z;
        this.f10443c = j;
        this.f10444d = z2;
    }

    public boolean O() {
        return this.f10444d;
    }

    public boolean P() {
        return this.f10442b;
    }

    public long a() {
        return this.f10443c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10441a);
        SafeParcelWriter.a(parcel, 2, P());
        SafeParcelWriter.a(parcel, 3, a());
        SafeParcelWriter.a(parcel, 4, O());
        SafeParcelWriter.a(parcel, a2);
    }
}
