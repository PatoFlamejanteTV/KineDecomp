package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzj extends zzco.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    int b;
    int c;
    private final FrameLayout e;
    private final FrameLayout f;
    private a h;
    private zzh i;
    private final Object d = new Object();
    private final Map<String, WeakReference<View>> g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    boolean f579a = false;

    public zzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.e = frameLayout;
        this.f = frameLayout2;
        zziu.zza((View) this.e, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zziu.zza((View) this.e, (ViewTreeObserver.OnScrollChangedListener) this);
        this.e.setOnTouchListener(this);
    }

    int a() {
        return this.e.getMeasuredWidth();
    }

    int a(int i) {
        return zzl.a().b(this.i.e(), i);
    }

    Point a(MotionEvent motionEvent) {
        this.e.getLocationOnScreen(new int[2]);
        return new Point((int) (motionEvent.getRawX() - r0[0]), (int) (motionEvent.getRawY() - r0[1]));
    }

    Point a(View view) {
        if (this.h == null || !this.h.a().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.e.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    a a(zzh zzhVar) {
        return zzhVar.a(this);
    }

    int b() {
        return this.e.getMeasuredHeight();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        synchronized (this.d) {
            if (this.i == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, WeakReference<View>> entry : this.g.entrySet()) {
                View view2 = entry.getValue().get();
                Point a2 = a(view2);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", a(view2.getWidth()));
                    jSONObject2.put("height", a(view2.getHeight()));
                    jSONObject2.put("x", a(a2.x));
                    jSONObject2.put("y", a(a2.y));
                    jSONObject.put(entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                    zzb.e("Unable to get view rectangle for view " + entry.getKey());
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("x", a(this.b));
                jSONObject3.put("y", a(this.c));
            } catch (JSONException e2) {
                zzb.e("Unable to get click location");
            }
            if (this.h == null || !this.h.a().equals(view)) {
                this.i.a(view, this.g, jSONObject, jSONObject3);
            } else {
                this.i.a("1007", jSONObject, jSONObject3);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        synchronized (this.d) {
            if (this.f579a) {
                int a2 = a();
                int b = b();
                if (a2 != 0 && b != 0) {
                    this.f.setLayoutParams(new FrameLayout.LayoutParams(a2, b));
                    this.f579a = false;
                }
            }
            if (this.i != null) {
                this.i.b(this.e);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        synchronized (this.d) {
            if (this.i != null) {
                this.i.b(this.e);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.d) {
            if (this.i != null) {
                Point a2 = a(motionEvent);
                this.b = a2.x;
                this.c = a2.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation(a2.x, a2.y);
                this.i.a(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzco
    public com.google.android.gms.dynamic.zzd zzW(String str) {
        com.google.android.gms.dynamic.zzd a2;
        synchronized (this.d) {
            WeakReference<View> weakReference = this.g.get(str);
            a2 = com.google.android.gms.dynamic.zze.a(weakReference == null ? null : weakReference.get());
        }
        return a2;
    }

    @Override // com.google.android.gms.internal.zzco
    public void zza(String str, com.google.android.gms.dynamic.zzd zzdVar) {
        View view = (View) com.google.android.gms.dynamic.zze.a(zzdVar);
        synchronized (this.d) {
            if (view == null) {
                this.g.remove(str);
            } else {
                this.g.put(str, new WeakReference<>(view));
                view.setOnTouchListener(this);
                view.setOnClickListener(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzco
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar) {
        synchronized (this.d) {
            this.f579a = true;
            zzh zzhVar = (zzh) com.google.android.gms.dynamic.zze.a(zzdVar);
            if ((this.i instanceof zzg) && ((zzg) this.i).b()) {
                ((zzg) this.i).a(zzhVar);
            } else {
                this.i = zzhVar;
                if (this.i instanceof zzg) {
                    ((zzg) this.i).a((zzh) null);
                }
            }
            this.f.removeAllViews();
            this.h = a(zzhVar);
            if (this.h != null) {
                this.g.put("1007", new WeakReference<>(this.h.a()));
                this.f.addView(this.h);
            }
            zzid.zzIE.post(new h(this, zzhVar));
            zzhVar.a(this.e);
        }
    }
}
