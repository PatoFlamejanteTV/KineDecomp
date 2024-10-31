package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface UBVI {
    public static final Map<String, String> ext = new HashMap();

    void destroy();

    void fetchAd();

    void onWindowFocusChanged(boolean z);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setRefresh(int i);
}
