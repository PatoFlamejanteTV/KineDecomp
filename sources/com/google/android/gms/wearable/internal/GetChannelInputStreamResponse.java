package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetChannelInputStreamResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetChannelInputStreamResponse> CREATOR = new zzaj();

    /* renamed from: a, reason: collision with root package name */
    public final int f2345a;
    public final int b;
    public final ParcelFileDescriptor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetChannelInputStreamResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2345a = i;
        this.b = i2;
        this.c = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaj.a(this, parcel, i);
    }
}
