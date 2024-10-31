package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class j implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f381a;
    final /* synthetic */ JSONArray b;
    final /* synthetic */ ShareApi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, JSONArray jSONArray) {
        this.c = shareApi;
        this.f381a = onMapValueCompleteListener;
        this.b = jSONArray;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        this.f381a.onComplete(this.b);
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.f381a.onError(facebookException);
    }
}
