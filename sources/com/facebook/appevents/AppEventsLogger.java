package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = "com.facebook.appevents.AppEventsLogger";
    private static String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByAppLink;
    private static String pushNotificationsRegistrationId;
    private static String sourceApplication;
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static Object staticLock = new Object();

    /* loaded from: classes.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* loaded from: classes.dex */
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    /* loaded from: classes.dex */
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }

    public static void activateApp(Application application) {
        activateApp(application, (String) null);
    }

    public static void augmentWebView(WebView webView, Context context) {
        String[] split = Build.VERSION.RELEASE.split("\\.");
        int parseInt = split.length > 0 ? Integer.parseInt(split[0]) : 0;
        int parseInt2 = split.length > 1 ? Integer.parseInt(split[1]) : 0;
        if (Build.VERSION.SDK_INT >= 17 && parseInt >= 4 && (parseInt != 4 || parseInt2 > 1)) {
            webView.addJavascriptInterface(new u(context), "fbmq_" + FacebookSdk.getApplicationId());
            return;
        }
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
    }

    public static void clearUserData() {
        UserDataStore.setUserDataAndHash(null);
    }

    public static void clearUserID() {
        d.b(null);
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
        } else {
            deactivateApp(context, Utility.getMetadataApplicationId(context));
        }
    }

    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            m.a(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getAnalyticsExecutor() {
        if (backgroundExecutor == null) {
            initializeTimersIfNeeded();
        }
        return backgroundExecutor;
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

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getPushNotificationsRegistrationId() {
        String str;
        synchronized (staticLock) {
            str = pushNotificationsRegistrationId;
        }
        return str;
    }

    static String getSourceApplication() {
        String str = isOpenedByAppLink ? "Applink" : "Unclassified";
        if (sourceApplication == null) {
            return str;
        }
        return str + "(" + sourceApplication + ")";
    }

    public static String getUserData() {
        return UserDataStore.getHashedUserData();
    }

    public static String getUserID() {
        return d.d();
    }

    public static void initializeLib(Context context, String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            backgroundExecutor.execute(new q(new AppEventsLogger(context, str, (AccessToken) null)));
        }
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor != null) {
                return;
            }
            backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            backgroundExecutor.scheduleAtFixedRate(new s(), 0L, 86400L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppSessionResumeEvent(long j, String str) {
        a.a(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppSessionSuspendEvent(long j) {
        a.a(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, (String) null, (AccessToken) null);
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    public static void onContextStop() {
        m.f();
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByAppLink = false;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public static void setPushNotificationsRegistrationId(String str) {
        synchronized (staticLock) {
            if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, str)) {
                pushNotificationsRegistrationId = str;
                AppEventsLogger newLogger = newLogger(FacebookSdk.getApplicationContext());
                newLogger.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    newLogger.flush();
                }
            }
        }
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
        if (intent != null && !intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            Bundle a2 = bolts.e.a(intent);
            if (a2 == null) {
                resetSourceApplication();
                return;
            }
            isOpenedByAppLink = true;
            Bundle bundle = a2.getBundle("referer_app_link");
            if (bundle == null) {
                sourceApplication = null;
                return;
            } else {
                sourceApplication = bundle.getString("package");
                intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
                return;
            }
        }
        resetSourceApplication();
    }

    public static void setUserData(Bundle bundle) {
        UserDataStore.setUserDataAndHash(bundle);
    }

    public static void setUserID(String str) {
        d.b(str);
    }

    public static void updateUserProperties(Bundle bundle, GraphRequest.Callback callback) {
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
    }

    public void flush() {
        m.a(FlushReason.EXPLICIT);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
    }

    public void logEvent(String str) {
        logEvent(str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        if (str == null) {
            notifyDeveloperError("itemID cannot be null");
            return;
        }
        if (productAvailability == null) {
            notifyDeveloperError("availability cannot be null");
            return;
        }
        if (productCondition == null) {
            notifyDeveloperError("condition cannot be null");
            return;
        }
        if (str2 == null) {
            notifyDeveloperError("description cannot be null");
            return;
        }
        if (str3 == null) {
            notifyDeveloperError("imageLink cannot be null");
            return;
        }
        if (str4 == null) {
            notifyDeveloperError("link cannot be null");
            return;
        }
        if (str5 == null) {
            notifyDeveloperError("title cannot be null");
            return;
        }
        if (bigDecimal == null) {
            notifyDeveloperError("priceAmount cannot be null");
            return;
        }
        if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        if (str6 == null && str7 == null && str8 == null) {
            notifyDeveloperError("Either gtin, mpn or brand is required");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
        bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
        if (str6 != null) {
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
        }
        if (str7 != null) {
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
        }
        if (str8 != null) {
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
        }
        logEvent(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
        eagerFlush();
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        logPurchase(bigDecimal, currency, null, false);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        String str;
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases";
        } else {
            str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. Please use logPurchase() function instead.";
        }
        Log.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        logPurchase(bigDecimal, currency, bundle, true);
    }

    public void logPushNotificationOpen(Bundle bundle) {
        logPushNotificationOpen(bundle, null);
    }

    public void logSdkEvent(String str, Double d2, Bundle bundle) {
        logEvent(str, d2, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public static void activateApp(Application application, String str) {
        if (FacebookSdk.isInitialized()) {
            d.e();
            UserDataStore.initStore();
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, (String) null, accessToken);
    }

    public void logEvent(String str, double d2) {
        logEvent(str, d2, null);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        String str2;
        String string;
        try {
            string = bundle.getString(PUSH_PAYLOAD_KEY);
        } catch (JSONException unused) {
            str2 = null;
        }
        if (Utility.isNullOrEmpty(string)) {
            return;
        }
        str2 = new JSONObject(string).getString(PUSH_PAYLOAD_CAMPAIGN_KEY);
        if (str2 == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, str2);
        if (str != null) {
            bundle2.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
        }
        logEvent(APP_EVENT_NAME_PUSH_OPENED, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppEventsLogger(String str, String str2, AccessToken accessToken) {
        Validate.sdkInitialized();
        this.contextName = str;
        accessToken = accessToken == null ? AccessToken.getCurrentAccessToken() : accessToken;
        if (AccessToken.isCurrentAccessTokenActive() && (str2 == null || str2.equals(accessToken.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2 == null ? Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext()) : str2);
        }
        initializeTimersIfNeeded();
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static void updateUserProperties(Bundle bundle, String str, GraphRequest.Callback callback) {
        getAnalyticsExecutor().execute(new r(bundle, str, callback));
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
            return;
        }
        if (context != null && str != null) {
            resetSourceApplication();
            backgroundExecutor.execute(new p(new AppEventsLogger(context, str, (AccessToken) null), System.currentTimeMillis()));
            return;
        }
        throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, (AccessToken) null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        logPurchase(bigDecimal, currency, bundle, false);
    }

    public void logEvent(String str, double d2, Bundle bundle) {
        logEvent(str, Double.valueOf(d2), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    private void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
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
        Bundle bundle2 = bundle;
        bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
        logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
        eagerFlush();
    }

    private void logEvent(String str, Double d2, Bundle bundle, boolean z, UUID uuid) {
        try {
            logEvent(new AppEvent(this.contextName, str, d2, bundle, z, uuid), this.accessTokenAppId);
        } catch (FacebookException e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
        } catch (JSONException e3) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e3.toString());
        }
    }

    @Deprecated
    public static void activateApp(Context context) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
        } else {
            FacebookSdk.sdkInitialize(context);
            activateApp(context, Utility.getMetadataApplicationId(context));
        }
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
            return;
        }
        if (context != null && str != null) {
            d.e();
            UserDataStore.initStore();
            if (context instanceof Activity) {
                setSourceApplication((Activity) context);
            } else {
                resetSourceApplication();
                Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
            }
            FacebookSdk.publishInstallAsync(context, str);
            backgroundExecutor.execute(new o(new AppEventsLogger(context, str, (AccessToken) null), System.currentTimeMillis(), getSourceApplication()));
            return;
        }
        throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> f9159d;

        /* renamed from: a, reason: collision with root package name */
        private static final Object f9156a = new Object();

        /* renamed from: b, reason: collision with root package name */
        private static boolean f9157b = false;

        /* renamed from: c, reason: collision with root package name */
        private static boolean f9158c = false;

        /* renamed from: e, reason: collision with root package name */
        private static final Runnable f9160e = new t();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
        public static void a(Context context) {
            synchronized (f9156a) {
                if (f9157b) {
                    ObjectOutputStream objectOutputStream = null;
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        try {
                            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
                            try {
                                objectOutputStream3.writeObject(f9159d);
                                f9157b = false;
                                ?? r1 = "AppEvents";
                                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                                Utility.closeQuietly(objectOutputStream3);
                                objectOutputStream = r1;
                            } catch (Exception e2) {
                                e = e2;
                                objectOutputStream2 = objectOutputStream3;
                                Log.w(AppEventsLogger.TAG, "Got unexpected exception while writing app session info: " + e.toString());
                                Utility.closeQuietly(objectOutputStream2);
                                objectOutputStream = objectOutputStream2;
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream3;
                                Utility.closeQuietly(objectOutputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0089 A[Catch: all -> 0x00ae, TryCatch #6 {, blocks: (B:4:0x0003, B:11:0x0026, B:13:0x0032, B:14:0x0039, B:16:0x003b, B:26:0x0066, B:28:0x0072, B:29:0x0079, B:32:0x007d, B:34:0x0089, B:35:0x0090, B:36:0x0094, B:20:0x0096, B:22:0x00a2, B:23:0x00a9, B:43:0x00ac), top: B:3:0x0003 }] */
        /* JADX WARN: Type inference failed for: r9v12, types: [java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData>] */
        /* JADX WARN: Type inference failed for: r9v14, types: [java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData>, java.util.HashMap] */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData>] */
        /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData>, java.util.HashMap] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void b(android.content.Context r9) {
            /*
                java.lang.Object r0 = com.facebook.appevents.AppEventsLogger.a.f9156a
                monitor-enter(r0)
                boolean r1 = com.facebook.appevents.AppEventsLogger.a.f9158c     // Catch: java.lang.Throwable -> Lae
                if (r1 != 0) goto Lac
                r1 = 0
                r2 = 1
                r3 = 0
                java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 java.io.FileNotFoundException -> L95
                java.lang.String r5 = "AppEventsLogger.persistedsessioninfo"
                java.io.FileInputStream r5 = r9.openFileInput(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 java.io.FileNotFoundException -> L95
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 java.io.FileNotFoundException -> L95
                java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L7c java.io.FileNotFoundException -> L96
                java.util.HashMap r3 = (java.util.HashMap) r3     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L7c java.io.FileNotFoundException -> L96
                com.facebook.appevents.AppEventsLogger.a.f9159d = r3     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L7c java.io.FileNotFoundException -> L96
                com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L7c java.io.FileNotFoundException -> L96
                java.lang.String r5 = "AppEvents"
                java.lang.String r6 = "App session info loaded"
                com.facebook.internal.Logger.log(r3, r5, r6)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L7c java.io.FileNotFoundException -> L96
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Lae
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r3)     // Catch: java.lang.Throwable -> Lae
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = com.facebook.appevents.AppEventsLogger.a.f9159d     // Catch: java.lang.Throwable -> Lae
                if (r9 != 0) goto L39
                java.util.HashMap r9 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lae
                r9.<init>()     // Catch: java.lang.Throwable -> Lae
                com.facebook.appevents.AppEventsLogger.a.f9159d = r9     // Catch: java.lang.Throwable -> Lae
            L39:
                com.facebook.appevents.AppEventsLogger.a.f9158c = r2     // Catch: java.lang.Throwable -> Lae
            L3b:
                com.facebook.appevents.AppEventsLogger.a.f9157b = r1     // Catch: java.lang.Throwable -> Lae
                goto Lac
            L3f:
                r3 = move-exception
                goto L4a
            L41:
                r4 = move-exception
                r8 = r4
                r4 = r3
                r3 = r8
                goto L7d
            L46:
                r4 = move-exception
                r8 = r4
                r4 = r3
                r3 = r8
            L4a:
                java.lang.String r5 = com.facebook.appevents.AppEventsLogger.access$200()     // Catch: java.lang.Throwable -> L7c
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
                r6.<init>()     // Catch: java.lang.Throwable -> L7c
                java.lang.String r7 = "Got unexpected exception restoring app session info: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L7c
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L7c
                r6.append(r3)     // Catch: java.lang.Throwable -> L7c
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L7c
                android.util.Log.w(r5, r3)     // Catch: java.lang.Throwable -> L7c
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Lae
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r3)     // Catch: java.lang.Throwable -> Lae
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = com.facebook.appevents.AppEventsLogger.a.f9159d     // Catch: java.lang.Throwable -> Lae
                if (r9 != 0) goto L79
                java.util.HashMap r9 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lae
                r9.<init>()     // Catch: java.lang.Throwable -> Lae
                com.facebook.appevents.AppEventsLogger.a.f9159d = r9     // Catch: java.lang.Throwable -> Lae
            L79:
                com.facebook.appevents.AppEventsLogger.a.f9158c = r2     // Catch: java.lang.Throwable -> Lae
                goto L3b
            L7c:
                r3 = move-exception
            L7d:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Lae
                java.lang.String r4 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r4)     // Catch: java.lang.Throwable -> Lae
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = com.facebook.appevents.AppEventsLogger.a.f9159d     // Catch: java.lang.Throwable -> Lae
                if (r9 != 0) goto L90
                java.util.HashMap r9 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lae
                r9.<init>()     // Catch: java.lang.Throwable -> Lae
                com.facebook.appevents.AppEventsLogger.a.f9159d = r9     // Catch: java.lang.Throwable -> Lae
            L90:
                com.facebook.appevents.AppEventsLogger.a.f9158c = r2     // Catch: java.lang.Throwable -> Lae
                com.facebook.appevents.AppEventsLogger.a.f9157b = r1     // Catch: java.lang.Throwable -> Lae
                throw r3     // Catch: java.lang.Throwable -> Lae
            L95:
                r4 = r3
            L96:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Lae
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r3)     // Catch: java.lang.Throwable -> Lae
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = com.facebook.appevents.AppEventsLogger.a.f9159d     // Catch: java.lang.Throwable -> Lae
                if (r9 != 0) goto La9
                java.util.HashMap r9 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lae
                r9.<init>()     // Catch: java.lang.Throwable -> Lae
                com.facebook.appevents.AppEventsLogger.a.f9159d = r9     // Catch: java.lang.Throwable -> Lae
            La9:
                com.facebook.appevents.AppEventsLogger.a.f9158c = r2     // Catch: java.lang.Throwable -> Lae
                goto L3b
            Lac:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lae
                return
            Lae:
                r9 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lae
                goto Lb2
            Lb1:
                throw r9
            Lb2:
                goto Lb1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.a.b(android.content.Context):void");
        }

        static void a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (f9156a) {
                a(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                a();
            }
        }

        static void a(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (f9156a) {
                a(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                a();
            }
        }

        private static FacebookTimeSpentData a(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            b(context);
            FacebookTimeSpentData facebookTimeSpentData = f9159d.get(accessTokenAppIdPair);
            if (facebookTimeSpentData != null) {
                return facebookTimeSpentData;
            }
            FacebookTimeSpentData facebookTimeSpentData2 = new FacebookTimeSpentData();
            f9159d.put(accessTokenAppIdPair, facebookTimeSpentData2);
            return facebookTimeSpentData2;
        }

        private static void a() {
            if (f9157b) {
                return;
            }
            f9157b = true;
            AppEventsLogger.backgroundExecutor.schedule(f9160e, 30L, TimeUnit.SECONDS);
        }
    }

    private static void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        m.a(accessTokenAppIdPair, appEvent);
        if (appEvent.getIsImplicit() || isActivateAppEventRequested) {
            return;
        }
        if (appEvent.getName() == AppEventsConstants.EVENT_NAME_ACTIVATED_APP) {
            isActivateAppEventRequested = true;
        } else {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
        }
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByAppLink = z;
    }
}
