package com.nexstreaming.kinemaster.ui.projectedit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionListView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bd */
/* loaded from: classes2.dex */
public abstract class AbstractC1855bd extends FrameLayout {

    /* renamed from: a */
    private ListView f22275a;

    /* renamed from: b */
    private View f22276b;

    /* renamed from: c */
    private View f22277c;

    /* renamed from: d */
    private C1935kd f22278d;

    /* renamed from: e */
    private com.nexstreaming.app.general.util.z f22279e;

    /* renamed from: f */
    private com.nexstreaming.app.general.util.z f22280f;

    /* renamed from: g */
    private com.nexstreaming.app.general.util.z f22281g;

    /* renamed from: h */
    private InterfaceC1997rd f22282h;
    private C2073xd i;
    private Bg j;
    private AdapterView.OnItemClickListener k;
    private AbsListView.OnScrollListener l;
    private C1935kd.a m;

    public AbstractC1855bd(Context context) {
        super(context);
        this.f22279e = new com.nexstreaming.app.general.util.z();
        this.f22280f = new com.nexstreaming.app.general.util.z();
        this.f22281g = new com.nexstreaming.app.general.util.z();
        this.f22282h = InterfaceC1997rd.f22506a;
        this.j = null;
        this.k = new Zc(this);
        this.l = new _c(this);
        this.m = new C1846ad(this);
        d();
    }

    private void c() {
        C1935kd c1935kd;
        Bg bg = this.j;
        if (bg == null || (c1935kd = this.f22278d) == null || this.i != null) {
            return;
        }
        this.i = new C2073xd(this.f22275a, c1935kd, bg, this.m, this.f22282h);
    }

    private void d() {
        FrameLayout.inflate(getContext(), R.layout.option_list_view, this);
        this.f22275a = (ListView) findViewById(R.id.optionMenuList);
        this.f22276b = findViewById(R.id.listViewDirectionUp);
        this.f22277c = findViewById(R.id.listViewDirectionDown);
        this.f22275a.setOnItemClickListener(this.k);
        this.f22275a.setOnScrollListener(this.l);
        this.f22275a.post(new Yc(this));
    }

    private void e() {
        int[] optionMenuItems = getOptionMenuItems();
        this.f22280f.clear();
        for (int i : optionMenuItems) {
            if (a(i)) {
                this.f22280f.a(i);
            }
        }
        this.f22278d.a(optionMenuItems, getTimelineItem(), this.f22279e, this.f22280f, this.f22281g, a(), false, getAllowCompactInitialRow());
        this.f22278d.a(this.m);
    }

    protected boolean a() {
        return false;
    }

    protected boolean getAllowCompactInitialRow() {
        return false;
    }

    protected abstract int[] getOptionMenuItems();

    protected NexTimelineItem getTimelineItem() {
        return null;
    }

    public void setFragment(Bg bg) {
        Bg bg2 = this.j;
        if (bg2 != null && bg2 != bg) {
            throw new IllegalStateException();
        }
        this.j = bg;
        c();
    }

    public void setOptionMenuHost(InterfaceC1997rd interfaceC1997rd) {
        if (interfaceC1997rd == null) {
            interfaceC1997rd = InterfaceC1997rd.f22506a;
        }
        this.f22282h = interfaceC1997rd;
        C1935kd c1935kd = this.f22278d;
        if (c1935kd != null) {
            c1935kd.a(this.f22282h);
            this.i = null;
            c();
        }
    }

    public void b() {
        if (this.f22278d == null) {
            this.f22278d = new C1935kd();
            this.f22278d.a(this.f22282h);
            e();
            this.f22275a.setAdapter((ListAdapter) this.f22278d);
            c();
            return;
        }
        e();
        this.f22278d.notifyDataSetChanged();
    }

    protected boolean a(int i) {
        NexTimelineItem timelineItem = getTimelineItem();
        return timelineItem != null && timelineItem.isOptionApplied(i);
    }

    public void a(OptionMenuItem optionMenuItem) {
        C2073xd c2073xd = this.i;
        if (c2073xd != null) {
            c2073xd.a(optionMenuItem, this.f22279e);
        }
    }

    public void a(int i, int i2, Intent intent) {
        C2073xd c2073xd = this.i;
        if (c2073xd != null) {
            c2073xd.a(i, i2, intent);
        }
    }

    public AbstractC1855bd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22279e = new com.nexstreaming.app.general.util.z();
        this.f22280f = new com.nexstreaming.app.general.util.z();
        this.f22281g = new com.nexstreaming.app.general.util.z();
        this.f22282h = InterfaceC1997rd.f22506a;
        this.j = null;
        this.k = new Zc(this);
        this.l = new _c(this);
        this.m = new C1846ad(this);
        d();
    }

    public AbstractC1855bd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22279e = new com.nexstreaming.app.general.util.z();
        this.f22280f = new com.nexstreaming.app.general.util.z();
        this.f22281g = new com.nexstreaming.app.general.util.z();
        this.f22282h = InterfaceC1997rd.f22506a;
        this.j = null;
        this.k = new Zc(this);
        this.l = new _c(this);
        this.m = new C1846ad(this);
        d();
    }

    @TargetApi(21)
    public AbstractC1855bd(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f22279e = new com.nexstreaming.app.general.util.z();
        this.f22280f = new com.nexstreaming.app.general.util.z();
        this.f22281g = new com.nexstreaming.app.general.util.z();
        this.f22282h = InterfaceC1997rd.f22506a;
        this.j = null;
        this.k = new Zc(this);
        this.l = new _c(this);
        this.m = new C1846ad(this);
        d();
    }
}
