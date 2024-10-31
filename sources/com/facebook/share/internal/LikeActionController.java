package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LikeActionController {
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
    private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static AccessTokenTracker accessTokenTracker;
    private static FileLruCache controllerDiskCache;
    private static Handler handler;
    private static boolean isInitialized;
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Bundle facebookDialogAnalyticsBundle;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private LikeView.ObjectType objectType;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;
    private static final String TAG = LikeActionController.class.getSimpleName();
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap<>();
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);

    /* loaded from: classes.dex */
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface h extends m {
        boolean b();

        String c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface l {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface m {
        FacebookRequestError a();

        void a(GraphRequestBatch graphRequestBatch);
    }

    public static boolean handleOnActivityResult(int i2, int i3, Intent intent) {
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new com.facebook.share.internal.a(i2, i3, intent));
        return true;
    }

    public static void getControllerForObjectId(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        if (!isInitialized) {
            performFirstInitialize();
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
        } else {
            diskIOWorkQueue.addActiveWorkItem(new b(str, objectType, creationCallback));
        }
    }

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        FacebookException facebookException;
        LikeActionController likeActionController2 = null;
        LikeView.ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.objectId, likeActionController.objectType.toString(), objectType.toString());
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
            likeActionController2 = likeActionController;
        }
        invokeCallbackWithController(creationCallback, likeActionController2, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createControllerForObjectIdAndType(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
            return;
        }
        LikeActionController deserializeFromDiskSynchronously = deserializeFromDiskSynchronously(str);
        if (deserializeFromDiskSynchronously == null) {
            deserializeFromDiskSynchronously = new LikeActionController(str, objectType);
            serializeToDiskAsync(deserializeFromDiskSynchronously);
        }
        putControllerInMemoryCache(str, deserializeFromDiskSynchronously);
        handler.post(new com.facebook.share.internal.e(deserializeFromDiskSynchronously));
        invokeCallbackWithController(creationCallback, deserializeFromDiskSynchronously, null);
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            if (!isInitialized) {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
                controllerDiskCache = new FileLruCache(TAG, new FileLruCache.Limits());
                registerAccessTokenTracker();
                CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new com.facebook.share.internal.f());
                isInitialized = true;
            }
        }
    }

    private static void invokeCallbackWithController(CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        if (creationCallback != null) {
            handler.post(new com.facebook.share.internal.g(creationCallback, likeActionController, facebookException));
        }
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new com.facebook.share.internal.h();
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new i(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new i(cacheKeyForObjectId, false));
        }
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!Utility.isNullOrEmpty(serializeToJson) && !Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            diskIOWorkQueue.addActiveWorkItem(new n(cacheKeyForObjectId, serializeToJson));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void serializeToDiskSynchronously(String str, String str2) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = controllerDiskCache.openPutStream(str);
                outputStream.write(str2.getBytes());
                if (outputStream != null) {
                    Utility.closeQuietly(outputStream);
                }
            } catch (IOException e2) {
                Log.e(TAG, "Unable to serialize controller to disk", e2);
                if (outputStream != null) {
                    Utility.closeQuietly(outputStream);
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.facebook.share.internal.LikeActionController deserializeFromDiskSynchronously(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.String r1 = getCacheKeyForObjectId(r5)     // Catch: java.io.IOException -> L21 java.lang.Throwable -> L30
            com.facebook.internal.FileLruCache r2 = com.facebook.share.internal.LikeActionController.controllerDiskCache     // Catch: java.io.IOException -> L21 java.lang.Throwable -> L30
            java.io.InputStream r2 = r2.get(r1)     // Catch: java.io.IOException -> L21 java.lang.Throwable -> L30
            if (r2 == 0) goto L1b
            java.lang.String r1 = com.facebook.internal.Utility.readStreamToString(r2)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r1)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            if (r3 != 0) goto L1b
            com.facebook.share.internal.LikeActionController r0 = deserializeFromJson(r1)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
        L1b:
            if (r2 == 0) goto L20
            com.facebook.internal.Utility.closeQuietly(r2)
        L20:
            return r0
        L21:
            r1 = move-exception
            r2 = r0
        L23:
            java.lang.String r3 = com.facebook.share.internal.LikeActionController.TAG     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = "Unable to deserialize controller from disk"
            android.util.Log.e(r3, r4, r1)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L20
            com.facebook.internal.Utility.closeQuietly(r2)
            goto L20
        L30:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L33:
            if (r2 == 0) goto L38
            com.facebook.internal.Utility.closeQuietly(r2)
        L38:
            throw r0
        L39:
            r0 = move-exception
            goto L33
        L3b:
            r1 = move-exception
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeActionController.deserializeFromDiskSynchronously(java.lang.String):com.facebook.share.internal.LikeActionController");
    }

    private static LikeActionController deserializeFromJson(String str) {
        LikeActionController likeActionController;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e2);
            likeActionController = null;
        }
        if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != 3) {
            return null;
        }
        likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
        likeActionController.likeCountStringWithLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, null);
        likeActionController.likeCountStringWithoutLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, null);
        likeActionController.socialSentenceWithLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, null);
        likeActionController.socialSentenceWithoutLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, null);
        likeActionController.isObjectLiked = jSONObject.optBoolean(JSON_BOOL_IS_OBJECT_LIKED_KEY);
        likeActionController.unlikeToken = jSONObject.optString("unlike_token", null);
        JSONObject optJSONObject = jSONObject.optJSONObject(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE);
        if (optJSONObject != null) {
            likeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(optJSONObject);
        }
        return likeActionController;
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        JSONObject convertToJSON;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_INT_VERSION_KEY, 3);
            jSONObject.put("object_id", likeActionController.objectId);
            jSONObject.put("object_type", likeActionController.objectType.getValue());
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, likeActionController.likeCountStringWithLike);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, likeActionController.likeCountStringWithoutLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, likeActionController.socialSentenceWithLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, likeActionController.socialSentenceWithoutLike);
            jSONObject.put(JSON_BOOL_IS_OBJECT_LIKED_KEY, likeActionController.isObjectLiked);
            jSONObject.put("unlike_token", likeActionController.unlikeToken);
            if (likeActionController.facebookDialogAnalyticsBundle != null && (convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.facebookDialogAnalyticsBundle)) != null) {
                jSONObject.put(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE, convertToJSON);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.e(TAG, "Unable to serialize controller to JSON", e2);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        String str2 = null;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null) {
            str2 = currentAccessToken.getToken();
        }
        if (str2 != null) {
            str2 = Utility.md5hash(str2);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.coerceValueIfNullOrEmpty(str2, ""), Integer.valueOf(objectSuffix));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void broadcastAction(LikeActionController likeActionController, String str) {
        broadcastAction(likeActionController, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void broadcastAction(LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        android.support.v4.a.f.a(FacebookSdk.getApplicationContext()).a(intent);
    }

    private LikeActionController(String str, LikeView.ObjectType objectType) {
        this.objectId = str;
        this.objectType = objectType;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    public boolean shouldEnableView() {
        if (LikeDialog.canShowNativeDialog() || LikeDialog.canShowWebFallback()) {
            return true;
        }
        if (this.objectIsPage || this.objectType == LikeView.ObjectType.PAGE) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) ? false : true;
    }

    public void toggleLike(Activity activity, Fragment fragment, Bundle bundle) {
        boolean z = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                return;
            } else {
                if (!publishLikeOrUnlikeAsync(z, bundle)) {
                    updateLikeState(z ? false : true);
                    presentLikeDialog(activity, fragment, bundle);
                    return;
                }
                return;
            }
        }
        presentLikeDialog(activity, fragment, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppEventsLogger getAppEventsLogger() {
        if (this.appEventsLogger == null) {
            this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        }
        return this.appEventsLogger;
    }

    private boolean publishLikeOrUnlikeAsync(boolean z, Bundle bundle) {
        if (canUseOGPublish()) {
            if (z) {
                publishLikeAsync(bundle);
                return true;
            }
            if (!Utility.isNullOrEmpty(this.unlikeToken)) {
                publishUnlikeAsync(bundle);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishDidError(boolean z) {
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
    }

    private void updateLikeState(boolean z) {
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        if ((z == this.isObjectLiked && Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken)) ? false : true) {
            this.isObjectLiked = z;
            this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
            this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
            this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
            this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
            this.unlikeToken = coerceValueIfNullOrEmpty5;
            serializeToDiskAsync(this);
            broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        }
    }

    private void presentLikeDialog(Activity activity, Fragment fragment, Bundle bundle) {
        String str;
        String objectType;
        if (LikeDialog.canShowNativeDialog()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG;
        } else if (LikeDialog.canShowWebFallback()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK;
        } else {
            logAppEventForError("present_dialog", bundle);
            Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
            broadcastAction(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
            str = null;
        }
        if (str != null) {
            if (this.objectType != null) {
                objectType = this.objectType.toString();
            } else {
                objectType = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(objectType).build();
            if (fragment != null) {
                new LikeDialog(fragment).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onActivityResult(int i2, int i3, Intent intent) {
        ShareInternalUtility.handleActivityResult(i2, i3, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
    }

    private ResultProcessor getResultProcessor(Bundle bundle) {
        return new com.facebook.share.internal.i(this, null, bundle);
    }

    private void saveState(Bundle bundle) {
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
    }

    private void clearState() {
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
    }

    private static void storeObjectIdForPendingController(String str) {
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
    }

    private boolean canUseOGPublish() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return (this.objectIsPage || this.verifiedObjectId == null || currentAccessToken == null || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) ? false : true;
    }

    private void publishLikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new com.facebook.share.internal.j(this, bundle));
    }

    private void publishUnlikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        k kVar = new k(this.unlikeToken);
        kVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new com.facebook.share.internal.l(this, kVar, bundle));
        graphRequestBatch.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshStatusAsync() {
        if (AccessToken.getCurrentAccessToken() == null) {
            refreshStatusViaService();
        } else {
            fetchVerifiedObjectId(new com.facebook.share.internal.m(this));
        }
    }

    private void refreshStatusViaService() {
        u uVar = new u(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (uVar.start()) {
            uVar.setCompletedListener(new com.facebook.share.internal.b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishAgainIfNeeded(Bundle bundle) {
        if (this.isObjectLiked != this.isObjectLikedOnServer && !publishLikeOrUnlikeAsync(this.isObjectLiked, bundle)) {
            publishDidError(!this.isObjectLiked);
        }
    }

    private void fetchVerifiedObjectId(l lVar) {
        if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
            if (lVar != null) {
                lVar.a();
                return;
            }
            return;
        }
        d dVar = new d(this.objectId, this.objectType);
        f fVar = new f(this.objectId, this.objectType);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        dVar.a(graphRequestBatch);
        fVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new com.facebook.share.internal.c(this, dVar, fVar, lVar));
        graphRequestBatch.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppEventForError(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.objectId);
        bundle2.putString("object_type", this.objectType.toString());
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        JSONObject requestResult;
        Bundle bundle = new Bundle();
        if (facebookRequestError != null && (requestResult = facebookRequestError.getRequestResult()) != null) {
            bundle.putString("error", requestResult.toString());
        }
        logAppEventForError(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends a {
        String e;

        d(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "og_object.fields(id)");
            bundle.putString("ids", str);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.c = null;
            } else {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.f345a, this.b, facebookRequestError);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.f345a);
            if (tryGetJSONObjectFromResponse != null && (optJSONObject = tryGetJSONObjectFromResponse.optJSONObject("og_object")) != null) {
                this.e = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends a {
        String e;
        boolean f;

        f(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, ShareConstants.WEB_DIALOG_PARAM_ID);
            bundle.putString("ids", str);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.f345a);
            if (tryGetJSONObjectFromResponse != null) {
                this.e = tryGetJSONObjectFromResponse.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                this.f = !Utility.isNullOrEmpty(this.e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.f345a, this.b, facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends a {
        String e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.POST));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            this.e = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_ID);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.c = null;
            } else {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.f345a, this.b, facebookRequestError);
                LikeActionController.this.logAppEventForError("publish_like", facebookRequestError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends a {
        private String f;

        k(String str) {
            super(null, null);
            this.f = str;
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.f, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_unlike", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends a implements h {
        private boolean f;
        private String g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(String str) {
            super(str, LikeView.ObjectType.PAGE);
            this.f = LikeActionController.this.isObjectLiked;
            this.g = str;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, ShareConstants.WEB_DIALOG_PARAM_ID);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + str, bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_DATA);
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.f = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.g, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_page_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public boolean b() {
            return this.f;
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public String c() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends a implements h {
        private boolean f;
        private String g;
        private final String h;
        private final LikeView.ObjectType i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.f = LikeActionController.this.isObjectLiked;
            this.h = str;
            this.i = objectType;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,application");
            bundle.putString("object", this.h);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_DATA);
            if (tryGetJSONArrayFromResponse != null) {
                for (int i = 0; i < tryGetJSONArrayFromResponse.length(); i++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.f = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && currentAccessToken != null && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID))) {
                            this.g = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.h, this.i, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_og_object_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public boolean b() {
            return this.f;
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public String c() {
            return this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends a {
        String e;
        String f;
        String g;
        String h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.e = LikeActionController.this.likeCountStringWithLike;
            this.f = LikeActionController.this.likeCountStringWithoutLike;
            this.g = LikeActionController.this.socialSentenceWithLike;
            this.h = LikeActionController.this.socialSentenceWithoutLike;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.e = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.e);
                this.f = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.f);
                this.g = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.g);
                this.h = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.h);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.f345a, this.b, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_engagement", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a implements m {

        /* renamed from: a, reason: collision with root package name */
        protected String f345a;
        protected LikeView.ObjectType b;
        protected FacebookRequestError c;
        private GraphRequest e;

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract void a(GraphResponse graphResponse);

        protected a(String str, LikeView.ObjectType objectType) {
            this.f345a = str;
            this.b = objectType;
        }

        @Override // com.facebook.share.internal.LikeActionController.m
        public void a(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.e);
        }

        @Override // com.facebook.share.internal.LikeActionController.m
        public FacebookRequestError a() {
            return this.c;
        }

        protected void a(GraphRequest graphRequest) {
            this.e = graphRequest;
            graphRequest.setVersion(ServerProtocol.GRAPH_API_VERSION);
            graphRequest.setCallback(new o(this));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", this.f345a, this.b, facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private static ArrayList<String> f347a = new ArrayList<>();
        private String b;
        private boolean c;

        i(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b != null) {
                f347a.remove(this.b);
                f347a.add(0, this.b);
            }
            if (this.c && f347a.size() >= LikeActionController.MAX_CACHE_SIZE) {
                while (64 < f347a.size()) {
                    LikeActionController.cache.remove(f347a.remove(f347a.size() - 1));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f348a;
        private String b;

        n(String str, String str2) {
            this.f348a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.serializeToDiskSynchronously(this.f348a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f346a;
        private LikeView.ObjectType b;
        private CreationCallback c;

        b(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
            this.f346a = str;
            this.b = objectType;
            this.c = creationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.createControllerForObjectIdAndType(this.f346a, this.b, this.c);
        }
    }
}
