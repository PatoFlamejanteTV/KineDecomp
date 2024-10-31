package com.bumptech.glide.load.c.c;

import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import java.io.File;

/* compiled from: FileDecoder.java */
/* loaded from: classes.dex */
public class a implements h<File, File> {
    @Override // com.bumptech.glide.load.h
    public boolean a(File file, g gVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.h
    public E<File> a(File file, int i, int i2, g gVar) {
        return new b(file);
    }
}
