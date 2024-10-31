package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CreateFileRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    final int f1085a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    final Integer e;
    final boolean f;
    final String g;
    final int h;
    final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3) {
        if (contents != null && i3 != 0) {
            com.google.android.gms.common.internal.zzx.b(contents.a() == i3, "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.f1085a = i;
        this.b = (DriveId) com.google.android.gms.common.internal.zzx.a(driveId);
        this.c = (MetadataBundle) com.google.android.gms.common.internal.zzx.a(metadataBundle);
        this.d = contents;
        this.e = num;
        this.g = str;
        this.h = i2;
        this.f = z;
        this.i = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
