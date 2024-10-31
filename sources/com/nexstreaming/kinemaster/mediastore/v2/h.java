package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class h extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3563a;
    final /* synthetic */ MediaStore b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MediaStore mediaStore, Context context, ResultTask resultTask) {
        super(context);
        this.b = mediaStore;
        this.f3563a = resultTask;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Set set;
        set = this.b.q;
        set.remove(this);
        this.f3563a.sendResult(bitmap);
    }
}
