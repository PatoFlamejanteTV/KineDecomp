package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();

    /* renamed from: a */
    private final int f11040a;

    /* renamed from: b */
    @Deprecated
    private final IBinder f11041b;

    /* renamed from: c */
    private final Scope[] f11042c;

    /* renamed from: d */
    private Integer f11043d;

    /* renamed from: e */
    private Integer f11044e;

    /* renamed from: f */
    private Account f11045f;

    @SafeParcelable.Constructor
    public AuthAccountRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) Scope[] scopeArr, @SafeParcelable.Param(id = 4) Integer num, @SafeParcelable.Param(id = 5) Integer num2, @SafeParcelable.Param(id = 6) Account account) {
        this.f11040a = i;
        this.f11041b = iBinder;
        this.f11042c = scopeArr;
        this.f11043d = num;
        this.f11044e = num2;
        this.f11045f = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11040a);
        SafeParcelWriter.a(parcel, 2, this.f11041b, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable[]) this.f11042c, i, false);
        SafeParcelWriter.a(parcel, 4, this.f11043d, false);
        SafeParcelWriter.a(parcel, 5, this.f11044e, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.f11045f, i, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
