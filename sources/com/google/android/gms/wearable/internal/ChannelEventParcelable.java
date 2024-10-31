package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes.dex */
public final class ChannelEventParcelable implements SafeParcelable {
    public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    final int f2335a;
    final ChannelImpl b;
    final int c;
    final int d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.f2335a = i;
        this.b = channelImpl;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    private static String a(int i) {
        switch (i) {
            case 1:
                return "CHANNEL_OPENED";
            case 2:
                return "CHANNEL_CLOSED";
            case 3:
                return "INPUT_CLOSED";
            case 4:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return "CLOSE_REASON_NORMAL";
            case 1:
                return "CLOSE_REASON_DISCONNECTED";
            case 2:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case 3:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public void a(ChannelApi.ChannelListener channelListener) {
        switch (this.c) {
            case 1:
                channelListener.a(this.b);
                return;
            case 2:
                channelListener.a(this.b, this.d, this.e);
                return;
            case 3:
                channelListener.b(this.b, this.d, this.e);
                return;
            case 4:
                channelListener.c(this.b, this.d, this.e);
                return;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.c);
                return;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.f2335a + ", channel=" + this.b + ", type=" + a(this.c) + ", closeReason=" + b(this.d) + ", appErrorCode=" + this.e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
