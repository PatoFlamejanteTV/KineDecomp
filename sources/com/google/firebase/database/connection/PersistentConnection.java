package com.google.firebase.database.connection;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface PersistentConnection {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface Delegate {
        void a();

        void a(List<String> list, Object obj, boolean z, Long l);

        void a(List<String> list, List<RangeMerge> list2, Long l);

        void a(Map<String, Object> map);

        void a(boolean z);

        void onDisconnect();
    }

    void a(List<String> list, Object obj, RequestResultCallback requestResultCallback);

    void a(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback);

    void a(List<String> list, Map<String, Object> map);

    void a(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l, RequestResultCallback requestResultCallback);

    void a(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback);

    void b(String str);

    void d();

    void d(String str);

    void e(String str);
}
