package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.Pools;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public final class AsyncLayoutInflater {

    /* renamed from: a */
    LayoutInflater f1773a;

    /* renamed from: d */
    private Handler.Callback f1776d = new Handler.Callback() { // from class: android.support.v4.view.AsyncLayoutInflater.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f1782d == null) {
                inflateRequest.f1782d = AsyncLayoutInflater.this.f1773a.inflate(inflateRequest.f1781c, inflateRequest.f1780b, false);
            }
            inflateRequest.f1783e.onInflateFinished(inflateRequest.f1782d, inflateRequest.f1781c, inflateRequest.f1780b);
            AsyncLayoutInflater.this.f1775c.releaseRequest(inflateRequest);
            return true;
        }
    };

    /* renamed from: b */
    Handler f1774b = new Handler(this.f1776d);

    /* renamed from: c */
    InflateThread f1775c = InflateThread.getInstance();

    /* renamed from: android.support.v4.view.AsyncLayoutInflater$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f1782d == null) {
                inflateRequest.f1782d = AsyncLayoutInflater.this.f1773a.inflate(inflateRequest.f1781c, inflateRequest.f1780b, false);
            }
            inflateRequest.f1783e.onInflateFinished(inflateRequest.f1782d, inflateRequest.f1781c, inflateRequest.f1780b);
            AsyncLayoutInflater.this.f1775c.releaseRequest(inflateRequest);
            return true;
        }
    }

    /* loaded from: classes.dex */
    private static class BasicInflater extends LayoutInflater {

        /* renamed from: a */
        private static final String[] f1778a = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : f1778a) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class InflateRequest {

        /* renamed from: a */
        AsyncLayoutInflater f1779a;

        /* renamed from: b */
        ViewGroup f1780b;

        /* renamed from: c */
        int f1781c;

        /* renamed from: d */
        View f1782d;

        /* renamed from: e */
        OnInflateFinishedListener f1783e;

        InflateRequest() {
        }
    }

    /* loaded from: classes.dex */
    private static class InflateThread extends Thread {

        /* renamed from: a */
        private static final InflateThread f1784a = new InflateThread();

        /* renamed from: b */
        private ArrayBlockingQueue<InflateRequest> f1785b = new ArrayBlockingQueue<>(10);

        /* renamed from: c */
        private Pools.SynchronizedPool<InflateRequest> f1786c = new Pools.SynchronizedPool<>(10);

        static {
            f1784a.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return f1784a;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.f1785b.put(inflateRequest);
            } catch (InterruptedException e2) {
                throw new RuntimeException("Failed to enqueue async inflate request", e2);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.f1786c.acquire();
            return acquire == null ? new InflateRequest() : acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.f1783e = null;
            inflateRequest.f1779a = null;
            inflateRequest.f1780b = null;
            inflateRequest.f1781c = 0;
            inflateRequest.f1782d = null;
            this.f1786c.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.f1785b.take();
                try {
                    take.f1782d = take.f1779a.f1773a.inflate(take.f1781c, take.f1780b, false);
                } catch (RuntimeException e2) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e2);
                }
                Message.obtain(take.f1779a.f1774b, 0, take).sendToTarget();
            } catch (InterruptedException e3) {
                Log.w("AsyncLayoutInflater", e3);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(Context context) {
        this.f1773a = new BasicInflater(context);
    }

    public void inflate(int i, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            InflateRequest obtainRequest = this.f1775c.obtainRequest();
            obtainRequest.f1779a = this;
            obtainRequest.f1781c = i;
            obtainRequest.f1780b = viewGroup;
            obtainRequest.f1783e = onInflateFinishedListener;
            this.f1775c.enqueue(obtainRequest);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
