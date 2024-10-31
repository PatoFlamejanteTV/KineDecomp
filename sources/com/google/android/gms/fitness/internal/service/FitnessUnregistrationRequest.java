package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class FitnessUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessUnregistrationRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1240a;
    private final DataSource b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FitnessUnregistrationRequest(int i, DataSource dataSource) {
        this.f1240a = i;
        this.b = dataSource;
    }

    public DataSource a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1240a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
