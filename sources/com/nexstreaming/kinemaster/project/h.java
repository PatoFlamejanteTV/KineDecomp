package com.nexstreaming.kinemaster.project;

import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.io.FileFilter;

/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
class h implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f21197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f21197a = iVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String str;
        if (file.length() < 16) {
            return false;
        }
        String name = file.getName();
        if (EditorGlobal.t() && !name.contains("Demo")) {
            return false;
        }
        if (!name.endsWith(".nexvideoproject")) {
            str = k.f21201a;
            if (!name.endsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
