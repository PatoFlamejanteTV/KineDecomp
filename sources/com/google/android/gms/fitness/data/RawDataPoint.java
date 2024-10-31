package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class RawDataPoint implements SafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    final int f1228a;
    public final long b;
    public final long c;
    public final Value[] d;
    public final int e;
    public final int f;
    public final long g;
    public final long h;

    public RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.f1228a = i;
        this.b = j;
        this.c = j2;
        this.e = i2;
        this.f = i3;
        this.g = j3;
        this.h = j4;
        this.d = valueArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.f1228a = 4;
        this.b = dataPoint.a(TimeUnit.NANOSECONDS);
        this.c = dataPoint.b(TimeUnit.NANOSECONDS);
        this.d = dataPoint.a();
        this.e = zzs.a(dataPoint.b(), list);
        this.f = zzs.a(dataPoint.c(), list);
        this.g = dataPoint.d();
        this.h = dataPoint.e();
    }

    private boolean a(RawDataPoint rawDataPoint) {
        return this.b == rawDataPoint.b && this.c == rawDataPoint.c && Arrays.equals(this.d, rawDataPoint.d) && this.e == rawDataPoint.e && this.f == rawDataPoint.f && this.g == rawDataPoint.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && a((RawDataPoint) obj));
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.d), Long.valueOf(this.c), Long.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(this.f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
