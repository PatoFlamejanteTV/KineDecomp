package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionMapper.java */
/* renamed from: com.facebook.internal.j */
/* loaded from: classes.dex */
public class C0740j implements CollectionMapper.OnMapValueCompleteListener {

    /* renamed from: a */
    final /* synthetic */ CollectionMapper.Collection f9317a;

    /* renamed from: b */
    final /* synthetic */ Object f9318b;

    /* renamed from: c */
    final /* synthetic */ CollectionMapper.OnMapperCompleteListener f9319c;

    public C0740j(CollectionMapper.Collection collection, Object obj, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        this.f9317a = collection;
        this.f9318b = obj;
        this.f9319c = onMapperCompleteListener;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapValueCompleteListener
    public void onComplete(Object obj) {
        this.f9317a.set(this.f9318b, obj, this.f9319c);
        this.f9319c.onComplete();
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.f9319c.onError(facebookException);
    }
}
