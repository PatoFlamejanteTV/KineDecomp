package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class CreateContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f1083a;
    final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateContentsRequest(int i, int i2) {
        this.f1083a = i;
        com.google.android.gms.common.internal.zzx.b(i2 == 536870912 || i2 == 805306368, "Cannot create a new read-only contents!");
        this.b = i2;
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
