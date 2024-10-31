package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzkk extends zzkp {
    public static final Parcelable.Creator<zzkk> CREATOR = new C0921gl();
    private final String description;
    private final String mimeType;
    private final int zzavs;
    private final byte[] zzavt;

    public zzkk(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzavs = 3;
        this.zzavt = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkk.class == obj.getClass()) {
            zzkk zzkkVar = (zzkk) obj;
            if (this.zzavs == zzkkVar.zzavs && zzqe.zza(this.mimeType, zzkkVar.mimeType) && zzqe.zza(this.description, zzkkVar.description) && Arrays.equals(this.zzavt, zzkkVar.zzavt)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.zzavs + 527) * 31;
        String str = this.mimeType;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzavt);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzavs);
        parcel.writeByteArray(this.zzavt);
    }

    public zzkk(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzavs = parcel.readInt();
        this.zzavt = parcel.createByteArray();
    }
}
