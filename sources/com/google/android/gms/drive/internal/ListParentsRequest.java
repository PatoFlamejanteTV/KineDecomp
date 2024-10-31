package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class ListParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListParentsRequest> CREATOR = new zzaq();

    /* renamed from: a, reason: collision with root package name */
    final int f1097a;
    final DriveId b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListParentsRequest(int i, DriveId driveId) {
        this.f1097a = i;
        this.b = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaq.a(this, parcel, i);
    }
}
