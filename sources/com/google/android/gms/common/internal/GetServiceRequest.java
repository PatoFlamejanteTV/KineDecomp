package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();

    /* renamed from: a */
    private final int f11086a;

    /* renamed from: b */
    private final int f11087b;

    /* renamed from: c */
    private int f11088c;

    /* renamed from: d */
    String f11089d;

    /* renamed from: e */
    IBinder f11090e;

    /* renamed from: f */
    Scope[] f11091f;

    /* renamed from: g */
    Bundle f11092g;

    /* renamed from: h */
    Account f11093h;
    Feature[] i;
    Feature[] j;
    private boolean k;

    public GetServiceRequest(int i) {
        this.f11086a = 4;
        this.f11088c = GoogleApiAvailabilityLight.f10663a;
        this.f11087b = i;
        this.k = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11086a);
        SafeParcelWriter.a(parcel, 2, this.f11087b);
        SafeParcelWriter.a(parcel, 3, this.f11088c);
        SafeParcelWriter.a(parcel, 4, this.f11089d, false);
        SafeParcelWriter.a(parcel, 5, this.f11090e, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable[]) this.f11091f, i, false);
        SafeParcelWriter.a(parcel, 7, this.f11092g, false);
        SafeParcelWriter.a(parcel, 8, (Parcelable) this.f11093h, i, false);
        SafeParcelWriter.a(parcel, 10, (Parcelable[]) this.i, i, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable[]) this.j, i, false);
        SafeParcelWriter.a(parcel, 12, this.k);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z) {
        this.f11086a = i;
        this.f11087b = i2;
        this.f11088c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f11089d = "com.google.android.gms";
        } else {
            this.f11089d = str;
        }
        if (i < 2) {
            this.f11093h = iBinder != null ? AccountAccessor.a(IAccountAccessor.Stub.a(iBinder)) : null;
        } else {
            this.f11090e = iBinder;
            this.f11093h = account;
        }
        this.f11091f = scopeArr;
        this.f11092g = bundle;
        this.i = featureArr;
        this.j = featureArr2;
        this.k = z;
    }
}
