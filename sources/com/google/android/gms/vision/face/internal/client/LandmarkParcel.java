package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LandmarkParcel implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final int f2273a;
    public final float b;
    public final float c;
    public final int d;

    public LandmarkParcel(int i, float f, float f2, int i2) {
        this.f2273a = i;
        this.b = f;
        this.c = f2;
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
