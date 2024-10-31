package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Bucket implements SafeParcelable {
    public static final Parcelable.Creator<Bucket> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f1218a;
    private final long b;
    private final long c;
    private final Session d;
    private final int e;
    private final List<DataSet> f;
    private final int g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bucket(int i, long j, long j2, Session session, int i2, List<DataSet> list, int i3, boolean z) {
        this.h = false;
        this.f1218a = i;
        this.b = j;
        this.c = j2;
        this.d = session;
        this.e = i2;
        this.f = list;
        this.g = i3;
        this.h = z;
    }

    public Bucket(RawBucket rawBucket, List<DataSource> list) {
        this(2, rawBucket.b, rawBucket.c, rawBucket.d, rawBucket.e, a(rawBucket.f, list), rawBucket.g, rawBucket.h);
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    private static List<DataSet> a(Collection<RawDataSet> collection, List<DataSource> list) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<RawDataSet> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new DataSet(it.next(), list));
        }
        return arrayList;
    }

    private boolean b(Bucket bucket) {
        return this.b == bucket.b && this.c == bucket.c && this.e == bucket.e && zzw.a(this.f, bucket.f) && this.g == bucket.g && this.h == bucket.h;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.b, TimeUnit.MILLISECONDS);
    }

    public Session a() {
        return this.d;
    }

    public boolean a(Bucket bucket) {
        return this.b == bucket.b && this.c == bucket.c && this.e == bucket.e && this.g == bucket.g;
    }

    public int b() {
        return this.e;
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.MILLISECONDS);
    }

    public List<DataSet> c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (this.h) {
            return true;
        }
        Iterator<DataSet> it = this.f.iterator();
        while (it.hasNext()) {
            if (it.next().d()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && b((Bucket) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1218a;
    }

    public long g() {
        return this.b;
    }

    public long h() {
        return this.c;
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.e), Integer.valueOf(this.g));
    }

    public String toString() {
        return zzw.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("activity", Integer.valueOf(this.e)).a("dataSets", this.f).a("bucketType", a(this.g)).a("serverHasMoreData", Boolean.valueOf(this.h)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
