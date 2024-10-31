package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1871a;
    final DataHolder b;
    private final Status c;
    private final PlacePhotoMetadataBuffer d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlacePhotoMetadataResult(int i, Status status, DataHolder dataHolder) {
        this.f1871a = i;
        this.c = status;
        this.b = dataHolder;
        if (dataHolder == null) {
            this.d = null;
        } else {
            this.d = new PlacePhotoMetadataBuffer(this.b);
        }
    }

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this(0, status, dataHolder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
