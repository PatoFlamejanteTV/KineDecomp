package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.personalized.zzf;

/* loaded from: classes.dex */
public class TestDataImpl extends zzf implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1902a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TestDataImpl(int i, String str) {
        this.f1902a = i;
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TestDataImpl) {
            return this.b.equals(((TestDataImpl) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return zzw.a(this).a("testName", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.a(this, parcel, i);
    }
}
