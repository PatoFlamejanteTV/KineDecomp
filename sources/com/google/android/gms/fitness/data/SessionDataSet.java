package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class SessionDataSet implements SafeParcelable {
    public static final Parcelable.Creator<SessionDataSet> CREATOR = new zzq();

    /* renamed from: a, reason: collision with root package name */
    final int f1232a;
    private final Session b;
    private final DataSet c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionDataSet(int i, Session session, DataSet dataSet) {
        this.f1232a = i;
        this.b = session;
        this.c = dataSet;
    }

    private boolean a(SessionDataSet sessionDataSet) {
        return zzw.a(this.b, sessionDataSet.b) && zzw.a(this.c, sessionDataSet.c);
    }

    public Session a() {
        return this.b;
    }

    public DataSet b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionDataSet) && a((SessionDataSet) obj));
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a("session", this.b).a("dataSet", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.a(this, parcel, i);
    }
}
