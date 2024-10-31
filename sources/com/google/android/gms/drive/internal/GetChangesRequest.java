package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class GetChangesRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzah();

    /* renamed from: a, reason: collision with root package name */
    final int f1092a;
    final ChangeSequenceNumber b;
    final int c;
    final List<DriveSpace> d;
    final boolean e;
    private final Set<DriveSpace> f;

    private GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, Set<DriveSpace> set, boolean z) {
        this.f1092a = i;
        this.b = changeSequenceNumber;
        this.c = i2;
        this.d = list;
        this.f = set;
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, boolean z) {
        this(i, changeSequenceNumber, i2, list, list == null ? null : new HashSet(list), z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzah.a(this, parcel, i);
    }
}
