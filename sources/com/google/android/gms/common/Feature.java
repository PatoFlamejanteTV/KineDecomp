package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();

    /* renamed from: a */
    private final String f10654a;

    /* renamed from: b */
    @Deprecated
    private final int f10655b;

    /* renamed from: c */
    private final long f10656c;

    @KeepForSdk
    public Feature(String str, long j) {
        this.f10654a = str;
        this.f10656c = j;
        this.f10655b = -1;
    }

    @KeepForSdk
    public long O() {
        long j = this.f10656c;
        return j == -1 ? this.f10655b : j;
    }

    @KeepForSdk
    public String a() {
        return this.f10654a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((a() != null && a().equals(feature.a())) || (a() == null && feature.a() == null)) && O() == feature.O()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.a(a(), Long.valueOf(O()));
    }

    public String toString() {
        return Objects.a(this).a("name", a()).a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Long.valueOf(O())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a(), false);
        SafeParcelWriter.a(parcel, 2, this.f10655b);
        SafeParcelWriter.a(parcel, 3, O());
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) long j) {
        this.f10654a = str;
        this.f10655b = i;
        this.f10656c = j;
    }
}
