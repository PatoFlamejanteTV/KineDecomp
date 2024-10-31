package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DataSet implements SafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    private final int f1220a;
    private final DataSource b;
    private final DataType c;
    private final List<DataPoint> d;
    private final List<DataSource> e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSet(int i, DataSource dataSource, DataType dataType, List<RawDataPoint> list, List<DataSource> list2, boolean z) {
        this.f = false;
        this.f1220a = i;
        this.b = dataSource;
        this.c = dataSource.a();
        this.f = z;
        this.d = new ArrayList(list.size());
        this.e = i < 2 ? Collections.singletonList(dataSource) : list2;
        Iterator<RawDataPoint> it = list.iterator();
        while (it.hasNext()) {
            this.d.add(new DataPoint(this.e, it.next()));
        }
    }

    public DataSet(DataSource dataSource) {
        this.f = false;
        this.f1220a = 3;
        this.b = (DataSource) zzx.a(dataSource);
        this.c = dataSource.a();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.e.add(this.b);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list) {
        this.f = false;
        this.f1220a = 3;
        this.b = (DataSource) a(list, rawDataSet.b);
        this.c = this.b.a();
        this.e = list;
        this.f = rawDataSet.e;
        List<RawDataPoint> list2 = rawDataSet.d;
        this.d = new ArrayList(list2.size());
        Iterator<RawDataPoint> it = list2.iterator();
        while (it.hasNext()) {
            this.d.add(new DataPoint(this.e, it.next()));
        }
    }

    public static DataSet a(DataSource dataSource) {
        zzx.a(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private static <T> T a(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    private boolean a(DataSet dataSet) {
        return zzw.a(b(), dataSet.b()) && zzw.a(this.b, dataSet.b) && zzw.a(this.d, dataSet.d) && this.f == dataSet.f;
    }

    public DataSource a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RawDataPoint> a(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.d.size());
        Iterator<DataPoint> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataPoint(it.next(), list));
        }
        return arrayList;
    }

    public void a(DataPoint dataPoint) {
        this.d.add(dataPoint);
        DataSource c = dataPoint.c();
        if (c == null || this.e.contains(c)) {
            return;
        }
        this.e.add(c);
    }

    public void a(Iterable<DataPoint> iterable) {
        Iterator<DataPoint> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public DataType b() {
        return this.b.a();
    }

    public List<DataPoint> c() {
        return Collections.unmodifiableList(this.d);
    }

    public boolean d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1220a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && a((DataSet) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RawDataPoint> f() {
        return a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DataSource> g() {
        return this.e;
    }

    public int hashCode() {
        return zzw.a(this.b);
    }

    public String toString() {
        List<RawDataPoint> f = f();
        Object[] objArr = new Object[2];
        objArr[0] = this.b.g();
        Object obj = f;
        if (this.d.size() >= 10) {
            obj = String.format("%d data points, first 5: %s", Integer.valueOf(this.d.size()), f.subList(0, 5));
        }
        objArr[1] = obj;
        return String.format("DataSet{%s %s}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
