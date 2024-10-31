package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxu;

@zzark
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

    /* renamed from: a */
    private final boolean f9974a;

    /* renamed from: b */
    private final zzxt f9975b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f9976a = false;
    }

    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.f9974a = z;
        this.f9975b = iBinder != null ? zzxu.zzd(iBinder) : null;
    }

    public final zzxt O() {
        return this.f9975b;
    }

    public final boolean a() {
        return this.f9974a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a());
        zzxt zzxtVar = this.f9975b;
        SafeParcelWriter.a(parcel, 2, zzxtVar == null ? null : zzxtVar.asBinder(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
