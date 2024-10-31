package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class FullWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    String f2282a;
    String b;
    Cart c;
    private final int d;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    FullWalletRequest() {
        this.d = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullWalletRequest(int i, String str, String str2, Cart cart) {
        this.d = i;
        this.f2282a = str;
        this.b = str2;
        this.c = cart;
    }

    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
