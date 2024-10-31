package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzq implements Parcelable.Creator<SessionDataSet> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sessionDataSet.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionDataSet.f1232a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) sessionDataSet.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionDataSet createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Session session;
        int i;
        DataSet dataSet2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Session session2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Session session3 = (Session) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Session.CREATOR);
                    i = i2;
                    dataSet = dataSet2;
                    session = session3;
                    break;
                case 2:
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSet.CREATOR);
                    session = session2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    DataSet dataSet3 = dataSet2;
                    session = session2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    dataSet = dataSet3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    dataSet = dataSet2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SessionDataSet(i2, session2, dataSet2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionDataSet[] newArray(int i) {
        return new SessionDataSet[i];
    }
}
