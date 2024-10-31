package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionMapper.java */
/* renamed from: com.facebook.internal.i */
/* loaded from: classes.dex */
public class C0739i implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a */
    final /* synthetic */ Mutable f9314a;

    /* renamed from: b */
    final /* synthetic */ Mutable f9315b;

    /* renamed from: c */
    final /* synthetic */ CollectionMapper.OnMapperCompleteListener f9316c;

    public C0739i(Mutable mutable, Mutable mutable2, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        this.f9314a = mutable;
        this.f9315b = mutable2;
        this.f9316c = onMapperCompleteListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        if (((Boolean) this.f9314a.value).booleanValue()) {
            return;
        }
        Mutable mutable = this.f9315b;
        ?? valueOf = Integer.valueOf(((Integer) mutable.value).intValue() - 1);
        mutable.value = valueOf;
        if (valueOf.intValue() == 0) {
            this.f9316c.onComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Boolean] */
    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        if (((Boolean) this.f9314a.value).booleanValue()) {
            return;
        }
        this.f9314a.value = true;
        this.f9316c.onError(facebookException);
    }
}
