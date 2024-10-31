package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataDeleteRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    private final int f1243a;
    private final long b;
    private final long c;
    private final List<DataSource> d;
    private final List<DataType> e;
    private final List<Session> f;
    private final boolean g;
    private final boolean h;
    private final zzoj i;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<DataSource> f1244a = new ArrayList();
        private List<DataType> b = new ArrayList();
        private List<Session> c = new ArrayList();
        private boolean d = false;
        private boolean e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, IBinder iBinder) {
        this.f1243a = i;
        this.b = j;
        this.c = j2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = z;
        this.h = z2;
        this.i = zzoj.zza.zzbJ(iBinder);
    }

    public DataDeleteRequest(long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, zzoj zzojVar) {
        this.f1243a = 3;
        this.b = j;
        this.c = j2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = z;
        this.h = z2;
        this.i = zzojVar;
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzoj zzojVar) {
        this(dataDeleteRequest.b, dataDeleteRequest.c, dataDeleteRequest.d, dataDeleteRequest.e, dataDeleteRequest.f, dataDeleteRequest.g, dataDeleteRequest.h, zzojVar);
    }

    private boolean a(DataDeleteRequest dataDeleteRequest) {
        return this.b == dataDeleteRequest.b && this.c == dataDeleteRequest.c && com.google.android.gms.common.internal.zzw.a(this.d, dataDeleteRequest.d) && com.google.android.gms.common.internal.zzw.a(this.e, dataDeleteRequest.e) && com.google.android.gms.common.internal.zzw.a(this.f, dataDeleteRequest.f) && this.g == dataDeleteRequest.g && this.h == dataDeleteRequest.h;
    }

    public List<DataSource> a() {
        return this.d;
    }

    public List<DataType> b() {
        return this.e;
    }

    public List<Session> c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1243a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && a((DataDeleteRequest) obj));
    }

    public boolean f() {
        return this.h;
    }

    public long g() {
        return this.c;
    }

    public long h() {
        return this.b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public IBinder i() {
        if (this.i == null) {
            return null;
        }
        return this.i.asBinder();
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("startTimeMillis", Long.valueOf(this.b)).a("endTimeMillis", Long.valueOf(this.c)).a("dataSources", this.d).a("dateTypes", this.e).a("sessions", this.f).a("deleteAllData", Boolean.valueOf(this.g)).a("deleteAllSessions", Boolean.valueOf(this.h)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
