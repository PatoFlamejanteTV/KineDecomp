package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import com.nextreaming.nexvideoeditor.NexThemeRenderer;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class EffectPreviewPlayer {

    /* renamed from: a, reason: collision with root package name */
    private NexThemeRenderer f3419a;
    private EffectLibrary b;
    private NexImageLoader.d c;
    private long h;
    private int i;
    private int j;
    private String k;
    private String l;
    private Thread n;
    private int o;
    private b p;
    private NexImageLoader s;
    private String t;
    private long u;
    private boolean v;
    private Surface w;
    private Object x;
    private Mode d = Mode.Stop;
    private boolean e = false;
    private List<b> f = new ArrayList();
    private String[] g = {"placeholder1.jpg", "placeholder2.jpg"};
    private int m = -1;
    private AtomicBoolean q = new AtomicBoolean();
    private AtomicBoolean r = new AtomicBoolean();
    private Runnable y = new t(this);

    /* loaded from: classes.dex */
    private enum Mode {
        ThemePlay,
        EffectPlay,
        Stop
    }

    public synchronized void a(Context context) {
        this.b = EffectLibrary.a(context);
        this.s = new NexImageLoader(context.getApplicationContext().getResources(), this.b.e(), this.c, 1440, 810, 1500000);
        this.n = new Thread(this.y);
        this.q.set(false);
        this.r.set(true);
        this.n.start();
    }

    private void c() {
        if (Thread.currentThread().getId() != this.u) {
            throw new IllegalStateException("called from wrong thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Theme theme, b bVar) {
        if (bVar == null) {
            throw new IllegalStateException("effect is null");
        }
        if (theme == null) {
            throw new IllegalStateException("theme is null");
        }
        if (bVar.a() == null) {
            throw new IllegalStateException("effect ID is null");
        }
        if (theme.i() == null) {
            throw new IllegalStateException("theme ID is null");
        }
        if (bVar.a().equals(theme.a(ThemeEffectType.OPENING))) {
            return 1;
        }
        if (bVar.a().equals(theme.a(ThemeEffectType.MIDDLE))) {
            return 2;
        }
        if (bVar.a().equals(theme.a(ThemeEffectType.ACCENT))) {
            return 3;
        }
        if (bVar.a().equals(theme.a(ThemeEffectType.TRANSITION))) {
            return 4;
        }
        if (bVar instanceof at) {
            return 5;
        }
        if (bVar.a().equals(theme.a(ThemeEffectType.ENDING))) {
            return 7;
        }
        return 6;
    }

    public synchronized void a(Theme theme) {
        if ((theme != this.x || this.d != Mode.ThemePlay) && this.f3419a != null) {
            this.f.clear();
            for (String str : theme.d()) {
                b c = this.b.c(str);
                if (c != null) {
                    this.f.add(c);
                    Log.i("EffectPreviewPlayer", "Cannot find effect for ID: " + String.valueOf(str) + " in theme " + theme.i());
                }
            }
            Collections.sort(this.f, new u(this, theme));
            this.t = this.b.a(this.f);
            this.h = System.nanoTime();
            this.d = Mode.ThemePlay;
            d();
            this.x = theme;
        }
    }

    private synchronized int a(b bVar) {
        int i;
        if (bVar instanceof at) {
            i = 1800;
        } else if (bVar instanceof a) {
            i = 2200;
        } else {
            i = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        }
        return i;
    }

    private synchronized void d() {
        this.o = 0;
        this.j = 50;
        for (b bVar : this.f) {
            this.j += a(bVar) + 250;
            if (bVar instanceof at) {
                this.o++;
            }
        }
        if (this.o < 1) {
            this.o = 1;
        }
    }

    public synchronized void a() {
        c();
        if (this.f3419a != null && this.e) {
            boolean z = false;
            boolean z2 = false;
            if (this.d != Mode.Stop) {
                long nanoTime = (System.nanoTime() - this.h) / 1000000;
                if (nanoTime < this.j) {
                    z2 = true;
                }
                this.i = (int) (nanoTime % (this.j * 2));
                if (this.i >= this.j) {
                    z = true;
                    this.i -= this.j;
                }
            }
            boolean z3 = z2;
            boolean z4 = z;
            if (this.t != null) {
                this.f3419a.a(this.t);
                this.t = null;
            }
            if (this.f3419a.aquireContext() != 0) {
                Log.w("EffectPreviewPlayer", "render : no context");
            } else {
                int i = 0;
                int i2 = 0;
                Iterator<b> it = this.f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    int a2 = a(next);
                    int i3 = i + a2;
                    int i4 = i3 + 250;
                    if (this.i < i3) {
                        int i5 = this.i - i;
                        int length = ((z4 ? this.o : 0) + i2) % this.g.length;
                        if (length != this.m) {
                            this.f3419a.setPlaceholders(this.g[length], this.g[(length + 1) % this.g.length]);
                            this.m = length;
                        }
                        if (this.p != next || this.l != this.k) {
                            this.f3419a.clearTransitionEffect();
                            this.f3419a.clearClipEffect();
                            String str = "0," + a2 + "?" + this.k + "?" + this.k;
                            if (next instanceof at) {
                                this.f3419a.setTransitionEffect(next.a(), str, i2 + (z3 ? 0 : 1), this.o + 2, i, i3);
                            } else if (next instanceof a) {
                                this.f3419a.setClipEffect(next.a(), str, i2 + (z3 ? 0 : 1), this.o + 2, i - 50, i3 + 50, i, i3);
                            }
                            this.p = next;
                            this.l = this.k;
                        }
                        this.f3419a.setCTS(this.i);
                    } else {
                        if (this.i < i4) {
                            break;
                        }
                        i2 = next instanceof at ? i2 + 1 : i2;
                        i = i4;
                    }
                }
                this.f3419a.render();
                this.f3419a.releaseContext(true);
            }
        }
    }

    public synchronized void a(Surface surface) {
        this.w = surface;
        this.v = true;
        this.n.interrupt();
    }

    public void b() {
        this.q.set(true);
        this.n.interrupt();
        while (this.r.get()) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.n = null;
    }
}
