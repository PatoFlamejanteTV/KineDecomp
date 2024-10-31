package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.MessageApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements zzlm.zzb<MessageApi.MessageListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MessageEventParcelable f2374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MessageEventParcelable messageEventParcelable) {
        this.f2374a = messageEventParcelable;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(MessageApi.MessageListener messageListener) {
        messageListener.a(this.f2374a);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
