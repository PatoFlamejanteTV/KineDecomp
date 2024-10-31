package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@zzark
/* loaded from: classes2.dex */
public final class zzwb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwb> CREATOR = new zzwd();
    public final Bundle extras;
    public final int versionCode;

    @Deprecated
    public final long zzcjb;

    @Deprecated
    public final int zzcjc;
    public final List<String> zzcjd;
    public final boolean zzcje;
    public final int zzcjf;
    public final boolean zzcjg;
    public final String zzcjh;
    public final zzzs zzcji;
    public final Location zzcjj;
    public final String zzcjk;
    public final Bundle zzcjl;
    public final Bundle zzcjm;
    public final List<String> zzcjn;
    public final String zzcjo;
    public final String zzcjp;

    @Deprecated
    public final boolean zzcjq;

    @Nullable
    public final zzvv zzcjr;
    public final int zzcjs;

    @Nullable
    public final String zzcjt;

    @SafeParcelable.Constructor
    public zzwb(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzzs zzzsVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzvv zzvvVar, @SafeParcelable.Param(id = 20) int i4, @SafeParcelable.Param(id = 21) @Nullable String str5) {
        this.versionCode = i;
        this.zzcjb = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcjc = i2;
        this.zzcjd = list;
        this.zzcje = z;
        this.zzcjf = i3;
        this.zzcjg = z2;
        this.zzcjh = str;
        this.zzcji = zzzsVar;
        this.zzcjj = location;
        this.zzcjk = str2;
        this.zzcjl = bundle2 == null ? new Bundle() : bundle2;
        this.zzcjm = bundle3;
        this.zzcjn = list2;
        this.zzcjo = str3;
        this.zzcjp = str4;
        this.zzcjq = z3;
        this.zzcjr = zzvvVar;
        this.zzcjs = i4;
        this.zzcjt = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzwb)) {
            return false;
        }
        zzwb zzwbVar = (zzwb) obj;
        return this.versionCode == zzwbVar.versionCode && this.zzcjb == zzwbVar.zzcjb && Objects.a(this.extras, zzwbVar.extras) && this.zzcjc == zzwbVar.zzcjc && Objects.a(this.zzcjd, zzwbVar.zzcjd) && this.zzcje == zzwbVar.zzcje && this.zzcjf == zzwbVar.zzcjf && this.zzcjg == zzwbVar.zzcjg && Objects.a(this.zzcjh, zzwbVar.zzcjh) && Objects.a(this.zzcji, zzwbVar.zzcji) && Objects.a(this.zzcjj, zzwbVar.zzcjj) && Objects.a(this.zzcjk, zzwbVar.zzcjk) && Objects.a(this.zzcjl, zzwbVar.zzcjl) && Objects.a(this.zzcjm, zzwbVar.zzcjm) && Objects.a(this.zzcjn, zzwbVar.zzcjn) && Objects.a(this.zzcjo, zzwbVar.zzcjo) && Objects.a(this.zzcjp, zzwbVar.zzcjp) && this.zzcjq == zzwbVar.zzcjq && this.zzcjs == zzwbVar.zzcjs && Objects.a(this.zzcjt, zzwbVar.zzcjt);
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcjb), this.extras, Integer.valueOf(this.zzcjc), this.zzcjd, Boolean.valueOf(this.zzcje), Integer.valueOf(this.zzcjf), Boolean.valueOf(this.zzcjg), this.zzcjh, this.zzcji, this.zzcjj, this.zzcjk, this.zzcjl, this.zzcjm, this.zzcjn, this.zzcjo, this.zzcjp, Boolean.valueOf(this.zzcjq), Integer.valueOf(this.zzcjs), this.zzcjt);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.a(parcel, 2, this.zzcjb);
        SafeParcelWriter.a(parcel, 3, this.extras, false);
        SafeParcelWriter.a(parcel, 4, this.zzcjc);
        SafeParcelWriter.c(parcel, 5, this.zzcjd, false);
        SafeParcelWriter.a(parcel, 6, this.zzcje);
        SafeParcelWriter.a(parcel, 7, this.zzcjf);
        SafeParcelWriter.a(parcel, 8, this.zzcjg);
        SafeParcelWriter.a(parcel, 9, this.zzcjh, false);
        SafeParcelWriter.a(parcel, 10, (Parcelable) this.zzcji, i, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable) this.zzcjj, i, false);
        SafeParcelWriter.a(parcel, 12, this.zzcjk, false);
        SafeParcelWriter.a(parcel, 13, this.zzcjl, false);
        SafeParcelWriter.a(parcel, 14, this.zzcjm, false);
        SafeParcelWriter.c(parcel, 15, this.zzcjn, false);
        SafeParcelWriter.a(parcel, 16, this.zzcjo, false);
        SafeParcelWriter.a(parcel, 17, this.zzcjp, false);
        SafeParcelWriter.a(parcel, 18, this.zzcjq);
        SafeParcelWriter.a(parcel, 19, (Parcelable) this.zzcjr, i, false);
        SafeParcelWriter.a(parcel, 20, this.zzcjs);
        SafeParcelWriter.a(parcel, 21, this.zzcjt, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final zzwb zzpm() {
        Bundle bundle = this.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = this.extras;
            this.zzcjl.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle);
        }
        return new zzwb(this.versionCode, this.zzcjb, bundle, this.zzcjc, this.zzcjd, this.zzcje, this.zzcjf, this.zzcjg, this.zzcjh, this.zzcji, this.zzcjj, this.zzcjk, this.zzcjl, this.zzcjm, this.zzcjn, this.zzcjo, this.zzcjp, this.zzcjq, this.zzcjr, this.zzcjs, this.zzcjt);
    }
}
