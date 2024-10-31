package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class AppIdentifier implements SafeParcelable {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f2092a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppIdentifier(int i, String str) {
        this.f2092a = i;
        this.b = zzx.a(str, (Object) "Missing application identifier value");
    }

    public int a() {
        return this.f2092a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
