package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzbk implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new C1333u();
    private String value;
    private String zzno;
    private String zzyj;

    @Deprecated
    public zzbk() {
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.zzno;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzno);
        parcel.writeString(this.zzyj);
        parcel.writeString(this.value);
    }

    @Deprecated
    public zzbk(Parcel parcel) {
        this.zzno = parcel.readString();
        this.zzyj = parcel.readString();
        this.value = parcel.readString();
    }
}
