package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* loaded from: classes2.dex */
public class SetResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetResourceParentsRequest> CREATOR = new zzbs();

    /* renamed from: a, reason: collision with root package name */
    final int f1121a;
    final DriveId b;
    final List<DriveId> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetResourceParentsRequest(int i, DriveId driveId, List<DriveId> list) {
        this.f1121a = i;
        this.b = driveId;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbs.a(this, parcel, i);
    }
}
