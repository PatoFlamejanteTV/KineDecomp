package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* compiled from: SharedPreferencesLoader.java */
/* loaded from: classes.dex */
class aa {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3016a = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SharedPreferencesLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        FutureTask futureTask = new FutureTask(new a(context, str, bVar));
        this.f3016a.execute(futureTask);
        return futureTask;
    }

    /* compiled from: SharedPreferencesLoader.java */
    /* loaded from: classes.dex */
    private static class a implements Callable<SharedPreferences> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f3017a;
        private final String b;
        private final b c;

        public a(Context context, String str, b bVar) {
            this.f3017a = context;
            this.b = str;
            this.c = bVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f3017a.getSharedPreferences(this.b, 0);
            if (this.c != null) {
                this.c.a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }
}
