package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzki implements Parcelable {
    public static final Parcelable.Creator<zzki> CREATOR = new C0907fl();
    private final zza[] zzavr;

    /* loaded from: classes2.dex */
    public interface zza extends Parcelable {
    }

    public zzki(List<? extends zza> list) {
        this.zzavr = new zza[list.size()];
        list.toArray(this.zzavr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzki.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzavr, ((zzki) obj).zzavr);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzavr);
    }

    public final int length() {
        return this.zzavr.length;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzavr.length);
        for (zza zzaVar : this.zzavr) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }

    public final zza zzao(int i) {
        return this.zzavr[i];
    }

    public zzki(Parcel parcel) {
        this.zzavr = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaVarArr = this.zzavr;
            if (i >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i++;
        }
    }
}
