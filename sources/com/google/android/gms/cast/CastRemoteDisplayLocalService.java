package com.google.android.gms.cast;

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.d.a;
import com.google.android.gms.cast.internal.zzl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class CastRemoteDisplayLocalService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private static final zzl f823a = new zzl("CastRemoteDisplayLocalService");
    private static final int b = com.google.android.gms.R.id.cast_notification_id;
    private static final Object c = new Object();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private final a.AbstractC0017a e = new d(this);
    private final IBinder f = new a(this, null);

    /* loaded from: classes.dex */
    public interface Callbacks {
    }

    /* loaded from: classes.dex */
    public static final class NotificationSettings {

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private NotificationSettings f824a = new NotificationSettings(null);
        }

        private NotificationSettings() {
        }

        /* synthetic */ NotificationSettings(d dVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a extends Binder {
        private a() {
        }

        /* synthetic */ a(CastRemoteDisplayLocalService castRemoteDisplayLocalService, d dVar) {
            this();
        }
    }
}
