package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class ClientIdentity implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final int f1851a;
    public final String b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientIdentity(int i, int i2, String str) {
        this.c = i;
        this.f1851a = i2;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f1851a == this.f1851a && zzw.a(clientIdentity.b, this.b);
    }

    public int hashCode() {
        return this.f1851a;
    }

    public String toString() {
        return String.format("%d:%s", Integer.valueOf(this.f1851a), this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
