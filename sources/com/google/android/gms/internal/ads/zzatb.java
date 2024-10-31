package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzatb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatb> CREATOR = new zzatc();
    private final ApplicationInfo applicationInfo;
    private final String packageName;

    @Nullable
    private final PackageInfo zzdwh;
    private final List<String> zzdwt;
    private final String zzdxc;
    private final Bundle zzdzn;
    private final zzbbi zzdzo;
    private final boolean zzdzp;
    private final String zzdzq;

    @SafeParcelable.Constructor
    public zzatb(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbbi zzbbiVar, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3) {
        this.zzdzn = bundle;
        this.zzdzo = zzbbiVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzdwt = list;
        this.zzdwh = packageInfo;
        this.zzdxc = str2;
        this.zzdzp = z;
        this.zzdzq = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.zzdzn, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzdzo, i, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.applicationInfo, i, false);
        SafeParcelWriter.a(parcel, 4, this.packageName, false);
        SafeParcelWriter.c(parcel, 5, this.zzdwt, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.zzdwh, i, false);
        SafeParcelWriter.a(parcel, 7, this.zzdxc, false);
        SafeParcelWriter.a(parcel, 8, this.zzdzp);
        SafeParcelWriter.a(parcel, 9, this.zzdzq, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
