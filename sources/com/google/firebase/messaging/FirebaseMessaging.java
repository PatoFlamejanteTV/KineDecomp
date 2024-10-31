package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FirebaseMessaging {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f18050a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: b, reason: collision with root package name */
    private static FirebaseMessaging f18051b;

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseInstanceId f18052c;

    private FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        this.f18052c = firebaseInstanceId;
    }

    public static synchronized FirebaseMessaging a() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            if (f18051b == null) {
                f18051b = new FirebaseMessaging(FirebaseInstanceId.b());
            }
            firebaseMessaging = f18051b;
        }
        return firebaseMessaging;
    }

    public void a(boolean z) {
        this.f18052c.b(z);
    }
}
