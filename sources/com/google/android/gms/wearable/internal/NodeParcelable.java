package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

/* loaded from: classes.dex */
public class NodeParcelable implements SafeParcelable, Node {
    public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbc();

    /* renamed from: a, reason: collision with root package name */
    final int f2357a;
    private final String b;
    private final String c;
    private final int d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.f2357a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = z;
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

    public boolean d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NodeParcelable) {
            return ((NodeParcelable) obj).b.equals(this.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Node{" + this.c + ", id=" + this.b + ", hops=" + this.d + ", isNearby=" + this.e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbc.a(this, parcel, i);
    }
}
