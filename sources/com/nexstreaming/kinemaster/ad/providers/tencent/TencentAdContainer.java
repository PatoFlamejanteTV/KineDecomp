package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.analytics.pro.b;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: TencentAdContainer.kt */
/* loaded from: classes.dex */
public final class TencentAdContainer extends FrameLayout {
    private HashMap _$_findViewCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TencentAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.b(context, b.Q);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ TencentAdContainer(Context context, AttributeSet attributeSet, int i, f fVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
