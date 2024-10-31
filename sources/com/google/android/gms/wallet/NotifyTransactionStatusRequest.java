package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator<NotifyTransactionStatusRequest> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final int f2289a;
    String b;
    int c;
    String d;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    /* loaded from: classes.dex */
    public interface Status {

        /* loaded from: classes.dex */
        public interface Error {
        }
    }

    NotifyTransactionStatusRequest() {
        this.f2289a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotifyTransactionStatusRequest(int i, String str, int i2, String str2) {
        this.f2289a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
