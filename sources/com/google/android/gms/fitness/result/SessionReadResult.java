package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SessionReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    private final int f1291a;
    private final List<Session> b;
    private final List<SessionDataSet> c;
    private final Status d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionReadResult(int i, List<Session> list, List<SessionDataSet> list2, Status status) {
        this.f1291a = i;
        this.b = list;
        this.c = Collections.unmodifiableList(list2);
        this.d = status;
    }

    public SessionReadResult(List<Session> list, List<SessionDataSet> list2, Status status) {
        this.f1291a = 3;
        this.b = list;
        this.c = Collections.unmodifiableList(list2);
        this.d = status;
    }

    public static SessionReadResult a(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean a(SessionReadResult sessionReadResult) {
        return this.d.equals(sessionReadResult.d) && zzw.a(this.b, sessionReadResult.b) && zzw.a(this.c, sessionReadResult.c);
    }

    public List<Session> a() {
        return this.b;
    }

    public List<SessionDataSet> b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1291a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && a((SessionReadResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.d;
    }

    public int hashCode() {
        return zzw.a(this.d, this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.d).a("sessions", this.b).a("sessionDataSets", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
