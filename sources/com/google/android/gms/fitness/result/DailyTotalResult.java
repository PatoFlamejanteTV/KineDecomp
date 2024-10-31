package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

/* loaded from: classes.dex */
public class DailyTotalResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1283a;
    private final Status b;
    private final DataSet c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DailyTotalResult(int i, Status status, DataSet dataSet) {
        this.f1283a = i;
        this.b = status;
        this.c = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.f1283a = 1;
        this.b = status;
        this.c = dataSet;
    }

    public static DailyTotalResult a(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.a(new DataSource.Builder().a(dataType).a(1).a()), status);
    }

    private boolean a(DailyTotalResult dailyTotalResult) {
        return this.b.equals(dailyTotalResult.b) && zzw.a(this.c, dailyTotalResult.c);
    }

    public DataSet a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1283a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DailyTotalResult) && a((DailyTotalResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.b).a("dataPoint", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
