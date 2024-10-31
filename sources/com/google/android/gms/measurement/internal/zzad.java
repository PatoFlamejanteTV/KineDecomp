package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzad extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzad> CREATOR = new zzaf();

    /* renamed from: a */
    private final Bundle f13896a;

    @SafeParcelable.Constructor
    public zzad(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f13896a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f13896a);
    }

    public final Object e(String str) {
        return this.f13896a.get(str);
    }

    public final Long f(String str) {
        return Long.valueOf(this.f13896a.getLong(str));
    }

    public final String g(String str) {
        return this.f13896a.getString(str);
    }

    public final Double h(String str) {
        return Double.valueOf(this.f13896a.getDouble(str));
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new C1406b(this);
    }

    public final int size() {
        return this.f13896a.size();
    }

    public final String toString() {
        return this.f13896a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
