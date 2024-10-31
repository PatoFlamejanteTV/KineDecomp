package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class EventParcel implements SafeParcelable {
    public static final zzj CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final int f2020a;
    public final String b;
    public final EventParams c;
    public final String d;
    public final long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.f2020a = i;
        this.b = str;
        this.c = eventParams;
        this.d = str2;
        this.e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.f2020a = 1;
        this.b = str;
        this.c = eventParams;
        this.d = str2;
        this.e = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "origin=" + this.d + ",name=" + this.b + ",params=" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
