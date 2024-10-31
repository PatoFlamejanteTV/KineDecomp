package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexAudioClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexAudioClipItem.java */
/* renamed from: com.nextreaming.nexeditorui.fa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C2307fa extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem.a f24248a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f24249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2307fa(NexAudioClipItem nexAudioClipItem, Context context, NexAudioClipItem.a aVar) {
        super(context);
        this.f24249b = nexAudioClipItem;
        this.f24248a = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(this.f24248a.f24080g, 0.0f);
        NexAudioClipItem.a aVar = this.f24248a;
        path.lineTo(aVar.f24080g, aVar.f24081h / 2);
        NexAudioClipItem.a aVar2 = this.f24248a;
        path.lineTo((aVar2.f24080g / 5) * 3, aVar2.f24081h / 2);
        NexAudioClipItem.a aVar3 = this.f24248a;
        path.lineTo(aVar3.f24080g / 2, (aVar3.f24081h / 5) * 4);
        NexAudioClipItem.a aVar4 = this.f24248a;
        path.lineTo((aVar4.f24080g / 5) * 2, aVar4.f24081h / 2);
        path.lineTo(0.0f, this.f24248a.f24081h / 2);
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        NexAudioClipItem.a aVar5 = this.f24248a;
        NexAudioClipItem.DragType dragType = aVar5.f24076c;
        if (dragType == NexAudioClipItem.DragType.START) {
            Resources resources = aVar5.o.getResources();
            i4 = this.f24249b.m_trimTimeStart;
            str = resources.getString(R.string.video_drag_starttrim, EditorGlobal.a(i4));
        } else if (dragType == NexAudioClipItem.DragType.END) {
            z = this.f24249b.m_loop;
            if (z) {
                Resources resources2 = this.f24248a.o.getResources();
                i2 = this.f24249b.m_relativeEndTime;
                i3 = this.f24249b.m_relativeStartTime;
                str = resources2.getString(R.string.video_drag_duration, EditorGlobal.a(i2 - i3));
            } else {
                Resources resources3 = this.f24248a.o.getResources();
                i = this.f24249b.m_trimTimeEnd;
                str = resources3.getString(R.string.video_drag_endtrim, EditorGlobal.a(i));
            }
        } else {
            str = "";
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        NexAudioClipItem.a aVar6 = this.f24248a;
        int i5 = aVar6.f24080g;
        int i6 = aVar6.f24081h / 2;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, (i5 / 2) - (r4.right / 2), i6 + (r4.top / 2), paint);
        super.onDraw(canvas);
    }
}
