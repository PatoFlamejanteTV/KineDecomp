package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FacebookSdk {
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized.";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static LockOnGetVariable<File> cacheDir;
    private static volatile Executor executor;
    private static volatile int webDialogTheme;
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    private static final String FACEBOOK_COM = "facebook.com";
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static int callbackRequestCodeOffset = 64206;
    private static final Object LOCK = new Object();
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new l();
    private static Boolean sdkInitialized = false;

    /* loaded from: classes.dex */
    public interface InitializeCallback {
        void onInitialized();
    }

    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i, null);
        }
    }

    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue() && i != callbackRequestCodeOffset) {
                throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
            }
            if (i < 0) {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
            callbackRequestCodeOffset = i;
            sdkInitialize(context);
        }
    }

    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    public static synchronized void sdkInitialize(Context context, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue()) {
                if (initializeCallback != null) {
                    initializeCallback.onInitialized();
                }
            } else {
                Validate.notNull(context, "applicationContext");
                Validate.hasFacebookActivity(context, false);
                Validate.hasInternetPermissions(context, false);
                applicationContext = context.getApplicationContext();
                loadDefaultsFromMetadata(applicationContext);
                Utility.loadAppSettingsAsync(applicationContext, applicationId);
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.getInstance(applicationContext);
                cacheDir = new LockOnGetVariable<>((Callable) new m());
                getExecutor().execute(new FutureTask(new n(initializeCallback)));
                sdkInitialized = true;
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            updateGraphDebugBehavior();
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor2) {
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            executor = executor2;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static void publishInstallAsync(Context context, String str) {
        getExecutor().execute(new o(context.getApplicationContext(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GraphResponse publishInstallAndWaitForResponse(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String str2 = str + "ping";
            String str3 = str + "json";
            long j = sharedPreferences.getLong(str2, 0L);
            String string = sharedPreferences.getString(str3, null);
            try {
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, str), AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context), null);
                if (j != 0) {
                    if (string != null) {
                        try {
                            jSONObject2 = new JSONObject(string);
                        } catch (JSONException e) {
                            jSONObject = null;
                        }
                    } else {
                        jSONObject2 = null;
                    }
                    jSONObject = jSONObject2;
                    if (jSONObject == null) {
                        return GraphResponse.createResponsesFromString(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, null, new GraphRequestBatch(newPostRequest)).get(0);
                    }
                    return new GraphResponse((GraphRequest) null, (HttpURLConnection) null, (String) null, jSONObject);
                }
                GraphResponse executeAndWait = newPostRequest.executeAndWait();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str2, System.currentTimeMillis());
                if (executeAndWait.getJSONObject() != null) {
                    edit.putString(str3, executeAndWait.getJSONObject().toString());
                }
                edit.apply();
                return executeAndWait;
            } catch (JSONException e2) {
                throw new FacebookException("An error occurred while publishing install.", e2);
            }
        } catch (Exception e3) {
            Utility.logd("Facebook-publish", e3);
            return new GraphResponse(null, null, new FacebookRequestError(null, e3));
        }
    }

    public static String getSdkVersion() {
        return "4.7.0";
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    static void loadDefaultsFromMetadata(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), DEFAULT_MAXIMUM_POOL_SIZE);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                applicationId = str.substring(2);
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (webDialogTheme == 0) {
                        setWebDialogTheme(applicationInfo.metaData.getInt(WEB_DIALOG_THEME));
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }

    public static String getApplicationSignature(Context context) {
        PackageManager packageManager;
        Validate.sdkInitialized();
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static int getWebDialogTheme() {
        Validate.sdkInitialized();
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i) {
        webDialogTheme = i;
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return cacheDir.getValue();
    }

    public static void setCacheDir(File file) {
        cacheDir = new LockOnGetVariable<>(file);
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static boolean isFacebookRequestCode(int i) {
        return i >= callbackRequestCodeOffset && i < callbackRequestCodeOffset + 100;
    }
}
