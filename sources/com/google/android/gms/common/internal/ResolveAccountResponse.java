package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();

    /* renamed from: a */
    private final int f11124a;

    /* renamed from: b */
    private IBinder f11125b;

    /* renamed from: c */
    private ConnectionResult f11126c;

    /* renamed from: d */
    private boolean f11127d;

    /* renamed from: e */
    private boolean f11128e;

    @SafeParcelable.Constructor
    public ResolveAccountResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.f11124a = i;
        this.f11125b = iBinder;
        this.f11126c = connectionResult;
        this.f11127d = z;
        this.f11128e = z2;
    }

    public ConnectionResult O() {
        return this.f11126c;
    }

    public boolean P() {
        return this.f11127d;
    }

    public boolean Q() {
        return this.f11128e;
    }

    public IAccountAccessor a() {
        return IAccountAccessor.Stub.a(this.f11125b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f11126c.equals(resolveAccountResponse.f11126c) && a().equals(resolveAccountResponse.a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11124a);
        SafeParcelWriter.a(parcel, 2, this.f11125b, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) O(), i, false);
        SafeParcelWriter.a(parcel, 4, P());
        SafeParcelWriter.a(parcel, 5, Q());
        SafeParcelWriter.a(parcel, a2);
    }
}
