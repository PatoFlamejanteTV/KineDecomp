package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.NodeApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements zzlm.zzb<NodeApi.NodeListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NodeParcelable f2376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NodeParcelable nodeParcelable) {
        this.f2376a = nodeParcelable;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(NodeApi.NodeListener nodeListener) {
        nodeListener.b(this.f2376a);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
