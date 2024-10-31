package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public final class OfferWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    String f2290a;
    String b;
    CommonWalletObject c;
    private final int d;

    OfferWalletObject() {
        this.d = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.d = i;
        this.b = str2;
        if (i < 3) {
            this.c = CommonWalletObject.a().a(str).a();
        } else {
            this.c = commonWalletObject;
        }
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
        zzn.a(this, parcel, i);
    }
}
