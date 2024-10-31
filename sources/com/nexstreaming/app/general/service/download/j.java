package com.nexstreaming.app.general.service.download;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: DownloadInfo.java */
/* loaded from: classes2.dex */
class j implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public k createFromParcel(Parcel parcel) {
        return new k(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public k[] newArray(int i) {
        return new k[i];
    }
}
