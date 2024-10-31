package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzav();

    /* renamed from: a, reason: collision with root package name */
    final int f1099a;
    final DataHolder b;
    final List<DriveId> c;
    final ChangeSequenceNumber d;
    final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnChangesResponse(int i, DataHolder dataHolder, List<DriveId> list, ChangeSequenceNumber changeSequenceNumber, boolean z) {
        this.f1099a = i;
        this.b = dataHolder;
        this.c = list;
        this.d = changeSequenceNumber;
        this.e = z;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void a(Parcel parcel, int i) {
        zzav.a(this, parcel, i | 1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
