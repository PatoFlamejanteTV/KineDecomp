package com.google.firebase.inappmessaging.display;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.squareup.picasso.InterfaceC2399l;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@Keep
@FirebaseAppScope
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;
    private FiamListener fiamListener;
    private com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    private final FiamWindowManager windowManager;

    @Inject
    public FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application;
        this.bindingWrapperFactory = bindingWrapperFactory;
        this.animator = fiamAnimator;
    }

    public void cancelTimers() {
        this.impressionTimer.a();
        this.autoDismissTimer.a();
    }

    public void dismissFiam(Activity activity) {
        Logging.a("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        this.inAppMessage = null;
        this.callbacks = null;
    }

    @Keep
    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.c().a(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void inflateBinding(Activity activity, BindingWrapper bindingWrapper) {
        View.OnClickListener onClickListener;
        c cVar = new c(this, activity);
        if (this.inAppMessage.getAction() != null && !TextUtils.isEmpty(this.inAppMessage.getAction().getActionUrl())) {
            onClickListener = new d(this, activity);
        } else {
            Logging.c("No action url found for action.");
            onClickListener = cVar;
        }
        ViewTreeObserver.OnGlobalLayoutListener a2 = bindingWrapper.a(onClickListener, cVar);
        if (a2 != null) {
            bindingWrapper.e().getViewTreeObserver().addOnGlobalLayoutListener(a2);
        }
        loadNullableImage(activity, bindingWrapper, this.inAppMessage.getImageUrl(), new h(this, bindingWrapper, activity, a2));
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, String str, InterfaceC2399l interfaceC2399l) {
        if (!TextUtils.isEmpty(str)) {
            this.imageLoader.a(str).a(activity.getClass()).a(R.drawable.image_placeholder).a(bindingWrapper.e(), interfaceC2399l);
        } else {
            interfaceC2399l.onSuccess();
        }
    }

    public void notifyFiamClick() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.a()) {
            this.windowManager.a(activity);
            cancelTimers();
        }
    }

    public void showActiveFiam(Activity activity) {
        BindingWrapper b2;
        if (this.inAppMessage != null && !this.headlessInAppMessaging.areMessagesSuppressed()) {
            notifyFiamTrigger();
            InAppMessageLayoutConfig inAppMessageLayoutConfig = this.layoutConfigs.get(InflaterConfigModule.a(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
            if (this.inAppMessage.getMessageType() == MessageType.MODAL) {
                b2 = this.bindingWrapperFactory.c(inAppMessageLayoutConfig, this.inAppMessage);
            } else if (this.inAppMessage.getMessageType() == MessageType.BANNER) {
                b2 = this.bindingWrapperFactory.a(inAppMessageLayoutConfig, this.inAppMessage);
            } else {
                b2 = this.bindingWrapperFactory.b(inAppMessageLayoutConfig, this.inAppMessage);
            }
            activity.findViewById(android.R.id.content).post(new b(this, activity, b2));
            return;
        }
        Logging.c("No active message found to render");
    }

    @Keep
    @KeepForSdk
    public void clearFiamListener() {
        this.fiamListener = null;
    }

    InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    @KeepForSdk
    public void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
        this.headlessInAppMessaging.clearDisplayListener();
        this.imageLoader.a(activity.getClass());
        removeDisplayedFiam(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    @KeepForSdk
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    @Keep
    @KeepForSdk
    public void onActivityStarted(Activity activity) {
        this.firebaseInAppMessagingDisplay = new a(this, activity);
        this.headlessInAppMessaging.setMessageDisplayComponent(this.firebaseInAppMessagingDisplay);
    }

    @Keep
    @KeepForSdk
    public void setFiamListener(FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    @Keep
    @KeepForSdk
    public void testMessage(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }
}
