package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoi;

/* loaded from: classes.dex */
public class SessionStopRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStopRequest> CREATOR = new zzy();

    /* renamed from: a, reason: collision with root package name */
    private final int f1271a;
    private final String b;
    private final String c;
    private final zzoi d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionStopRequest(int i, String str, String str2, IBinder iBinder) {
        this.f1271a = i;
        this.b = str;
        this.c = str2;
        this.d = zzoi.zza.zzbI(iBinder);
    }

    public SessionStopRequest(String str, String str2, zzoi zzoiVar) {
        this.f1271a = 3;
        this.b = str;
        this.c = str2;
        this.d = zzoiVar;
    }

    private boolean a(SessionStopRequest sessionStopRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, sessionStopRequest.b) && com.google.android.gms.common.internal.zzw.a(this.c, sessionStopRequest.c);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public IBinder c() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1271a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStopRequest) && a((SessionStopRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b, this.c);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("name", this.b).a("identifier", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzy.a(this, parcel, i);
    }
}
