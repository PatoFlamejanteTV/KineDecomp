package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class Subscription implements SafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    private final int f1233a;
    private final DataSource b;
    private final DataType c;
    private final long d;
    private final int e;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private DataSource f1234a;
        private DataType b;
        private long c = -1;
        private int d = 2;

        public zza a(DataSource dataSource) {
            this.f1234a = dataSource;
            return this;
        }

        public zza a(DataType dataType) {
            this.b = dataType;
            return this;
        }

        public Subscription a() {
            zzx.a((this.f1234a == null && this.b == null) ? false : true, "Must call setDataSource() or setDataType()");
            zzx.a(this.b == null || this.f1234a == null || this.b.equals(this.f1234a.a()), "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.f1233a = i;
        this.b = dataSource;
        this.c = dataType;
        this.d = j;
        this.e = i2;
    }

    private Subscription(zza zzaVar) {
        this.f1233a = 1;
        this.c = zzaVar.b;
        this.b = zzaVar.f1234a;
        this.d = zzaVar.c;
        this.e = zzaVar.d;
    }

    private boolean a(Subscription subscription) {
        return zzw.a(this.b, subscription.b) && zzw.a(this.c, subscription.c) && this.d == subscription.d && this.e == subscription.e;
    }

    public DataSource a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1233a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && a((Subscription) obj));
    }

    public int hashCode() {
        return zzw.a(this.b, this.b, Long.valueOf(this.d), Integer.valueOf(this.e));
    }

    public String toString() {
        return zzw.a(this).a("dataSource", this.b).a("dataType", this.c).a("samplingIntervalMicros", Long.valueOf(this.d)).a("accuracyMode", Integer.valueOf(this.e)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.a(this, parcel, i);
    }
}
