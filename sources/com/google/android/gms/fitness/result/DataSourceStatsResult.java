package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class DataSourceStatsResult implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceStatsResult> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f1285a;
    public final DataSource b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSourceStatsResult(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.f1285a = i;
        this.b = dataSource;
        this.c = j;
        this.d = z;
        this.e = j2;
        this.f = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
