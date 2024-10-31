package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zza();

    /* renamed from: a */
    private final int f10702a;

    /* renamed from: b */
    private final String f10703b;

    @SafeParcelable.Constructor
    public Scope(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        Preconditions.a(str, (Object) "scopeUri must not be null or empty");
        this.f10702a = i;
        this.f10703b = str;
    }

    @KeepForSdk
    public final String a() {
        return this.f10703b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f10703b.equals(((Scope) obj).f10703b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10703b.hashCode();
    }

    public final String toString() {
        return this.f10703b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10702a);
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, a2);
    }

    public Scope(String str) {
        this(1, str);
    }
}
