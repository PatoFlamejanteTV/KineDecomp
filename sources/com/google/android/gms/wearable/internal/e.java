package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes.dex */
final class e implements ChannelApi.ChannelListener {

    /* renamed from: a, reason: collision with root package name */
    private final String f2368a;
    private final ChannelApi.ChannelListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, ChannelApi.ChannelListener channelListener) {
        this.f2368a = (String) com.google.android.gms.common.internal.zzx.a(str);
        this.b = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzx.a(channelListener);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void a(Channel channel) {
        this.b.a(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void a(Channel channel, int i, int i2) {
        this.b.a(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void b(Channel channel, int i, int i2) {
        this.b.b(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void c(Channel channel, int i, int i2) {
        this.b.c(channel, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b.equals(eVar.b) && this.f2368a.equals(eVar.f2368a);
    }

    public int hashCode() {
        return (this.f2368a.hashCode() * 31) + this.b.hashCode();
    }
}
