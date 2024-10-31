package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class OpenChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator<OpenChannelResponse> CREATOR = new zzbd();

    /* renamed from: a, reason: collision with root package name */
    public final int f2358a;
    public final int b;
    public final ChannelImpl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenChannelResponse(int i, int i2, ChannelImpl channelImpl) {
        this.f2358a = i;
        this.b = i2;
        this.c = channelImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbd.a(this, parcel, i);
    }
}
