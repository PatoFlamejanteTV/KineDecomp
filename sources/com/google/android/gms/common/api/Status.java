package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class Status implements Result, SafeParcelable {
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;

    /* renamed from: a, reason: collision with root package name */
    public static final Status f979a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new zzd();

    public Status(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f = i;
        this.g = i2;
        this.h = str;
        this.i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String f() {
        return this.h != null ? this.h : CommonStatusCodes.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingIntent a() {
        return this.i;
    }

    public String b() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.g <= 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f == status.f && this.g == status.g && zzw.a(this.h, status.h) && zzw.a(this.i, status.i);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i);
    }

    public String toString() {
        return zzw.a(this).a("statusCode", f()).a("resolution", this.i).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
