package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.iid.m */
/* loaded from: classes2.dex */
public final class C1616m {

    /* renamed from: a */
    private final Executor f17362a;

    /* renamed from: b */
    private final Map<Pair<String, String>, Task<String>> f17363b = new ArrayMap();

    public C1616m(Executor executor) {
        this.f17362a = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Task<String> a(String str, String str2, InterfaceC1618o interfaceC1618o) {
        Pair pair = new Pair(str, str2);
        Task<String> task = this.f17363b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task b2 = interfaceC1618o.a().b(this.f17362a, new Continuation(this, pair) { // from class: com.google.firebase.iid.n

            /* renamed from: a, reason: collision with root package name */
            private final C1616m f17364a;

            /* renamed from: b, reason: collision with root package name */
            private final Pair f17365b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17364a = this;
                this.f17365b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                this.f17364a.a(this.f17365b, task2);
                return task2;
            }
        });
        this.f17363b.put(pair, b2);
        return b2;
    }

    public final /* synthetic */ Task a(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f17363b.remove(pair);
        }
        return task;
    }
}
