package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NexPopupMenu.java */
/* loaded from: classes.dex */
class b extends ListView {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f4506a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Context context, Path path) {
        super(context);
        this.b = aVar;
        this.f4506a = path;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        this.f4506a.rewind();
        this.f4506a.moveTo(10.0f, 0.0f);
        this.f4506a.lineTo(getWidth() - 10, 0.0f);
        this.f4506a.quadTo(getWidth(), 0.0f, getWidth(), 10.0f);
        this.f4506a.lineTo(getWidth(), getHeight() - 10);
        this.f4506a.quadTo(getWidth(), getHeight(), getWidth() - 10, getHeight());
        this.f4506a.lineTo(10.0f, getHeight());
        this.f4506a.quadTo(0.0f, getHeight(), 0.0f, getHeight() - 10);
        this.f4506a.lineTo(0.0f, 10.0f);
        this.f4506a.quadTo(0.0f, 0.0f, 10.0f, 0.0f);
        this.f4506a.close();
        canvas.clipPath(this.f4506a);
        canvas.drawColor(getResources().getColor(R.color.popup_menu_selector));
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
