package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a */
    private final int f10395a;

    /* renamed from: b */
    private int f10396b;

    /* renamed from: c */
    @Deprecated
    private String f10397c;

    /* renamed from: d */
    private Account f10398d;

    @SafeParcelable.Constructor
    public AccountChangeEventsRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Account account) {
        this.f10395a = i;
        this.f10396b = i2;
        this.f10397c = str;
        if (account == null && !TextUtils.isEmpty(str)) {
            this.f10398d = new Account(str, "com.google");
        } else {
            this.f10398d = account;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10395a);
        SafeParcelWriter.a(parcel, 2, this.f10396b);
        SafeParcelWriter.a(parcel, 3, this.f10397c, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.f10398d, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public AccountChangeEventsRequest() {
        this.f10395a = 1;
    }
}
