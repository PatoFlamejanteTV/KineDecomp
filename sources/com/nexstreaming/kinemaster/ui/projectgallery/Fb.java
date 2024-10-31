package com.nexstreaming.kinemaster.ui.projectgallery;

import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.view.View;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.nexstreaming.kinemaster.ui.projectgallery.Eb;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ProjectGalleryAdapter.kt */
/* loaded from: classes2.dex */
public final class Fb implements com.bumptech.glide.request.e<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Eb.c f22833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(Eb.c cVar) {
        this.f22833a = cVar;
    }

    @Override // com.bumptech.glide.request.e
    public boolean a(GlideException glideException, Object obj, com.bumptech.glide.request.a.i<Bitmap> iVar, boolean z) {
        return false;
    }

    @Override // com.bumptech.glide.request.e
    public boolean a(Bitmap bitmap, Object obj, com.bumptech.glide.request.a.i<Bitmap> iVar, DataSource dataSource, boolean z) {
        View view = this.f22833a.itemView;
        kotlin.jvm.internal.h.a((Object) view, "itemView");
        CardView cardView = (CardView) view.findViewById(com.nexstreaming.app.kinemasterfree.b.cv_container);
        kotlin.jvm.internal.h.a((Object) cardView, "itemView.cv_container");
        kotlin.jvm.internal.h.a((Object) this.f22833a.itemView, "itemView");
        cardView.setCardElevation(EditorGlobal.a(r3.getContext(), 4));
        return false;
    }
}
