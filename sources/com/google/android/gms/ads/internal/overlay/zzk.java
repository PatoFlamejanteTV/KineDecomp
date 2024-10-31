package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;
import java.util.HashMap;

@zzgr
/* loaded from: classes.dex */
public class zzk extends FrameLayout implements zzh {

    /* renamed from: a, reason: collision with root package name */
    private final zziz f605a;
    private final FrameLayout b;
    private final j c;
    private zzi d;
    private boolean e;
    private boolean f;
    private TextView g;
    private long h;
    private long i;
    private String j;
    private String k;

    public zzk(Context context, zziz zzizVar, int i, zzcg zzcgVar, zzce zzceVar) {
        super(context);
        this.f605a = zzizVar;
        this.b = new FrameLayout(context);
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.zzb.a(zzizVar.zzhb());
        this.d = zzizVar.zzhb().b.a(context, zzizVar, i, zzcgVar, zzceVar);
        if (this.d != null) {
            this.b.addView(this.d, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.g = new TextView(context);
        this.g.setBackgroundColor(-16777216);
        o();
        this.c = new j(this);
        this.c.b();
        if (this.d != null) {
            this.d.a(this);
        }
        if (this.d == null) {
            a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void a(zziz zzizVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzizVar.zzb("onVideoEvent", hashMap);
    }

    private void a(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                hashMap.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.f605a.zzb("onVideoEvent", hashMap);
    }

    private void o() {
        if (q()) {
            return;
        }
        this.b.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        this.b.bringChildToFront(this.g);
    }

    private void p() {
        if (q()) {
            this.b.removeView(this.g);
        }
    }

    private boolean q() {
        return this.g.getParent() != null;
    }

    private void r() {
        if (this.f605a.zzgZ() == null || this.e) {
            return;
        }
        this.f = (this.f605a.zzgZ().getWindow().getAttributes().flags & 128) != 0;
        if (this.f) {
            return;
        }
        this.f605a.zzgZ().getWindow().addFlags(128);
        this.e = true;
    }

    private void s() {
        if (this.f605a.zzgZ() == null || !this.e || this.f) {
            return;
        }
        this.f605a.zzgZ().getWindow().clearFlags(128);
        this.e = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void a() {
    }

    public void a(float f) {
        if (this.d == null) {
            return;
        }
        this.d.a(f);
    }

    public void a(int i) {
        if (this.d == null) {
            return;
        }
        this.d.a(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3 + 2, i4 + 2);
        layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
        this.b.setLayoutParams(layoutParams);
        requestLayout();
    }

    public void a(MotionEvent motionEvent) {
        if (this.d == null) {
            return;
        }
        this.d.dispatchTouchEvent(motionEvent);
    }

    public void a(String str) {
        this.k = str;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void a(String str, String str2) {
        a("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void b() {
        if (this.d != null && this.i == 0) {
            a("canplaythrough", "duration", String.valueOf(this.d.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.d.getVideoWidth()), "videoHeight", String.valueOf(this.d.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void c() {
        r();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void d() {
        a("pause", new String[0]);
        s();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void e() {
        a("ended", new String[0]);
        s();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void f() {
        o();
        this.i = this.h;
    }

    public void g() {
        if (this.d == null) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            a("no_src", new String[0]);
        } else {
            this.d.setMimeType(this.j);
            this.d.setVideoPath(this.k);
        }
    }

    public void h() {
        if (this.d == null) {
            return;
        }
        this.d.d();
    }

    public void i() {
        if (this.d == null) {
            return;
        }
        this.d.c();
    }

    public void j() {
        if (this.d == null) {
            return;
        }
        this.d.e();
    }

    public void k() {
        if (this.d == null) {
            return;
        }
        this.d.f();
    }

    public void l() {
        if (this.d == null) {
            return;
        }
        TextView textView = new TextView(this.d.getContext());
        textView.setText("AdMob - " + this.d.a());
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.b.bringChildToFront(textView);
    }

    public void m() {
        this.c.a();
        if (this.d != null) {
            this.d.b();
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (this.d == null) {
            return;
        }
        long currentPosition = this.d.getCurrentPosition();
        if (this.h == currentPosition || currentPosition <= 0) {
            return;
        }
        p();
        a("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.h = currentPosition;
    }

    public void setMimeType(String str) {
        this.j = str;
    }
}
