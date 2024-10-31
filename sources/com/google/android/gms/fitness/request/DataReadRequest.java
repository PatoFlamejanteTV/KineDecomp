package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zznu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DataReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f1246a;
    private final List<DataType> b;
    private final List<DataSource> c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private final int h;
    private final long i;
    private final DataSource j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final zznu n;
    private final List<Device> o;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<DataType> f1247a = new ArrayList();
        private List<DataSource> b = new ArrayList();
        private List<DataType> c = new ArrayList();
        private List<DataSource> d = new ArrayList();
        private int e = 0;
        private long f = 0;
        private int g = 0;
        private boolean h = false;
        private boolean i = false;
        private List<Device> j = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, List<Device> list5) {
        this.f1246a = i;
        this.b = list;
        this.c = list2;
        this.d = j;
        this.e = j2;
        this.f = list3;
        this.g = list4;
        this.h = i2;
        this.i = j3;
        this.j = dataSource;
        this.k = i3;
        this.l = z;
        this.m = z2;
        this.n = iBinder == null ? null : zznu.zza.zzbu(iBinder);
        this.o = list5 == null ? Collections.EMPTY_LIST : list5;
    }

    public DataReadRequest(DataReadRequest dataReadRequest, zznu zznuVar) {
        this(dataReadRequest.b, dataReadRequest.c, dataReadRequest.d, dataReadRequest.e, dataReadRequest.f, dataReadRequest.g, dataReadRequest.h, dataReadRequest.i, dataReadRequest.j, dataReadRequest.k, dataReadRequest.l, dataReadRequest.m, zznuVar, dataReadRequest.o);
    }

    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, zznu zznuVar, List<Device> list5) {
        this(5, list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, zznuVar == null ? null : zznuVar.asBinder(), list5);
    }

    private boolean a(DataReadRequest dataReadRequest) {
        return this.b.equals(dataReadRequest.b) && this.c.equals(dataReadRequest.c) && this.d == dataReadRequest.d && this.e == dataReadRequest.e && this.h == dataReadRequest.h && this.g.equals(dataReadRequest.g) && this.f.equals(dataReadRequest.f) && com.google.android.gms.common.internal.zzw.a(this.j, dataReadRequest.j) && this.i == dataReadRequest.i && this.m == dataReadRequest.m;
    }

    public List<DataType> a() {
        return this.b;
    }

    public List<DataSource> b() {
        return this.c;
    }

    public List<DataType> c() {
        return this.f;
    }

    public List<DataSource> d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && a((DataReadRequest) obj));
    }

    public DataSource f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public boolean h() {
        return this.m;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(Integer.valueOf(this.h), Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public boolean i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f1246a;
    }

    public long k() {
        return this.e;
    }

    public long l() {
        return this.d;
    }

    public long m() {
        return this.i;
    }

    public IBinder n() {
        if (this.n == null) {
            return null;
        }
        return this.n.asBinder();
    }

    public List<Device> o() {
        return this.o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.b.isEmpty()) {
            Iterator<DataType> it = this.b.iterator();
            while (it.hasNext()) {
                sb.append(it.next().c()).append(" ");
            }
        }
        if (!this.c.isEmpty()) {
            Iterator<DataSource> it2 = this.c.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().g()).append(" ");
            }
        }
        if (this.h != 0) {
            sb.append("bucket by ").append(Bucket.a(this.h));
            if (this.i > 0) {
                sb.append(" >").append(this.i).append("ms");
            }
            sb.append(": ");
        }
        if (!this.f.isEmpty()) {
            Iterator<DataType> it3 = this.f.iterator();
            while (it3.hasNext()) {
                sb.append(it3.next().c()).append(" ");
            }
        }
        if (!this.g.isEmpty()) {
            Iterator<DataSource> it4 = this.g.iterator();
            while (it4.hasNext()) {
                sb.append(it4.next().g()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", Long.valueOf(this.d), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.e)));
        if (this.j != null) {
            sb.append("activities: ").append(this.j.g());
        }
        if (this.m) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
