package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ChannelReceiveFileResponse implements SafeParcelable {
    public static final Parcelable.Creator<ChannelReceiveFileResponse> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    public final int f2337a;
    public final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelReceiveFileResponse(int i, int i2) {
        this.f2337a = i;
        this.b = i2;
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
