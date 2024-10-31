package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
public class CloseContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f1081a;
    final Contents b;
    final Boolean c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CloseContentsRequest(int i, Contents contents, Boolean bool, int i2) {
        this.f1081a = i;
        this.b = contents;
        this.c = bool;
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
