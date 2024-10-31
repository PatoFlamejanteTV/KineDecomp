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
/* loaded from: classes2.dex */
public class e extends p {

    /* renamed from: f */
    private final int f23858f;

    /* renamed from: g */
    private final int f23859g;

    /* renamed from: h */
    private b f23860h;
    private LinearLayout i;
    private int j;
    private int k;
    private LinearLayout l;
    private List<a> m;
    private final boolean n;
    private View.OnClickListener o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IconMenuPopout.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final int f23861a;

        /* renamed from: b */
        final int f23862b;

        /* renamed from: c */
        final boolean f23863c;

        a(int i, int i2, boolean z) {
            this.f23861a = i;
            this.f23862b = i2;
            this.f23863c = z;
        }
    }

    /* compiled from: IconMenuPopout.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(e eVar, int i);
    }

    public e(Context context, boolean z) {
        super(context);
        this.j = 0;
        this.k = 0;
        this.m = new ArrayList();
        this.o = new d(this);
        this.f23858f = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupIconSize);
        this.f23859g = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupIconPadding);
        this.n = z;
    }

    private void b(int i, int i2, boolean z) {
        if (i == 0) {
            this.l = null;
            return;
        }
        if (this.l == null) {
            this.j++;
            this.k = 0;
            this.l = new LinearLayout(this.i.getContext());
            this.l.setOrientation(0);
            if (this.j > 1) {
                this.l.setBackgroundResource(R.drawable.icon_popout_line_above);
            }
            this.i.addView(this.l, new LinearLayout.LayoutParams(-2, -2));
        }
        this.k++;
        if (this.k > 1) {
            ImageView imageView = new ImageView(this.i.getContext());
            imageView.setImageResource(R.drawable.icon_popout_line_vertical);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f23858f);
            layoutParams.gravity = 16;
            this.l.addView(imageView, layoutParams);
        }
        IconButton iconButton = new IconButton(this.i.getContext());
        iconButton.setImageResource(i);
        iconButton.setBackgroundResource(R.drawable.handwriting_tool_popup_icon_bg);
        iconButton.setIconColorStateList(R.color.handwriting_tool_popup_icon_color);
        iconButton.setTag(R.id.icon_idtag, Integer.valueOf(i2));
        iconButton.setOnClickListener(this.o);
        if (z) {
            iconButton.setActivated(true);
        }
        int i3 = this.f23858f;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.gravity = 16;
        this.l.addView(iconButton, layoutParams2);
    }

    public void c() {
        if (this.i != null) {
            b(0, 0, false);
        } else {
            this.m.add(new a(0, 0, false));
        }
    }

    public void a(b bVar) {
        this.f23860h = bVar;
    }

    public void a(int i, int i2, boolean z) {
        if (i == 0) {
            return;
        }
        if (this.i != null) {
            b(i, i2, z);
        } else {
            this.m.add(new a(i, i2, z));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    protected View a(Context context) {
        this.i = new LinearLayout(context);
        this.i.setBackgroundResource(R.drawable.popup_bg_no_arrow);
        LinearLayout linearLayout = this.i;
        linearLayout.setPadding(linearLayout.getPaddingLeft() + this.f23859g, this.i.getPaddingTop() + this.f23859g, this.i.getPaddingRight() + this.f23859g, this.i.getPaddingBottom() + this.f23859g);
        this.i.setOrientation(1);
        for (a aVar : this.m) {
            b(aVar.f23861a, aVar.f23862b, aVar.f23863c);
        }
        this.m.clear();
        return this.i;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    public void b() {
        this.i = null;
        this.f23860h = null;
        super.b();
    }
}
