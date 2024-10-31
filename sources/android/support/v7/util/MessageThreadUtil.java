package android.support.v7.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.util.MessageThreadUtil$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {

        /* renamed from: a */
        final MessageQueue f2328a = new MessageQueue();

        /* renamed from: b */
        private final Handler f2329b = new Handler(Looper.getMainLooper());

        /* renamed from: c */
        private Runnable f2330c = new Runnable() { // from class: android.support.v7.util.MessageThreadUtil.1.1
            RunnableC00061() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem a2 = AnonymousClass1.this.f2328a.a();
                while (a2 != null) {
                    int i = a2.what;
                    if (i == 1) {
                        AnonymousClass1.this.f2331d.updateItemCount(a2.arg1, a2.arg2);
                    } else if (i == 2) {
                        AnonymousClass1.this.f2331d.addTile(a2.arg1, (TileList.Tile) a2.data);
                    } else if (i != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass1.this.f2331d.removeTile(a2.arg1, a2.arg2);
                    }
                    a2 = AnonymousClass1.this.f2328a.a();
                }
            }
        };

        /* renamed from: d */
        final /* synthetic */ ThreadUtil.MainThreadCallback f2331d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: android.support.v7.util.MessageThreadUtil$1$1 */
        /* loaded from: classes.dex */
        public class RunnableC00061 implements Runnable {
            RunnableC00061() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem a2 = AnonymousClass1.this.f2328a.a();
                while (a2 != null) {
                    int i = a2.what;
                    if (i == 1) {
                        AnonymousClass1.this.f2331d.updateItemCount(a2.arg1, a2.arg2);
                    } else if (i == 2) {
                        AnonymousClass1.this.f2331d.addTile(a2.arg1, (TileList.Tile) a2.data);
                    } else if (i != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass1.this.f2331d.removeTile(a2.arg1, a2.arg2);
                    }
                    a2 = AnonymousClass1.this.f2328a.a();
                }
            }
        }

        AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.f2331d = mainThreadCallback;
        }

        private void a(SyncQueueItem syncQueueItem) {
            this.f2328a.a(syncQueueItem);
            this.f2329b.post(this.f2330c);
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            a(SyncQueueItem.a(2, i, tile));
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            a(SyncQueueItem.a(3, i, i2));
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            a(SyncQueueItem.a(1, i, i2));
        }
    }

    /* loaded from: classes.dex */
    public static class SyncQueueItem {

        /* renamed from: a */
        private static SyncQueueItem f2342a;

        /* renamed from: b */
        private static final Object f2343b = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;

        /* renamed from: c */
        private SyncQueueItem f2344c;
        public Object data;
        public int what;

        SyncQueueItem() {
        }

        void a() {
            this.f2344c = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (f2343b) {
                if (f2342a != null) {
                    this.f2344c = f2342a;
                }
                f2342a = this;
            }
        }

        static SyncQueueItem a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f2343b) {
                if (f2342a == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = f2342a;
                    f2342a = f2342a.f2344c;
                    syncQueueItem.f2344c = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem a(int i, int i2, int i3) {
            return a(i, i2, i3, 0, 0, 0, null);
        }

        static SyncQueueItem a(int i, int i2, Object obj) {
            return a(i, i2, 0, 0, 0, 0, obj);
        }
    }

    @Override // android.support.v7.util.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(backgroundCallback);
    }

    @Override // android.support.v7.util.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.util.MessageThreadUtil$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        final MessageQueue f2334a = new MessageQueue();

        /* renamed from: b */
        private final Executor f2335b = AsyncTask.THREAD_POOL_EXECUTOR;

        /* renamed from: c */
        AtomicBoolean f2336c = new AtomicBoolean(false);

        /* renamed from: d */
        private Runnable f2337d = new Runnable() { // from class: android.support.v7.util.MessageThreadUtil.2.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a2 = AnonymousClass2.this.f2334a.a();
                    if (a2 == null) {
                        AnonymousClass2.this.f2336c.set(false);
                        return;
                    }
                    int i = a2.what;
                    if (i == 1) {
                        AnonymousClass2.this.f2334a.a(1);
                        AnonymousClass2.this.f2338e.refresh(a2.arg1);
                    } else if (i == 2) {
                        AnonymousClass2.this.f2334a.a(2);
                        AnonymousClass2.this.f2334a.a(3);
                        AnonymousClass2.this.f2338e.updateRange(a2.arg1, a2.arg2, a2.arg3, a2.arg4, a2.arg5);
                    } else if (i == 3) {
                        AnonymousClass2.this.f2338e.loadTile(a2.arg1, a2.arg2);
                    } else if (i != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass2.this.f2338e.recycleTile((TileList.Tile) a2.data);
                    }
                }
            }
        };

        /* renamed from: e */
        final /* synthetic */ ThreadUtil.BackgroundCallback f2338e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: android.support.v7.util.MessageThreadUtil$2$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a2 = AnonymousClass2.this.f2334a.a();
                    if (a2 == null) {
                        AnonymousClass2.this.f2336c.set(false);
                        return;
                    }
                    int i = a2.what;
                    if (i == 1) {
                        AnonymousClass2.this.f2334a.a(1);
                        AnonymousClass2.this.f2338e.refresh(a2.arg1);
                    } else if (i == 2) {
                        AnonymousClass2.this.f2334a.a(2);
                        AnonymousClass2.this.f2334a.a(3);
                        AnonymousClass2.this.f2338e.updateRange(a2.arg1, a2.arg2, a2.arg3, a2.arg4, a2.arg5);
                    } else if (i == 3) {
                        AnonymousClass2.this.f2338e.loadTile(a2.arg1, a2.arg2);
                    } else if (i != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass2.this.f2338e.recycleTile((TileList.Tile) a2.data);
                    }
                }
            }
        }

        AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.f2338e = backgroundCallback;
        }

        private void a(SyncQueueItem syncQueueItem) {
            this.f2334a.a(syncQueueItem);
            a();
        }

        private void b(SyncQueueItem syncQueueItem) {
            this.f2334a.b(syncQueueItem);
            a();
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            a(SyncQueueItem.a(3, i, i2));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            a(SyncQueueItem.a(4, 0, tile));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            b(SyncQueueItem.a(1, i, (Object) null));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            b(SyncQueueItem.a(2, i, i2, i3, i4, i5, null));
        }

        private void a() {
            if (this.f2336c.compareAndSet(false, true)) {
                this.f2335b.execute(this.f2337d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MessageQueue {

        /* renamed from: a */
        private SyncQueueItem f2341a;

        MessageQueue() {
        }

        synchronized SyncQueueItem a() {
            if (this.f2341a == null) {
                return null;
            }
            SyncQueueItem syncQueueItem = this.f2341a;
            this.f2341a = this.f2341a.f2344c;
            return syncQueueItem;
        }

        synchronized void b(SyncQueueItem syncQueueItem) {
            syncQueueItem.f2344c = this.f2341a;
            this.f2341a = syncQueueItem;
        }

        synchronized void a(SyncQueueItem syncQueueItem) {
            if (this.f2341a == null) {
                this.f2341a = syncQueueItem;
                return;
            }
            SyncQueueItem syncQueueItem2 = this.f2341a;
            while (syncQueueItem2.f2344c != null) {
                syncQueueItem2 = syncQueueItem2.f2344c;
            }
            syncQueueItem2.f2344c = syncQueueItem;
        }

        synchronized void a(int i) {
            while (this.f2341a != null && this.f2341a.what == i) {
                SyncQueueItem syncQueueItem = this.f2341a;
                this.f2341a = this.f2341a.f2344c;
                syncQueueItem.a();
            }
            if (this.f2341a != null) {
                SyncQueueItem syncQueueItem2 = this.f2341a;
                SyncQueueItem syncQueueItem3 = syncQueueItem2.f2344c;
                while (syncQueueItem3 != null) {
                    SyncQueueItem syncQueueItem4 = syncQueueItem3.f2344c;
                    if (syncQueueItem3.what == i) {
                        syncQueueItem2.f2344c = syncQueueItem4;
                        syncQueueItem3.a();
                    } else {
                        syncQueueItem2 = syncQueueItem3;
                    }
                    syncQueueItem3 = syncQueueItem4;
                }
            }
        }
    }
}
