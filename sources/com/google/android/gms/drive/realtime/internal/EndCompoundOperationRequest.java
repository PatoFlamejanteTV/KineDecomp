package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class EndCompoundOperationRequest implements SafeParcelable {
    public static final Parcelable.Creator<EndCompoundOperationRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1172a;

    public EndCompoundOperationRequest() {
        this(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndCompoundOperationRequest(int i) {
        this.f1172a = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
