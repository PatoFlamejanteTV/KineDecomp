package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: a */
    public String f14073a;

    /* renamed from: b */
    public String f14074b;

    /* renamed from: c */
    public zzfv f14075c;

    /* renamed from: d */
    public long f14076d;

    /* renamed from: e */
    public boolean f14077e;

    /* renamed from: f */
    public String f14078f;

    /* renamed from: g */
    public zzag f14079g;

    /* renamed from: h */
    public long f14080h;
    public zzag i;
    public long j;
    public zzag k;

    public zzo(zzo zzoVar) {
        Preconditions.a(zzoVar);
        this.f14073a = zzoVar.f14073a;
        this.f14074b = zzoVar.f14074b;
        this.f14075c = zzoVar.f14075c;
        this.f14076d = zzoVar.f14076d;
        this.f14077e = zzoVar.f14077e;
        this.f14078f = zzoVar.f14078f;
        this.f14079g = zzoVar.f14079g;
        this.f14080h = zzoVar.f14080h;
        this.i = zzoVar.i;
        this.j = zzoVar.j;
        this.k = zzoVar.k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f14073a, false);
        SafeParcelWriter.a(parcel, 3, this.f14074b, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.f14075c, i, false);
        SafeParcelWriter.a(parcel, 5, this.f14076d);
        SafeParcelWriter.a(parcel, 6, this.f14077e);
        SafeParcelWriter.a(parcel, 7, this.f14078f, false);
        SafeParcelWriter.a(parcel, 8, (Parcelable) this.f14079g, i, false);
        SafeParcelWriter.a(parcel, 9, this.f14080h);
        SafeParcelWriter.a(parcel, 10, (Parcelable) this.i, i, false);
        SafeParcelWriter.a(parcel, 11, this.j);
        SafeParcelWriter.a(parcel, 12, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzfv zzfvVar, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) zzag zzagVar, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) zzag zzagVar2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) zzag zzagVar3) {
        this.f14073a = str;
        this.f14074b = str2;
        this.f14075c = zzfvVar;
        this.f14076d = j;
        this.f14077e = z;
        this.f14078f = str3;
        this.f14079g = zzagVar;
        this.f14080h = j2;
        this.i = zzagVar2;
        this.j = j3;
        this.k = zzagVar3;
    }
}
