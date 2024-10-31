package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static TooltipCompatHandler f3144a;

    /* renamed from: b */
    private static TooltipCompatHandler f3145b;

    /* renamed from: c */
    private final View f3146c;

    /* renamed from: d */
    private final CharSequence f3147d;

    /* renamed from: e */
    private final Runnable f3148e = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.a(false);
        }
    };

    /* renamed from: f */
    private final Runnable f3149f = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.b();
        }
    };

    /* renamed from: g */
    private int f3150g;

    /* renamed from: h */
    private int f3151h;
    private TooltipPopup i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.TooltipCompatHandler$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.TooltipCompatHandler$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.b();
        }
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f3146c = view;
        this.f3147d = charSequence;
        this.f3146c.setOnLongClickListener(this);
        this.f3146c.setOnHoverListener(this);
    }

    public void b() {
        if (f3145b == this) {
            f3145b = null;
            TooltipPopup tooltipPopup = this.i;
            if (tooltipPopup != null) {
                tooltipPopup.a();
                this.i = null;
                this.f3146c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f3144a == this) {
            b(null);
        }
        this.f3146c.removeCallbacks(this.f3149f);
    }

    private void c() {
        this.f3146c.postDelayed(this.f3148e, ViewConfiguration.getLongPressTimeout());
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = f3144a;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f3146c == view) {
            b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = f3145b;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f3146c == view) {
                tooltipCompatHandler2.b();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f3146c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
            }
        } else if (this.f3146c.isEnabled() && this.i == null) {
            this.f3150g = (int) motionEvent.getX();
            this.f3151h = (int) motionEvent.getY();
            b(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f3150g = view.getWidth() / 2;
        this.f3151h = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }

    public void a(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        if (ViewCompat.isAttachedToWindow(this.f3146c)) {
            b(null);
            TooltipCompatHandler tooltipCompatHandler = f3145b;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.b();
            }
            f3145b = this;
            this.j = z;
            this.i = new TooltipPopup(this.f3146c.getContext());
            this.i.a(this.f3146c, this.f3150g, this.f3151h, this.j, this.f3147d);
            this.f3146c.addOnAttachStateChangeListener(this);
            if (this.j) {
                j2 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f3146c) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.f3146c.removeCallbacks(this.f3149f);
            this.f3146c.postDelayed(this.f3149f, j2);
        }
    }

    private static void b(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f3144a;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.a();
        }
        f3144a = tooltipCompatHandler;
        TooltipCompatHandler tooltipCompatHandler3 = f3144a;
        if (tooltipCompatHandler3 != null) {
            tooltipCompatHandler3.c();
        }
    }

    private void a() {
        this.f3146c.removeCallbacks(this.f3148e);
    }
}
