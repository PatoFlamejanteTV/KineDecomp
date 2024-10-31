package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import java.util.Arrays;

/* compiled from: MediaViewerMode.kt */
/* loaded from: classes.dex */
public enum MediaViewerMode {
    ALL(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO, MediaItemType.SPECIAL),
    IMAGES(MediaItemType.FOLDER, MediaItemType.IMAGE),
    VIDEO(MediaItemType.FOLDER, MediaItemType.VIDEO);

    private MediaItemType[] mediaMode;

    MediaViewerMode(MediaItemType... mediaItemTypeArr) {
        this.mediaMode = (MediaItemType[]) Arrays.copyOf(mediaItemTypeArr, mediaItemTypeArr.length);
    }

    public final MediaItemType[] getMediaMode() {
        return this.mediaMode;
    }

    public final void setMediaMode(MediaItemType[] mediaItemTypeArr) {
        kotlin.jvm.internal.h.b(mediaItemTypeArr, "<set-?>");
        this.mediaMode = mediaItemTypeArr;
    }
}
