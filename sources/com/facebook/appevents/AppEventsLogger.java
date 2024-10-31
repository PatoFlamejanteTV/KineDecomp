package com.facebook.appevents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static String anonymousAppDeviceGUID;
    private static Context applicationContext;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByApplink;
    private static boolean requestInFlight;
    private static String sourceApplication;
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static Map<AccessTokenAppIdPair, d> stateMap = new ConcurrentHashMap();
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static Object staticLock = new Object();

    /* loaded from: classes.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum FlushReason {
        EXPLICIT,
        TIMER,
        SESSION_CHANGE,
        PERSISTED_EVENTS,
        EVENT_THRESHOLD,
        EAGER_FLUSHING_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum FlushResult {
        SUCCESS,
        SERVER_ERROR,
        NO_CONNECTIVITY,
        UNKNOWN_ERROR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AccessTokenAppIdPair implements Serializable {
        private static final long serialVersionUID = 1;
        private final String accessTokenString;
        private final String applicationId;

        AccessTokenAppIdPair(AccessToken accessToken) {
            this(accessToken.getToken(), FacebookSdk.getApplicationId());
        }

        AccessTokenAppIdPair(String str, String str2) {
            this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
            this.applicationId = str2;
        }

        String getAccessTokenString() {
            return this.accessTokenString;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getApplicationId() {
            return this.applicationId;
        }

        public int hashCode() {
            return (this.accessTokenString == null ? 0 : this.accessTokenString.hashCode()) ^ (this.applicationId != null ? this.applicationId.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AccessTokenAppIdPair)) {
                return false;
            }
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            return Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId);
        }

        /* loaded from: classes.dex */
        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final String accessTokenString;
            private final String appId;

            /* synthetic */ SerializationProxyV1(String str, String str2, com.facebook.appevents.a aVar) {
                this(str, str2);
            }

            private SerializationProxyV1(String str, String str2) {
                this.accessTokenString = str;
                this.appId = str2;
            }

            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.accessTokenString, this.applicationId, null);
        }
    }

    public static void activateApp(Context context) {
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void activateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        if (context instanceof Activity) {
            setSourceApplication((Activity) context);
        } else {
            resetSourceApplication();
            Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
        FacebookSdk.publishInstallAsync(context, str);
        backgroundExecutor.execute(new com.facebook.appevents.a(new AppEventsLogger(context, str, null), System.currentTimeMillis(), getSourceApplication()));
    }

    public static void deactivateApp(Context context) {
        deactivateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void deactivateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        resetSourceApplication();
        backgroundExecutor.execute(new com.facebook.appevents.b(new AppEventsLogger(context, str, null), System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppSessionResumeEvent(long j, String str) {
        b.a(applicationContext, this.accessTokenAppId, this, j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppSessionSuspendEvent(long j) {
        b.a(applicationContext, this.accessTokenAppId, this, j);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, null, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public void logEvent(String str) {
        logEvent(str, (Bundle) null);
    }

    public void logEvent(String str, double d2) {
        logEvent(str, d2, (Bundle) null);
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false);
    }

    public void logEvent(String str, double d2, Bundle bundle) {
        logEvent(str, Double.valueOf(d2), bundle, false);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        logPurchase(bigDecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
        logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, bigDecimal.doubleValue(), bundle);
        eagerFlush();
    }

    public void flush() {
        flush(FlushReason.EXPLICIT);
    }

    public static void onContextStop() {
        c.a(applicationContext, stateMap);
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
    }

    public void logSdkEvent(String str, Double d2, Bundle bundle) {
        logEvent(str, d2, bundle, true);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        Validate.notNull(context, "context");
        this.contextName = Utility.getActivityName(context);
        accessToken = accessToken == null ? AccessToken.getCurrentAccessToken() : accessToken;
        if (accessToken != null && (str == null || str.equals(accessToken.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str == null ? Utility.getMetadataApplicationId(context) : str);
        }
        synchronized (staticLock) {
            if (applicationContext == null) {
                applicationContext = context.getApplicationContext();
            }
        }
        initializeTimersIfNeeded();
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                backgroundExecutor.scheduleAtFixedRate(new com.facebook.appevents.c(), 0L, 15L, TimeUnit.SECONDS);
                backgroundExecutor.scheduleAtFixedRate(new com.facebook.appevents.d(), 0L, 86400L, TimeUnit.SECONDS);
            }
        }
    }

    private void logEvent(String str, Double d2, Bundle bundle, boolean z) {
        logEvent(applicationContext, new AppEvent(this.contextName, str, d2, bundle, z), this.accessTokenAppId);
    }

    private static void logEvent(Context context, AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        FacebookSdk.getExecutor().execute(new e(context, accessTokenAppIdPair, appEvent));
        if (!appEvent.isImplicit && !isActivateAppEventRequested) {
            if (appEvent.getName() == AppEventsConstants.EVENT_NAME_ACTIVATED_APP) {
                isActivateAppEventRequested = true;
            } else {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flushIfNecessary() {
        synchronized (staticLock) {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > 100) {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
    }

    private static int getAccumulatedEventCount() {
        int i;
        synchronized (staticLock) {
            Iterator<d> it = stateMap.values().iterator();
            i = 0;
            while (it.hasNext()) {
                i = it.next().a() + i;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d getSessionEventsState(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
        d dVar;
        AttributionIdentifiers attributionIdentifiers = null;
        if (stateMap.get(accessTokenAppIdPair) == null) {
            attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        }
        synchronized (staticLock) {
            dVar = stateMap.get(accessTokenAppIdPair);
            if (dVar == null) {
                dVar = new d(attributionIdentifiers, context.getPackageName(), getAnonymousAppDeviceGUID(context));
                stateMap.put(accessTokenAppIdPair, dVar);
            }
        }
        return dVar;
    }

    private static d getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        d dVar;
        synchronized (staticLock) {
            dVar = stateMap.get(accessTokenAppIdPair);
        }
        return dVar;
    }

    private static void flush(FlushReason flushReason) {
        FacebookSdk.getExecutor().execute(new f(flushReason));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flushAndWait(FlushReason flushReason) {
        synchronized (staticLock) {
            if (!requestInFlight) {
                requestInFlight = true;
                HashSet hashSet = new HashSet(stateMap.keySet());
                accumulatePersistedEvents();
                a aVar = null;
                try {
                    aVar = buildAndExecuteRequests(flushReason, hashSet);
                } catch (Exception e) {
                    Utility.logd(TAG, "Caught unexpected exception while flushing: ", e);
                }
                synchronized (staticLock) {
                    requestInFlight = false;
                }
                if (aVar != null) {
                    Intent intent = new Intent(ACTION_APP_EVENTS_FLUSHED);
                    intent.putExtra(APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, aVar.f247a);
                    intent.putExtra(APP_EVENTS_EXTRA_FLUSH_RESULT, aVar.b);
                    android.support.v4.a.f.a(applicationContext).a(intent);
                }
            }
        }
    }

    private static a buildAndExecuteRequests(FlushReason flushReason, Set<AccessTokenAppIdPair> set) {
        GraphRequest buildRequestForSession;
        a aVar = new a(null);
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(applicationContext);
        ArrayList arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
            d sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null && (buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, aVar)) != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(aVar.f247a), flushReason.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((GraphRequest) it.next()).executeAndWait();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f247a;
        public FlushResult b;

        private a() {
            this.f247a = 0;
            this.b = FlushResult.SUCCESS;
        }

        /* synthetic */ a(com.facebook.appevents.a aVar) {
            this();
        }
    }

    private static GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppIdPair, d dVar, boolean z, a aVar) {
        int a2;
        String applicationId = accessTokenAppIdPair.getApplicationId();
        Utility.FetchedAppSettings queryAppSettings = Utility.queryAppSettings(applicationId, false);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", applicationId), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        newPostRequest.setParameters(parameters);
        if (queryAppSettings != null && (a2 = dVar.a(newPostRequest, queryAppSettings.supportsImplicitLogging(), z)) != 0) {
            aVar.f247a = a2 + aVar.f247a;
            newPostRequest.setCallback(new g(accessTokenAppIdPair, newPostRequest, dVar, aVar));
            return newPostRequest;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, d dVar, a aVar) {
        String str;
        FlushResult flushResult;
        String str2;
        FacebookRequestError error = graphResponse.getError();
        FlushResult flushResult2 = FlushResult.SUCCESS;
        if (error == null) {
            str = "Success";
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            str = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), error.toString());
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str2 = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException e) {
                str2 = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str, str2);
        }
        dVar.a(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            c.a(applicationContext, accessTokenAppIdPair, dVar);
        }
        if (flushResult != FlushResult.SUCCESS && aVar.b != FlushResult.NO_CONNECTIVITY) {
            aVar.b = flushResult;
        }
    }

    private static int accumulatePersistedEvents() {
        c a2 = c.a(applicationContext);
        int i = 0;
        Iterator<AccessTokenAppIdPair> it = a2.a().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                AccessTokenAppIdPair next = it.next();
                d sessionEventsState = getSessionEventsState(applicationContext, next);
                List<AppEvent> a3 = a2.a(next);
                sessionEventsState.a(a3);
                i = a3.size() + i2;
            } else {
                return i2;
            }
        }
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    private static void setSourceApplication(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            return;
        }
        Bundle a2 = a.c.a(intent);
        if (a2 == null) {
            resetSourceApplication();
            return;
        }
        isOpenedByApplink = true;
        Bundle bundle = a2.getBundle("referer_app_link");
        if (bundle == null) {
            sourceApplication = null;
        } else {
            sourceApplication = bundle.getString("package");
            intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
        }
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByApplink = z;
    }

    static String getSourceApplication() {
        String str = "Unclassified";
        if (isOpenedByApplink) {
            str = "Applink";
        }
        if (sourceApplication != null) {
            return str + "(" + sourceApplication + ")";
        }
        return str;
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByApplink = false;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                if (anonymousAppDeviceGUID == null) {
                    anonymousAppDeviceGUID = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                    if (anonymousAppDeviceGUID == null) {
                        anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                    }
                }
            }
        }
        return anonymousAppDeviceGUID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        private int c;
        private AttributionIdentifiers d;
        private String e;
        private String f;

        /* renamed from: a, reason: collision with root package name */
        private List<AppEvent> f250a = new ArrayList();
        private List<AppEvent> b = new ArrayList();
        private final int g = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;

        public d(AttributionIdentifiers attributionIdentifiers, String str, String str2) {
            this.d = attributionIdentifiers;
            this.e = str;
            this.f = str2;
        }

        public synchronized void a(AppEvent appEvent) {
            if (this.f250a.size() + this.b.size() >= 1000) {
                this.c++;
            } else {
                this.f250a.add(appEvent);
            }
        }

        public synchronized int a() {
            return this.f250a.size();
        }

        public synchronized void a(boolean z) {
            if (z) {
                this.f250a.addAll(this.b);
            }
            this.b.clear();
            this.c = 0;
        }

        public int a(GraphRequest graphRequest, boolean z, boolean z2) {
            synchronized (this) {
                int i = this.c;
                this.b.addAll(this.f250a);
                this.f250a.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.b) {
                    if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                a(graphRequest, i, jSONArray, z2);
                return jSONArray.length();
            }
        }

        public synchronized List<AppEvent> b() {
            List<AppEvent> list;
            list = this.f250a;
            this.f250a = new ArrayList();
            return list;
        }

        public synchronized void a(List<AppEvent> list) {
            this.f250a.addAll(list);
        }

        private void a(GraphRequest graphRequest, int i, JSONArray jSONArray, boolean z) {
            JSONObject jSONObject;
            try {
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.d, this.f, z, AppEventsLogger.applicationContext);
                if (this.c > 0) {
                    jSONObject.put("num_skipped_events", i);
                }
            } catch (JSONException e) {
                jSONObject = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObject);
            Bundle parameters = graphRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                parameters.putByteArray("custom_events_file", a(jSONArray2));
                graphRequest.setTag(jSONArray2);
            }
            graphRequest.setParameters(parameters);
        }

        private byte[] a(String str) {
            try {
                return str.getBytes(Keyczar.DEFAULT_ENCODING);
            } catch (UnsupportedEncodingException e) {
                Utility.logd("Encoding exception: ", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AppEvent implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final HashSet<String> f246a = new HashSet<>();
        private static final long serialVersionUID = 1;
        private boolean isImplicit;
        private JSONObject jsonObject;
        private String name;

        /* synthetic */ AppEvent(String str, boolean z, com.facebook.appevents.a aVar) throws JSONException {
            this(str, z);
        }

        public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z) {
            try {
                a(str2);
                this.name = str2;
                this.isImplicit = z;
                this.jsonObject = new JSONObject();
                this.jsonObject.put("_eventName", str2);
                this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000);
                this.jsonObject.put("_ui", str);
                if (d != null) {
                    this.jsonObject.put("_valueToSum", d.doubleValue());
                }
                if (this.isImplicit) {
                    this.jsonObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (bundle != null) {
                    for (String str3 : bundle.keySet()) {
                        a(str3);
                        Object obj = bundle.get(str3);
                        if (!(obj instanceof String) && !(obj instanceof Number)) {
                            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                        }
                        this.jsonObject.put(str3, obj.toString());
                    }
                }
                if (!this.isImplicit) {
                    Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
                }
            } catch (FacebookException e) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", e.toString());
                this.jsonObject = null;
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e2.toString());
                this.jsonObject = null;
            }
        }

        public String getName() {
            return this.name;
        }

        private AppEvent(String str, boolean z) throws JSONException {
            this.jsonObject = new JSONObject(str);
            this.isImplicit = z;
        }

        public boolean getIsImplicit() {
            return this.isImplicit;
        }

        public JSONObject getJSONObject() {
            return this.jsonObject;
        }

        private void a(String str) throws FacebookException {
            boolean contains;
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
            }
            synchronized (f246a) {
                contains = f246a.contains(str);
            }
            if (!contains) {
                if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                    synchronized (f246a) {
                        f246a.add(str);
                    }
                    return;
                }
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
            }
        }

        /* loaded from: classes.dex */
        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final boolean isImplicit;
            private final String jsonString;

            /* synthetic */ SerializationProxyV1(String str, boolean z, com.facebook.appevents.a aVar) {
                this(str, z);
            }

            private SerializationProxyV1(String str, boolean z) {
                this.jsonString = str;
                this.isImplicit = z;
            }

            private Object readResolve() throws JSONException {
                return new AppEvent(this.jsonString, this.isImplicit, null);
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.jsonObject.toString(), this.isImplicit, null);
        }

        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> d;

        /* renamed from: a, reason: collision with root package name */
        private static final Object f248a = new Object();
        private static boolean b = false;
        private static boolean c = false;
        private static final Runnable e = new h();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v9 */
        private static void b(Context context) {
            ObjectInputStream objectInputStream;
            Exception e2;
            Closeable closeable = null;
            synchronized (f248a) {
                ?? r1 = c;
                try {
                    if (r1 == 0) {
                        try {
                            objectInputStream = new ObjectInputStream(context.openFileInput("AppEventsLogger.persistedsessioninfo"));
                        } catch (FileNotFoundException e3) {
                        } catch (Exception e4) {
                            objectInputStream = null;
                            e2 = e4;
                        } catch (Throwable th) {
                            r1 = 0;
                            th = th;
                            Utility.closeQuietly(r1);
                            context.deleteFile("AppEventsLogger.persistedsessioninfo");
                            if (d == null) {
                                d = new HashMap();
                            }
                            c = true;
                            b = false;
                            throw th;
                        }
                        try {
                            d = (HashMap) objectInputStream.readObject();
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
                            Utility.closeQuietly(objectInputStream);
                            context.deleteFile("AppEventsLogger.persistedsessioninfo");
                            if (d == null) {
                                d = new HashMap();
                            }
                            c = true;
                            b = false;
                            r1 = objectInputStream;
                        } catch (FileNotFoundException e5) {
                            closeable = objectInputStream;
                            Utility.closeQuietly(closeable);
                            context.deleteFile("AppEventsLogger.persistedsessioninfo");
                            if (d == null) {
                                d = new HashMap();
                            }
                            c = true;
                            b = false;
                        } catch (Exception e6) {
                            e2 = e6;
                            Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e2.toString());
                            Utility.closeQuietly(objectInputStream);
                            context.deleteFile("AppEventsLogger.persistedsessioninfo");
                            if (d == null) {
                                d = new HashMap();
                            }
                            c = true;
                            b = false;
                            r1 = objectInputStream;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(Context context) {
            ObjectOutputStream objectOutputStream;
            synchronized (f248a) {
                if (b) {
                    try {
                        objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
                    } catch (Exception e2) {
                        e = e2;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = null;
                        Utility.closeQuietly(objectOutputStream);
                        throw th;
                    }
                    try {
                        try {
                            objectOutputStream.writeObject(d);
                            b = false;
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                            Utility.closeQuietly(objectOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            Utility.closeQuietly(objectOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    }
                }
            }
        }

        static void a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (f248a) {
                a(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                a();
            }
        }

        static void a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (f248a) {
                a(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                a();
            }
        }

        private static FacebookTimeSpentData a(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            b(context);
            FacebookTimeSpentData facebookTimeSpentData = d.get(accessTokenAppIdPair);
            if (facebookTimeSpentData == null) {
                FacebookTimeSpentData facebookTimeSpentData2 = new FacebookTimeSpentData();
                d.put(accessTokenAppIdPair, facebookTimeSpentData2);
                return facebookTimeSpentData2;
            }
            return facebookTimeSpentData;
        }

        private static void a() {
            if (!b) {
                b = true;
                AppEventsLogger.backgroundExecutor.schedule(e, 30L, TimeUnit.SECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static Object f249a = new Object();
        private Context b;
        private HashMap<AccessTokenAppIdPair, List<AppEvent>> c = new HashMap<>();

        private c(Context context) {
            this.b = context;
        }

        public static c a(Context context) {
            c cVar;
            synchronized (f249a) {
                cVar = new c(context);
                cVar.c();
            }
            return cVar;
        }

        public static void a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, d dVar) {
            HashMap hashMap = new HashMap();
            hashMap.put(accessTokenAppIdPair, dVar);
            a(context, hashMap);
        }

        public static void a(Context context, Map<AccessTokenAppIdPair, d> map) {
            synchronized (f249a) {
                c a2 = a(context);
                for (Map.Entry<AccessTokenAppIdPair, d> entry : map.entrySet()) {
                    List<AppEvent> b = entry.getValue().b();
                    if (b.size() != 0) {
                        a2.a(entry.getKey(), b);
                    }
                }
                a2.b();
            }
        }

        public Set<AccessTokenAppIdPair> a() {
            return this.c.keySet();
        }

        public List<AppEvent> a(AccessTokenAppIdPair accessTokenAppIdPair) {
            return this.c.get(accessTokenAppIdPair);
        }

        private void b() {
            ObjectOutputStream objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(this.b.openFileOutput("AppEventsLogger.persistedevents", 0)));
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.c);
                    Utility.closeQuietly(objectOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    Utility.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectOutputStream);
            }
        }

        private void c() {
            ObjectInputStream objectInputStream;
            Throwable th;
            Exception e;
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(this.b.openFileInput("AppEventsLogger.persistedevents")));
                } catch (FileNotFoundException e2) {
                } catch (Exception e3) {
                    objectInputStream = null;
                    e = e3;
                } catch (Throwable th2) {
                    objectInputStream = null;
                    th = th2;
                    Utility.closeQuietly(objectInputStream);
                    throw th;
                }
                try {
                    HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap = (HashMap) objectInputStream.readObject();
                    this.b.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    this.c = hashMap;
                    Utility.closeQuietly(objectInputStream);
                } catch (FileNotFoundException e4) {
                    objectInputStream2 = objectInputStream;
                    Utility.closeQuietly(objectInputStream2);
                } catch (Exception e5) {
                    e = e5;
                    Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                    Utility.closeQuietly(objectInputStream);
                }
            } catch (Throwable th3) {
                th = th3;
                Utility.closeQuietly(objectInputStream);
                throw th;
            }
        }

        public void a(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
            if (!this.c.containsKey(accessTokenAppIdPair)) {
                this.c.put(accessTokenAppIdPair, new ArrayList());
            }
            this.c.get(accessTokenAppIdPair).addAll(list);
        }
    }
}
