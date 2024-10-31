package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new zak();

    /* renamed from: a */
    private final int f14138a;

    /* renamed from: b */
    private final ConnectionResult f14139b;

    /* renamed from: c */
    private final ResolveAccountResponse f14140c;

    @SafeParcelable.Constructor
    public zaj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.f14138a = i;
        this.f14139b = connectionResult;
        this.f14140c = resolveAccountResponse;
    }

    public final ResolveAccountResponse O() {
        return this.f14140c;
    }

    public final ConnectionResult a() {
        return this.f14139b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f14138a);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.f14139b, i, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.f14140c, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zaj(int i) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
