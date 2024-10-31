package com.nexstreaming.kinemaster.mediastore;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.mediastore.MediaStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class f extends c.e.a.a.f {
    final /* synthetic */ MediaStore o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MediaStore mediaStore, Context context) {
        super(context);
        this.o = mediaStore;
    }

    @Override // c.e.a.a.f
    protected Bitmap a(Object obj) {
        Bitmap a2;
        a2 = this.o.a((MediaStore.f) obj);
        return a2;
    }
}
