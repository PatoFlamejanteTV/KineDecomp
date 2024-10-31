package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f1284a;
    private final List<DataSet> b;
    private final Status c;
    private final List<Bucket> d;
    private int e;
    private final List<DataSource> f;
    private final List<DataType> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.f1284a = i;
        this.c = status;
        this.e = i2;
        this.f = list3;
        this.g = list4;
        this.b = new ArrayList(list.size());
        Iterator<RawDataSet> it = list.iterator();
        while (it.hasNext()) {
            this.b.add(new DataSet(it.next(), list3));
        }
        this.d = new ArrayList(list2.size());
        Iterator<RawBucket> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.d.add(new Bucket(it2.next(), list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.f1284a = 5;
        this.b = list;
        this.c = status;
        this.d = list2;
        this.e = 1;
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static DataReadResult a(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = dataReadRequest.b().iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.a(it.next()));
        }
        Iterator<DataType> it2 = dataReadRequest.a().iterator();
        while (it2.hasNext()) {
            arrayList.add(DataSet.a(new DataSource.Builder().a(it2.next()).a(1).a("Default").a()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void a(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.a(bucket)) {
                Iterator<DataSet> it = bucket.c().iterator();
                while (it.hasNext()) {
                    a(it.next(), bucket2.c());
                }
                return;
            }
        }
        this.d.add(bucket);
    }

    private void a(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.a().equals(dataSet.a())) {
                dataSet2.a(dataSet.c());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean b(DataReadResult dataReadResult) {
        return this.c.equals(dataReadResult.c) && zzw.a(this.b, dataReadResult.b) && zzw.a(this.d, dataReadResult.d);
    }

    public List<DataSet> a() {
        return this.b;
    }

    public void a(DataReadResult dataReadResult) {
        Iterator<DataSet> it = dataReadResult.a().iterator();
        while (it.hasNext()) {
            a(it.next(), this.b);
        }
        Iterator<Bucket> it2 = dataReadResult.b().iterator();
        while (it2.hasNext()) {
            a(it2.next(), this.d);
        }
    }

    public List<Bucket> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1284a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RawBucket> e() {
        ArrayList arrayList = new ArrayList(this.d.size());
        Iterator<Bucket> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawBucket(it.next(), this.f, this.g));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && b((DataReadResult) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RawDataSet> f() {
        ArrayList arrayList = new ArrayList(this.b.size());
        Iterator<DataSet> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataSet(it.next(), this.f, this.g));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DataSource> g() {
        return this.f;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DataType> h() {
        return this.g;
    }

    public int hashCode() {
        return zzw.a(this.c, this.b, this.d);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.c).a("dataSets", this.b.size() > 5 ? this.b.size() + " data sets" : this.b).a("buckets", this.d.size() > 5 ? this.d.size() + " buckets" : this.d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
