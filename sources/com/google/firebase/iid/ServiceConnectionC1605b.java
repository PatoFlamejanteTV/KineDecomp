package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.b */
/* loaded from: classes2.dex */
public final class ServiceConnectionC1605b implements ServiceConnection {

    /* renamed from: a */
    int f17343a;

    /* renamed from: b */
    final Messenger f17344b;

    /* renamed from: c */
    C1610g f17345c;

    /* renamed from: d */
    final Queue<AbstractC1612i<?>> f17346d;

    /* renamed from: e */
    final SparseArray<AbstractC1612i<?>> f17347e;

    /* renamed from: f */
    final /* synthetic */ zzab f17348f;

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceConnectionC1605b(zzab zzabVar) {
        this.f17348f = zzabVar;
        this.f17343a = 0;
        this.f17344b = new Messenger(new com.google.android.gms.internal.firebase_messaging.zza(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.c

            /* renamed from: a, reason: collision with root package name */
            private final ServiceConnectionC1605b f17349a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17349a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f17349a.a(message);
            }
        }));
        this.f17346d = new ArrayDeque();
        this.f17347e = new SparseArray<>();
    }

    private final void c() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f17348f.f17405c;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.e

            /* renamed from: a, reason: collision with root package name */
            private final ServiceConnectionC1605b f17351a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17351a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final AbstractC1612i poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final ServiceConnectionC1605b serviceConnectionC1605b = this.f17351a;
                while (true) {
                    synchronized (serviceConnectionC1605b) {
                        if (serviceConnectionC1605b.f17343a != 2) {
                            return;
                        }
                        if (serviceConnectionC1605b.f17346d.isEmpty()) {
                            serviceConnectionC1605b.b();
                            return;
                        }
                        poll = serviceConnectionC1605b.f17346d.poll();
                        serviceConnectionC1605b.f17347e.put(poll.f17356a, poll);
                        scheduledExecutorService2 = serviceConnectionC1605b.f17348f.f17405c;
                        scheduledExecutorService2.schedule(new Runnable(serviceConnectionC1605b, poll) { // from class: com.google.firebase.iid.f

                            /* renamed from: a, reason: collision with root package name */
                            private final ServiceConnectionC1605b f17352a;

                            /* renamed from: b, reason: collision with root package name */
                            private final AbstractC1612i f17353b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f17352a = serviceConnectionC1605b;
                                this.f17353b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f17352a.a(this.f17353b.f17356a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = serviceConnectionC1605b.f17348f.f17404b;
                    Messenger messenger = serviceConnectionC1605b.f17344b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f17358c;
                    obtain.arg1 = poll.f17356a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle(ShareConstants.WEB_DIALOG_PARAM_DATA, poll.f17359d);
                    obtain.setData(bundle);
                    try {
                        serviceConnectionC1605b.f17345c.a(obtain);
                    } catch (RemoteException e2) {
                        serviceConnectionC1605b.a(2, e2.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized boolean a(AbstractC1612i abstractC1612i) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i = this.f17343a;
        if (i == 0) {
            this.f17346d.add(abstractC1612i);
            Preconditions.b(this.f17343a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f17343a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            ConnectionTracker a2 = ConnectionTracker.a();
            context = this.f17348f.f17404b;
            if (a2.a(context, intent, this, 1)) {
                scheduledExecutorService = this.f17348f.f17405c;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.d

                    /* renamed from: a, reason: collision with root package name */
                    private final ServiceConnectionC1605b f17350a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f17350a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17350a.a();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.f17346d.add(abstractC1612i);
            return true;
        }
        if (i == 2) {
            this.f17346d.add(abstractC1612i);
            c();
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.f17343a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    public final synchronized void b() {
        Context context;
        if (this.f17343a == 2 && this.f17346d.isEmpty() && this.f17347e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f17343a = 3;
            ConnectionTracker a2 = ConnectionTracker.a();
            context = this.f17348f.f17404b;
            a2.a(context, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            a(0, "Null service connection");
            return;
        }
        try {
            this.f17345c = new C1610g(iBinder);
            this.f17343a = 2;
            c();
        } catch (RemoteException e2) {
            a(0, e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        a(2, "Service disconnected");
    }

    public /* synthetic */ ServiceConnectionC1605b(zzab zzabVar, C1604a c1604a) {
        this(zzabVar);
    }

    public final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            AbstractC1612i<?> abstractC1612i = this.f17347e.get(i);
            if (abstractC1612i == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f17347e.remove(i);
            b();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                abstractC1612i.a(new zzal(4, "Not supported by GmsCore"));
            } else {
                abstractC1612i.a(data);
            }
            return true;
        }
    }

    public final synchronized void a(int i, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.f17343a;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.f17343a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            this.f17343a = 4;
            return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f17343a = 4;
        ConnectionTracker a2 = ConnectionTracker.a();
        context = this.f17348f.f17404b;
        a2.a(context, this);
        zzal zzalVar = new zzal(i, str);
        Iterator<AbstractC1612i<?>> it = this.f17346d.iterator();
        while (it.hasNext()) {
            it.next().a(zzalVar);
        }
        this.f17346d.clear();
        for (int i4 = 0; i4 < this.f17347e.size(); i4++) {
            this.f17347e.valueAt(i4).a(zzalVar);
        }
        this.f17347e.clear();
    }

    public final synchronized void a() {
        if (this.f17343a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void a(int i) {
        AbstractC1612i<?> abstractC1612i = this.f17347e.get(i);
        if (abstractC1612i != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f17347e.remove(i);
            abstractC1612i.a(new zzal(3, "Timed out waiting for response"));
            b();
        }
    }
}
