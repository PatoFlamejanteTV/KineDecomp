package com.google.firebase.crash.component;

import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.events.Subscriber;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public class FirebaseCrashRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.a(FirebaseCrash.class).a(Dependency.b(FirebaseApp.class)).a(Dependency.b(Subscriber.class)).a(Dependency.a(AnalyticsConnector.class)).a(a.f16618a).c().b());
    }
}
