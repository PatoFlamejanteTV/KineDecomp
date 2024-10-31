package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SensorRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    int f1261a;
    int b;
    private final int c;
    private DataSource d;
    private DataType e;
    private com.google.android.gms.fitness.data.zzj f;
    private final long g;
    private final long h;
    private final PendingIntent i;
    private final long j;
    private final int k;
    private final List<LocationRequest> l;
    private final long m;
    private final List<Object> n;
    private final zzoj o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SensorRegistrationRequest(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2) {
        this.c = i;
        this.d = dataSource;
        this.e = dataType;
        this.f = iBinder == null ? null : zzj.zza.a(iBinder);
        this.g = j == 0 ? i2 : j;
        this.j = j3;
        this.h = j2 == 0 ? i3 : j2;
        this.l = list;
        this.i = pendingIntent;
        this.k = i4;
        this.n = Collections.emptyList();
        this.m = j4;
        this.o = zzoj.zza.zzbJ(iBinder2);
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<Object> list2, long j4, zzoj zzojVar) {
        this.c = 6;
        this.d = dataSource;
        this.e = dataType;
        this.f = zzjVar;
        this.i = pendingIntent;
        this.g = j;
        this.j = j2;
        this.h = j3;
        this.k = i;
        this.l = list;
        this.n = list2;
        this.m = j4;
        this.o = zzojVar;
    }

    public SensorRegistrationRequest(SensorRequest sensorRequest, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, zzoj zzojVar) {
        this(sensorRequest.a(), sensorRequest.b(), zzjVar, pendingIntent, sensorRequest.a(TimeUnit.MICROSECONDS), sensorRequest.b(TimeUnit.MICROSECONDS), sensorRequest.c(TimeUnit.MICROSECONDS), sensorRequest.c(), null, Collections.emptyList(), sensorRequest.d(), zzojVar);
    }

    private boolean a(SensorRegistrationRequest sensorRegistrationRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.d, sensorRegistrationRequest.d) && com.google.android.gms.common.internal.zzw.a(this.e, sensorRegistrationRequest.e) && this.g == sensorRegistrationRequest.g && this.j == sensorRegistrationRequest.j && this.h == sensorRegistrationRequest.h && this.k == sensorRegistrationRequest.k && com.google.android.gms.common.internal.zzw.a(this.l, sensorRegistrationRequest.l);
    }

    public DataSource a() {
        return this.d;
    }

    public DataType b() {
        return this.e;
    }

    public PendingIntent c() {
        return this.i;
    }

    public long d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRegistrationRequest) && a((SensorRegistrationRequest) obj));
    }

    public long f() {
        return this.h;
    }

    public List<LocationRequest> g() {
        return this.l;
    }

    public int h() {
        return this.k;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.d, this.e, this.f, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(this.k), this.l);
    }

    public long i() {
        return this.m;
    }

    public IBinder j() {
        if (this.o == null) {
            return null;
        }
        return this.o.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder l() {
        if (this.f == null) {
            return null;
        }
        return this.f.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.e, this.d, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzs.a(this, parcel, i);
    }
}
