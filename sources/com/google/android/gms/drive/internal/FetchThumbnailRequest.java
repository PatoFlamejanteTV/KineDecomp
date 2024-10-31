package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class FetchThumbnailRequest implements SafeParcelable {
    public static final Parcelable.Creator<FetchThumbnailRequest> CREATOR = new zzaf();

    /* renamed from: a, reason: collision with root package name */
    final int f1090a;
    final DriveId b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FetchThumbnailRequest(int i, DriveId driveId) {
        this.f1090a = i;
        this.b = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaf.a(this, parcel, i);
    }
}
