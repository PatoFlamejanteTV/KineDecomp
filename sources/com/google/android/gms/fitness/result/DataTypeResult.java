package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

/* loaded from: classes.dex */
public class DataTypeResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    private final int f1288a;
    private final Status b;
    private final DataType c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataTypeResult(int i, Status status, DataType dataType) {
        this.f1288a = i;
        this.b = status;
        this.c = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.f1288a = 2;
        this.b = status;
        this.c = dataType;
    }

    public static DataTypeResult a(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean a(DataTypeResult dataTypeResult) {
        return this.b.equals(dataTypeResult.b) && zzw.a(this.c, dataTypeResult.c);
    }

    public DataType a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1288a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && a((DataTypeResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.b).a("dataType", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
