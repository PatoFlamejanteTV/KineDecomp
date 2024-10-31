package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class SessionStartRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzx();

    /* renamed from: a, reason: collision with root package name */
    private final int f1270a;
    private final Session b;
    private final zzoj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionStartRequest(int i, Session session, IBinder iBinder) {
        this.f1270a = i;
        this.b = session;
        this.c = zzoj.zza.zzbJ(iBinder);
    }

    public SessionStartRequest(Session session, zzoj zzojVar) {
        com.google.android.gms.common.internal.zzx.b(session.a(), "Cannot start a session which has already ended");
        this.f1270a = 3;
        this.b = session;
        this.c = zzojVar;
    }

    private boolean a(SessionStartRequest sessionStartRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, sessionStartRequest.b);
    }

    public Session a() {
        return this.b;
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1270a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStartRequest) && a((SessionStartRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("session", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzx.a(this, parcel, i);
    }
}
