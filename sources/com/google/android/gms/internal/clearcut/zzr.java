package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.clearcut.zzge;

/* loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private final String packageName;
    private final boolean zzay;
    private final int zzaz;
    private final int zzi;
    public final String zzj;
    public final int zzk;
    private final String zzl;
    private final String zzm;
    private final boolean zzn;

    public zzr(String str, int i, int i2, String str2, String str3, String str4, boolean z, zzge.zzv.zzb zzbVar) {
        Preconditions.a(str);
        this.packageName = str;
        this.zzi = i;
        this.zzk = i2;
        this.zzj = str2;
        this.zzl = str3;
        this.zzm = str4;
        this.zzay = !z;
        this.zzn = z;
        this.zzaz = zzbVar.zzc();
    }

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) int i3) {
        this.packageName = str;
        this.zzi = i;
        this.zzk = i2;
        this.zzl = str2;
        this.zzm = str3;
        this.zzay = z;
        this.zzj = str4;
        this.zzn = z2;
        this.zzaz = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzr) {
            zzr zzrVar = (zzr) obj;
            if (Objects.a(this.packageName, zzrVar.packageName) && this.zzi == zzrVar.zzi && this.zzk == zzrVar.zzk && Objects.a(this.zzj, zzrVar.zzj) && Objects.a(this.zzl, zzrVar.zzl) && Objects.a(this.zzm, zzrVar.zzm) && this.zzay == zzrVar.zzay && this.zzn == zzrVar.zzn && this.zzaz == zzrVar.zzaz) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(this.packageName, Integer.valueOf(this.zzi), Integer.valueOf(this.zzk), this.zzj, this.zzl, this.zzm, Boolean.valueOf(this.zzay), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzaz));
    }

    public final String toString() {
        return "PlayLoggerContext[package=" + this.packageName + ",packageVersionCode=" + this.zzi + ",logSource=" + this.zzk + ",logSourceName=" + this.zzj + ",uploadAccount=" + this.zzl + ",loggingId=" + this.zzm + ",logAndroidId=" + this.zzay + ",isAnonymous=" + this.zzn + ",qosTier=" + this.zzaz + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.packageName, false);
        SafeParcelWriter.a(parcel, 3, this.zzi);
        SafeParcelWriter.a(parcel, 4, this.zzk);
        SafeParcelWriter.a(parcel, 5, this.zzl, false);
        SafeParcelWriter.a(parcel, 6, this.zzm, false);
        SafeParcelWriter.a(parcel, 7, this.zzay);
        SafeParcelWriter.a(parcel, 8, this.zzj, false);
        SafeParcelWriter.a(parcel, 9, this.zzn);
        SafeParcelWriter.a(parcel, 10, this.zzaz);
        SafeParcelWriter.a(parcel, a2);
    }
}
