package com.google.firebase.database.android;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.core.Platform;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.logging.AndroidLogger;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class AndroidPlatform implements Platform {

    /* renamed from: a, reason: collision with root package name */
    private final Context f16656a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f16657b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseApp f16658c;

    public AndroidPlatform(FirebaseApp firebaseApp) {
        this.f16658c = firebaseApp;
        FirebaseApp firebaseApp2 = this.f16658c;
        if (firebaseApp2 != null) {
            this.f16656a = firebaseApp2.b();
            return;
        }
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    @Override // com.google.firebase.database.core.Platform
    public String b(com.google.firebase.database.core.Context context) {
        return Build.VERSION.SDK_INT + "/Android";
    }

    @Override // com.google.firebase.database.core.Platform
    public RunLoop c(com.google.firebase.database.core.Context context) {
        return new f(this, context.a("RunLoop"));
    }

    @Override // com.google.firebase.database.core.Platform
    public EventTarget a(com.google.firebase.database.core.Context context) {
        return new AndroidEventTarget();
    }

    @Override // com.google.firebase.database.core.Platform
    public AuthTokenProvider a(ScheduledExecutorService scheduledExecutorService) {
        return new AndroidAuthTokenProvider(this.f16658c, scheduledExecutorService);
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistentConnection a(com.google.firebase.database.core.Context context, ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        PersistentConnectionImpl persistentConnectionImpl = new PersistentConnectionImpl(connectionContext, hostInfo, delegate);
        this.f16658c.a(new g(this, persistentConnectionImpl));
        return persistentConnectionImpl;
    }

    @Override // com.google.firebase.database.core.Platform
    public Logger a(com.google.firebase.database.core.Context context, Logger.Level level, List<String> list) {
        return new AndroidLogger(level, list);
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistenceManager a(com.google.firebase.database.core.Context context, String str) {
        String j = context.j();
        String str2 = str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + j;
        if (!this.f16657b.contains(str2)) {
            this.f16657b.add(str2);
            return new DefaultPersistenceManager(context, new SqlPersistenceStorageEngine(this.f16656a, context, str2), new LRUCachePolicy(context.g()));
        }
        throw new DatabaseException("SessionPersistenceKey '" + j + "' has already been used.");
    }

    @Override // com.google.firebase.database.core.Platform
    public File a() {
        return this.f16656a.getApplicationContext().getDir("sslcache", 0);
    }
}
