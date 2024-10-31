package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class DataPoint implements SafeParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    private final int f1219a;
    private final DataSource b;
    private long c;
    private long d;
    private final Value[] e;
    private DataSource f;
    private long g;
    private long h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.f1219a = i;
        this.b = dataSource;
        this.f = dataSource2;
        this.c = j;
        this.d = j2;
        this.e = valueArr;
        this.g = j3;
        this.h = j4;
    }

    public DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(4, dataSource, a(Long.valueOf(rawDataPoint.b), 0L), a(Long.valueOf(rawDataPoint.c), 0L), rawDataPoint.d, dataSource2, a(Long.valueOf(rawDataPoint.g), 0L), a(Long.valueOf(rawDataPoint.h), 0L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(a(list, rawDataPoint.e), a(list, rawDataPoint.f), rawDataPoint);
    }

    private static long a(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource a(List<DataSource> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    private boolean a(DataPoint dataPoint) {
        return zzw.a(this.b, dataPoint.b) && this.c == dataPoint.c && this.d == dataPoint.d && Arrays.equals(this.e, dataPoint.e) && zzw.a(this.f, dataPoint.f);
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.NANOSECONDS);
    }

    public Value[] a() {
        return this.e;
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.NANOSECONDS);
    }

    public DataSource b() {
        return this.b;
    }

    public DataSource c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataPoint) && a((DataPoint) obj));
    }

    public int f() {
        return this.f1219a;
    }

    public long g() {
        return this.c;
    }

    public long h() {
        return this.d;
    }

    public int hashCode() {
        return zzw.a(this.b, Long.valueOf(this.c), Long.valueOf(this.d));
    }

    public String toString() {
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.e);
        objArr[1] = Long.valueOf(this.d);
        objArr[2] = Long.valueOf(this.c);
        objArr[3] = Long.valueOf(this.g);
        objArr[4] = Long.valueOf(this.h);
        objArr[5] = this.b.g();
        objArr[6] = this.f != null ? this.f.g() : "N/A";
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
