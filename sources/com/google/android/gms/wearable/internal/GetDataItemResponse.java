package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetDataItemResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetDataItemResponse> CREATOR = new zzar();

    /* renamed from: a, reason: collision with root package name */
    public final int f2353a;
    public final int b;
    public final DataItemParcelable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetDataItemResponse(int i, int i2, DataItemParcelable dataItemParcelable) {
        this.f2353a = i;
        this.b = i2;
        this.c = dataItemParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzar.a(this, parcel, i);
    }
}
