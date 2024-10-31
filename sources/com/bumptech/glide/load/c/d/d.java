package com.bumptech.glide.load.c.d;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.E;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.i<c> {
    @Override // com.bumptech.glide.load.i
    public EncodeStrategy a(com.bumptech.glide.load.g gVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(E<c> e2, File file, com.bumptech.glide.load.g gVar) {
        try {
            com.bumptech.glide.g.a.a(e2.get().b(), file);
            return true;
        } catch (IOException e3) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e3);
            }
            return false;
        }
    }
}
