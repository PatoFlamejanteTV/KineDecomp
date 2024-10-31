package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;

/* compiled from: CollectionMapper.java */
/* loaded from: classes.dex */
final class i implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mutable f289a;
    final /* synthetic */ Mutable b;
    final /* synthetic */ CollectionMapper.OnMapperCompleteListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Mutable mutable, Mutable mutable2, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        this.f289a = mutable;
        this.b = mutable2;
        this.c = onMapperCompleteListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Integer] */
    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        if (!((Boolean) this.f289a.value).booleanValue()) {
            Mutable mutable = this.b;
            ?? valueOf = Integer.valueOf(((Integer) this.b.value).intValue() - 1);
            mutable.value = valueOf;
            if (valueOf.intValue() == 0) {
                this.c.onComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Boolean] */
    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        if (!((Boolean) this.f289a.value).booleanValue()) {
            this.f289a.value = true;
            this.c.onError(facebookException);
        }
    }
}
