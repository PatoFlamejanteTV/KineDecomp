package android.support.v4.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: a */
    static final Object f868a = new Object();

    /* renamed from: b */
    static final HashMap<ComponentName, WorkEnqueuer> f869b = new HashMap<>();

    /* renamed from: c */
    CompatJobEngine f870c;

    /* renamed from: d */
    WorkEnqueuer f871d;

    /* renamed from: e */
    CommandProcessor f872e;

    /* renamed from: f */
    boolean f873f = false;

    /* renamed from: g */
    boolean f874g = false;

    /* renamed from: h */
    boolean f875h = false;
    final ArrayList<CompatWorkItem> i;

    /* loaded from: classes.dex */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* loaded from: classes.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d */
        private final Context f877d;

        /* renamed from: e */
        private final PowerManager.WakeLock f878e;

        /* renamed from: f */
        private final PowerManager.WakeLock f879f;

        /* renamed from: g */
        boolean f880g;

        /* renamed from: h */
        boolean f881h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(context, componentName);
            this.f877d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f878e = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f878e.setReferenceCounted(false);
            this.f879f = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f879f.setReferenceCounted(false);
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f892a);
            if (this.f877d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f880g) {
                        this.f880g = true;
                        if (!this.f881h) {
                            this.f878e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.f881h) {
                    if (this.f880g) {
                        this.f878e.acquire(60000L);
                    }
                    this.f881h = false;
                    this.f879f.release();
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.f881h) {
                    this.f881h = true;
                    this.f879f.acquire(600000L);
                    this.f878e.release();
                }
            }
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.f880g = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a */
        final Intent f882a;

        /* renamed from: b */
        final int f883b;

        CompatWorkItem(Intent intent, int i) {
            this.f882a = intent;
            this.f883b = i;
        }

        @Override // android.support.v4.app.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.f883b);
        }

        @Override // android.support.v4.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f882a;
        }
    }

    /* loaded from: classes.dex */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a */
        final JobIntentService f885a;

        /* renamed from: b */
        final Object f886b;

        /* renamed from: c */
        JobParameters f887c;

        /* loaded from: classes.dex */
        final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a */
            final JobWorkItem f888a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f888a = jobWorkItem;
            }

            @Override // android.support.v4.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.f886b) {
                    if (JobServiceEngineImpl.this.f887c != null) {
                        JobServiceEngineImpl.this.f887c.completeWork(this.f888a);
                    }
                }
            }

            @Override // android.support.v4.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.f888a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f886b = new Object();
            this.f885a = jobIntentService;
        }

        @Override // android.support.v4.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.support.v4.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.f886b) {
                if (this.f887c == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.f887c.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.f885a.getClassLoader());
                return new WrapperWorkItem(dequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f887c = jobParameters;
            this.f885a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f885a.b();
            synchronized (this.f886b) {
                this.f887c = null;
            }
            return b2;
        }
    }

    /* loaded from: classes.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d */
        private final JobInfo f890d;

        /* renamed from: e */
        private final JobScheduler f891e;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(context, componentName);
            a(i);
            this.f890d = new JobInfo.Builder(i, this.f892a).setOverrideDeadline(0L).build();
            this.f891e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // android.support.v4.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            this.f891e.enqueue(this.f890d, new JobWorkItem(intent));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class WorkEnqueuer {

        /* renamed from: a */
        final ComponentName f892a;

        /* renamed from: b */
        boolean f893b;

        /* renamed from: c */
        int f894c;

        WorkEnqueuer(Context context, ComponentName componentName) {
            this.f892a = componentName;
        }

        void a(int i) {
            if (!this.f893b) {
                this.f893b = true;
                this.f894c = i;
            } else {
                if (this.f894c == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f894c);
            }
        }

        abstract void a(Intent intent);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.i = null;
        } else {
            this.i = new ArrayList<>();
        }
    }

    static WorkEnqueuer a(Context context, ComponentName componentName, boolean z, int i) {
        WorkEnqueuer compatWorkEnqueuer;
        WorkEnqueuer workEnqueuer = f869b.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (Build.VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else if (z) {
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
        f869b.put(componentName, workEnqueuer2);
        return workEnqueuer2;
    }

    public static void enqueueWork(Context context, Class cls, int i, Intent intent) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i, intent);
    }

    protected abstract void a(Intent intent);

    boolean b() {
        CommandProcessor commandProcessor = this.f872e;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f873f);
        }
        this.f874g = true;
        return onStopCurrentWork();
    }

    void c() {
        ArrayList<CompatWorkItem> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f872e = null;
                if (this.i != null && this.i.size() > 0) {
                    a(false);
                } else if (!this.f875h) {
                    this.f871d.serviceProcessingFinished();
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f874g;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f870c;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f870c = new JobServiceEngineImpl(this);
            this.f871d = null;
        } else {
            this.f870c = null;
            this.f871d = a(this, new ComponentName(this, (Class<?>) JobIntentService.class), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f875h = true;
                this.f871d.serviceProcessingFinished();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.i == null) {
            return 2;
        }
        this.f871d.serviceStartReceived();
        synchronized (this.i) {
            ArrayList<CompatWorkItem> arrayList = this.i;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i2));
            a(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.f873f = z;
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent != null) {
            synchronized (f868a) {
                WorkEnqueuer a2 = a(context, componentName, true, i);
                a2.a(i);
                a2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    /* loaded from: classes.dex */
    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.a(a2.getIntent());
                a2.complete();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            JobIntentService.this.c();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Void r1) {
            JobIntentService.this.c();
        }
    }

    void a(boolean z) {
        if (this.f872e == null) {
            this.f872e = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f871d;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.f872e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.f870c;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.i) {
            if (this.i.size() <= 0) {
                return null;
            }
            return this.i.remove(0);
        }
    }
}
