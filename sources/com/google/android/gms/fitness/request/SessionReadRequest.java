package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoh;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SessionReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzv();

    /* renamed from: a, reason: collision with root package name */
    private final int f1267a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private boolean h;
    private final boolean i;
    private final List<String> j;
    private final zzoh k;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private long f1268a = 0;
        private long b = 0;
        private List<DataType> c = new ArrayList();
        private List<DataSource> d = new ArrayList();
        private boolean e = false;
        private boolean f = false;
        private List<String> g = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder) {
        this.f1267a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = z;
        this.i = z2;
        this.j = list3;
        this.k = zzoh.zza.zzbH(iBinder);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzoh zzohVar) {
        this(sessionReadRequest.b, sessionReadRequest.c, sessionReadRequest.d, sessionReadRequest.e, sessionReadRequest.f, sessionReadRequest.g, sessionReadRequest.h, sessionReadRequest.i, sessionReadRequest.j, zzohVar);
    }

    public SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zzoh zzohVar) {
        this(5, str, str2, j, j2, list, list2, z, z2, list3, zzohVar == null ? null : zzohVar.asBinder());
    }

    private boolean a(SessionReadRequest sessionReadRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, sessionReadRequest.b) && this.c.equals(sessionReadRequest.c) && this.d == sessionReadRequest.d && this.e == sessionReadRequest.e && com.google.android.gms.common.internal.zzw.a(this.f, sessionReadRequest.f) && com.google.android.gms.common.internal.zzw.a(this.g, sessionReadRequest.g) && this.h == sessionReadRequest.h && this.j.equals(sessionReadRequest.j) && this.i == sessionReadRequest.i;
    }

    public String a() {
        return this.b;
    }

    public String b() {
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

    public List<String> e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && a((SessionReadRequest) obj));
    }

    public boolean f() {
        return this.i;
    }

    public long g() {
        return this.e;
    }

    public long h() {
        return this.d;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b, this.c, Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public boolean i() {
        return this.h;
    }

    public IBinder j() {
        if (this.k == null) {
            return null;
        }
        return this.k.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f1267a;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("sessionName", this.b).a("sessionId", this.c).a("startTimeMillis", Long.valueOf(this.d)).a("endTimeMillis", Long.valueOf(this.e)).a("dataTypes", this.f).a("dataSources", this.g).a("sessionsFromAllApps", Boolean.valueOf(this.h)).a("excludedPackages", this.j).a("useServer", Boolean.valueOf(this.i)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.a(this, parcel, i);
    }
}
