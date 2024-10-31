package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;

/* compiled from: CollectionMapper.java */
/* loaded from: classes.dex */
final class j implements CollectionMapper.OnMapValueCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.Collection f290a;
    final /* synthetic */ Object b;
    final /* synthetic */ CollectionMapper.OnMapperCompleteListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(CollectionMapper.Collection collection, Object obj, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        this.f290a = collection;
        this.b = obj;
        this.c = onMapperCompleteListener;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapValueCompleteListener
    public void onComplete(Object obj) {
        this.f290a.set(this.b, obj, this.c);
        this.c.onComplete();
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.c.onError(facebookException);
    }
}
