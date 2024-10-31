package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zao();

    /* renamed from: a */
    private final int f11130a;

    /* renamed from: b */
    private final int f11131b;

    /* renamed from: c */
    private final int f11132c;

    /* renamed from: d */
    @Deprecated
    private final Scope[] f11133d;

    @SafeParcelable.Constructor
    public SignInButtonConfig(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.f11130a = i;
        this.f11131b = i2;
        this.f11132c = i3;
        this.f11133d = scopeArr;
    }

    public int O() {
        return this.f11132c;
    }

    @Deprecated
    public Scope[] P() {
        return this.f11133d;
    }

    public int a() {
        return this.f11131b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11130a);
        SafeParcelWriter.a(parcel, 2, a());
        SafeParcelWriter.a(parcel, 3, O());
        SafeParcelWriter.a(parcel, 4, (Parcelable[]) P(), i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }
}
