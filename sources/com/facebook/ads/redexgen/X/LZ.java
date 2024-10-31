package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public interface LZ {
    boolean A5C();

    boolean A5D();

    int getCurrentPositionInMillis();

    boolean getGlobalVisibleRect(Rect rect);

    long getInitialBufferTime();

    int getMeasuredHeight();

    int getMeasuredWidth();

    QH getVideoStartReason();

    @Nullable
    View getView();

    float getVolume();
}
