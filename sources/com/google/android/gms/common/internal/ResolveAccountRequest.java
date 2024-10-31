package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzy();

    /* renamed from: a, reason: collision with root package name */
    final int f997a;
    private final Account b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountRequest(int i, Account account, int i2) {
        this.f997a = i;
        this.b = account;
        this.c = i2;
    }

    public ResolveAccountRequest(Account account, int i) {
        this(1, account, i);
    }

    public Account a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzy.a(this, parcel, i);
    }
}
