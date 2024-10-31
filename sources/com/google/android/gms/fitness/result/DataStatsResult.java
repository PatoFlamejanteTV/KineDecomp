package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class DataStatsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataStatsResult> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f1287a;
    private final Status b;
    private final List<DataSourceStatsResult> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataStatsResult(int i, Status status, List<DataSourceStatsResult> list) {
        this.f1287a = i;
        this.b = status;
        this.c = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1287a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DataSourceStatsResult> b() {
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
        zzf.a(this, parcel, i);
    }
}
