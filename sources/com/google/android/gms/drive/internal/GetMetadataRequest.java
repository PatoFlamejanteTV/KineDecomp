package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class GetMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new zzaj();

    /* renamed from: a, reason: collision with root package name */
    final int f1094a;
    final DriveId b;
    final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetMetadataRequest(int i, DriveId driveId, boolean z) {
        this.f1094a = i;
        this.b = driveId;
        this.c = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaj.a(this, parcel, i);
    }
}
