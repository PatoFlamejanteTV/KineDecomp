package com.nextreaming.nexeditorui;

import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterApplication.java */
/* loaded from: classes.dex */
public class az extends NexImageLoader.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KineMasterApplication f4535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(KineMasterApplication kineMasterApplication) {
        this.f4535a = kineMasterApplication;
    }

    @Override // com.nextreaming.nexvideoeditor.NexImageLoader.d
    public String a(String str) {
        return new File(EditorGlobal.k(), str).getAbsolutePath();
    }
}
