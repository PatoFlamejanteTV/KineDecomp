package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class RecordConsentRequest implements SafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2195a;
    private final Account b;
    private final Scope[] c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f2195a = i;
        this.b = account;
        this.c = scopeArr;
        this.d = str;
    }

    public Account a() {
        return this.b;
    }

    public Scope[] b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
