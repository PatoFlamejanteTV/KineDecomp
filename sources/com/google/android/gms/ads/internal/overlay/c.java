package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzazc;

@VisibleForTesting
@zzark
/* loaded from: classes.dex */
public final class c extends RelativeLayout {

    /* renamed from: a */
    @VisibleForTesting
    private zzazc f10108a;

    /* renamed from: b */
    @VisibleForTesting
    boolean f10109b;

    public c(Context context, String str, String str2) {
        super(context);
        this.f10108a = new zzazc(context, str);
        this.f10108a.zzee(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f10109b) {
            return false;
        }
        this.f10108a.zze(motionEvent);
        return false;
    }
}
