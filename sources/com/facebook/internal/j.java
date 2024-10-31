package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.WebDialog;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class J implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f9297a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f9298b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f9299c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WebDialog.b f9300d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(WebDialog.b bVar, String[] strArr, int i, CountDownLatch countDownLatch) {
        this.f9300d = bVar;
        this.f9297a = strArr;
        this.f9298b = i;
        this.f9299c = countDownLatch;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        Exception[] excArr;
        FacebookRequestError error;
        try {
            error = graphResponse.getError();
        } catch (Exception e2) {
            excArr = this.f9300d.f9307c;
            excArr[this.f9298b] = e2;
        }
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "Error staging photo.";
            }
            throw new FacebookGraphResponseException(graphResponse, errorMessage);
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null) {
            String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
            if (optString != null) {
                this.f9297a[this.f9298b] = optString;
                this.f9299c.countDown();
                return;
            }
            throw new FacebookException("Error staging photo.");
        }
        throw new FacebookException("Error staging photo.");
    }
}
