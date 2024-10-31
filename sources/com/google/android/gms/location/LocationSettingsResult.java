package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    private final int f1849a;
    private final Status b;
    private final LocationSettingsStates c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.f1849a = i;
        this.b = status;
        this.c = locationSettingsStates;
    }

    public int a() {
        return this.f1849a;
    }

    public LocationSettingsStates b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
