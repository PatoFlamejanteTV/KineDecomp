package com.google.android.gms.ads.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzgr
/* loaded from: classes.dex */
public final class zzq implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public zzhx A;
    View B;
    public int C;
    boolean D;
    boolean E;
    private HashSet<zzht> F;
    private int G;
    private int H;
    private zzik I;
    private boolean J;
    private boolean K;
    private boolean L;

    /* renamed from: a */
    final String f668a;
    public String b;
    public final Context c;
    final zzan d;
    public final VersionInfoParcel e;
    zza f;
    public zzhz g;
    public zzgh h;
    public AdSizeParcel i;
    public zzhs j;
    public zzhs.zza k;
    public zzht l;
    com.google.android.gms.ads.internal.client.zzn m;
    com.google.android.gms.ads.internal.client.zzo n;
    zzu o;
    zzv p;
    zzfs q;
    zzfw r;
    zzcw s;
    zzcx t;
    zzmi<String, zzcy> u;
    zzmi<String, zzcz> v;
    NativeAdOptionsParcel w;
    zzck x;
    List<String> y;
    com.google.android.gms.ads.internal.purchase.zzk z;

    /* loaded from: classes.dex */
    public static class zza extends ViewSwitcher {

        /* renamed from: a */
        private final zzif f669a;
        private final zzim b;

        public zza(Context context, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f669a = new zzif(context);
            if (!(context instanceof Activity)) {
                this.b = null;
            } else {
                this.b = new zzim((Activity) context, onGlobalLayoutListener, onScrollChangedListener);
                this.b.zzgO();
            }
        }

        public zzif a() {
            return this.f669a;
        }

        public void b() {
            com.google.android.gms.ads.internal.util.client.zzb.d("Disable position monitoring on adFrame.");
            if (this.b != null) {
                this.b.zzgP();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.b != null) {
                this.b.onAttachedToWindow();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.b != null) {
                this.b.onDetachedFromWindow();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f669a.zze(motionEvent);
            return false;
        }

        @Override // android.widget.ViewAnimator, android.view.ViewGroup
        public void removeAllViews() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                KeyEvent.Callback childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof zziz)) {
                    arrayList.add((zziz) childAt);
                }
                i = i2 + 1;
            }
            super.removeAllViews();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zziz) it.next()).destroy();
            }
        }
    }

    public zzq(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    zzq(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzan zzanVar) {
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = null;
        this.G = -1;
        this.H = -1;
        this.J = true;
        this.K = true;
        this.L = false;
        zzby.initialize(context);
        if (zzp.h().zzgo() != null) {
            List<String> zzdf = zzby.zzdf();
            if (versionInfoParcel.c != 0) {
                zzdf.add(Integer.toString(versionInfoParcel.c));
            }
            zzp.h().zzgo().zzb(zzdf);
        }
        this.f668a = UUID.randomUUID().toString();
        if (adSizeParcel.e || adSizeParcel.i) {
            this.f = null;
        } else {
            this.f = new zza(context, this, this);
            this.f.setMinimumWidth(adSizeParcel.g);
            this.f.setMinimumHeight(adSizeParcel.d);
            this.f.setVisibility(4);
        }
        this.i = adSizeParcel;
        this.b = str;
        this.c = context;
        this.e = versionInfoParcel;
        this.d = zzanVar == null ? new zzan(new g(this)) : zzanVar;
        this.I = new zzik(200L);
        this.v = new zzmi<>();
    }

    private void b(boolean z) {
        if (this.f == null || this.j == null || this.j.zzBD == null) {
            return;
        }
        if (!z || this.I.tryAcquire()) {
            if (this.j.zzBD.zzhe().zzbY()) {
                int[] iArr = new int[2];
                this.f.getLocationOnScreen(iArr);
                int b = com.google.android.gms.ads.internal.client.zzl.a().b(this.c, iArr[0]);
                int b2 = com.google.android.gms.ads.internal.client.zzl.a().b(this.c, iArr[1]);
                if (b != this.G || b2 != this.H) {
                    this.G = b;
                    this.H = b2;
                    this.j.zzBD.zzhe().zza(this.G, this.H, z ? false : true);
                }
            }
            k();
        }
    }

    private void k() {
        View findViewById = this.f.getRootView().findViewById(R.id.content);
        if (findViewById == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.f.getGlobalVisibleRect(rect);
        findViewById.getGlobalVisibleRect(rect2);
        if (rect.top != rect2.top) {
            this.J = false;
        }
        if (rect.bottom != rect2.bottom) {
            this.K = false;
        }
    }

    public HashSet<zzht> a() {
        return this.F;
    }

    public void a(HashSet<zzht> hashSet) {
        this.F = hashSet;
    }

    public void a(boolean z) {
        if (this.C == 0) {
            c();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.h != null) {
            this.h.cancel();
        }
        if (z) {
            this.j = null;
        }
    }

    public void b() {
        if (this.j == null || this.j.zzBD == null) {
            return;
        }
        this.j.zzBD.destroy();
    }

    public void c() {
        if (this.j == null || this.j.zzBD == null) {
            return;
        }
        this.j.zzBD.stopLoading();
    }

    public void d() {
        if (this.j == null || this.j.zzzv == null) {
            return;
        }
        try {
            this.j.zzzv.destroy();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not destroy mediation adapter.");
        }
    }

    public boolean e() {
        return this.C == 0;
    }

    public boolean f() {
        return this.C == 1;
    }

    public void g() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public String h() {
        return (this.J && this.K) ? "" : this.J ? this.L ? "top-scrollable" : "top-locked" : this.K ? this.L ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public void i() {
        this.l.zzl(this.j.zzHz);
        this.l.zzm(this.j.zzHA);
        this.l.zzy(this.i.e);
        this.l.zzz(this.j.zzEK);
    }

    public void j() {
        g();
        this.n = null;
        this.o = null;
        this.r = null;
        this.q = null;
        this.x = null;
        this.p = null;
        a(false);
        if (this.f != null) {
            this.f.removeAllViews();
        }
        b();
        d();
        this.j = null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        b(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        b(true);
        this.L = true;
    }
}
