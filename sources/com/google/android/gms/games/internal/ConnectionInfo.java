package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1314a;
    private final String b;
    private final int c;

    public ConnectionInfo(int i, String str, int i2) {
        this.f1314a = i;
        this.b = str;
        this.c = i2;
    }

    public int a() {
        return this.f1314a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.a(this, parcel, i);
    }
}
