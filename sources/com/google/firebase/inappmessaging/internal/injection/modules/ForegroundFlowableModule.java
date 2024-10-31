package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import io.reactivex.BackpressureStrategy;
import io.reactivex.e;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ForegroundFlowableModule {
    @Singleton
    @AppForeground
    public io.reactivex.b.a<String> a(Application application, ForegroundNotifier foregroundNotifier) {
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        io.reactivex.b.a<String> g2 = e.a(b.a(foregroundNotifier), BackpressureStrategy.BUFFER).g();
        g2.i();
        return g2;
    }
}
