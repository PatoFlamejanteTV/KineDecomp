package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.xa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1776xa extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexLayerItem.a f20376a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20377b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1776xa(NexLayerItem nexLayerItem, Context context, NexLayerItem.a aVar) {
        super(context);
        this.f20377b = nexLayerItem;
        this.f20376a = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String string;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(this.f20376a.f20228g, 0.0f);
        NexLayerItem.a aVar = this.f20376a;
        path.lineTo(aVar.f20228g, aVar.f20229h / 2);
        NexLayerItem.a aVar2 = this.f20376a;
        path.lineTo((aVar2.f20228g / 5) * 3, aVar2.f20229h / 2);
        NexLayerItem.a aVar3 = this.f20376a;
        path.lineTo(aVar3.f20228g / 2, (aVar3.f20229h / 5) * 4);
        NexLayerItem.a aVar4 = this.f20376a;
        path.lineTo((aVar4.f20228g / 5) * 2, aVar4.f20229h / 2);
        path.lineTo(0.0f, this.f20376a.f20229h / 2);
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        NexLayerItem.a aVar5 = this.f20376a;
        NexLayerItem.DragType dragType = aVar5.f20224c;
        if (dragType == NexLayerItem.DragType.START) {
            string = aVar5.n.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.f20377b.getDuration()));
        } else {
            string = dragType == NexLayerItem.DragType.END ? aVar5.n.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.f20377b.getDuration())) : "";
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        NexLayerItem.a aVar6 = this.f20376a;
        int i = aVar6.f20228g;
        int i2 = aVar6.f20229h / 2;
        paint.getTextBounds(string, 0, string.length(), new Rect());
        canvas.drawText(string, (i / 2) - (r4.right / 2), i2 + (r4.top / 2), paint);
        super.onDraw(canvas);
    }
}
