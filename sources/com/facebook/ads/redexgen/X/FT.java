package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public interface FT {
    void A53();

    boolean A55();

    boolean A56();

    void A8P(int i);

    void A8Q(QH qh);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    QH getStartReason();

    FR getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void pause(boolean z);

    void seekTo(int i);

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoStateChangeListener(LY ly);

    void setup(Uri uri);

    void stop();
}
