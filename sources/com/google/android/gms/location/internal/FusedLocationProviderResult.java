package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class FusedLocationProviderResult implements Result, SafeParcelable {
    private final int b;
    private final Status c;

    /* renamed from: a, reason: collision with root package name */
    public static final FusedLocationProviderResult f1852a = new FusedLocationProviderResult(Status.f979a);
    public static final Parcelable.Creator<FusedLocationProviderResult> CREATOR = new zze();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FusedLocationProviderResult(int i, Status status) {
        this.b = i;
        this.c = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    public int a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
