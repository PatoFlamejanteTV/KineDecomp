package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<DocumentContents> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DocumentContents documentContents, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable[]) documentContents.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, documentContents.f755a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, documentContents.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, documentContents.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) documentContents.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DocumentContents createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        DocumentSection[] documentSectionArr = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    documentSectionArr = (DocumentSection[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, DocumentSection.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DocumentContents(i, documentSectionArr, str, z, account);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DocumentContents[] newArray(int i) {
        return new DocumentContents[i];
    }
}
