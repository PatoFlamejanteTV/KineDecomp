package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SessionInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzu();

    /* renamed from: a, reason: collision with root package name */
    private final int f1265a;
    private final Session b;
    private final List<DataSet> c;
    private final List<DataPoint> d;
    private final zzoj e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<DataSet> f1266a = new ArrayList();
        private List<DataPoint> b = new ArrayList();
        private List<DataSource> c = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder) {
        this.f1265a = i;
        this.b = session;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = zzoj.zza.zzbJ(iBinder);
    }

    public SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, zzoj zzojVar) {
        this.f1265a = 3;
        this.b = session;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = zzojVar;
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzoj zzojVar) {
        this(sessionInsertRequest.b, sessionInsertRequest.c, sessionInsertRequest.d, zzojVar);
    }

    private boolean a(SessionInsertRequest sessionInsertRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, sessionInsertRequest.b) && com.google.android.gms.common.internal.zzw.a(this.c, sessionInsertRequest.c) && com.google.android.gms.common.internal.zzw.a(this.d, sessionInsertRequest.d);
    }

    public Session a() {
        return this.b;
    }

    public List<DataSet> b() {
        return this.c;
    }

    public List<DataPoint> c() {
        return this.d;
    }

    public IBinder d() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1265a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && a((SessionInsertRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b, this.c, this.d);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("session", this.b).a("dataSets", this.c).a("aggregateDataPoints", this.d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzu.a(this, parcel, i);
    }
}
