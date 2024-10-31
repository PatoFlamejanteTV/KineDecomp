package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class CloseChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator<CloseChannelResponse> CREATOR = new zzv();

    /* renamed from: a, reason: collision with root package name */
    public final int f2339a;
    public final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CloseChannelResponse(int i, int i2) {
        this.f2339a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.a(this, parcel, i);
    }
}
