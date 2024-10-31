package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class DriveFileRange implements SafeParcelable {
    public static final Parcelable.Creator<DriveFileRange> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f1054a;
    final long b;
    final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriveFileRange(int i, long j, long j2) {
        this.f1054a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
