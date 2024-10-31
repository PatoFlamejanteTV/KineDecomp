package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnSyncMoreResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new zzbj();

    /* renamed from: a, reason: collision with root package name */
    final int f1113a;
    final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnSyncMoreResponse(int i, boolean z) {
        this.f1113a = i;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbj.a(this, parcel, i);
    }
}
