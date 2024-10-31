package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;

/* loaded from: classes.dex */
public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzz();

    /* renamed from: a, reason: collision with root package name */
    final int f998a;
    IBinder b;
    private ConnectionResult c;
    private boolean d;
    private boolean e;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f998a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public zzp a() {
        return zzp.zza.a(this.b);
    }

    public ConnectionResult b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.c.equals(resolveAccountResponse.c) && a().equals(resolveAccountResponse.a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzz.a(this, parcel, i);
    }
}
