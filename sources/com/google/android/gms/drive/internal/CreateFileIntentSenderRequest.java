package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final int f1084a;
    final MetadataBundle b;
    final int c;
    final String d;
    final DriveId e;
    final Integer f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateFileIntentSenderRequest(int i, MetadataBundle metadataBundle, int i2, String str, DriveId driveId, Integer num) {
        this.f1084a = i;
        this.b = metadataBundle;
        this.c = i2;
        this.d = str;
        this.e = driveId;
        this.f = num;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
