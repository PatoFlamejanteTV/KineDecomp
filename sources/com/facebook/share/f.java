package com.facebook.share;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareOpenGraphAction;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class f implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9483a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareOpenGraphAction f9484b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GraphRequest.Callback f9485c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9486d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ShareApi f9487e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ShareApi shareApi, Bundle bundle, ShareOpenGraphAction shareOpenGraphAction, GraphRequest.Callback callback, FacebookCallback facebookCallback) {
        this.f9487e = shareApi;
        this.f9483a = bundle;
        this.f9484b = shareOpenGraphAction;
        this.f9485c = callback;
        this.f9486d = facebookCallback;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        String graphPath;
        try {
            ShareApi.handleImagesOnAction(this.f9483a);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            graphPath = this.f9487e.getGraphPath(URLEncoder.encode(this.f9484b.getActionType(), "UTF-8"));
            new GraphRequest(currentAccessToken, graphPath, this.f9483a, HttpMethod.POST, this.f9485c).executeAsync();
        } catch (UnsupportedEncodingException e2) {
            ShareInternalUtility.invokeCallbackWithException(this.f9486d, e2);
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        ShareInternalUtility.invokeCallbackWithException(this.f9486d, facebookException);
    }
}
