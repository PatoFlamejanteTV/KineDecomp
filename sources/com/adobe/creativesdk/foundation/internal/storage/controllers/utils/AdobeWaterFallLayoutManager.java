package com.adobe.creativesdk.foundation.internal.storage.controllers.utils;

import android.content.Context;
import android.util.AttributeSet;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.StaggeredGridLayoutManager;

/* loaded from: classes.dex */
public class AdobeWaterFallLayoutManager extends StaggeredGridLayoutManager {
    private a K;
    private int L;

    /* loaded from: classes.dex */
    public interface a {
        int a();

        int a(int i);
    }

    public AdobeWaterFallLayoutManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = -1;
    }

    private int a(int i, boolean z) {
        int a2 = this.K.a();
        return z ? a2 : a2 / this.K.a(i);
    }

    public AdobeWaterFallLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = -1;
    }

    public StaggeredGridLayoutManager.a a(StaggeredGridLayoutManager.a aVar, int i, boolean z) {
        StaggeredGridLayoutManager.a aVar2 = new StaggeredGridLayoutManager.a(aVar);
        aVar2.f6825e = a(i, z);
        return aVar2;
    }

    public AdobeWaterFallLayoutManager(int i) {
        super(TwoWayLayoutManager.Orientation.VERTICAL, i, 1);
        this.L = -1;
    }

    public void a(a aVar) {
        this.K = aVar;
    }
}
