package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CodelessMatcher {
    private static final String CURRENT_CLASS_NAME = ".";
    private static final String PARENT_CLASS_NAME = "..";
    private static final String TAG = "com.facebook.appevents.codeless.CodelessMatcher";
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<Activity> activitiesSet = new HashSet();
    private Set<ViewMatcher> viewMatchers = new HashSet();
    private HashMap<String, String> delegateMap = new HashMap<>();

    /* loaded from: classes.dex */
    public static class MatchedView {
        private WeakReference<View> view;
        private String viewMapKey;

        public MatchedView(View view, String str) {
            this.view = new WeakReference<>(view);
            this.viewMapKey = str;
        }

        public View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    /* loaded from: classes.dex */
    public static class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashMap<String, String> delegateMap;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler, HashMap<String, String> hashMap, String str) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler;
            this.delegateMap = hashMap;
            this.activityName = str;
            this.handler.postDelayed(this, 200L);
        }

        private void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding == null) {
                return;
            }
            try {
                View view2 = matchedView.getView();
                if (view2 == null) {
                    return;
                }
                String viewMapKey = matchedView.getViewMapKey();
                View.AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view2);
                boolean z = true;
                boolean z2 = existingDelegate != null;
                boolean z3 = z2 && (existingDelegate instanceof CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate);
                if (!z3 || !((CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate) existingDelegate).getSupportCodelessLogging()) {
                    z = false;
                }
                if (this.delegateMap.containsKey(viewMapKey)) {
                    return;
                }
                if (z2 && z3 && z) {
                    return;
                }
                view2.setAccessibilityDelegate(CodelessLoggingEventListener.getAccessibilityDelegate(eventBinding, view, view2));
                this.delegateMap.put(viewMapKey, eventBinding.getEventName());
            } catch (FacebookException e2) {
                Log.e(CodelessMatcher.TAG, "Failed to attach auto logging event listener.", e2);
            }
        }

        public static List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            String str2 = str + CodelessMatcher.CURRENT_CLASS_NAME + String.valueOf(i2);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            if (i >= list.size()) {
                arrayList.add(new MatchedView(view, str2));
            } else {
                PathComponent pathComponent = list.get(i);
                if (pathComponent.className.equals(CodelessMatcher.PARENT_CLASS_NAME)) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> findVisibleChildren = findVisibleChildren((ViewGroup) parent);
                        int size = findVisibleChildren.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren.get(i3), list, i + 1, i3, str2));
                        }
                    }
                    return arrayList;
                }
                if (pathComponent.className.equals(CodelessMatcher.CURRENT_CLASS_NAME)) {
                    arrayList.add(new MatchedView(view, str2));
                    return arrayList;
                }
                if (!isTheSameView(view, pathComponent, i2)) {
                    return arrayList;
                }
                if (i == list.size() - 1) {
                    arrayList.add(new MatchedView(view, str2));
                }
            }
            if (view instanceof ViewGroup) {
                List<View> findVisibleChildren2 = findVisibleChildren((ViewGroup) view);
                int size2 = findVisibleChildren2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren2.get(i4), list, i + 1, i4, str2));
                }
            }
            return arrayList;
        }

        private static List<View> findVisibleChildren(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:            if (r4.getClass().getSimpleName().equals(r6[r6.length - 1]) == false) goto L63;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean isTheSameView(android.view.View r4, com.facebook.appevents.codeless.internal.PathComponent r5, int r6) {
            /*
                int r0 = r5.index
                r1 = 0
                r2 = -1
                if (r0 == r2) goto L9
                if (r6 == r0) goto L9
                return r1
            L9:
                java.lang.Class r6 = r4.getClass()
                java.lang.String r6 = r6.getCanonicalName()
                java.lang.String r0 = r5.className
                boolean r6 = r6.equals(r0)
                r0 = 1
                if (r6 != 0) goto L42
                java.lang.String r6 = r5.className
                java.lang.String r2 = ".*android\\..*"
                boolean r6 = r6.matches(r2)
                if (r6 == 0) goto L41
                java.lang.String r6 = r5.className
                java.lang.String r2 = "\\."
                java.lang.String[] r6 = r6.split(r2)
                int r2 = r6.length
                if (r2 <= 0) goto L41
                int r2 = r6.length
                int r2 = r2 - r0
                r6 = r6[r2]
                java.lang.Class r2 = r4.getClass()
                java.lang.String r2 = r2.getSimpleName()
                boolean r6 = r2.equals(r6)
                if (r6 != 0) goto L42
            L41:
                return r1
            L42:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                int r2 = r2.getValue()
                r6 = r6 & r2
                if (r6 <= 0) goto L56
                int r6 = r5.id
                int r2 = r4.getId()
                if (r6 == r2) goto L56
                return r1
            L56:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                int r2 = r2.getValue()
                r6 = r6 & r2
                if (r6 <= 0) goto L6e
                java.lang.String r6 = r5.text
                java.lang.String r2 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r4)
                boolean r6 = r6.equals(r2)
                if (r6 != 0) goto L6e
                return r1
            L6e:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                int r2 = r2.getValue()
                r6 = r6 & r2
                java.lang.String r2 = ""
                if (r6 <= 0) goto L94
                java.lang.String r6 = r5.description
                java.lang.CharSequence r3 = r4.getContentDescription()
                if (r3 != 0) goto L85
                r3 = r2
                goto L8d
            L85:
                java.lang.CharSequence r3 = r4.getContentDescription()
                java.lang.String r3 = java.lang.String.valueOf(r3)
            L8d:
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L94
                return r1
            L94:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                int r3 = r3.getValue()
                r6 = r6 & r3
                if (r6 <= 0) goto Lac
                java.lang.String r6 = r5.hint
                java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r4)
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto Lac
                return r1
            Lac:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                int r3 = r3.getValue()
                r6 = r6 & r3
                if (r6 <= 0) goto Lcf
                java.lang.String r5 = r5.tag
                java.lang.Object r6 = r4.getTag()
                if (r6 != 0) goto Lc0
                goto Lc8
            Lc0:
                java.lang.Object r4 = r4.getTag()
                java.lang.String r2 = java.lang.String.valueOf(r4)
            Lc8:
                boolean r4 = r5.equals(r2)
                if (r4 != 0) goto Lcf
                return r1
            Lcf:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
        }

        private void startMatch() {
            if (this.eventBindings == null || this.rootView.get() == null) {
                return;
            }
            for (int i = 0; i < this.eventBindings.size(); i++) {
                findView(this.eventBindings.get(i), this.rootView.get());
            }
        }

        public void findView(EventBinding eventBinding, View view) {
            if (eventBinding == null || view == null) {
                return;
            }
            if (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.activityName)) {
                List<PathComponent> viewPath = eventBinding.getViewPath();
                if (viewPath.size() > 25) {
                    return;
                }
                Iterator<MatchedView> it = findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName).iterator();
                while (it.hasNext()) {
                    attachListener(it.next(), view, eventBinding);
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            startMatch();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            startMatch();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                return;
            }
            this.eventBindings = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
            if (this.eventBindings == null || (view = this.rootView.get()) == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                viewTreeObserver.addOnScrollChangedListener(this);
            }
            startMatch();
        }
    }

    public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        List<ParameterComponent> viewParameters;
        List<MatchedView> findViewByPath;
        Bundle bundle = new Bundle();
        if (eventBinding != null && (viewParameters = eventBinding.getViewParameters()) != null) {
            for (ParameterComponent parameterComponent : viewParameters) {
                String str = parameterComponent.value;
                if (str != null && str.length() > 0) {
                    bundle.putString(parameterComponent.name, parameterComponent.value);
                } else if (parameterComponent.path.size() > 0) {
                    if (parameterComponent.pathType.equals(Constants.PATH_TYPE_RELATIVE)) {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view2, parameterComponent.path, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view, parameterComponent.path, 0, -1, view.getClass().getSimpleName());
                    }
                    Iterator<MatchedView> it = findViewByPath.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            MatchedView next = it.next();
                            if (next.getView() != null) {
                                String textOfView = ViewHierarchy.getTextOfView(next.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(parameterComponent.name, textOfView);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public void matchViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewMatchers.add(new ViewMatcher(activity.getWindow().getDecorView().getRootView(), this.uiThreadHandler, this.delegateMap, activity.getClass().getSimpleName()));
        }
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
        } else {
            this.uiThreadHandler.post(new c(this));
        }
    }

    public void add(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.add(activity);
            this.delegateMap.clear();
            startTracking();
            return;
        }
        throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
    }

    public void remove(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.remove(activity);
            this.viewMatchers.clear();
            this.delegateMap.clear();
            return;
        }
        throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
    }
}
