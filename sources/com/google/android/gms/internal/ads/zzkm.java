package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzkm extends zzkp {
    public static final Parcelable.Creator<zzkm> CREATOR = new C0935hl();
    public final String description;
    private final String zzaaa;
    public final String zzavu;

    public zzkm(String str, String str2, String str3) {
        super("COMM");
        this.zzaaa = str;
        this.description = str2;
        this.zzavu = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkm.class == obj.getClass()) {
            zzkm zzkmVar = (zzkm) obj;
            if (zzqe.zza(this.description, zzkmVar.description) && zzqe.zza(this.zzaaa, zzkmVar.zzaaa) && zzqe.zza(this.zzavu, zzkmVar.zzavu)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzaaa;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzavu;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzze);
        parcel.writeString(this.zzaaa);
        parcel.writeString(this.zzavu);
    }

    public zzkm(Parcel parcel) {
        super("COMM");
        this.zzaaa = parcel.readString();
        this.description = parcel.readString();
        this.zzavu = parcel.readString();
    }
}
