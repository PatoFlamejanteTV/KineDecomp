package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class ConnectionConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f2325a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.f2325a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = i3;
        this.f = z;
        this.g = z2;
        this.h = str3;
        this.i = z3;
        this.j = str4;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return zzw.a(Integer.valueOf(this.f2325a), Integer.valueOf(connectionConfiguration.f2325a)) && zzw.a(this.b, connectionConfiguration.b) && zzw.a(this.c, connectionConfiguration.c) && zzw.a(Integer.valueOf(this.d), Integer.valueOf(connectionConfiguration.d)) && zzw.a(Integer.valueOf(this.e), Integer.valueOf(connectionConfiguration.e)) && zzw.a(Boolean.valueOf(this.f), Boolean.valueOf(connectionConfiguration.f)) && zzw.a(Boolean.valueOf(this.i), Boolean.valueOf(connectionConfiguration.i));
    }

    public String f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public String h() {
        return this.j;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f2325a), this.b, this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.i));
    }

    public boolean i() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        sb.append("mName=" + this.b);
        sb.append(", mAddress=" + this.c);
        sb.append(", mType=" + this.d);
        sb.append(", mRole=" + this.e);
        sb.append(", mEnabled=" + this.f);
        sb.append(", mIsConnected=" + this.g);
        sb.append(", mPeerNodeId=" + this.h);
        sb.append(", mBtlePriority=" + this.i);
        sb.append(", mNodeId=" + this.j);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
