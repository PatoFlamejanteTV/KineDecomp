package com.qq.e.ads.hybrid;

import com.qq.e.comm.util.AdError;

/* loaded from: classes3.dex */
public interface HybridADListener {
    void onClose();

    void onError(AdError adError);

    void onLoadFinished();

    void onPageShow();
}
