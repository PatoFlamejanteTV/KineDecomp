package android.support.v4.os;

import android.os.Build;

/* loaded from: classes.dex */
public final class CancellationSignal {

    /* renamed from: a */
    private boolean f1528a;

    /* renamed from: b */
    private OnCancelListener f1529b;

    /* renamed from: c */
    private Object f1530c;

    /* renamed from: d */
    private boolean f1531d;

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    private void a() {
        while (this.f1531d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            if (this.f1528a) {
                return;
            }
            this.f1528a = true;
            this.f1531d = true;
            OnCancelListener onCancelListener = this.f1529b;
            Object obj = this.f1530c;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1531d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((android.os.CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1531d = false;
                notifyAll();
            }
        }
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1530c == null) {
                this.f1530c = new android.os.CancellationSignal();
                if (this.f1528a) {
                    ((android.os.CancellationSignal) this.f1530c).cancel();
                }
            }
            obj = this.f1530c;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f1528a;
        }
        return z;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            a();
            if (this.f1529b == onCancelListener) {
                return;
            }
            this.f1529b = onCancelListener;
            if (this.f1528a && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
