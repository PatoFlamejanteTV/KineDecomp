package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f2334a;
    private final String c;
    private final List<NodeParcelable> d;
    private final Object b = new Object();
    private Set<Node> e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.f2334a = i;
        this.c = str;
        this.d = list;
    }

    public String a() {
        return this.c;
    }

    public List<NodeParcelable> b() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
        if (this.f2334a != capabilityInfoParcelable.f2334a) {
            return false;
        }
        if (this.c == null ? capabilityInfoParcelable.c != null : !this.c.equals(capabilityInfoParcelable.c)) {
            return false;
        }
        if (this.d != null) {
            if (this.d.equals(capabilityInfoParcelable.d)) {
                return true;
            }
        } else if (capabilityInfoParcelable.d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.c != null ? this.c.hashCode() : 0) + (this.f2334a * 31)) * 31) + (this.d != null ? this.d.hashCode() : 0);
    }

    public String toString() {
        return "CapabilityInfo{" + this.c + ", " + this.d + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
