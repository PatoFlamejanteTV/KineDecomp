package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzazc;
import com.google.android.gms.internal.ads.zzbas;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzbx extends ViewSwitcher {

    /* renamed from: a, reason: collision with root package name */
    private final zzazc f10257a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbas f10258b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10259c;

    public zzbx(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.f10257a = new zzazc(context);
        this.f10257a.setAdUnitId(str);
        this.f10257a.zzee(str2);
        this.f10259c = true;
        if (context instanceof Activity) {
            this.f10258b = new zzbas((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.f10258b = new zzbas(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.f10258b.zzaam();
    }

    public final zzazc a() {
        return this.f10257a;
    }

    public final void b() {
        zzaxz.v("Disable position monitoring on adFrame.");
        zzbas zzbasVar = this.f10258b;
        if (zzbasVar != null) {
            zzbasVar.zzaan();
        }
    }

    public final void c() {
        zzaxz.v("Enable debug gesture detector on adFrame.");
        this.f10259c = true;
    }

    public final void d() {
        zzaxz.v("Disable debug gesture detector on adFrame.");
        this.f10259c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        zzbas zzbasVar = this.f10258b;
        if (zzbasVar != null) {
            zzbasVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zzbas zzbasVar = this.f10258b;
        if (zzbasVar != null) {
            zzbasVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f10259c) {
            return false;
        }
        this.f10257a.zze(motionEvent);
        return false;
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            KeyEvent.Callback childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzbgg)) {
                arrayList.add((zzbgg) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzbgg) obj).destroy();
        }
    }
}
