package com.nexstreaming.kinemaster.editorwrapper;

import java.util.Comparator;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
final class bj implements Comparator<NexLayerItem> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(NexLayerItem nexLayerItem, NexLayerItem nexLayerItem2) {
        long zOrder = nexLayerItem.getZOrder() - nexLayerItem2.getZOrder();
        if (zOrder < 0) {
            return -1;
        }
        return zOrder > 0 ? 1 : 0;
    }
}
