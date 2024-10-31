package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();

    /* renamed from: a */
    private final int f11120a;

    /* renamed from: b */
    private final Account f11121b;

    /* renamed from: c */
    private final int f11122c;

    /* renamed from: d */
    private final GoogleSignInAccount f11123d;

    @SafeParcelable.Constructor
    public ResolveAccountRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f11120a = i;
        this.f11121b = account;
        this.f11122c = i2;
        this.f11123d = googleSignInAccount;
    }

    public int O() {
        return this.f11122c;
    }

    public GoogleSignInAccount P() {
        return this.f11123d;
    }

    public Account a() {
        return this.f11121b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11120a);
        SafeParcelWriter.a(parcel, 2, (Parcelable) a(), i, false);
        SafeParcelWriter.a(parcel, 3, O());
        SafeParcelWriter.a(parcel, 4, (Parcelable) P(), i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }
}
