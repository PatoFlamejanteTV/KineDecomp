package com.nexstreaming.kinemaster.layer;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* loaded from: classes.dex */
public abstract class MediaLayer extends NexLayerItem {
    public abstract String getMediaPath();

    public int getOriginalHeight() {
        return getHeight();
    }

    public int getOriginalWidth() {
        return getWidth();
    }
}
