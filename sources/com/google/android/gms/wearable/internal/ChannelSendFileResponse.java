package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ChannelSendFileResponse implements SafeParcelable {
    public static final Parcelable.Creator<ChannelSendFileResponse> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    public final int f2338a;
    public final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelSendFileResponse(int i, int i2) {
        this.f2338a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzs.a(this, parcel, i);
    }
}
