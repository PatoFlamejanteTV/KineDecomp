package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class WalletObjectMessage implements SafeParcelable {
    public static final Parcelable.Creator<WalletObjectMessage> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    String f2323a;
    String b;
    TimeInterval c;
    UriData d;
    UriData e;
    private final int f;

    WalletObjectMessage() {
        this.f = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletObjectMessage(int i, String str, String str2, TimeInterval timeInterval, UriData uriData, UriData uriData2) {
        this.f = i;
        this.f2323a = str;
        this.b = str2;
        this.c = timeInterval;
        this.d = uriData;
        this.e = uriData2;
    }

    public int a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
