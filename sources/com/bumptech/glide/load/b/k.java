package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class k implements i.d<InputStream> {
    @Override // com.bumptech.glide.load.b.i.d
    public InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    @Override // com.bumptech.glide.load.b.i.d
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.b.i.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
