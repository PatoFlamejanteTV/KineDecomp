package com.nextreaming.nexeditorui.newproject.mediabrowser;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import java.io.File;

/* compiled from: MediaFileAdder.java */
/* loaded from: classes.dex */
public class bb {
    public static boolean a(String str) {
        MediaInfo a2 = MediaInfo.a(new File(str));
        return (a2.y() + (-4000)) / Math.max(1, a2.j()) > 4000;
    }
}
