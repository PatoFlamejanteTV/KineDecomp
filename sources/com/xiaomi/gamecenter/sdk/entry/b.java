package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CardBuyInfoOffline createFromParcel(Parcel parcel) {
        CardBuyInfoOffline cardBuyInfoOffline = new CardBuyInfoOffline(null);
        cardBuyInfoOffline.setCardNumber(parcel.readString());
        cardBuyInfoOffline.setCardPass(parcel.readString());
        cardBuyInfoOffline.setCardType(CardType.valueOf(parcel.readString()));
        cardBuyInfoOffline.setMoney(parcel.readInt());
        cardBuyInfoOffline.setInfoOffline((MiBuyInfoOffline) parcel.readParcelable(MiBuyInfoOffline.class.getClassLoader()));
        return cardBuyInfoOffline;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CardBuyInfoOffline[] newArray(int i) {
        return new CardBuyInfoOffline[i];
    }
}
