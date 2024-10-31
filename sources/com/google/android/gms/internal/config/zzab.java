package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();
    private final String mPackageName;
    private final List<String> zzaa;
    private final List<zzl> zzab;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final long zzv;
    private final DataHolder zzw;
    private final String zzx;
    private final String zzy;
    private final String zzz;

    @SafeParcelable.Constructor
    public zzab(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) DataHolder dataHolder, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) String str4, @SafeParcelable.Param(id = 8) List<String> list, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) List<zzl> list2, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3) {
        this.mPackageName = str;
        this.zzv = j;
        this.zzw = dataHolder;
        this.zzx = str2;
        this.zzy = str3;
        this.zzz = str4;
        this.zzaa = list;
        this.zzi = i;
        this.zzab = list2;
        this.zzk = i2;
        this.zzj = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.mPackageName, false);
        SafeParcelWriter.a(parcel, 3, this.zzv);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.zzw, i, false);
        SafeParcelWriter.a(parcel, 5, this.zzx, false);
        SafeParcelWriter.a(parcel, 6, this.zzy, false);
        SafeParcelWriter.a(parcel, 7, this.zzz, false);
        SafeParcelWriter.c(parcel, 8, this.zzaa, false);
        SafeParcelWriter.a(parcel, 9, this.zzi);
        SafeParcelWriter.d(parcel, 10, this.zzab, false);
        SafeParcelWriter.a(parcel, 11, this.zzk);
        SafeParcelWriter.a(parcel, 12, this.zzj);
        SafeParcelWriter.a(parcel, a2);
    }
}
