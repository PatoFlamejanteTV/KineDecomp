package com.google.android.gms.games.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class PopupManager {

    /* renamed from: a */
    protected GamesClientImpl f1366a;
    protected PopupLocationInfo b;

    /* loaded from: classes.dex */
    public static final class PopupLocationInfo {

        /* renamed from: a */
        public IBinder f1367a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        private PopupLocationInfo(int i, IBinder iBinder) {
            this.c = -1;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.b = i;
            this.f1367a = iBinder;
        }

        /* synthetic */ PopupLocationInfo(int i, IBinder iBinder, AnonymousClass1 anonymousClass1) {
            this(i, iBinder);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.b);
            bundle.putInt("popupLocationInfo.displayId", this.c);
            bundle.putInt("popupLocationInfo.left", this.d);
            bundle.putInt("popupLocationInfo.top", this.e);
            bundle.putInt("popupLocationInfo.right", this.f);
            bundle.putInt("popupLocationInfo.bottom", this.g);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends PopupManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private WeakReference<View> c;
        private boolean d;

        protected a(GamesClientImpl gamesClientImpl, int i) {
            super(gamesClientImpl, i);
            this.d = false;
        }

        private void b(View view) {
            Display display;
            int i = -1;
            if (zzmx.zzqz() && (display = view.getDisplay()) != null) {
                i = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.b.c = i;
            this.b.f1367a = windowToken;
            this.b.d = iArr[0];
            this.b.e = iArr[1];
            this.b.f = iArr[0] + width;
            this.b.g = iArr[1] + height;
            if (this.d) {
                a();
                this.d = false;
            }
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        public void a() {
            if (this.b.f1367a != null) {
                super.a();
            } else {
                this.d = this.c != null;
            }
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        protected void a(int i) {
            this.b = new PopupLocationInfo(i, null);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        public void a(View view) {
            this.f1366a.b();
            if (this.c != null) {
                View view2 = this.c.get();
                Context context = this.f1366a.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzmx.zzqy()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.c = null;
            Context context2 = this.f1366a.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View findViewById = ((Activity) context2).findViewById(R.id.content);
                if (findViewById == null) {
                    findViewById = ((Activity) context2).getWindow().getDecorView();
                }
                GamesLog.a("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = findViewById;
            }
            if (view == null) {
                GamesLog.b("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
            b(view);
            this.c = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            if (this.c == null || (view = this.c.get()) == null) {
                return;
            }
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f1366a.b();
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int i) {
        this.f1366a = gamesClientImpl;
        a(i);
    }

    /* synthetic */ PopupManager(GamesClientImpl gamesClientImpl, int i, AnonymousClass1 anonymousClass1) {
        this(gamesClientImpl, i);
    }

    public static PopupManager a(GamesClientImpl gamesClientImpl, int i) {
        return zzmx.zzqv() ? new a(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void a() {
        this.f1366a.a(this.b.f1367a, this.b.a());
    }

    protected void a(int i) {
        this.b = new PopupLocationInfo(i, new Binder());
    }

    public void a(View view) {
    }

    public IBinder b() {
        return this.b.f1367a;
    }

    public PopupLocationInfo c() {
        return this.b;
    }
}
