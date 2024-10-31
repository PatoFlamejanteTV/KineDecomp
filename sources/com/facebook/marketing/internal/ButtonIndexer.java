package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ButtonIndexer {
    private static final String TAG = "com.facebook.marketing.internal.ButtonIndexer";
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<Activity> activitiesSet = new HashSet();
    private Set<ViewProcessor> viewProcessors = new HashSet();
    private HashSet<String> delegateSet = new HashSet<>();

    /* loaded from: classes.dex */
    public static class ViewProcessor implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashSet<String> delegateSet;
        private final Handler handler;
        private WeakReference<View> rootView;
        private HashMap<String, WeakReference<View>> viewMap = new HashMap<>();

        public ViewProcessor(View view, String str, HashSet<String> hashSet, Handler handler) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler;
            this.activityName = str;
            this.delegateSet = hashSet;
            this.handler.postDelayed(this, 200L);
        }

        private void attachListener(View view, String str) {
            if (view == null) {
                return;
            }
            try {
                View.AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view);
                boolean z = true;
                boolean z2 = existingDelegate != null;
                boolean z3 = z2 && (existingDelegate instanceof CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate);
                if (!z3 || !((CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate) existingDelegate).getSupportButtonIndexing()) {
                    z = false;
                }
                if (this.delegateSet.contains(str)) {
                    return;
                }
                if (z2 && z3 && z) {
                    return;
                }
                view.setAccessibilityDelegate(ButtonIndexingEventListener.getAccessibilityDelegate(view, str));
                this.delegateSet.add(str);
            } catch (FacebookException e2) {
                Log.e(ButtonIndexer.TAG, "Failed to attach auto logging event listener.", e2);
            }
        }

        private void process() {
            View view = this.rootView.get();
            if (view != null) {
                attachListeners(view);
            }
        }

        public void attachListeners(View view) {
            getClickableElementsOfView(view, -1, this.activityName);
            FacebookSdk.getExecutor().execute(new b(this));
            for (Map.Entry<String, WeakReference<View>> entry : this.viewMap.entrySet()) {
                attachListener(entry.getValue().get(), entry.getKey());
            }
        }

        public void getClickableElementsOfView(View view, int i, String str) {
            String str2 = str + "." + String.valueOf(i);
            if (view == null) {
                return;
            }
            if (ViewHierarchy.isClickableView(view)) {
                this.viewMap.put(str2, new WeakReference<>(view));
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    getClickableElementsOfView(viewGroup.getChildAt(i2), i2, str2);
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            process();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            process();
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteConfig remoteConfigWithoutQuery = RemoteConfigManager.getRemoteConfigWithoutQuery(FacebookSdk.getApplicationId());
            if (remoteConfigWithoutQuery == null || !remoteConfigWithoutQuery.getEnableButtonIndexing()) {
                return;
            }
            process();
        }
    }

    public void processViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewProcessors.add(new ViewProcessor(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.delegateSet, this.uiThreadHandler));
        }
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            processViews();
        } else {
            this.uiThreadHandler.post(new a(this));
        }
    }

    public void add(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.add(activity);
            this.delegateSet.clear();
            startTracking();
            return;
        }
        throw new FacebookException("Can't add activity to ButtonIndexer on non-UI thread");
    }

    public void remove(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.remove(activity);
            this.viewProcessors.clear();
            this.delegateSet.clear();
            return;
        }
        throw new FacebookException("Can't remove activity from ButtonIndexer on non-UI thread");
    }
}
