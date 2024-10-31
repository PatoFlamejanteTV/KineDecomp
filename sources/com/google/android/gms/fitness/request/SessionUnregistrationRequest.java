package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionUnregistrationRequest> CREATOR = new zzz();

    /* renamed from: a, reason: collision with root package name */
    private final int f1272a;
    private final PendingIntent b;
    private final zzoj c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionUnregistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder) {
        this.f1272a = i;
        this.b = pendingIntent;
        this.c = zzoj.zza.zzbJ(iBinder);
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zzoj zzojVar) {
        this.f1272a = 5;
        this.b = pendingIntent;
        this.c = zzojVar;
    }

    private boolean a(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, sessionUnregistrationRequest.b);
    }

    public PendingIntent a() {
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
        return this.f1272a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionUnregistrationRequest) && a((SessionUnregistrationRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("pendingIntent", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzz.a(this, parcel, i);
    }
}
