package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class ParentDriveIdSet implements SafeParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f1148a;
    final List<PartialDriveId> b;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentDriveIdSet(int i, List<PartialDriveId> list) {
        this.f1148a = i;
        this.b = list;
    }

    public Set<DriveId> a(long j) {
        HashSet hashSet = new HashSet();
        Iterator<PartialDriveId> it = this.b.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a(j));
        }
        return hashSet;
    }

    public void a(PartialDriveId partialDriveId) {
        this.b.add(partialDriveId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
