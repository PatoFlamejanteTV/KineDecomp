package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* loaded from: classes.dex */
public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzba();

    /* renamed from: a, reason: collision with root package name */
    final int f2356a;
    private final int b;
    private final String c;
    private final byte[] d;
    private final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.f2356a = i;
        this.b = i2;
        this.c = str;
        this.d = bArr;
        this.e = str2;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public byte[] c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.b + "," + this.c + ", size=" + (this.d == null ? "null" : Integer.valueOf(this.d.length)) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzba.a(this, parcel, i);
    }
}
