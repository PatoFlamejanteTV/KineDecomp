package com.google.firebase.inappmessaging.display;

import android.app.Application;
import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@Keep
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI(ComponentContainer componentContainer) {
        FirebaseApp c2 = FirebaseApp.c();
        FirebaseInAppMessaging firebaseInAppMessaging = (FirebaseInAppMessaging) componentContainer.a(FirebaseInAppMessaging.class);
        Application application = (Application) c2.b();
        FirebaseInAppMessagingDisplay a2 = DaggerAppComponent.b().a(DaggerUniversalComponent.e().a(new ApplicationModule(application)).a()).a(new HeadlessInAppMessagingModule(firebaseInAppMessaging)).a().a();
        application.registerActivityLifecycleCallbacks(a2);
        return a2;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.a(FirebaseInAppMessagingDisplay.class).a(Dependency.b(FirebaseApp.class)).a(Dependency.b(AnalyticsConnector.class)).a(Dependency.b(FirebaseInAppMessaging.class)).a(i.a(this)).c().b());
    }
}
