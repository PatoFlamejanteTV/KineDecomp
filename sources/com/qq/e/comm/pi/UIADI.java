package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface UIADI {
    public static final Map<String, String> ext = new HashMap();

    void close();

    void destory();

    void loadAd();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);
}
