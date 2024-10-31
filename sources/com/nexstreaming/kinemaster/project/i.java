package com.nexstreaming.kinemaster.project;

import java.io.File;
import java.io.FileFilter;

/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
class i implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3625a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3625a = hVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String str;
        if (file.length() < 16) {
            return false;
        }
        String name = file.getName();
        if (!name.endsWith(".nexvideoproject")) {
            str = f.f3621a;
            if (!name.endsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
