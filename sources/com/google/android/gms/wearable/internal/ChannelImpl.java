package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;

/* loaded from: classes.dex */
public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    final int f2336a;
    private final String b;
    private final String c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelImpl(int i, String str, String str2, String str3) {
        this.f2336a = i;
        this.b = (String) com.google.android.gms.common.internal.zzx.a(str);
        this.c = (String) com.google.android.gms.common.internal.zzx.a(str2);
        this.d = (String) com.google.android.gms.common.internal.zzx.a(str3);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
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
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.b.equals(channelImpl.b) && com.google.android.gms.common.internal.zzw.a(channelImpl.c, this.c) && com.google.android.gms.common.internal.zzw.a(channelImpl.d, this.d) && channelImpl.f2336a == this.f2336a;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.f2336a + ", token='" + this.b + "', nodeId='" + this.c + "', path='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
