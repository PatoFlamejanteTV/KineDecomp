package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f1872a;
    final BitmapTeleporter b;
    private final Status c;
    private final Bitmap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapTeleporter) {
        this.f1872a = i;
        this.c = status;
        this.b = bitmapTeleporter;
        if (this.b != null) {
            this.d = bitmapTeleporter.a();
        } else {
            this.d = null;
        }
    }

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.f1872a = 0;
        this.c = status;
        this.b = bitmapTeleporter;
        if (this.b != null) {
            this.d = bitmapTeleporter.a();
        } else {
            this.d = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.c).a("bitmap", this.d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
