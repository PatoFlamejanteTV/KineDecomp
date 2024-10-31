package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class FrameMetadataParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2275a;
    public int b;
    public int c;
    public int d;
    public long e;
    public int f;

    public FrameMetadataParcel() {
        this.f2275a = 1;
    }

    public FrameMetadataParcel(int i, int i2, int i3, int i4, long j, int i5) {
        this.f2275a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = j;
        this.f = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.a(this, parcel, i);
    }
}
