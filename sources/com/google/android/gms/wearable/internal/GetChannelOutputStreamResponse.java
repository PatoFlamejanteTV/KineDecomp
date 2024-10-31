package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetChannelOutputStreamResponse> CREATOR = new zzak();

    /* renamed from: a, reason: collision with root package name */
    public final int f2346a;
    public final int b;
    public final ParcelFileDescriptor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetChannelOutputStreamResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2346a = i;
        this.b = i2;
        this.c = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzak.a(this, parcel, i);
    }
}
