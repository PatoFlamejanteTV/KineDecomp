package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final int f563a;
    public final boolean b;
    public final int c;
    public final boolean d;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.f563a = i;
        this.b = z;
        this.c = i2;
        this.d = z2;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(1, nativeAdOptions.a(), nativeAdOptions.b(), nativeAdOptions.c());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
