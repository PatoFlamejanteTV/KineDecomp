package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class DataSourceQueryParams implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceQueryParams> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f1248a;
    public final DataSource b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSourceQueryParams(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.f1248a = i;
        this.b = dataSource;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i2;
        this.g = i3;
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
