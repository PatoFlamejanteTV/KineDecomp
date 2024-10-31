package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CreateFolderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    final int f1086a;
    final DriveId b;
    final MetadataBundle c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.f1086a = i;
        this.b = (DriveId) com.google.android.gms.common.internal.zzx.a(driveId);
        this.c = (MetadataBundle) com.google.android.gms.common.internal.zzx.a(metadataBundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
