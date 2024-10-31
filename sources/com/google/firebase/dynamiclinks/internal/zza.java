package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    /* renamed from: a */
    private String f17279a;

    /* renamed from: b */
    private String f17280b;

    /* renamed from: c */
    private int f17281c;

    /* renamed from: d */
    private long f17282d;

    /* renamed from: e */
    private Bundle f17283e;

    /* renamed from: f */
    private Uri f17284f;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) Bundle bundle, @SafeParcelable.Param(id = 6) Uri uri) {
        this.f17282d = 0L;
        this.f17283e = null;
        this.f17279a = str;
        this.f17280b = str2;
        this.f17281c = i;
        this.f17282d = j;
        this.f17283e = bundle;
        this.f17284f = uri;
    }

    public final String O() {
        return this.f17280b;
    }

    public final Bundle P() {
        Bundle bundle = this.f17283e;
        return bundle == null ? new Bundle() : bundle;
    }

    public final long a() {
        return this.f17282d;
    }

    public final void h(long j) {
        this.f17282d = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f17279a, false);
        SafeParcelWriter.a(parcel, 2, this.f17280b, false);
        SafeParcelWriter.a(parcel, 3, this.f17281c);
        SafeParcelWriter.a(parcel, 4, this.f17282d);
        SafeParcelWriter.a(parcel, 5, P(), false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.f17284f, i, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
