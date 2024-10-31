package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f978a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i, String str) {
        zzx.a(str, (Object) "scopeUri must not be null or empty");
        this.f978a = i;
        this.b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.b.equals(((Scope) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
