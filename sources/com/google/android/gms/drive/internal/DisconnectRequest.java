package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class DisconnectRequest implements SafeParcelable {
    public static final Parcelable.Creator<DisconnectRequest> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    final int f1088a;

    public DisconnectRequest() {
        this(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisconnectRequest(int i) {
        this.f1088a = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.a(this, parcel, i);
    }
}
