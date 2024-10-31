package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class SessionRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionRegistrationRequest> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    private final int f1269a;
    private final PendingIntent b;
    private final zzoj c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionRegistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder, int i2) {
        this.f1269a = i;
        this.b = pendingIntent;
        this.c = iBinder == null ? null : zzoj.zza.zzbJ(iBinder);
        this.d = i2;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zzoj zzojVar, int i) {
        this.f1269a = 6;
        this.b = pendingIntent;
        this.c = zzojVar;
        this.d = i;
    }

    private boolean a(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.d == sessionRegistrationRequest.d && com.google.android.gms.common.internal.zzw.a(this.b, sessionRegistrationRequest.b);
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

    public int c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1269a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionRegistrationRequest) && a((SessionRegistrationRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b, Integer.valueOf(this.d));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("pendingIntent", this.b).a("sessionRegistrationOption", Integer.valueOf(this.d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzw.a(this, parcel, i);
    }
}
