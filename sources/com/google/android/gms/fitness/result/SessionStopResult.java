package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SessionStopResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    private final int f1292a;
    private final Status b;
    private final List<Session> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionStopResult(int i, Status status, List<Session> list) {
        this.f1292a = i;
        this.b = status;
        this.c = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List<Session> list) {
        this.f1292a = 3;
        this.b = status;
        this.c = Collections.unmodifiableList(list);
    }

    public static SessionStopResult a(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean a(SessionStopResult sessionStopResult) {
        return this.b.equals(sessionStopResult.b) && zzw.a(this.c, sessionStopResult.c);
    }

    public List<Session> a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1292a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && a((SessionStopResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.b).a("sessions", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
