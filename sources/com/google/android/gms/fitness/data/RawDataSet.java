package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* loaded from: classes.dex */
public final class RawDataSet implements SafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    final int f1229a;
    public final int b;
    public final int c;
    public final List<RawDataPoint> d;
    public final boolean e;

    public RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.f1229a = i;
        this.b = i2;
        this.c = i3;
        this.d = list;
        this.e = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.f1229a = 3;
        this.d = dataSet.a(list);
        this.e = dataSet.d();
        this.b = zzs.a(dataSet.a(), list);
        this.c = zzs.a(dataSet.b(), list2);
    }

    private boolean a(RawDataSet rawDataSet) {
        return this.b == rawDataSet.b && this.e == rawDataSet.e && zzw.a(this.d, rawDataSet.d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && a((RawDataSet) obj));
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", Integer.valueOf(this.b), this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
