package io.reactivex.internal.util;

import io.reactivex.q;
import java.io.Serializable;

/* loaded from: classes3.dex */
public enum NotificationLite {
    COMPLETE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.disposables.b upstream;

        DisposableNotification(io.reactivex.disposables.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e */
        final Throwable f28476e;

        ErrorNotification(Throwable th) {
            this.f28476e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return io.reactivex.d.a.b.a(this.f28476e, ((ErrorNotification) obj).f28476e);
            }
            return false;
        }

        public int hashCode() {
            return this.f28476e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f28476e + "]";
        }
    }

    /* loaded from: classes3.dex */
    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final g.b.c upstream;

        SubscriptionNotification(g.b.c cVar) {
            this.upstream = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, g.b.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            bVar.onError(((ErrorNotification) obj).f28476e);
            return true;
        }
        bVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, g.b.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            bVar.onError(((ErrorNotification) obj).f28476e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            bVar.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        }
        bVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.disposables.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static io.reactivex.disposables.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f28476e;
    }

    public static g.b.c getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(g.b.c cVar) {
        return new SubscriptionNotification(cVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, q<? super T> qVar) {
        if (obj == COMPLETE) {
            qVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            qVar.onError(((ErrorNotification) obj).f28476e);
            return true;
        }
        qVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, q<? super T> qVar) {
        if (obj == COMPLETE) {
            qVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            qVar.onError(((ErrorNotification) obj).f28476e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            qVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        qVar.onNext(obj);
        return false;
    }
}
