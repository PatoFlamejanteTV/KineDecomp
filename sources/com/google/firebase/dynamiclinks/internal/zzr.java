package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

/* loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable implements ShortDynamicLink.Warning {
    public static final Parcelable.Creator<zzr> CREATOR = new zzt();

    /* renamed from: a */
    private final String f17293a;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 2) String str) {
        this.f17293a = str;
    }

    public final String a() {
        return this.f17293a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
