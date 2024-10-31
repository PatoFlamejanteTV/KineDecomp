package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* loaded from: classes2.dex */
public class ChangeResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ChangeResourceParentsRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    final int f1078a;
    final DriveId b;
    final List<DriveId> c;
    final List<DriveId> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangeResourceParentsRequest(int i, DriveId driveId, List<DriveId> list, List<DriveId> list2) {
        this.f1078a = i;
        this.b = driveId;
        this.c = list;
        this.d = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
