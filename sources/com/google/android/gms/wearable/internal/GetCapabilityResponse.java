package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new zzai();

    /* renamed from: a, reason: collision with root package name */
    public final int f2344a;
    public final int b;
    public final CapabilityInfoParcelable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetCapabilityResponse(int i, int i2, CapabilityInfoParcelable capabilityInfoParcelable) {
        this.f2344a = i;
        this.b = i2;
        this.c = capabilityInfoParcelable;
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
