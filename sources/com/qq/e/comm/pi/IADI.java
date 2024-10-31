package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: classes3.dex */
public interface IADI {
    void closePopupWindow();

    void destory();

    void loadAd();

    void setAdListener(ADListener aDListener);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void show(Activity activity);

    void showAsPopupWindown();

    void showAsPopupWindown(Activity activity);
}
