package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnFetchThumbnailResponse> CREATOR = new zzbc();

    /* renamed from: a, reason: collision with root package name */
    final int f1106a;
    final ParcelFileDescriptor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnFetchThumbnailResponse(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f1106a = i;
        this.b = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbc.a(this, parcel, i | 1);
    }
}
