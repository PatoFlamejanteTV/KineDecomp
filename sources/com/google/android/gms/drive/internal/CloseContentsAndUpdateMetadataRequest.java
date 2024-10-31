package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1080a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    final boolean e;
    final String f;
    final int g;
    final int h;
    final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2, int i3, boolean z2) {
        this.f1080a = i;
        this.b = driveId;
        this.c = metadataBundle;
        this.d = contents;
        this.e = z;
        this.f = str;
        this.g = i2;
        this.h = i3;
        this.i = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
