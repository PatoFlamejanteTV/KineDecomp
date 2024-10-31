package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class TimeInterval implements SafeParcelable {
    public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    long f2321a;
    long b;
    private final int c;

    TimeInterval() {
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeInterval(int i, long j, long j2) {
        this.c = i;
        this.f2321a = j;
        this.b = j2;
    }

    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
