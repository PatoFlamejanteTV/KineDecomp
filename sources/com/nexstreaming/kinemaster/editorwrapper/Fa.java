package com.nexstreaming.kinemaster.editorwrapper;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;

/* compiled from: TrackOrItem.kt */
/* loaded from: classes.dex */
public interface Fa extends InterfaceC1732b {

    /* compiled from: TrackOrItem.kt */
    /* loaded from: classes.dex */
    public interface a {
        int getColorOption(int i);

        void setColorOption(int i, int i2);
    }

    /* compiled from: TrackOrItem.kt */
    /* loaded from: classes.dex */
    public interface b {
        boolean getSwitchOption(int i);
    }

    void bindView(View view, InterfaceC2028i interfaceC2028i);

    int getTimelineViewLayoutResource();
}
