package android.support.a;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiDexExtractor.java */
/* loaded from: classes.dex */
public final class d implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.f17a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().startsWith(this.f17a);
    }
}
