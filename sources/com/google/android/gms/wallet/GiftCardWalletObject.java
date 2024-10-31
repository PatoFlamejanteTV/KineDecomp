package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public final class GiftCardWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2283a;
    CommonWalletObject b;
    String c;
    String d;
    String e;
    long f;
    String g;
    long h;
    String i;

    GiftCardWalletObject() {
        this.b = CommonWalletObject.a().a();
        this.f2283a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GiftCardWalletObject(int i, CommonWalletObject commonWalletObject, String str, String str2, String str3, long j, String str4, long j2, String str5) {
        this.b = CommonWalletObject.a().a();
        this.f2283a = i;
        this.b = commonWalletObject;
        this.c = str;
        this.d = str2;
        this.f = j;
        this.g = str4;
        this.h = j2;
        this.i = str5;
        this.e = str3;
    }

    public int a() {
        return this.f2283a;
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
