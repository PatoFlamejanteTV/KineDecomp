package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9210a = "com.facebook.appevents.m";

    /* renamed from: d, reason: collision with root package name */
    private static ScheduledFuture f9213d;

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f9211b = new f();

    /* renamed from: c, reason: collision with root package name */
    private static final ScheduledExecutorService f9212c = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: e, reason: collision with root package name */
    private static final Runnable f9214e = new g();

    public static Set<AccessTokenAppIdPair> e() {
        return f9211b.b();
    }

    public static void f() {
        f9212c.execute(new h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(FlushReason flushReason) {
        f9211b.a(n.a());
        try {
            w a2 = a(flushReason, f9211b);
            if (a2 != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, a2.f9227a);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, a2.f9228b);
                LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
            }
        } catch (Exception e2) {
            Log.w(f9210a, "Caught unexpected exception while flushing app events: ", e2);
        }
    }

    public static void a(FlushReason flushReason) {
        f9212c.execute(new i(flushReason));
    }

    public static void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        f9212c.execute(new j(accessTokenAppIdPair, appEvent));
    }

    private static w a(FlushReason flushReason, f fVar) {
        w wVar = new w();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : fVar.b()) {
            GraphRequest a2 = a(accessTokenAppIdPair, fVar.a(accessTokenAppIdPair), limitEventAndDataUsage, wVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, f9210a, "Flushing %d events due to %s.", Integer.valueOf(wVar.f9227a), flushReason.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((GraphRequest) it.next()).executeAndWait();
        }
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, y yVar, w wVar) {
        String str;
        String str2;
        FacebookRequestError error = graphResponse.getError();
        FlushResult flushResult = FlushResult.SUCCESS;
        if (error == null) {
            str = "Success";
        } else if (error.getErrorCode() == -1) {
            flushResult = FlushResult.NO_CONNECTIVITY;
            str = "Failed: No Connectivity";
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), error.toString());
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str2 = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException unused) {
                str2 = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, f9210a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str, str2);
        }
        yVar.a(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.getExecutor().execute(new l(accessTokenAppIdPair, yVar));
        }
        if (flushResult == FlushResult.SUCCESS || wVar.f9228b == FlushResult.NO_CONNECTIVITY) {
            return;
        }
        wVar.f9228b = flushResult;
    }

    private static GraphRequest a(AccessTokenAppIdPair accessTokenAppIdPair, y yVar, boolean z, w wVar) {
        String applicationId = accessTokenAppIdPair.getApplicationId();
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", applicationId), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String pushNotificationsRegistrationId = AppEventsLogger.getPushNotificationsRegistrationId();
        if (pushNotificationsRegistrationId != null) {
            parameters.putString("device_token", pushNotificationsRegistrationId);
        }
        newPostRequest.setParameters(parameters);
        int a2 = yVar.a(newPostRequest, FacebookSdk.getApplicationContext(), queryAppSettings != null ? queryAppSettings.supportsImplicitLogging() : false, z);
        if (a2 == 0) {
            return null;
        }
        wVar.f9227a += a2;
        newPostRequest.setCallback(new k(accessTokenAppIdPair, newPostRequest, yVar, wVar));
        return newPostRequest;
    }
}
