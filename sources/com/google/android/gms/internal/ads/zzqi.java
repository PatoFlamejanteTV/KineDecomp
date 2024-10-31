package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzqi implements Parcelable {
    public static final Parcelable.Creator<zzqi> CREATOR = new Rl();
    private int zzaac;
    public final int zzakc;
    public final int zzakd;
    public final int zzake;
    public final byte[] zzbii;

    public zzqi(int i, int i2, int i3, byte[] bArr) {
        this.zzakc = i;
        this.zzake = i2;
        this.zzakd = i3;
        this.zzbii = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzqi.class == obj.getClass()) {
            zzqi zzqiVar = (zzqi) obj;
            if (this.zzakc == zzqiVar.zzakc && this.zzake == zzqiVar.zzake && this.zzakd == zzqiVar.zzakd && Arrays.equals(this.zzbii, zzqiVar.zzbii)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = ((((((this.zzakc + 527) * 31) + this.zzake) * 31) + this.zzakd) * 31) + Arrays.hashCode(this.zzbii);
        }
        return this.zzaac;
    }

    public final String toString() {
        int i = this.zzakc;
        int i2 = this.zzake;
        int i3 = this.zzakd;
        boolean z = this.zzbii != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzakc);
        parcel.writeInt(this.zzake);
        parcel.writeInt(this.zzakd);
        parcel.writeInt(this.zzbii != null ? 1 : 0);
        byte[] bArr = this.zzbii;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public zzqi(Parcel parcel) {
        this.zzakc = parcel.readInt();
        this.zzake = parcel.readInt();
        this.zzakd = parcel.readInt();
        this.zzbii = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
