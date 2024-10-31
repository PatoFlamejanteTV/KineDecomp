package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new zzah();

    /* renamed from: a, reason: collision with root package name */
    public final int f2343a;
    public final int b;
    final List<CapabilityInfoParcelable> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetAllCapabilitiesResponse(int i, int i2, List<CapabilityInfoParcelable> list) {
        this.f2343a = i;
        this.b = i2;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzah.a(this, parcel, i);
    }
}
