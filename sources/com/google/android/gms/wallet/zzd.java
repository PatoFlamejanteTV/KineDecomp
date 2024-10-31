package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<CreateWalletObjectsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, createWalletObjectsRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) createWalletObjectsRequest.f2280a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) createWalletObjectsRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) createWalletObjectsRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateWalletObjectsRequest createFromParcel(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject;
        OfferWalletObject offerWalletObject;
        LoyaltyWalletObject loyaltyWalletObject;
        int i;
        GiftCardWalletObject giftCardWalletObject2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        OfferWalletObject offerWalletObject2 = null;
        LoyaltyWalletObject loyaltyWalletObject2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    GiftCardWalletObject giftCardWalletObject3 = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    giftCardWalletObject = giftCardWalletObject3;
                    break;
                case 2:
                    i = i2;
                    OfferWalletObject offerWalletObject3 = offerWalletObject2;
                    loyaltyWalletObject = (LoyaltyWalletObject) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    GiftCardWalletObject giftCardWalletObject4 = giftCardWalletObject2;
                    offerWalletObject = (OfferWalletObject) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, OfferWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject4;
                    break;
                case 4:
                    giftCardWalletObject = (GiftCardWalletObject) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, GiftCardWalletObject.CREATOR);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
            }
            i2 = i;
            loyaltyWalletObject2 = loyaltyWalletObject;
            offerWalletObject2 = offerWalletObject;
            giftCardWalletObject2 = giftCardWalletObject;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CreateWalletObjectsRequest(i2, loyaltyWalletObject2, offerWalletObject2, giftCardWalletObject2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateWalletObjectsRequest[] newArray(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
