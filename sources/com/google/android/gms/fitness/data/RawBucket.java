package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class RawBucket implements SafeParcelable {
    public static final Parcelable.Creator<RawBucket> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final int f1227a;
    public final long b;
    public final long c;
    public final Session d;
    public final int e;
    public final List<RawDataSet> f;
    public final int g;
    public final boolean h;

    public RawBucket(int i, long j, long j2, Session session, int i2, List<RawDataSet> list, int i3, boolean z) {
        this.f1227a = i;
        this.b = j;
        this.c = j2;
        this.d = session;
        this.e = i2;
        this.f = list;
        this.g = i3;
        this.h = z;
    }

    public RawBucket(Bucket bucket, List<DataSource> list, List<DataType> list2) {
        this.f1227a = 2;
        this.b = bucket.a(TimeUnit.MILLISECONDS);
        this.c = bucket.b(TimeUnit.MILLISECONDS);
        this.d = bucket.a();
        this.e = bucket.b();
        this.g = bucket.d();
        this.h = bucket.e();
        List<DataSet> c = bucket.c();
        this.f = new ArrayList(c.size());
        Iterator<DataSet> it = c.iterator();
        while (it.hasNext()) {
            this.f.add(new RawDataSet(it.next(), list, list2));
        }
    }

    private boolean a(RawBucket rawBucket) {
        return this.b == rawBucket.b && this.c == rawBucket.c && this.e == rawBucket.e && zzw.a(this.f, rawBucket.f) && this.g == rawBucket.g && this.h == rawBucket.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawBucket) && a((RawBucket) obj));
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.g));
    }

    public String toString() {
        return zzw.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("activity", Integer.valueOf(this.e)).a("dataSets", this.f).a("bucketType", Integer.valueOf(this.g)).a("serverHasMoreData", Boolean.valueOf(this.h)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
