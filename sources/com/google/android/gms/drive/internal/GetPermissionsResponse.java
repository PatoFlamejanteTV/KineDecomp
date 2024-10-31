package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

/* loaded from: classes2.dex */
public class GetPermissionsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new zzal();

    /* renamed from: a, reason: collision with root package name */
    final int f1096a;
    final List<Permission> b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetPermissionsResponse(int i, List<Permission> list, int i2) {
        this.f1096a = i;
        this.b = list;
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzal.a(this, parcel, i);
    }
}
