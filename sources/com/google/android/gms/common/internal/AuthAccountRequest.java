package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

/* loaded from: classes.dex */
public class AuthAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f993a;
    final IBinder b;
    final Scope[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr) {
        this.f993a = i;
        this.b = iBinder;
        this.c = scopeArr;
    }

    public AuthAccountRequest(zzp zzpVar, Set<Scope> set) {
        this(1, zzpVar.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
