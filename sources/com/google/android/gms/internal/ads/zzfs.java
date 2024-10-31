package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzfs implements Parcelable {
    public static final Parcelable.Creator<zzfs> CREATOR = new Zj();
    public final int height;
    public final int width;
    public final String zzaaa;
    private final int zzaab;
    private int zzaac;
    public final String zzze;
    public final int zzzf;
    public final String zzzg;
    private final zzki zzzh;
    public final String zzzi;
    public final String zzzj;
    public final int zzzk;
    public final List<byte[]> zzzl;
    public final zzhp zzzm;
    public final float zzzn;
    public final int zzzo;
    public final float zzzp;
    private final int zzzq;
    private final byte[] zzzr;
    private final zzqi zzzs;
    public final int zzzt;
    public final int zzzu;
    public final int zzzv;
    private final int zzzw;
    private final int zzzx;
    public final long zzzy;
    public final int zzzz;

    private zzfs(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f2, int i5, float f3, byte[] bArr, int i6, zzqi zzqiVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzhp zzhpVar, zzki zzkiVar) {
        this.zzze = str;
        this.zzzi = str2;
        this.zzzj = str3;
        this.zzzg = str4;
        this.zzzf = i;
        this.zzzk = i2;
        this.width = i3;
        this.height = i4;
        this.zzzn = f2;
        this.zzzo = i5;
        this.zzzp = f3;
        this.zzzr = bArr;
        this.zzzq = i6;
        this.zzzs = zzqiVar;
        this.zzzt = i7;
        this.zzzu = i8;
        this.zzzv = i9;
        this.zzzw = i10;
        this.zzzx = i11;
        this.zzzz = i12;
        this.zzaaa = str5;
        this.zzaab = i13;
        this.zzzy = j;
        this.zzzl = list == null ? Collections.emptyList() : list;
        this.zzzm = zzhpVar;
        this.zzzh = zzkiVar;
    }

    public static zzfs zza(String str, String str2, String str3, String str4, int i, int i2, int i3, float f2, List<byte[]> list, int i4) {
        return new zzfs(str, str2, str3, str4, i, -1, i2, i3, f2, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Long.MAX_VALUE, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfs.class == obj.getClass()) {
            zzfs zzfsVar = (zzfs) obj;
            if (this.zzzf == zzfsVar.zzzf && this.zzzk == zzfsVar.zzzk && this.width == zzfsVar.width && this.height == zzfsVar.height && this.zzzn == zzfsVar.zzzn && this.zzzo == zzfsVar.zzzo && this.zzzp == zzfsVar.zzzp && this.zzzq == zzfsVar.zzzq && this.zzzt == zzfsVar.zzzt && this.zzzu == zzfsVar.zzzu && this.zzzv == zzfsVar.zzzv && this.zzzw == zzfsVar.zzzw && this.zzzx == zzfsVar.zzzx && this.zzzy == zzfsVar.zzzy && this.zzzz == zzfsVar.zzzz && zzqe.zza(this.zzze, zzfsVar.zzze) && zzqe.zza(this.zzaaa, zzfsVar.zzaaa) && this.zzaab == zzfsVar.zzaab && zzqe.zza(this.zzzi, zzfsVar.zzzi) && zzqe.zza(this.zzzj, zzfsVar.zzzj) && zzqe.zza(this.zzzg, zzfsVar.zzzg) && zzqe.zza(this.zzzm, zzfsVar.zzzm) && zzqe.zza(this.zzzh, zzfsVar.zzzh) && zzqe.zza(this.zzzs, zzfsVar.zzzs) && Arrays.equals(this.zzzr, zzfsVar.zzzr) && this.zzzl.size() == zzfsVar.zzzl.size()) {
                for (int i = 0; i < this.zzzl.size(); i++) {
                    if (!Arrays.equals(this.zzzl.get(i), zzfsVar.zzzl.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            String str = this.zzze;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzzi;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzzj;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzzg;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzzf) * 31) + this.width) * 31) + this.height) * 31) + this.zzzt) * 31) + this.zzzu) * 31;
            String str5 = this.zzaaa;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzaab) * 31;
            zzhp zzhpVar = this.zzzm;
            int hashCode6 = (hashCode5 + (zzhpVar == null ? 0 : zzhpVar.hashCode())) * 31;
            zzki zzkiVar = this.zzzh;
            this.zzaac = hashCode6 + (zzkiVar != null ? zzkiVar.hashCode() : 0);
        }
        return this.zzaac;
    }

    public final String toString() {
        String str = this.zzze;
        String str2 = this.zzzi;
        String str3 = this.zzzj;
        int i = this.zzzf;
        String str4 = this.zzaaa;
        int i2 = this.width;
        int i3 = this.height;
        float f2 = this.zzzn;
        int i4 = this.zzzt;
        int i5 = this.zzzu;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f2);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzze);
        parcel.writeString(this.zzzi);
        parcel.writeString(this.zzzj);
        parcel.writeString(this.zzzg);
        parcel.writeInt(this.zzzf);
        parcel.writeInt(this.zzzk);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzzn);
        parcel.writeInt(this.zzzo);
        parcel.writeFloat(this.zzzp);
        parcel.writeInt(this.zzzr != null ? 1 : 0);
        byte[] bArr = this.zzzr;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzzq);
        parcel.writeParcelable(this.zzzs, i);
        parcel.writeInt(this.zzzt);
        parcel.writeInt(this.zzzu);
        parcel.writeInt(this.zzzv);
        parcel.writeInt(this.zzzw);
        parcel.writeInt(this.zzzx);
        parcel.writeInt(this.zzzz);
        parcel.writeString(this.zzaaa);
        parcel.writeInt(this.zzaab);
        parcel.writeLong(this.zzzy);
        int size = this.zzzl.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzzl.get(i2));
        }
        parcel.writeParcelable(this.zzzm, 0);
        parcel.writeParcelable(this.zzzh, 0);
    }

    public final int zzce() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzcf() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzzj);
        String str = this.zzaaa;
        if (str != null) {
            mediaFormat.setString(com.umeng.commonsdk.proguard.e.M, str);
        }
        zza(mediaFormat, "max-input-size", this.zzzk);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f2 = this.zzzn;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        zza(mediaFormat, "rotation-degrees", this.zzzo);
        zza(mediaFormat, "channel-count", this.zzzt);
        zza(mediaFormat, "sample-rate", this.zzzu);
        zza(mediaFormat, "encoder-delay", this.zzzw);
        zza(mediaFormat, "encoder-padding", this.zzzx);
        for (int i = 0; i < this.zzzl.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzzl.get(i)));
        }
        zzqi zzqiVar = this.zzzs;
        if (zzqiVar != null) {
            zza(mediaFormat, "color-transfer", zzqiVar.zzakd);
            zza(mediaFormat, "color-standard", zzqiVar.zzakc);
            zza(mediaFormat, "color-range", zzqiVar.zzake);
            byte[] bArr = zzqiVar.zzbii;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzfs zzj(int i) {
        return new zzfs(this.zzze, this.zzzi, this.zzzj, this.zzzg, this.zzzf, i, this.width, this.height, this.zzzn, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, this.zzzw, this.zzzx, this.zzzz, this.zzaaa, this.zzaab, this.zzzy, this.zzzl, this.zzzm, this.zzzh);
    }

    public static zzfs zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f2, List<byte[]> list, int i5, float f3, byte[] bArr, int i6, zzqi zzqiVar, zzhp zzhpVar) {
        return new zzfs(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f3, bArr, i6, zzqiVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzhpVar, null);
    }

    public final zzfs zzj(long j) {
        return new zzfs(this.zzze, this.zzzi, this.zzzj, this.zzzg, this.zzzf, this.zzzk, this.width, this.height, this.zzzn, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, this.zzzw, this.zzzx, this.zzzz, this.zzaaa, this.zzaab, j, this.zzzl, this.zzzm, this.zzzh);
    }

    public static zzfs zza(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new zzfs(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzfs zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzhp zzhpVar, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzhpVar, 0, str4);
    }

    public static zzfs zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzhp zzhpVar, int i6, String str4) {
        return new zzfs(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzhpVar, null);
    }

    public static zzfs zza(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new zzfs(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Long.MAX_VALUE, null, null, null);
    }

    public static zzfs zza(String str, String str2, String str3, int i, int i2, String str4, zzhp zzhpVar) {
        return zza(str, str2, (String) null, -1, i2, str4, -1, zzhpVar, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    public static zzfs zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzhp zzhpVar, long j, List<byte[]> list) {
        return new zzfs(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzhpVar, null);
    }

    public static zzfs zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzhp zzhpVar) {
        return new zzfs(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzhpVar, null);
    }

    public static zzfs zza(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new zzfs(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzfs zza(String str, String str2, long j) {
        return new zzfs(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzfs zza(String str, String str2, String str3, int i, zzhp zzhpVar) {
        return new zzfs(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, zzhpVar, null);
    }

    public final zzfs zza(zzfs zzfsVar) {
        if (this == zzfsVar) {
            return this;
        }
        String str = zzfsVar.zzze;
        String str2 = this.zzzg;
        if (str2 == null) {
            str2 = zzfsVar.zzzg;
        }
        String str3 = str2;
        int i = this.zzzf;
        if (i == -1) {
            i = zzfsVar.zzzf;
        }
        int i2 = i;
        float f2 = this.zzzn;
        if (f2 == -1.0f) {
            f2 = zzfsVar.zzzn;
        }
        float f3 = f2;
        int i3 = this.zzzz | zzfsVar.zzzz;
        String str4 = this.zzaaa;
        if (str4 == null) {
            str4 = zzfsVar.zzaaa;
        }
        String str5 = str4;
        zzhp zzhpVar = zzfsVar.zzzm;
        if (zzhpVar == null) {
            zzhpVar = this.zzzm;
        }
        return new zzfs(str, this.zzzi, this.zzzj, str3, i2, this.zzzk, this.width, this.height, f3, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, this.zzzw, this.zzzx, i3, str5, this.zzaab, this.zzzy, this.zzzl, zzhpVar, this.zzzh);
    }

    public final zzfs zza(int i, int i2) {
        return new zzfs(this.zzze, this.zzzi, this.zzzj, this.zzzg, this.zzzf, this.zzzk, this.width, this.height, this.zzzn, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, i, i2, this.zzzz, this.zzaaa, this.zzaab, this.zzzy, this.zzzl, this.zzzm, this.zzzh);
    }

    public final zzfs zza(zzhp zzhpVar) {
        return new zzfs(this.zzze, this.zzzi, this.zzzj, this.zzzg, this.zzzf, this.zzzk, this.width, this.height, this.zzzn, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, this.zzzw, this.zzzx, this.zzzz, this.zzaaa, this.zzaab, this.zzzy, this.zzzl, zzhpVar, this.zzzh);
    }

    public final zzfs zza(zzki zzkiVar) {
        return new zzfs(this.zzze, this.zzzi, this.zzzj, this.zzzg, this.zzzf, this.zzzk, this.width, this.height, this.zzzn, this.zzzo, this.zzzp, this.zzzr, this.zzzq, this.zzzs, this.zzzt, this.zzzu, this.zzzv, this.zzzw, this.zzzx, this.zzzz, this.zzaaa, this.zzaab, this.zzzy, this.zzzl, this.zzzm, zzkiVar);
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public zzfs(Parcel parcel) {
        this.zzze = parcel.readString();
        this.zzzi = parcel.readString();
        this.zzzj = parcel.readString();
        this.zzzg = parcel.readString();
        this.zzzf = parcel.readInt();
        this.zzzk = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzzn = parcel.readFloat();
        this.zzzo = parcel.readInt();
        this.zzzp = parcel.readFloat();
        this.zzzr = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzzq = parcel.readInt();
        this.zzzs = (zzqi) parcel.readParcelable(zzqi.class.getClassLoader());
        this.zzzt = parcel.readInt();
        this.zzzu = parcel.readInt();
        this.zzzv = parcel.readInt();
        this.zzzw = parcel.readInt();
        this.zzzx = parcel.readInt();
        this.zzzz = parcel.readInt();
        this.zzaaa = parcel.readString();
        this.zzaab = parcel.readInt();
        this.zzzy = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzzl = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzzl.add(parcel.createByteArray());
        }
        this.zzzm = (zzhp) parcel.readParcelable(zzhp.class.getClassLoader());
        this.zzzh = (zzki) parcel.readParcelable(zzki.class.getClassLoader());
    }
}
