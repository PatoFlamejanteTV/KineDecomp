package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class ApplicationStatus implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationStatus> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f844a;
    private String b;

    public ApplicationStatus() {
        this(1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationStatus(int i, String str) {
        this.f844a = i;
        this.b = str;
    }

    public int a() {
        return this.f844a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ApplicationStatus) {
            return zzf.a(this.b, ((ApplicationStatus) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
