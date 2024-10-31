package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
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
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.places.model.PlaceFields;
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

@Deprecated
/* loaded from: classes.dex */
public class LikeActionController {

    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";

    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";

    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";

    @Deprecated
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;

    @Deprecated
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";

    @Deprecated
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
    private static final String TAG = "LikeActionController";
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
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap<>();
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);

    @Deprecated
    /* loaded from: classes.dex */
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private GraphRequest f9513a;

        /* renamed from: b, reason: collision with root package name */
        protected String f9514b;

        /* renamed from: c, reason: collision with root package name */
        protected LikeView.ObjectType f9515c;

        /* renamed from: d, reason: collision with root package name */
        protected FacebookRequestError f9516d;

        protected a(String str, LikeView.ObjectType objectType) {
            this.f9514b = str;
            this.f9515c = objectType;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract void a(FacebookRequestError facebookRequestError);

        @Override // com.facebook.share.internal.LikeActionController.m
        public void a(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.f9513a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract void a(GraphResponse graphResponse);

        @Override // com.facebook.share.internal.LikeActionController.m
        public FacebookRequestError a() {
            return this.f9516d;
        }

        protected void a(GraphRequest graphRequest) {
            this.f9513a = graphRequest;
            graphRequest.setVersion(FacebookSdk.getGraphApiVersion());
            graphRequest.setCallback(new v(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f9518a;

        /* renamed from: b, reason: collision with root package name */
        private LikeView.ObjectType f9519b;

        /* renamed from: c, reason: collision with root package name */
        private CreationCallback f9520c;

        b(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
            this.f9518a = str;
            this.f9519b = objectType;
            this.f9520c = creationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.createControllerForObjectIdAndType(this.f9518a, this.f9519b, this.f9520c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface h extends m {
        boolean b();

        String c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private static ArrayList<String> f9535a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        private String f9536b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9537c;

        i(String str, boolean z) {
            this.f9536b = str;
            this.f9537c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f9536b;
            if (str != null) {
                f9535a.remove(str);
                f9535a.add(0, this.f9536b);
            }
            if (!this.f9537c || f9535a.size() < 128) {
                return;
            }
            while (64 < f9535a.size()) {
                LikeActionController.cache.remove(f9535a.remove(r1.size() - 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends a {

        /* renamed from: f, reason: collision with root package name */
        String f9538f;

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
            this.f9538f = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), "id");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.f9516d = null;
            } else {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.f9514b, this.f9515c, facebookRequestError);
                LikeActionController.this.logAppEventForError("publish_like", facebookRequestError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends a {

        /* renamed from: f, reason: collision with root package name */
        private String f9540f;

        k(String str) {
            super(null, null);
            this.f9540f = str;
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.f9540f, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_unlike", facebookRequestError);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface l {
        void onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface m {
        FacebookRequestError a();

        void a(GraphRequestBatch graphRequestBatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f9542a;

        /* renamed from: b, reason: collision with root package name */
        private String f9543b;

        n(String str, String str2) {
            this.f9542a = str;
            this.f9543b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.serializeToDiskSynchronously(this.f9542a, this.f9543b);
        }
    }

    private LikeActionController(String str, LikeView.ObjectType objectType) {
        this.objectId = str;
        this.objectType = objectType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void broadcastAction(LikeActionController likeActionController, String str) {
        broadcastAction(likeActionController, str, null);
    }

    private boolean canUseOGPublish() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return (this.objectIsPage || this.verifiedObjectId == null || !AccessToken.isCurrentAccessTokenActive() || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) ? false : true;
    }

    private void clearState() {
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
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
        handler.post(new RunnableC0766l(deserializeFromDiskSynchronously));
        invokeCallbackWithController(creationCallback, deserializeFromDiskSynchronously, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:            if (r5 == null) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:            if (r5 != null) goto L12;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:            com.facebook.internal.Utility.closeQuietly(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:            return r0;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.facebook.share.internal.LikeActionController deserializeFromDiskSynchronously(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.String r5 = getCacheKeyForObjectId(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            com.facebook.internal.FileLruCache r1 = com.facebook.share.internal.LikeActionController.controllerDiskCache     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            java.io.InputStream r5 = r1.get(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            if (r5 == 0) goto L1e
            java.lang.String r1 = com.facebook.internal.Utility.readStreamToString(r5)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            boolean r2 = com.facebook.internal.Utility.isNullOrEmpty(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            if (r2 != 0) goto L1e
            com.facebook.share.internal.LikeActionController r0 = deserializeFromJson(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            goto L1e
        L1c:
            r1 = move-exception
            goto L2b
        L1e:
            if (r5 == 0) goto L35
        L20:
            com.facebook.internal.Utility.closeQuietly(r5)
            goto L35
        L24:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L37
        L29:
            r1 = move-exception
            r5 = r0
        L2b:
            java.lang.String r2 = com.facebook.share.internal.LikeActionController.TAG     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "Unable to deserialize controller from disk"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L35
            goto L20
        L35:
            return r0
        L36:
            r0 = move-exception
        L37:
            if (r5 == 0) goto L3c
            com.facebook.internal.Utility.closeQuietly(r5)
        L3c:
            goto L3e
        L3d:
            throw r0
        L3e:
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeActionController.deserializeFromDiskSynchronously(java.lang.String):com.facebook.share.internal.LikeActionController");
    }

    private static LikeActionController deserializeFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != 3) {
                return null;
            }
            LikeActionController likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
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
        } catch (JSONException e2) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e2);
            return null;
        }
    }

    private void fetchVerifiedObjectId(l lVar) {
        if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
            if (lVar != null) {
                lVar.onComplete();
                return;
            }
            return;
        }
        d dVar = new d(this.objectId, this.objectType);
        f fVar = new f(this.objectId, this.objectType);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        dVar.a(graphRequestBatch);
        fVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new C0763i(this, dVar, fVar, lVar));
        graphRequestBatch.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppEventsLogger getAppEventsLogger() {
        if (this.appEventsLogger == null) {
            this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        }
        return this.appEventsLogger;
    }

    private static String getCacheKeyForObjectId(String str) {
        String token = AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : null;
        if (token != null) {
            token = Utility.md5hash(token);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.coerceValueIfNullOrEmpty(token, ""), Integer.valueOf(objectSuffix));
    }

    @Deprecated
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

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new i(cacheKeyForObjectId, false));
        }
        return likeActionController;
    }

    private ResultProcessor getResultProcessor(Bundle bundle) {
        return new C0770p(this, null, bundle);
    }

    @Deprecated
    public static boolean handleOnActivityResult(int i2, int i3, Intent intent) {
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new C0765k(i2, i3, intent));
        return true;
    }

    private static void invokeCallbackWithController(CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        if (creationCallback == null) {
            return;
        }
        handler.post(new RunnableC0768n(creationCallback, likeActionController, facebookException));
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        ShareInternalUtility.handleActivityResult(i2, i3, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            if (isInitialized) {
                return;
            }
            handler = new Handler(Looper.getMainLooper());
            objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
            controllerDiskCache = new FileLruCache(TAG, new FileLruCache.Limits());
            registerAccessTokenTracker();
            CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new C0767m());
            isInitialized = true;
        }
    }

    private void presentLikeDialog(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
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
            LikeView.ObjectType objectType2 = this.objectType;
            if (objectType2 != null) {
                objectType = objectType2.toString();
            } else {
                objectType = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(objectType).build();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishAgainIfNeeded(Bundle bundle) {
        boolean z = this.isObjectLiked;
        if (z == this.isObjectLikedOnServer || publishLikeOrUnlikeAsync(z, bundle)) {
            return;
        }
        publishDidError(!this.isObjectLiked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishDidError(boolean z) {
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
    }

    private void publishLikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new r(this, bundle));
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

    private void publishUnlikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        k kVar = new k(this.unlikeToken);
        kVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new C0772s(this, kVar, bundle));
        graphRequestBatch.executeAsync();
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new i(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshStatusAsync() {
        if (!AccessToken.isCurrentAccessTokenActive()) {
            refreshStatusViaService();
        } else {
            fetchVerifiedObjectId(new C0774u(this));
        }
    }

    private void refreshStatusViaService() {
        B b2 = new B(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (b2.start()) {
            b2.setCompletedListener(new C0762h(this));
        }
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new C0769o();
    }

    private void saveState(Bundle bundle) {
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (Utility.isNullOrEmpty(serializeToJson) || Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            return;
        }
        diskIOWorkQueue.addActiveWorkItem(new n(cacheKeyForObjectId, serializeToJson));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void serializeToDiskSynchronously(String str, String str2) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = controllerDiskCache.openPutStream(str);
                outputStream.write(str2.getBytes());
                if (outputStream == null) {
                    return;
                }
            } catch (IOException e2) {
                Log.e(TAG, "Unable to serialize controller to disk", e2);
                if (outputStream == null) {
                    return;
                }
            }
            Utility.closeQuietly(outputStream);
        } catch (Throwable th) {
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
            throw th;
        }
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

    private static void storeObjectIdForPendingController(String str) {
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
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

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        FacebookException facebookException;
        LikeView.ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.objectId, likeActionController.objectType.toString(), objectType.toString());
            likeActionController = null;
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
        }
        invokeCallbackWithController(creationCallback, likeActionController, facebookException);
    }

    @Deprecated
    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    @Deprecated
    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    @Deprecated
    public boolean shouldEnableView() {
        return false;
    }

    @Deprecated
    public void toggleLike(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                return;
            } else {
                if (publishLikeOrUnlikeAsync(z, bundle)) {
                    return;
                }
                updateLikeState(z ? false : true);
                presentLikeDialog(activity, fragmentWrapper, bundle);
                return;
            }
        }
        presentLikeDialog(activity, fragmentWrapper, bundle);
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
        LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends a {

        /* renamed from: f, reason: collision with root package name */
        String f9529f;

        /* renamed from: g, reason: collision with root package name */
        boolean f9530g;

        f(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            bundle.putString("ids", str);
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.f9514b);
            if (tryGetJSONObjectFromResponse != null) {
                this.f9529f = tryGetJSONObjectFromResponse.optString("id");
                this.f9530g = !Utility.isNullOrEmpty(this.f9529f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.f9514b, this.f9515c, facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends a implements h {

        /* renamed from: f, reason: collision with root package name */
        private boolean f9532f;

        /* renamed from: g, reason: collision with root package name */
        private String f9533g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(String str) {
            super(str, LikeView.ObjectType.PAGE);
            this.f9532f = LikeActionController.this.isObjectLiked;
            this.f9533g = str;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + str, bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_DATA);
            if (tryGetJSONArrayFromResponse == null || tryGetJSONArrayFromResponse.length() <= 0) {
                return;
            }
            this.f9532f = true;
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public boolean b() {
            return this.f9532f;
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public String c() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.f9533g, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_page_like", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends a {

        /* renamed from: f, reason: collision with root package name */
        String f9524f;

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
                this.f9516d = null;
            } else {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.f9514b, this.f9515c, facebookRequestError);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.f9514b);
            if (tryGetJSONObjectFromResponse == null || (optJSONObject = tryGetJSONObjectFromResponse.optJSONObject("og_object")) == null) {
                return;
            }
            this.f9524f = optJSONObject.optString("id");
        }
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
    public class c extends a {

        /* renamed from: f, reason: collision with root package name */
        String f9521f;

        /* renamed from: g, reason: collision with root package name */
        String f9522g;

        /* renamed from: h, reason: collision with root package name */
        String f9523h;
        String i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.f9521f = LikeActionController.this.likeCountStringWithLike;
            this.f9522g = LikeActionController.this.likeCountStringWithoutLike;
            this.f9523h = LikeActionController.this.socialSentenceWithLike;
            this.i = LikeActionController.this.socialSentenceWithoutLike;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            a(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), PlaceFields.ENGAGEMENT);
            if (tryGetJSONObjectFromResponse != null) {
                this.f9521f = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.f9521f);
                this.f9522g = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.f9522g);
                this.f9523h = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.f9523h);
                this.i = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.i);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.f9514b, this.f9515c, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_engagement", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends a implements h {

        /* renamed from: f, reason: collision with root package name */
        private boolean f9526f;

        /* renamed from: g, reason: collision with root package name */
        private String f9527g;

        /* renamed from: h, reason: collision with root package name */
        private final String f9528h;
        private final LikeView.ObjectType i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.f9526f = LikeActionController.this.isObjectLiked;
            this.f9528h = str;
            this.i = objectType;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,application");
            bundle.putString("object", this.f9528h);
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
                        this.f9526f = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && AccessToken.isCurrentAccessTokenActive() && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.f9527g = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public boolean b() {
            return this.f9526f;
        }

        @Override // com.facebook.share.internal.LikeActionController.h
        public String c() {
            return this.f9527g;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.a
        public void a(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.f9528h, this.i, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_og_object_like", facebookRequestError);
        }
    }
}
