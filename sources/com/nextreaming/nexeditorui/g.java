package com.nextreaming.nexeditorui;

import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;

/* compiled from: KineMasterApplication.kt */
/* loaded from: classes.dex */
public final class G extends NexImageLoader.d {
    @Override // com.nextreaming.nexvideoeditor.NexImageLoader.d
    public String a(String str) {
        kotlin.jvm.internal.h.b(str, "overlayPath");
        String absolutePath = new File(EditorGlobal.j(), str).getAbsolutePath();
        kotlin.jvm.internal.h.a((Object) absolutePath, "File(EditorGlobal.getOve…overlayPath).absolutePath");
        return absolutePath;
    }
}
