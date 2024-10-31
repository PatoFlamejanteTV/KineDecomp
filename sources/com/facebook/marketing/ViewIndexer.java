package com.facebook.marketing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.marketing.internal.Constants;
import com.facebook.marketing.internal.MarketingLogger;
import com.facebook.marketing.internal.MarketingUtils;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String SUCCESS = "success";
    private static final String TAG = "com.facebook.marketing.ViewIndexer";
    private static final String TREE_PARAM = "tree";
    private WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private final MarketingLogger logger = new MarketingLogger(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId());

    /* loaded from: classes.dex */
    public static class a implements Callable<String> {

        /* renamed from: a */
        private WeakReference<View> f9426a;

        public a(View view) {
            this.f9426a = new WeakReference<>(view);
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            View view = this.f9426a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference<>(activity);
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2) {
        if (str == null) {
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", str2), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(TREE_PARAM, str);
        parameters.putString("app_version", MarketingUtils.getAppVersion());
        parameters.putString(PLATFORM_PARAM, "android");
        parameters.putString(Constants.DEVICE_SESSION_ID, CodelessActivityLifecycleTracker.getCurrentDeviceSessionID());
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new h());
        return newPostRequest;
    }

    public void sendToServer(String str, String str2) {
        FacebookSdk.getExecutor().execute(new g(this, str, str2));
    }

    public void schedule() {
        Activity activity = this.activityReference.get();
        if (activity == null) {
            return;
        }
        String simpleName = activity.getClass().getSimpleName();
        FacebookSdk.getApplicationId();
        FacebookSdk.getExecutor().execute(new f(this, new e(this, activity, simpleName)));
    }

    public void unschedule() {
        Timer timer;
        Activity activity = this.activityReference.get();
        if (activity == null || (timer = this.indexingTimer) == null) {
            return;
        }
        try {
            timer.cancel();
            this.indexingTimer = null;
            if (CodelessActivityLifecycleTracker.getIsAppIndexingEnabled()) {
                this.logger.logIndexingCancelled(activity.getClass().getCanonicalName());
            }
        } catch (Exception e2) {
            Log.e(TAG, "Error unscheduling indexing job", e2);
        }
    }
}
