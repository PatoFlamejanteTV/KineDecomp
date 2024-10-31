package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class FitnessDataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessDataSourcesRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1239a;
    private final List<DataType> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FitnessDataSourcesRequest(int i, List<DataType> list) {
        this.f1239a = i;
        this.b = list;
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1239a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return zzw.a(this).a("dataTypes", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
