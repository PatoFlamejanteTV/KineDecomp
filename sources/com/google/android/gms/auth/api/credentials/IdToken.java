package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class IdToken implements SafeParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f791a;
    private final String b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdToken(int i, String str, String str2) {
        this.f791a = i;
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
