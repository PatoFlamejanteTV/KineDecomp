package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class MessageType implements SafeParcelable {
    public static final Parcelable.Creator<MessageType> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f2112a;
    public final String b;
    public final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType(int i, String str, String str2) {
        this.f2112a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) obj;
        return zzw.a(this.b, messageType.b) && zzw.a(this.c, messageType.c);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return "namespace=" + this.b + ", type=" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
