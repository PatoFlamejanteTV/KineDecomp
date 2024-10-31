package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;
import java.util.Collection;

/* loaded from: classes.dex */
public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f996a;
    final int b;
    int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;

    public GetServiceRequest(int i) {
        this.f996a = 2;
        this.c = GoogleApiAvailability.f862a;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f996a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        if (i < 2) {
            this.h = a(iBinder);
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
    }

    private Account a(IBinder iBinder) {
        if (iBinder != null) {
            return zza.a(zzp.zza.a(iBinder));
        }
        return null;
    }

    public GetServiceRequest a(Account account) {
        this.h = account;
        return this;
    }

    public GetServiceRequest a(Bundle bundle) {
        this.g = bundle;
        return this;
    }

    public GetServiceRequest a(zzp zzpVar) {
        if (zzpVar != null) {
            this.e = zzpVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest a(String str) {
        this.d = str;
        return this;
    }

    public GetServiceRequest a(Collection<Scope> collection) {
        this.f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
