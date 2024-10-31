package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ApiClientModule {

    /* renamed from: a */
    private final FirebaseApp f17913a;

    /* renamed from: b */
    private final FirebaseInstanceId f17914b;

    /* renamed from: c */
    private final Clock f17915c;

    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Clock clock) {
        this.f17913a = firebaseApp;
        this.f17914b = firebaseInstanceId;
        this.f17915c = clock;
    }

    public FirebaseApp a() {
        return this.f17913a;
    }

    public FirebaseInstanceId b() {
        return this.f17914b;
    }

    public SharedPreferencesUtils c() {
        return new SharedPreferencesUtils(this.f17913a);
    }

    public DataCollectionHelper a(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.f17913a, sharedPreferencesUtils, this.f17914b, subscriber);
    }

    public TestDeviceHelper a(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    @FirebaseAppScope
    public ApiClient a(GrpcClient grpcClient, Application application, DataCollectionHelper dataCollectionHelper) {
        return new ApiClient(grpcClient, this.f17913a, application, this.f17914b, dataCollectionHelper, this.f17915c);
    }
}
