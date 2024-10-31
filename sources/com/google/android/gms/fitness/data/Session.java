package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Session implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    private final int f1230a;
    private final long b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final Application h;
    private final Long i;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private long f1231a = 0;
        private long b = 0;
        private String c = null;
        private int d = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session(int i, long j, long j2, String str, String str2, String str3, int i2, Application application, Long l) {
        this.f1230a = i;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = i2;
        this.h = application;
        this.i = l;
    }

    private boolean a(Session session) {
        return this.b == session.b && this.c == session.c && zzw.a(this.d, session.d) && zzw.a(this.e, session.e) && zzw.a(this.f, session.f) && zzw.a(this.h, session.h) && this.g == session.g;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.MILLISECONDS);
    }

    public boolean a() {
        return this.c == 0;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && a((Session) obj));
    }

    public Application f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1230a;
    }

    public long h() {
        return this.b;
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c), this.e);
    }

    public long i() {
        return this.c;
    }

    public Long j() {
        return this.i;
    }

    public String toString() {
        return zzw.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("name", this.d).a("identifier", this.e).a("description", this.f).a("activity", Integer.valueOf(this.g)).a("application", this.h).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.a(this, parcel, i);
    }
}
