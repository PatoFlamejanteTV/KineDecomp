package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f2272a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public FaceSettingsParcel() {
        this.f2272a = 1;
    }

    public FaceSettingsParcel(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f2272a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
        this.f = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
