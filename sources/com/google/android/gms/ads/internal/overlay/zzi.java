package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbgg;

@VisibleForTesting
@zzark
/* loaded from: classes.dex */
public final class zzi {

    /* renamed from: a, reason: collision with root package name */
    public final int f10134a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup.LayoutParams f10135b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f10136c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f10137d;

    public zzi(zzbgg zzbggVar) throws zzg {
        this.f10135b = zzbggVar.getLayoutParams();
        ViewParent parent = zzbggVar.getParent();
        this.f10137d = zzbggVar.zzadg();
        if (parent != null && (parent instanceof ViewGroup)) {
            this.f10136c = (ViewGroup) parent;
            this.f10134a = this.f10136c.indexOfChild(zzbggVar.getView());
            this.f10136c.removeView(zzbggVar.getView());
            zzbggVar.zzav(true);
            return;
        }
        throw new zzg("Could not get the parent of the WebView for an overlay.");
    }
}
