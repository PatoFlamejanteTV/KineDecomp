package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class d extends com.nextreaming.a.a.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStore f3559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MediaStore mediaStore, Context context) {
        super(context);
        this.f3559a = mediaStore;
    }

    @Override // com.nextreaming.a.a.e
    protected Bitmap a(Object obj) {
        Bitmap a2;
        a2 = this.f3559a.a((MediaStore.d) obj);
        return a2;
    }
}
