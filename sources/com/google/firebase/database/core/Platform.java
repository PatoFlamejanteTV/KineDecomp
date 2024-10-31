package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface Platform {
    PersistentConnection a(Context context, ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate);

    AuthTokenProvider a(ScheduledExecutorService scheduledExecutorService);

    EventTarget a(Context context);

    PersistenceManager a(Context context, String str);

    Logger a(Context context, Logger.Level level, List<String> list);

    File a();

    String b(Context context);

    RunLoop c(Context context);
}
