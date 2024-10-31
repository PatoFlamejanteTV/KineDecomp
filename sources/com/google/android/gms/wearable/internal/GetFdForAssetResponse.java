package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetFdForAssetResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzas();

    /* renamed from: a, reason: collision with root package name */
    public final int f2354a;
    public final int b;
    public final ParcelFileDescriptor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetFdForAssetResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2354a = i;
        this.b = i2;
        this.c = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzas.a(this, parcel, i | 1);
    }
}
