package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.ThreadInitializer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class DefaultRunLoop implements RunLoop {

    /* renamed from: a */
    private ScheduledThreadPoolExecutor f17051a = new com.google.firebase.database.core.utilities.a(this, 1, new a(this, null));

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public class a implements ThreadFactory {
        private a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = DefaultRunLoop.this.c().newThread(runnable);
            ThreadInitializer d2 = DefaultRunLoop.this.d();
            d2.a(newThread, "FirebaseDatabaseWorker");
            d2.a(newThread, true);
            d2.a(newThread, new b(this));
            return newThread;
        }

        /* synthetic */ a(DefaultRunLoop defaultRunLoop, com.google.firebase.database.core.utilities.a aVar) {
            this();
        }
    }

    public DefaultRunLoop() {
        this.f17051a.setKeepAliveTime(3L, TimeUnit.SECONDS);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void a(Runnable runnable) {
        this.f17051a.execute(runnable);
    }

    public abstract void a(Throwable th);

    public ScheduledExecutorService b() {
        return this.f17051a;
    }

    protected ThreadFactory c() {
        return Executors.defaultThreadFactory();
    }

    protected ThreadInitializer d() {
        return ThreadInitializer.f16946a;
    }

    public static String b(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof DatabaseException) {
            return "";
        }
        return "Uncaught exception in Firebase Database runloop (" + FirebaseDatabase.b() + "). Please report to firebase-database-client@google.com";
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void a() {
        this.f17051a.setCorePoolSize(1);
    }
}
