package com.bumptech.glide.load.b;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* renamed from: com.bumptech.glide.load.b.e */
/* loaded from: classes.dex */
public class C0710e implements com.bumptech.glide.load.a<ByteBuffer> {
    @Override // com.bumptech.glide.load.a
    public boolean a(ByteBuffer byteBuffer, File file, com.bumptech.glide.load.g gVar) {
        try {
            com.bumptech.glide.g.a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
