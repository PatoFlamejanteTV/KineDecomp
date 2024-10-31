package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class GetConsentIntentRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final ScopeDetail[] f786a;
    private final int b;
    private final String c;
    private final int d;
    private final String e;
    private final Account f;
    private final boolean g;
    private final int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetConsentIntentRequest(int i, String str, int i2, String str2, Account account, ScopeDetail[] scopeDetailArr, boolean z, int i3) {
        this.b = i;
        this.c = str;
        this.d = i2;
        this.e = str2;
        this.f = (Account) zzx.a(account);
        this.f786a = scopeDetailArr;
        this.g = z;
        this.h = i3;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
