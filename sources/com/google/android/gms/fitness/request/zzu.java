package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzu implements Parcelable.Creator<SessionInsertRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sessionInsertRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionInsertRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, sessionInsertRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, sessionInsertRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, sessionInsertRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionInsertRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Session session = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    session = (Session) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Session.CREATOR);
                    break;
                case 2:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSet.CREATOR);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataPoint.CREATOR);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
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
        return new SessionInsertRequest(i, session, arrayList2, arrayList, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionInsertRequest[] newArray(int i) {
        return new SessionInsertRequest[i];
    }
}
