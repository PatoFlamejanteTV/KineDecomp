package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.ChannelApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements zzlm.zzb<ChannelApi.ChannelListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChannelEventParcelable f2378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ChannelEventParcelable channelEventParcelable) {
        this.f2378a = channelEventParcelable;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(ChannelApi.ChannelListener channelListener) {
        this.f2378a.a(channelListener);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
