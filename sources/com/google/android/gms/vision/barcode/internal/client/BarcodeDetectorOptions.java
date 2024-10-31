package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class BarcodeDetectorOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2269a;
    public int b;

    public BarcodeDetectorOptions() {
        this.f2269a = 1;
    }

    public BarcodeDetectorOptions(int i, int i2) {
        this.f2269a = i;
        this.b = i2;
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
