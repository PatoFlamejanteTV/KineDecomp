package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();

    /* renamed from: a */
    public final String f13897a;

    /* renamed from: b */
    public final zzad f13898b;

    /* renamed from: c */
    public final String f13899c;

    /* renamed from: d */
    public final long f13900d;

    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zzad zzadVar, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j) {
        this.f13897a = str;
        this.f13898b = zzadVar;
        this.f13899c = str2;
        this.f13900d = j;
    }

    public final String toString() {
        String str = this.f13899c;
        String str2 = this.f13897a;
        String valueOf = String.valueOf(this.f13898b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f13897a, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.f13898b, i, false);
        SafeParcelWriter.a(parcel, 4, this.f13899c, false);
        SafeParcelWriter.a(parcel, 5, this.f13900d);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzag(zzag zzagVar, long j) {
        Preconditions.a(zzagVar);
        this.f13897a = zzagVar.f13897a;
        this.f13898b = zzagVar.f13898b;
        this.f13899c = zzagVar.f13899c;
        this.f13900d = j;
    }
}
