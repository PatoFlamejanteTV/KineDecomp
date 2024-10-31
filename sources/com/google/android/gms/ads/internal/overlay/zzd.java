package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzfk;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziz;
import java.util.Collections;
import org.keyczar.Keyczar;

@zzgr
/* loaded from: classes.dex */
public class zzd extends zzfk.zza implements zzo {

    /* renamed from: a, reason: collision with root package name */
    static final int f601a = Color.argb(0, 0, 0, 0);
    AdOverlayInfoParcel b;
    zziz c;
    zzc d;
    zzm e;
    FrameLayout g;
    WebChromeClient.CustomViewCallback h;
    RelativeLayout k;
    private final Activity n;
    private boolean o;
    boolean f = false;
    boolean i = false;
    boolean j = false;
    boolean l = false;
    int m = 0;
    private boolean p = false;
    private boolean q = true;

    @zzgr
    /* loaded from: classes.dex */
    static final class a extends RelativeLayout {

        /* renamed from: a, reason: collision with root package name */
        zzif f602a;

        public a(Context context, String str) {
            super(context);
            this.f602a = new zzif(context, str);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f602a.zze(motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @zzgr
    /* loaded from: classes.dex */
    public class b extends zzhz {
        private b() {
        }

        /* synthetic */ b(zzd zzdVar, h hVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzhz
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzhz
        public void zzbn() {
            Bitmap zzg = com.google.android.gms.ads.internal.zzp.e().zzg(zzd.this.n, zzd.this.b.q.d);
            if (zzg != null) {
                zzid.zzIE.post(new i(this, com.google.android.gms.ads.internal.zzp.g().zza(zzd.this.n, zzg, zzd.this.b.q.e, zzd.this.b.q.f)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @zzgr
    /* loaded from: classes.dex */
    public static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzgr
    /* loaded from: classes.dex */
    public static class zzc {

        /* renamed from: a, reason: collision with root package name */
        public final int f604a;
        public final ViewGroup.LayoutParams b;
        public final ViewGroup c;
        public final Context d;

        public zzc(zziz zzizVar) throws zza {
            this.b = zzizVar.getLayoutParams();
            ViewParent parent = zzizVar.getParent();
            this.d = zzizVar.zzha();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.c = (ViewGroup) parent;
            this.f604a = this.c.indexOfChild(zzizVar.getView());
            this.c.removeView(zzizVar.getView());
            zzizVar.zzC(true);
        }
    }

    public zzd(Activity activity) {
        this.n = activity;
    }

    public void a() {
        this.m = 2;
        this.n.finish();
    }

    public void a(int i) {
        this.n.setRequestedOrientation(i);
    }

    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.g = new FrameLayout(this.n);
        this.g.setBackgroundColor(-16777216);
        this.g.addView(view, -1, -1);
        this.n.setContentView(this.g);
        zzaE();
        this.h = customViewCallback;
        this.f = true;
    }

    public void a(boolean z) {
        this.e = new zzm(this.n, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.e.a(z, this.b.h);
        this.k.addView(this.e, layoutParams);
    }

    public void a(boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(z, z2);
        }
    }

    public void b() {
        if (this.b != null && this.f) {
            a(this.b.k);
        }
        if (this.g != null) {
            this.n.setContentView(this.k);
            zzaE();
            this.g.removeAllViews();
            this.g = null;
        }
        if (this.h != null) {
            this.h.onCustomViewHidden();
            this.h = null;
        }
        this.f = false;
    }

    protected void b(int i) {
        this.c.zzv(i);
    }

    protected void b(boolean z) throws zza {
        if (!this.o) {
            this.n.requestWindowFeature(1);
        }
        Window window = this.n.getWindow();
        if (window == null) {
            throw new zza("Invalid activity, no window available.");
        }
        if (!this.j || (this.b.q != null && this.b.q.c)) {
            window.setFlags(1024, 1024);
        }
        boolean zzbY = this.b.e.zzhe().zzbY();
        this.l = false;
        if (zzbY) {
            if (this.b.k == com.google.android.gms.ads.internal.zzp.g().zzgG()) {
                this.l = this.n.getResources().getConfiguration().orientation == 1;
            } else if (this.b.k == com.google.android.gms.ads.internal.zzp.g().zzgH()) {
                this.l = this.n.getResources().getConfiguration().orientation == 2;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Delay onShow to next orientation change: " + this.l);
        a(this.b.k);
        if (com.google.android.gms.ads.internal.zzp.g().zza(window)) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.j) {
            this.k.setBackgroundColor(f601a);
        } else {
            this.k.setBackgroundColor(-16777216);
        }
        this.n.setContentView(this.k);
        zzaE();
        if (z) {
            this.c = com.google.android.gms.ads.internal.zzp.f().zza(this.n, this.b.e.zzaN(), true, zzbY, null, this.b.n);
            this.c.zzhe().zzb(null, null, this.b.f, this.b.j, true, this.b.o, null, this.b.e.zzhe().zzhq(), null);
            this.c.zzhe().zza(new h(this));
            if (this.b.m != null) {
                this.c.loadUrl(this.b.m);
            } else {
                if (this.b.i == null) {
                    throw new zza("No URL or HTML to display in ad overlay.");
                }
                this.c.loadDataWithBaseURL(this.b.g, this.b.i, "text/html", Keyczar.DEFAULT_ENCODING, null);
            }
            if (this.b.e != null) {
                this.b.e.zzc(this);
            }
        } else {
            this.c = this.b.e;
            this.c.setContext(this.n);
        }
        this.c.zzb(this);
        ViewParent parent = this.c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.c.getView());
        }
        if (this.j) {
            this.c.setBackgroundColor(f601a);
        }
        this.k.addView(this.c.getView(), -1, -1);
        if (!z && !this.l) {
            g();
        }
        a(zzbY);
        if (this.c.zzhf()) {
            a(zzbY, true);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public void c() {
        this.m = 1;
        this.n.finish();
    }

    public void d() {
        this.k.removeView(this.e);
        a(true);
    }

    protected void e() {
        if (!this.n.isFinishing() || this.p) {
            return;
        }
        this.p = true;
        if (this.c != null) {
            b(this.m);
            this.k.removeView(this.c.getView());
            if (this.d != null) {
                this.c.setContext(this.d.d);
                this.c.zzC(false);
                this.d.c.addView(this.c.getView(), this.d.f604a, this.d.b);
                this.d = null;
            }
            this.c = null;
        }
        if (this.b == null || this.b.d == null) {
            return;
        }
        this.b.d.zzaV();
    }

    public void f() {
        if (this.l) {
            this.l = false;
            g();
        }
    }

    protected void g() {
        this.c.zzeJ();
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onBackPressed() {
        this.m = 0;
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onCreate(Bundle bundle) {
        this.i = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.b = AdOverlayInfoParcel.a(this.n.getIntent());
            if (this.b == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.b.n.d > 7500000) {
                this.m = 3;
            }
            if (this.n.getIntent() != null) {
                this.q = this.n.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.q != null) {
                this.j = this.b.q.b;
            } else {
                this.j = false;
            }
            if (zzby.zzvz.get().booleanValue() && this.j && this.b.q.d != null) {
                new b(this, null).zzfu();
            }
            if (bundle == null) {
                if (this.b.d != null && this.q) {
                    this.b.d.zzaW();
                }
                if (this.b.l != 1 && this.b.c != null) {
                    this.b.c.onAdClicked();
                }
            }
            this.k = new a(this.n, this.b.p);
            switch (this.b.l) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.d = new zzc(this.b.e);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                case 4:
                    if (this.i) {
                        this.m = 3;
                        this.n.finish();
                        return;
                    } else {
                        if (com.google.android.gms.ads.internal.zzp.b().a(this.n, this.b.b, this.b.j)) {
                            return;
                        }
                        this.m = 3;
                        this.n.finish();
                        return;
                    }
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
        } catch (zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.e(e.getMessage());
            this.m = 3;
            this.n.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onDestroy() {
        if (this.c != null) {
            this.k.removeView(this.c.getView());
        }
        e();
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onPause() {
        b();
        if (this.c != null && (!this.n.isFinishing() || this.d == null)) {
            com.google.android.gms.ads.internal.zzp.g().zza(this.c.getWebView());
        }
        e();
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onResume() {
        if (this.b != null && this.b.l == 4) {
            if (this.i) {
                this.m = 3;
                this.n.finish();
            } else {
                this.i = true;
            }
        }
        if (this.c == null || this.c.isDestroyed()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("The webview does not exit. Ignoring action.");
        } else {
            com.google.android.gms.ads.internal.zzp.g().zzb(this.c.getWebView());
        }
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.i);
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onStart() {
    }

    @Override // com.google.android.gms.internal.zzfk
    public void onStop() {
        e();
    }

    @Override // com.google.android.gms.internal.zzfk
    public void zzaE() {
        this.o = true;
    }

    @Override // com.google.android.gms.internal.zzfk
    public boolean zzeF() {
        this.m = 0;
        if (this.c == null) {
            return true;
        }
        boolean zzhk = this.c.zzhk();
        if (zzhk) {
            return zzhk;
        }
        this.c.zzb("onbackblocked", Collections.emptyMap());
        return zzhk;
    }
}
