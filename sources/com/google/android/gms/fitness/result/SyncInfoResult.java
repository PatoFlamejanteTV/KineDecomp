package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class SyncInfoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SyncInfoResult> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    private final int f1293a;
    private final Status b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SyncInfoResult(int i, Status status, long j) {
        this.f1293a = i;
        this.b = status;
        this.c = j;
    }

    private boolean a(SyncInfoResult syncInfoResult) {
        return this.b.equals(syncInfoResult.b) && zzw.a(Long.valueOf(this.c), Long.valueOf(syncInfoResult.c));
    }

    public long a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1293a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SyncInfoResult) && a((SyncInfoResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }

    public int hashCode() {
        return zzw.a(this.b, Long.valueOf(this.c));
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.b).a("timestamp", Long.valueOf(this.c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
