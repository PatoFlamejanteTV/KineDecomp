package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;

/* loaded from: classes.dex */
public final /* synthetic */ class G {

    /* renamed from: a */
    public static final /* synthetic */ int[] f21650a = new int[MediaViewerMode.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f21651b;

    static {
        f21650a[MediaViewerMode.IMAGES.ordinal()] = 1;
        f21650a[MediaViewerMode.VIDEO.ordinal()] = 2;
        f21651b = new int[MediaItemType.values().length];
        f21651b[MediaItemType.FOLDER.ordinal()] = 1;
        f21651b[MediaItemType.IMAGE.ordinal()] = 2;
        f21651b[MediaItemType.VIDEO.ordinal()] = 3;
        f21651b[MediaItemType.SPECIAL.ordinal()] = 4;
    }
}
