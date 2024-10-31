package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f1389a;
    private final byte[] b;
    private final int c;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RealTimeMessage(Parcel parcel, a aVar) {
        this(parcel);
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.f1389a = (String) zzx.a(str);
        this.b = (byte[]) ((byte[]) zzx.a(bArr)).clone();
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1389a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }
}
