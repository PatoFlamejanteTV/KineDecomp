package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f778a;
    int b;

    @Deprecated
    String c;
    Account d;

    public AccountChangeEventsRequest() {
        this.f778a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f778a = i;
        this.b = i2;
        this.c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.d = account;
        } else {
            this.d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
