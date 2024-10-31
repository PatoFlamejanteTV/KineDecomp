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
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class c implements CollectionMapper.OnMapperCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f338a;
    final /* synthetic */ String b;
    final /* synthetic */ GraphRequest.Callback c;
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener d;
    final /* synthetic */ ShareApi e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ShareApi shareApi, JSONObject jSONObject, String str, GraphRequest.Callback callback, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        this.e = shareApi;
        this.f338a = jSONObject;
        this.b = str;
        this.c = callback;
        this.d = onMapValueCompleteListener;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        String graphPath;
        String jSONObject = this.f338a.toString();
        Bundle bundle = new Bundle();
        bundle.putString("object", jSONObject);
        try {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            graphPath = this.e.getGraphPath("objects/" + URLEncoder.encode(this.b, Keyczar.DEFAULT_ENCODING));
            new GraphRequest(currentAccessToken, graphPath, bundle, HttpMethod.POST, this.c).executeAsync();
        } catch (UnsupportedEncodingException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging Open Graph object.";
            }
            this.d.onError(new FacebookException(localizedMessage));
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.d.onError(facebookException);
    }
}
