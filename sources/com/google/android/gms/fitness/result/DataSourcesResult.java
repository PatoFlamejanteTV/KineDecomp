package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataSourcesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    private final int f1286a;
    private final List<DataSource> b;
    private final Status c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSourcesResult(int i, List<DataSource> list, Status status) {
        this.f1286a = i;
        this.b = Collections.unmodifiableList(list);
        this.c = status;
    }

    public DataSourcesResult(List<DataSource> list, Status status) {
        this.f1286a = 3;
        this.b = Collections.unmodifiableList(list);
        this.c = status;
    }

    public static DataSourcesResult a(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean a(DataSourcesResult dataSourcesResult) {
        return this.c.equals(dataSourcesResult.c) && zzw.a(this.b, dataSourcesResult.b);
    }

    public List<DataSource> a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1286a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSourcesResult) && a((DataSourcesResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    public int hashCode() {
        return zzw.a(this.c, this.b);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.c).a("dataSets", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
