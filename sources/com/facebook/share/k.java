package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class k implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f9607a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONArray f9608b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ShareApi f9609c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, JSONArray jSONArray) {
        this.f9609c = shareApi;
        this.f9607a = onMapValueCompleteListener;
        this.f9608b = jSONArray;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        this.f9607a.onComplete(this.f9608b);
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.f9607a.onError(facebookException);
    }
}
