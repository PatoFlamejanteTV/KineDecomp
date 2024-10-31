package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Subscription;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f1289a;
    private final List<Subscription> b;
    private final Status c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListSubscriptionsResult(int i, List<Subscription> list, Status status) {
        this.f1289a = i;
        this.b = list;
        this.c = status;
    }

    public ListSubscriptionsResult(List<Subscription> list, Status status) {
        this.f1289a = 3;
        this.b = Collections.unmodifiableList(list);
        this.c = (Status) zzx.a(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    public static ListSubscriptionsResult a(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean a(ListSubscriptionsResult listSubscriptionsResult) {
        return this.c.equals(listSubscriptionsResult.c) && zzw.a(this.b, listSubscriptionsResult.b);
    }

    public List<Subscription> a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1289a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && a((ListSubscriptionsResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    public int hashCode() {
        return zzw.a(this.c, this.b);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.c).a("subscriptions", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
