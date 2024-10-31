package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditState.java */
/* loaded from: classes.dex */
public class c extends i<Activity> {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3086a = new Handler(Looper.getMainLooper());
    private final Map<String, List<o>> b = new HashMap();
    private final Set<a> c = new HashSet();

    @Override // com.mixpanel.android.viewcrawler.i
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(Activity activity) {
        super.b((c) activity);
        c();
    }

    @Override // com.mixpanel.android.viewcrawler.i
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(Activity activity) {
        super.a((c) activity);
    }

    public void a(Map<String, List<o>> map) {
        synchronized (this.c) {
            Iterator<a> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.c.clear();
        }
        synchronized (this.b) {
            this.b.clear();
            this.b.putAll(map);
        }
        c();
    }

    private void c() {
        if (Thread.currentThread() == this.f3086a.getLooper().getThread()) {
            d();
        } else {
            this.f3086a.post(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<o> list;
        List<o> list2;
        for (Activity activity : a()) {
            String canonicalName = activity.getClass().getCanonicalName();
            View rootView = activity.getWindow().getDecorView().getRootView();
            synchronized (this.b) {
                list = this.b.get(canonicalName);
                list2 = this.b.get(null);
            }
            if (list != null) {
                a(rootView, list);
            }
            if (list2 != null) {
                a(rootView, list2);
            }
        }
    }

    private void a(View view, List<o> list) {
        synchronized (this.c) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.c.add(new a(view, list.get(i), this.f3086a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EditState.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        private final WeakReference<View> c;
        private final o d;
        private final Handler e;
        private boolean b = true;

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f3087a = false;

        public a(View view, o oVar, Handler handler) {
            this.d = oVar;
            this.c = new WeakReference<>(view);
            this.e = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                View view = this.c.get();
                if (view == null || this.f3087a) {
                    b();
                    return;
                }
                this.d.b(view);
                this.e.removeCallbacks(this);
                this.e.postDelayed(this, 1000L);
            }
        }

        public void a() {
            this.f3087a = true;
            this.e.post(this);
        }

        private void b() {
            if (this.b) {
                View view = this.c.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
                this.d.a();
            }
            this.b = false;
        }
    }
}
