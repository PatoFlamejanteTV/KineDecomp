package com.google.firebase.inappmessaging.internal;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class DataCollectionHelper {

    /* renamed from: a */
    private SharedPreferencesUtils f17727a;

    /* renamed from: b */
    private AtomicBoolean f17728b;

    @Inject
    public DataCollectionHelper(FirebaseApp firebaseApp, SharedPreferencesUtils sharedPreferencesUtils, FirebaseInstanceId firebaseInstanceId, Subscriber subscriber) {
        this.f17727a = sharedPreferencesUtils;
        this.f17728b = new AtomicBoolean(firebaseApp.g());
        if (a()) {
            firebaseInstanceId.d();
        }
        subscriber.a(DataCollectionDefaultChange.class, C1626f.a(this));
    }

    private boolean b() {
        return this.f17727a.a("firebase_inapp_messaging_auto_data_collection_enabled");
    }

    private boolean c() {
        return this.f17727a.b("auto_init");
    }

    public boolean a() {
        if (c()) {
            return this.f17727a.c("auto_init", true);
        }
        if (b()) {
            return this.f17727a.b("firebase_inapp_messaging_auto_data_collection_enabled", true);
        }
        return this.f17728b.get();
    }

    public void a(boolean z) {
        this.f17727a.d("auto_init", z);
    }
}
