package com.google.firebase.inappmessaging;

import android.app.Application;
import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Keep
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.a(FirebaseApp.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) componentContainer.a(FirebaseInstanceId.class);
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) componentContainer.a(AnalyticsConnector.class);
        Subscriber subscriber = (Subscriber) componentContainer.a(Subscriber.class);
        UniversalComponent a2 = DaggerUniversalComponent.m().a(new ApplicationModule((Application) firebaseApp.b())).a(new AppMeasurementModule(analyticsConnector, subscriber)).a(new AnalyticsEventsModule()).a();
        return DaggerAppComponent.b().a(new ApiClientModule(firebaseApp, firebaseInstanceId, a2.f())).a(new ClearcutLoggerClientModule(firebaseApp)).a(new GrpcClientModule(firebaseApp)).a(a2).a().a();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.a(FirebaseInAppMessaging.class).a(Dependency.b(FirebaseInstanceId.class)).a(Dependency.b(FirebaseApp.class)).a(Dependency.b(AnalyticsConnector.class)).a(Dependency.b(Subscriber.class)).a(l.a(this)).c().b());
    }
}
