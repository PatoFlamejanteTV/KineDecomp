package io.fabric.sdk.android.services.common;

import java.io.File;
import java.util.Comparator;

/* compiled from: CommonUtils.java */
/* loaded from: classes3.dex */
class k implements Comparator<File> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        return (int) (file.lastModified() - file2.lastModified());
    }
}
