package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IconMenuPopout.java */
/* loaded from: classes.dex */
public class b extends j {

    /* renamed from: a, reason: collision with root package name */
    private final int f4385a;
    private final int d;
    private InterfaceC0078b e;
    private LinearLayout f;
    private int g;
    private int h;
    private LinearLayout i;
    private List<a> j;
    private final boolean k;
    private View.OnClickListener l;

    /* compiled from: IconMenuPopout.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078b {
        void a(b bVar, int i);
    }

    /* compiled from: IconMenuPopout.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final int f4386a;
        final int b;
        final boolean c;

        a(int i, int i2, boolean z) {
            this.f4386a = i;
            this.b = i2;
            this.c = z;
        }
    }

    public b(Context context, boolean z) {
        super(context);
        this.g = 0;
        this.h = 0;
        this.j = new ArrayList();
        this.l = new c(this);
        this.f4385a = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupIconSize);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupIconPadding);
        this.k = z;
    }

    public void a(InterfaceC0078b interfaceC0078b) {
        this.e = interfaceC0078b;
    }

    public void m_() {
        if (this.f != null) {
            b(0, 0, false);
        } else {
            this.j.add(new a(0, 0, false));
        }
    }

    public void a(int i, int i2, boolean z) {
        if (i != 0) {
            if (this.f != null) {
                b(i, i2, z);
            } else {
                this.j.add(new a(i, i2, z));
            }
        }
    }

    private void b(int i, int i2, boolean z) {
        if (i == 0) {
            this.i = null;
            return;
        }
        if (this.i == null) {
            this.g++;
            this.h = 0;
            this.i = new LinearLayout(this.f.getContext());
            this.i.setOrientation(0);
            if (this.g > 1) {
                this.i.setBackgroundResource(R.drawable.icon_popout_line_above);
            }
            this.f.addView(this.i, new LinearLayout.LayoutParams(-2, -2));
        }
        this.h++;
        if (this.h > 1) {
            ImageView imageView = new ImageView(this.f.getContext());
            imageView.setImageResource(R.drawable.icon_popout_line_vertical);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f4385a);
            layoutParams.gravity = 16;
            this.i.addView(imageView, layoutParams);
        }
        IconButton iconButton = new IconButton(this.f.getContext());
        iconButton.setImageResource(i);
        iconButton.setBackgroundResource(R.drawable.handwriting_tool_popup_icon_bg);
        iconButton.setIconColorStateList(R.color.handwriting_tool_popup_icon_color);
        iconButton.setTag(R.id.icon_idtag, Integer.valueOf(i2));
        iconButton.setOnClickListener(this.l);
        if (z) {
            iconButton.setActivated(true);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f4385a, this.f4385a);
        layoutParams2.gravity = 16;
        this.i.addView(iconButton, layoutParams2);
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.j
    protected View a(Context context) {
        this.f = new LinearLayout(context);
        this.f.setBackgroundResource(this.k ? R.drawable.popup_bg_arrow_righttop : R.drawable.popup_bg_arrow_right);
        this.f.setPadding(this.f.getPaddingLeft() + this.d, this.f.getPaddingTop() + this.d, this.f.getPaddingRight() + this.d, this.f.getPaddingBottom() + this.d);
        this.f.setOrientation(1);
        for (a aVar : this.j) {
            b(aVar.f4386a, aVar.b, aVar.c);
        }
        this.j.clear();
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.widget.j
    public void b() {
        this.f = null;
        this.e = null;
        super.b();
    }
}
