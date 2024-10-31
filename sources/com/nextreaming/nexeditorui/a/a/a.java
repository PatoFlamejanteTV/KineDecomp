package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexPopupMenu.java */
/* loaded from: classes.dex */
public class a extends ListView {

    /* renamed from: a */
    final /* synthetic */ Path f24200a;

    /* renamed from: b */
    final /* synthetic */ b f24201b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, Context context, Path path) {
        super(context);
        this.f24201b = bVar;
        this.f24200a = path;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        this.f24200a.rewind();
        this.f24200a.moveTo(10.0f, 0.0f);
        this.f24200a.lineTo(getWidth() - 10, 0.0f);
        this.f24200a.quadTo(getWidth(), 0.0f, getWidth(), 10.0f);
        this.f24200a.lineTo(getWidth(), getHeight() - 10);
        this.f24200a.quadTo(getWidth(), getHeight(), getWidth() - 10, getHeight());
        this.f24200a.lineTo(10.0f, getHeight());
        this.f24200a.quadTo(0.0f, getHeight(), 0.0f, getHeight() - 10);
        this.f24200a.lineTo(0.0f, 10.0f);
        this.f24200a.quadTo(0.0f, 0.0f, 10.0f, 0.0f);
        this.f24200a.close();
        canvas.clipPath(this.f24200a);
        canvas.drawColor(getResources().getColor(R.color.popup_menu_selector));
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
