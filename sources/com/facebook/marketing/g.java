package com.facebook.marketing;

import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.marketing.internal.Constants;
import com.facebook.marketing.internal.MarketingLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewIndexer.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9439a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9440b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewIndexer f9441c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ViewIndexer viewIndexer, String str, String str2) {
        this.f9441c = viewIndexer;
        this.f9439a = str;
        this.f9440b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        MarketingLogger marketingLogger;
        GraphRequest buildAppIndexingRequest;
        String str;
        String str2;
        String str3;
        MarketingLogger marketingLogger2;
        String str4;
        String applicationId = FacebookSdk.getApplicationId();
        String md5hash = Utility.md5hash(this.f9439a);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (md5hash != null) {
            str4 = this.f9441c.previousDigest;
            if (md5hash.equals(str4)) {
                return;
            }
        }
        marketingLogger = this.f9441c.logger;
        marketingLogger.logIndexingStart(this.f9440b);
        buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(this.f9439a, currentAccessToken, applicationId);
        if (buildAppIndexingRequest != null) {
            GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
            try {
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject == null) {
                    str2 = ViewIndexer.TAG;
                    Log.e(str2, "Error sending UI component tree to Facebook: " + executeAndWait.getError());
                    return;
                }
                if (jSONObject.has(GraphResponse.SUCCESS_KEY) && jSONObject.getString(GraphResponse.SUCCESS_KEY) == ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str3 = ViewIndexer.TAG;
                    Logger.log(loggingBehavior, str3, "Successfully send UI component tree to server");
                    this.f9441c.previousDigest = md5hash;
                    marketingLogger2 = this.f9441c.logger;
                    marketingLogger2.logIndexingComplete(this.f9440b);
                }
                if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                    CodelessActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                }
            } catch (JSONException e2) {
                str = ViewIndexer.TAG;
                Log.e(str, "Error decoding server response.", e2);
            }
        }
    }
}
