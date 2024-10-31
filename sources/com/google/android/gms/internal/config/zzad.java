package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();
    private final int zzac;
    private final DataHolder zzad;
    private final DataHolder zzae;
    private final long zzs;

    @SafeParcelable.Constructor
    public zzad(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) DataHolder dataHolder, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) DataHolder dataHolder2) {
        this.zzac = i;
        this.zzad = dataHolder;
        this.zzs = j;
        this.zzae = dataHolder2;
    }

    public final int getStatusCode() {
        return this.zzac;
    }

    public final long getThrottleEndTimeMillis() {
        return this.zzs;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzac);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.zzad, i, false);
        SafeParcelWriter.a(parcel, 4, this.zzs);
        SafeParcelWriter.a(parcel, 5, (Parcelable) this.zzae, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final DataHolder zzj() {
        return this.zzad;
    }

    public final DataHolder zzk() {
        return this.zzae;
    }

    public final void zzl() {
        DataHolder dataHolder = this.zzad;
        if (dataHolder == null || dataHolder.isClosed()) {
            return;
        }
        this.zzad.close();
    }

    public final void zzm() {
        DataHolder dataHolder = this.zzae;
        if (dataHolder == null || dataHolder.isClosed()) {
            return;
        }
        this.zzae.close();
    }
}
