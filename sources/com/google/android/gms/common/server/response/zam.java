package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zaj();

    /* renamed from: a */
    private final int f11232a;

    /* renamed from: b */
    final String f11233b;

    /* renamed from: c */
    final FastJsonResponse.Field<?, ?> f11234c;

    @SafeParcelable.Constructor
    public zam(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.f11232a = i;
        this.f11233b = str;
        this.f11234c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11232a);
        SafeParcelWriter.a(parcel, 2, this.f11233b, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.f11234c, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f11232a = 1;
        this.f11233b = str;
        this.f11234c = field;
    }
}
