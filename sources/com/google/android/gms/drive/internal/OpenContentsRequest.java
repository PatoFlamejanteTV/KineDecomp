package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class OpenContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new zzbk();

    /* renamed from: a, reason: collision with root package name */
    final int f1114a;
    final DriveId b;
    final int c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenContentsRequest(int i, DriveId driveId, int i2, int i3) {
        this.f1114a = i;
        this.b = driveId;
        this.c = i2;
        this.d = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbk.a(this, parcel, i);
    }
}
