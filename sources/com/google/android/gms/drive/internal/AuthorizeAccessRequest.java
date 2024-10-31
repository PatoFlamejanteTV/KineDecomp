package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f1076a;
    final long b;
    final DriveId c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthorizeAccessRequest(int i, long j, DriveId driveId) {
        this.f1076a = i;
        this.b = j;
        this.c = driveId;
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
