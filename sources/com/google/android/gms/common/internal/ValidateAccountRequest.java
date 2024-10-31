package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ValidateAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzad();

    /* renamed from: a, reason: collision with root package name */
    final int f999a;
    final IBinder b;
    private final int c;
    private final Scope[] d;
    private final Bundle e;
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f999a = i;
        this.c = i2;
        this.b = iBinder;
        this.d = scopeArr;
        this.e = bundle;
        this.f = str;
    }

    public ValidateAccountRequest(zzp zzpVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, GoogleApiAvailability.f862a, zzpVar == null ? null : zzpVar.asBinder(), scopeArr, bundle, str);
    }

    public int a() {
        return this.c;
    }

    public Scope[] b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public Bundle d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.a(this, parcel, i);
    }
}
