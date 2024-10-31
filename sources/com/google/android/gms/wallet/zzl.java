package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<MaskedWalletRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, maskedWalletRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, maskedWalletRequest.f2288a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, maskedWalletRequest.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, maskedWalletRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, maskedWalletRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, maskedWalletRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, maskedWalletRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, maskedWalletRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) maskedWalletRequest.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, maskedWalletRequest.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, maskedWalletRequest.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable[]) maskedWalletRequest.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, maskedWalletRequest.l);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, maskedWalletRequest.m);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 15, maskedWalletRequest.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, (List<Integer>) maskedWalletRequest.p, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, (Parcelable) maskedWalletRequest.o, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList<Integer> arrayList2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    cart = (Cart) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Cart.CREATOR);
                    break;
                case 10:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 11:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 14:
                    z7 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 15:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
                    break;
                case 16:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case 17:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList, paymentMethodTokenizationParameters, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
