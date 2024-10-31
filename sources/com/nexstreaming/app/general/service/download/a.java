package com.nexstreaming.app.general.service.download;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: DownloadError.java */
/* loaded from: classes2.dex */
class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public b createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public b[] newArray(int i) {
        return new b[i];
    }
}
