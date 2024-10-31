package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes.dex */
public class NexIndexableListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4487a;
    private ch b;
    private GestureDetector c;

    public NexIndexableListView(Context context) {
        super(context);
        this.f4487a = false;
        this.b = null;
        this.c = null;
    }

    public NexIndexableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4487a = false;
        this.b = null;
        this.c = null;
    }

    public NexIndexableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4487a = false;
        this.b = null;
        this.c = null;
    }

    @Override // android.widget.AbsListView
    public boolean isFastScrollEnabled() {
        return this.f4487a;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        this.f4487a = z;
        if (this.f4487a) {
            if (this.b == null) {
                this.b = new ch(getContext(), this, getPaddingTop(), getPaddingBottom());
            }
            this.b.a();
        } else if (this.b != null) {
            this.b.b();
            this.b = null;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.b != null) {
            this.b.a(canvas);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b != null && this.b.a(motionEvent)) {
            return true;
        }
        if (this.c == null) {
            this.c = new GestureDetector(getContext(), new cj(this));
        }
        this.c.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.b != null) {
            this.b.a(listAdapter);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b != null) {
            this.b.a(i, i2, i3, i4);
        }
    }
}
