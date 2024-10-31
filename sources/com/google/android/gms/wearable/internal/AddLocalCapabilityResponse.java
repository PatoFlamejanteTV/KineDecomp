package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AddLocalCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<AddLocalCapabilityResponse> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public final int f2331a;
    public final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddLocalCapabilityResponse(int i, int i2) {
        this.f2331a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
