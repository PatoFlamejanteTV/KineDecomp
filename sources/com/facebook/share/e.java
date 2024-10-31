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
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class e implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f340a;
    final /* synthetic */ ShareOpenGraphAction b;
    final /* synthetic */ GraphRequest.Callback c;
    final /* synthetic */ FacebookCallback d;
    final /* synthetic */ ShareApi e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ShareApi shareApi, Bundle bundle, ShareOpenGraphAction shareOpenGraphAction, GraphRequest.Callback callback, FacebookCallback facebookCallback) {
        this.e = shareApi;
        this.f340a = bundle;
        this.b = shareOpenGraphAction;
        this.c = callback;
        this.d = facebookCallback;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        String graphPath;
        try {
            ShareApi.handleImagesOnAction(this.f340a);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            graphPath = this.e.getGraphPath(URLEncoder.encode(this.b.getActionType(), Keyczar.DEFAULT_ENCODING));
            new GraphRequest(currentAccessToken, graphPath, this.f340a, HttpMethod.POST, this.c).executeAsync();
        } catch (UnsupportedEncodingException e) {
            ShareInternalUtility.invokeCallbackWithException(this.d, e);
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        ShareInternalUtility.invokeCallbackWithException(this.d, facebookException);
    }
}
