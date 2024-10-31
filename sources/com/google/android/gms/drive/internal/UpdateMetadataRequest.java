package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class UpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new zzbz();

    /* renamed from: a, reason: collision with root package name */
    final int f1127a;
    final DriveId b;
    final MetadataBundle c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.f1127a = i;
        this.b = driveId;
        this.c = metadataBundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbz.a(this, parcel, i);
    }
}
