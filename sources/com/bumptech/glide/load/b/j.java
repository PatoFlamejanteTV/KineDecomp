package com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class j implements i.d<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.b.i.d
    public ParcelFileDescriptor a(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    @Override // com.bumptech.glide.load.b.i.d
    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.b.i.d
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
