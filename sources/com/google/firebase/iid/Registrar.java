package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes2.dex */
public final class Registrar implements ComponentRegistrar {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements FirebaseInstanceIdInternal {

        /* renamed from: a, reason: collision with root package name */
        private final FirebaseInstanceId f17342a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f17342a = firebaseInstanceId;
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(Component.a(FirebaseInstanceId.class).a(Dependency.b(FirebaseApp.class)).a(Dependency.b(Subscriber.class)).a(C1614k.f17360a).a().b(), Component.a(FirebaseInstanceIdInternal.class).a(Dependency.b(FirebaseInstanceId.class)).a(C1615l.f17361a).b());
    }
}
