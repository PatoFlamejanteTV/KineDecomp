package com.qq.e.ads.nativ;

import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class MediaListenerAdapter implements ADListener {

    /* renamed from: a */
    private MediaListener f24875a;

    public MediaListenerAdapter(MediaListener mediaListener) {
        this.f24875a = mediaListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f24875a.onVideoReady(((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 2:
                this.f24875a.onVideoStart();
                return;
            case 3:
                this.f24875a.onVideoPause();
                return;
            case 4:
                this.f24875a.onVideoComplete();
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f24875a.onVideoError(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 6:
                this.f24875a.onReplayButtonClicked();
                return;
            case 7:
                this.f24875a.onADButtonClicked();
                return;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Boolean)) {
                    this.f24875a.onFullScreenChanged(((Boolean) aDEvent.getParas()[0]).booleanValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            default:
                return;
        }
    }
}
