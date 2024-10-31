package com.facebook.share;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class c implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f9473a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9474b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GraphRequest.Callback f9475c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f9476d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ShareApi f9477e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ShareApi shareApi, JSONObject jSONObject, String str, GraphRequest.Callback callback, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        this.f9477e = shareApi;
        this.f9473a = jSONObject;
        this.f9474b = str;
        this.f9475c = callback;
        this.f9476d = onMapValueCompleteListener;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        String graphPath;
        String jSONObject = this.f9473a.toString();
        Bundle bundle = new Bundle();
        bundle.putString("object", jSONObject);
        try {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            graphPath = this.f9477e.getGraphPath("objects/" + URLEncoder.encode(this.f9474b, "UTF-8"));
            new GraphRequest(currentAccessToken, graphPath, bundle, HttpMethod.POST, this.f9475c).executeAsync();
        } catch (UnsupportedEncodingException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging Open Graph object.";
            }
            this.f9476d.onError(new FacebookException(localizedMessage));
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.f9476d.onError(facebookException);
    }
}
