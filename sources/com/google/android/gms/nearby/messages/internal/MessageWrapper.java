package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

/* loaded from: classes.dex */
public class MessageWrapper implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f2113a;
    public final Message b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageWrapper(int i, Message message) {
        this.f2113a = i;
        this.b = (Message) zzx.a(message);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzi zziVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageWrapper) {
            return zzw.a(this.b, ((MessageWrapper) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi zziVar = CREATOR;
        zzi.a(this, parcel, i);
    }
}
