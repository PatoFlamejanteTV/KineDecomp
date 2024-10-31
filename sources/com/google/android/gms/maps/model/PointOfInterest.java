package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f1986a;
    public final String b;
    public final String c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.d = i;
        this.f1986a = latLng;
        this.b = str;
        this.c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
