package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzq extends AbstractSafeParcelable implements ShortDynamicLink {
    public static final Parcelable.Creator<zzq> CREATOR = new zzs();

    /* renamed from: a */
    private final Uri f17290a;

    /* renamed from: b */
    private final Uri f17291b;

    /* renamed from: c */
    private final List<zzr> f17292c;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 1) Uri uri, @SafeParcelable.Param(id = 2) Uri uri2, @SafeParcelable.Param(id = 3) List<zzr> list) {
        this.f17290a = uri;
        this.f17291b = uri2;
        this.f17292c = list;
    }

    public final Uri O() {
        return this.f17290a;
    }

    public final List<zzr> P() {
        return this.f17292c;
    }

    public final Uri a() {
        return this.f17291b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) O(), i, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) a(), i, false);
        SafeParcelWriter.d(parcel, 3, P(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
