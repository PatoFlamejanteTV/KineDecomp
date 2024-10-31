package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CreateWalletObjectsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    LoyaltyWalletObject f2280a;
    OfferWalletObject b;
    GiftCardWalletObject c;
    private final int d;

    CreateWalletObjectsRequest() {
        this.d = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateWalletObjectsRequest(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.d = i;
        this.f2280a = loyaltyWalletObject;
        this.b = offerWalletObject;
        this.c = giftCardWalletObject;
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
        zzd.a(this, parcel, i);
    }
}
