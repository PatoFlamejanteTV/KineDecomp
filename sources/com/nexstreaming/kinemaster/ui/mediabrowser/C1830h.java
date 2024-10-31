package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;

/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.h */
/* loaded from: classes.dex */
public final /* synthetic */ class C1830h {

    /* renamed from: a */
    public static final /* synthetic */ int[] f21689a = new int[MediaItemType.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f21690b;

    static {
        f21689a[MediaItemType.IMAGE.ordinal()] = 1;
        f21689a[MediaItemType.VIDEO.ordinal()] = 2;
        f21690b = new int[MediaSupportType.values().length];
        f21690b[MediaSupportType.NeedTranscodeAVSync.ordinal()] = 1;
        f21690b[MediaSupportType.NeedTranscodeFPS.ordinal()] = 2;
        f21690b[MediaSupportType.NeedTranscodeRes.ordinal()] = 3;
    }
}
