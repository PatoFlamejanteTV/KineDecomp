package com.nexstreaming.kinemaster.ui.projectgallery;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class o implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportFileListActivity f4216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ExportFileListActivity exportFileListActivity) {
        this.f4216a = exportFileListActivity;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith("mp4");
    }
}
