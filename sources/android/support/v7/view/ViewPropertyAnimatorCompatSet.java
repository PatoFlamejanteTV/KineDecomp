package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c */
    private Interpolator f2398c;

    /* renamed from: d */
    ViewPropertyAnimatorListener f2399d;

    /* renamed from: e */
    private boolean f2400e;

    /* renamed from: b */
    private long f2397b = -1;

    /* renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f2401f = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.view.ViewPropertyAnimatorCompatSet.1

        /* renamed from: a */
        private boolean f2402a = false;

        /* renamed from: b */
        private int f2403b = 0;

        AnonymousClass1() {
        }

        void a() {
            this.f2403b = 0;
            this.f2402a = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.f2403b + 1;
            this.f2403b = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f2396a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2399d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f2402a) {
                return;
            }
            this.f2402a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2399d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    };

    /* renamed from: a */
    final ArrayList<ViewPropertyAnimatorCompat> f2396a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.view.ViewPropertyAnimatorCompatSet$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f2402a = false;

        /* renamed from: b */
        private int f2403b = 0;

        AnonymousClass1() {
        }

        void a() {
            this.f2403b = 0;
            this.f2402a = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.f2403b + 1;
            this.f2403b = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f2396a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2399d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f2402a) {
                return;
            }
            this.f2402a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2399d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    }

    void a() {
        this.f2400e = false;
    }

    public void cancel() {
        if (this.f2400e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f2396a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f2400e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f2400e) {
            this.f2396a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f2396a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f2396a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.f2400e) {
            this.f2397b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f2400e) {
            this.f2398c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f2400e) {
            this.f2399d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.f2400e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f2396a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j = this.f2397b;
            if (j >= 0) {
                next.setDuration(j);
            }
            Interpolator interpolator = this.f2398c;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.f2399d != null) {
                next.setListener(this.f2401f);
            }
            next.start();
        }
        this.f2400e = true;
    }
}
