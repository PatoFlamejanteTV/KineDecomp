package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    private WeakReference<View> f1866a;

    /* renamed from: b */
    Runnable f1867b = null;

    /* renamed from: c */
    Runnable f1868c = null;

    /* renamed from: d */
    int f1869d = -1;

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewPropertyAnimatorListener f1870a;

        /* renamed from: b */
        final /* synthetic */ View f1871b;

        AnonymousClass1(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            viewPropertyAnimatorListener = viewPropertyAnimatorListener;
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            viewPropertyAnimatorListener.onAnimationEnd(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ ViewPropertyAnimatorUpdateListener f1873a;

        /* renamed from: b */
        final /* synthetic */ View f1874b;

        AnonymousClass2(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            viewPropertyAnimatorUpdateListener = viewPropertyAnimatorUpdateListener;
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        ViewPropertyAnimatorCompat f1876a;

        /* renamed from: b */
        boolean f1877b;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1876a = viewPropertyAnimatorCompat;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.f1876a.f1869d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f1876a.f1869d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1877b) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1876a;
                Runnable runnable = viewPropertyAnimatorCompat.f1868c;
                if (runnable != null) {
                    viewPropertyAnimatorCompat.f1868c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
                this.f1877b = true;
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            this.f1877b = false;
            if (this.f1876a.f1869d > -1) {
                view.setLayerType(2, null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1876a;
            Runnable runnable = viewPropertyAnimatorCompat.f1867b;
            if (runnable != null) {
                viewPropertyAnimatorCompat.f1867b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.f1866a = new WeakReference<>(view);
    }

    private void a(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompat.1

                /* renamed from: a */
                final /* synthetic */ ViewPropertyAnimatorListener f1870a;

                /* renamed from: b */
                final /* synthetic */ View f1871b;

                AnonymousClass1(ViewPropertyAnimatorListener viewPropertyAnimatorListener2, View view2) {
                    viewPropertyAnimatorListener = viewPropertyAnimatorListener2;
                    view = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view2.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().alphaBy(f2);
        }
        return this;
    }

    public void cancel() {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.f1866a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view = this.f1866a.get();
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        return (Interpolator) view.animate().getInterpolator();
    }

    public long getStartDelay() {
        View view = this.f1866a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotation(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotationBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotationX(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotationXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotationY(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().rotationYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().scaleX(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().scaleXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().scaleY(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().scaleYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f1866a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                a(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = this.f1866a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.view.ViewPropertyAnimatorCompat.2

                /* renamed from: a */
                final /* synthetic */ ViewPropertyAnimatorUpdateListener f1873a;

                /* renamed from: b */
                final /* synthetic */ View f1874b;

                AnonymousClass2(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener2, View view2) {
                    viewPropertyAnimatorUpdateListener = viewPropertyAnimatorUpdateListener2;
                    view = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            } : null);
        }
        return this;
    }

    public void start() {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().translationXBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().translationYBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f2) {
        View view = this.f1866a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZ(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f2) {
        View view = this.f1866a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.f1866a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withEndAction(runnable);
            } else {
                a(view, new ViewPropertyAnimatorListenerApi14(this));
                this.f1868c = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.f1866a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withLayer();
            } else {
                this.f1869d = view.getLayerType();
                a(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.f1866a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withStartAction(runnable);
            } else {
                a(view, new ViewPropertyAnimatorListenerApi14(this));
                this.f1867b = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().x(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().xBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().y(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f2) {
        View view = this.f1866a.get();
        if (view != null) {
            view.animate().yBy(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f2) {
        View view = this.f1866a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().z(f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f2) {
        View view = this.f1866a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().zBy(f2);
        }
        return this;
    }
}
