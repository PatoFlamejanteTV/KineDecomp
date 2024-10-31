package b.b.g;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiDexExtractor.java */
/* loaded from: classes.dex */
public class c implements FileFilter {

    /* renamed from: a */
    final /* synthetic */ String f3362a;

    public c(String str) {
        this.f3362a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().startsWith(this.f3362a);
    }
}
