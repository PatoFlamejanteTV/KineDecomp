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
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class hb extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem.b f24291a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24292b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(NexVideoClipItem nexVideoClipItem, Context context, NexVideoClipItem.b bVar) {
        super(context);
        this.f24292b = nexVideoClipItem;
        this.f24291a = bVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        NexVideoClipItem.DragType dragType;
        int i5;
        int i6;
        NexVideoClipItem.b bVar;
        NexVideoClipItem.DragType dragType2;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        if (!this.f24292b.isImage() && (dragType2 = (bVar = this.f24291a).f24150c) != NexVideoClipItem.DragType.FXSTART && dragType2 != NexVideoClipItem.DragType.FXEND) {
            path.lineTo(bVar.i, 0.0f);
            NexVideoClipItem.b bVar2 = this.f24291a;
            path.lineTo(bVar2.i, (bVar2.j / 3) * 2);
            NexVideoClipItem.b bVar3 = this.f24291a;
            path.lineTo((bVar3.i / 5) * 3, (bVar3.j / 3) * 2);
            NexVideoClipItem.b bVar4 = this.f24291a;
            path.lineTo(bVar4.i / 2, (bVar4.j / 7) * 6);
            NexVideoClipItem.b bVar5 = this.f24291a;
            path.lineTo((bVar5.i / 5) * 2, (bVar5.j / 3) * 2);
            path.lineTo(0.0f, (this.f24291a.j / 3) * 2);
        } else {
            path.lineTo(this.f24291a.i, 0.0f);
            NexVideoClipItem.b bVar6 = this.f24291a;
            path.lineTo(bVar6.i, bVar6.j / 2);
            NexVideoClipItem.b bVar7 = this.f24291a;
            path.lineTo((bVar7.i / 5) * 3, bVar7.j / 2);
            NexVideoClipItem.b bVar8 = this.f24291a;
            path.lineTo(bVar8.i / 2, (bVar8.j / 5) * 4);
            NexVideoClipItem.b bVar9 = this.f24291a;
            path.lineTo((bVar9.i / 5) * 2, bVar9.j / 2);
            path.lineTo(0.0f, this.f24291a.j / 2);
        }
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        NexVideoClipItem.b bVar10 = this.f24291a;
        NexVideoClipItem.DragType dragType3 = bVar10.f24150c;
        if (dragType3 == NexVideoClipItem.DragType.START) {
            if (this.f24292b.isImage()) {
                str = this.f24291a.q.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.f24292b.getDuration()));
            } else {
                StringBuilder sb = new StringBuilder();
                Resources resources = this.f24291a.q.getResources();
                i5 = this.f24292b.m_trimmedDuration;
                sb.append(resources.getString(R.string.video_drag_duration, EditorGlobal.a((i5 * 100) / this.f24292b.getPlaybackSpeed())));
                sb.append('\n');
                Resources resources2 = this.f24291a.q.getResources();
                i6 = this.f24292b.m_trimTimeStart;
                sb.append(resources2.getString(R.string.video_drag_starttrim, EditorGlobal.a(i6)));
                str = sb.toString();
            }
        } else if (dragType3 == NexVideoClipItem.DragType.FXSTART) {
            Resources resources3 = bVar10.q.getResources();
            i4 = this.f24292b.m_effectStartTime;
            str = resources3.getString(R.string.video_drag_fxstart, EditorGlobal.a(i4));
        } else if (dragType3 == NexVideoClipItem.DragType.FXEND) {
            Resources resources4 = bVar10.q.getResources();
            i3 = this.f24292b.m_effectEndTime;
            str = resources4.getString(R.string.video_drag_fxend, EditorGlobal.a(i3));
        } else if (dragType3 != NexVideoClipItem.DragType.END) {
            str = "";
        } else if (this.f24292b.isImage()) {
            str = this.f24291a.q.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.f24292b.getDuration()));
        } else {
            StringBuilder sb2 = new StringBuilder();
            Resources resources5 = this.f24291a.q.getResources();
            i = this.f24292b.m_trimmedDuration;
            sb2.append(resources5.getString(R.string.video_drag_duration, EditorGlobal.a((i * 100) / this.f24292b.getPlaybackSpeed())));
            sb2.append('\n');
            Resources resources6 = this.f24291a.q.getResources();
            i2 = this.f24292b.m_trimTimeEnd;
            sb2.append(resources6.getString(R.string.video_drag_endtrim, EditorGlobal.a(i2)));
            str = sb2.toString();
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        NexVideoClipItem.b bVar11 = this.f24291a;
        int i7 = bVar11.i;
        int i8 = bVar11.j / 2;
        if (!this.f24292b.isImage() && (dragType = this.f24291a.f24150c) != NexVideoClipItem.DragType.FXSTART && dragType != NexVideoClipItem.DragType.FXEND) {
            Rect rect = new Rect();
            int i9 = this.f24291a.j / 3;
            int i10 = i9;
            for (String str2 : str.split("\n")) {
                paint.getTextBounds(str2, 0, str2.length(), rect);
                canvas.drawText(str2, (i7 / 2) - (rect.right / 2), (rect.top / 3) + i10, paint);
                i10 = (int) (i10 + (paint.descent() - paint.ascent()));
            }
        } else {
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, (i7 / 2) - (r4.right / 2), i8 + (r4.top / 2), paint);
        }
        super.onDraw(canvas);
    }
}
