package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes.dex */
public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2311a;
    private String b;
    private MaskedWalletRequest c;
    private int d;
    private MaskedWallet e;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    private WalletFragmentInitParams() {
        this.f2311a = 1;
        this.d = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletFragmentInitParams(int i, String str, MaskedWalletRequest maskedWalletRequest, int i2, MaskedWallet maskedWallet) {
        this.f2311a = i;
        this.b = str;
        this.c = maskedWalletRequest;
        this.d = i2;
        this.e = maskedWallet;
    }

    public String a() {
        return this.b;
    }

    public MaskedWalletRequest b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public MaskedWallet d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
