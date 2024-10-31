package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzai();

    /* renamed from: a, reason: collision with root package name */
    final int f1093a;
    final String b;
    final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetDriveIdFromUniqueIdentifierRequest(int i, String str, boolean z) {
        this.f1093a = i;
        this.b = str;
        this.c = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzai.a(this, parcel, i);
    }
}
