package com.qq.e.comm.pi;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface NSPVI {
    public static final Map<String, String> ext = new HashMap();

    void fetchAndShowIn(ViewGroup viewGroup);

    void setAdListener(ADListener aDListener);

    void setFetchDelay(int i);

    void setSkipView(View view);
}
