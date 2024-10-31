package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzhp implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzhp> CREATOR = new C1072rk();
    private int zzaac;
    private final zza[] zzagq;
    public final int zzagr;

    /* loaded from: classes2.dex */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new C1086sk();
        private final byte[] data;
        private final String mimeType;
        private final UUID uuid;
        private int zzaac;
        public final boolean zzags;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.mimeType.equals(zzaVar.mimeType) && zzqe.zza(this.uuid, zzaVar.uuid) && Arrays.equals(this.data, zzaVar.data);
        }

        public final int hashCode() {
            if (this.zzaac == 0) {
                this.zzaac = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzaac;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzags ? (byte) 1 : (byte) 0);
        }

        public zza(UUID uuid, String str, byte[] bArr, boolean z) {
            zzpo.checkNotNull(uuid);
            this.uuid = uuid;
            zzpo.checkNotNull(str);
            this.mimeType = str;
            zzpo.checkNotNull(bArr);
            this.data = bArr;
            this.zzags = z;
        }

        public zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzags = parcel.readByte() != 0;
        }
    }

    public zzhp(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        if (zzfe.zzwm.equals(zzaVar3.uuid)) {
            return zzfe.zzwm.equals(zzaVar4.uuid) ? 0 : 1;
        }
        return zzaVar3.uuid.compareTo(zzaVar4.uuid);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzhp.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzagq, ((zzhp) obj).zzagq);
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = Arrays.hashCode(this.zzagq);
        }
        return this.zzaac;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzagq, 0);
    }

    public final zza zzu(int i) {
        return this.zzagq[i];
    }

    public zzhp(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    private zzhp(boolean z, zza... zzaVarArr) {
        zzaVarArr = z ? (zza[]) zzaVarArr.clone() : zzaVarArr;
        Arrays.sort(zzaVarArr, this);
        for (int i = 1; i < zzaVarArr.length; i++) {
            if (zzaVarArr[i - 1].uuid.equals(zzaVarArr[i].uuid)) {
                String valueOf = String.valueOf(zzaVarArr[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzagq = zzaVarArr;
        this.zzagr = zzaVarArr.length;
    }

    public zzhp(Parcel parcel) {
        this.zzagq = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzagr = this.zzagq.length;
    }
}
