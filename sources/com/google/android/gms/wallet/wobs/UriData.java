package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    String f2322a;
    String b;
    private final int c;

    UriData() {
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UriData(int i, String str, String str2) {
        this.c = i;
        this.f2322a = str;
        this.b = str2;
    }

    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
