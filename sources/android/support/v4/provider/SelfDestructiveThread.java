package android.support.v4.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class SelfDestructiveThread {

    /* renamed from: b */
    private HandlerThread f1638b;

    /* renamed from: c */
    private Handler f1639c;

    /* renamed from: f */
    private final int f1642f;

    /* renamed from: g */
    private final int f1643g;

    /* renamed from: h */
    private final String f1644h;

    /* renamed from: a */
    private final Object f1637a = new Object();

    /* renamed from: e */
    private Handler.Callback f1641e = new Handler.Callback() { // from class: android.support.v4.provider.SelfDestructiveThread.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.a();
                return true;
            }
            if (i != 1) {
                return true;
            }
            SelfDestructiveThread.this.a((Runnable) message.obj);
            return true;
        }
    };

    /* renamed from: d */
    private int f1640d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.provider.SelfDestructiveThread$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.a();
                return true;
            }
            if (i != 1) {
                return true;
            }
            SelfDestructiveThread.this.a((Runnable) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.provider.SelfDestructiveThread$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callable f1646a;

        /* renamed from: b */
        final /* synthetic */ Handler f1647b;

        /* renamed from: c */
        final /* synthetic */ ReplyCallback f1648c;

        /* renamed from: android.support.v4.provider.SelfDestructiveThread$2$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Object f1650a;

            AnonymousClass1(Object obj) {
                obj = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                replyCallback.onReply(obj);
            }
        }

        AnonymousClass2(Callable callable, Handler handler, ReplyCallback replyCallback) {
            callable = callable;
            handler = handler;
            replyCallback = replyCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = callable.call();
            } catch (Exception unused) {
                obj = null;
            }
            handler.post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2.1

                /* renamed from: a */
                final /* synthetic */ Object f1650a;

                AnonymousClass1(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    replyCallback.onReply(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.provider.SelfDestructiveThread$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f1652a;

        /* renamed from: b */
        final /* synthetic */ Callable f1653b;

        /* renamed from: c */
        final /* synthetic */ ReentrantLock f1654c;

        /* renamed from: d */
        final /* synthetic */ AtomicBoolean f1655d;

        /* renamed from: e */
        final /* synthetic */ Condition f1656e;

        AnonymousClass3(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            atomicReference = atomicReference;
            callable = callable;
            reentrantLock = reentrantLock;
            atomicBoolean = atomicBoolean;
            newCondition = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                atomicReference.set(callable.call());
            } catch (Exception unused) {
            }
            reentrantLock.lock();
            try {
                atomicBoolean.set(false);
                newCondition.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.f1644h = str;
        this.f1643g = i;
        this.f1642f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f1637a) {
            if (this.f1638b == null) {
                this.f1638b = new HandlerThread(this.f1644h, this.f1643g);
                this.f1638b.start();
                this.f1639c = new Handler(this.f1638b.getLooper(), this.f1641e);
                this.f1640d++;
            }
            this.f1639c.removeMessages(0);
            this.f1639c.sendMessage(this.f1639c.obtainMessage(1, runnable));
        }
    }

    public int getGeneration() {
        int i;
        synchronized (this.f1637a) {
            i = this.f1640d;
        }
        return i;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f1637a) {
            z = this.f1638b != null;
        }
        return z;
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        b(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2

            /* renamed from: a */
            final /* synthetic */ Callable f1646a;

            /* renamed from: b */
            final /* synthetic */ Handler f1647b;

            /* renamed from: c */
            final /* synthetic */ ReplyCallback f1648c;

            /* renamed from: android.support.v4.provider.SelfDestructiveThread$2$1 */
            /* loaded from: classes.dex */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Object f1650a;

                AnonymousClass1(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    replyCallback.onReply(obj);
                }
            }

            AnonymousClass2(Callable callable2, Handler handler, ReplyCallback replyCallback2) {
                callable = callable2;
                handler = handler;
                replyCallback = replyCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                try {
                    obj2 = callable.call();
                } catch (Exception unused) {
                    obj2 = null;
                }
                handler.post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2.1

                    /* renamed from: a */
                    final /* synthetic */ Object f1650a;

                    AnonymousClass1(Object obj22) {
                        obj = obj22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.onReply(obj);
                    }
                });
            }
        });
    }

    public <T> T postAndWait(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.3

            /* renamed from: a */
            final /* synthetic */ AtomicReference f1652a;

            /* renamed from: b */
            final /* synthetic */ Callable f1653b;

            /* renamed from: c */
            final /* synthetic */ ReentrantLock f1654c;

            /* renamed from: d */
            final /* synthetic */ AtomicBoolean f1655d;

            /* renamed from: e */
            final /* synthetic */ Condition f1656e;

            AnonymousClass3(AtomicReference atomicReference2, Callable callable2, ReentrantLock reentrantLock2, AtomicBoolean atomicBoolean2, Condition newCondition2) {
                atomicReference = atomicReference2;
                callable = callable2;
                reentrantLock = reentrantLock2;
                atomicBoolean = atomicBoolean2;
                newCondition = newCondition2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock2.lock();
        try {
            if (!atomicBoolean2.get()) {
                return (T) atomicReference2.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition2.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean2.get()) {
                    return (T) atomicReference2.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock2.unlock();
        }
    }

    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f1637a) {
            this.f1639c.removeMessages(0);
            this.f1639c.sendMessageDelayed(this.f1639c.obtainMessage(0), this.f1642f);
        }
    }

    public void a() {
        synchronized (this.f1637a) {
            if (this.f1639c.hasMessages(1)) {
                return;
            }
            this.f1638b.quit();
            this.f1638b = null;
            this.f1639c = null;
        }
    }
}
