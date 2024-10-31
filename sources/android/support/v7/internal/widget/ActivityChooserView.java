package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    android.support.v4.g.a f147a;
    private final a b;
    private final b c;
    private final android.support.v7.widget.e d;
    private final FrameLayout e;
    private final ImageView f;
    private final FrameLayout g;
    private final int h;
    private final DataSetObserver i;
    private final ViewTreeObserver.OnGlobalLayoutListener j;
    private android.support.v7.widget.f k;
    private PopupWindow.OnDismissListener l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(i iVar) {
        this.b.a(iVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f.setContentDescription(getContext().getString(i));
    }

    public void setProvider(android.support.v4.g.a aVar) {
        this.f147a = aVar;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.m = false;
        a(this.n);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.b.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        boolean z = this.g.getVisibility() == 0;
        int c = this.b.c();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && c > i2 + i) {
            this.b.a(true);
            this.b.a(i - 1);
        } else {
            this.b.a(false);
            this.b.a(i);
        }
        android.support.v7.widget.f listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.b()) {
            if (this.m || !z) {
                this.b.a(true, z);
            } else {
                this.b.a(false, false);
            }
            listPopupWindow.d(Math.min(this.b.a(), this.h));
            listPopupWindow.c();
            if (this.f147a != null) {
                this.f147a.a(true);
            }
            listPopupWindow.g().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        }
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().a();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.j);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i d = this.b.d();
        if (d != null) {
            d.registerObserver(this.i);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i d = this.b.d();
        if (d != null) {
            d.unregisterObserver(this.i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.j);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        android.support.v7.widget.e eVar = this.d;
        if (this.g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(eVar, i, i2);
        setMeasuredDimension(eVar.getMeasuredWidth(), eVar.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    public i getDataModel() {
        return this.b.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.n = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    private android.support.v7.widget.f getListPopupWindow() {
        if (this.k == null) {
            this.k = new android.support.v7.widget.f(getContext());
            this.k.a(this.b);
            this.k.a(this);
            this.k.a(true);
            this.k.a((AdapterView.OnItemClickListener) this.c);
            this.k.a((PopupWindow.OnDismissListener) this.c);
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f150a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f150a.b();
                    if (!this.f150a.m) {
                        if (!this.f150a.b.e()) {
                            i++;
                        }
                        Intent b = this.f150a.b.d().b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f150a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    }
                    if (i > 0) {
                        this.f150a.b.d().c(i);
                        return;
                    }
                    return;
                case 1:
                    this.f150a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != this.f150a.g) {
                if (view == this.f150a.e) {
                    this.f150a.m = false;
                    this.f150a.a(this.f150a.n);
                    return;
                }
                throw new IllegalArgumentException();
            }
            this.f150a.b();
            Intent b = this.f150a.b.d().b(this.f150a.b.d().a(this.f150a.b.b()));
            if (b != null) {
                b.addFlags(524288);
                this.f150a.getContext().startActivity(b);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == this.f150a.g) {
                if (this.f150a.b.getCount() > 0) {
                    this.f150a.m = true;
                    this.f150a.a(this.f150a.n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (this.f150a.f147a != null) {
                this.f150a.f147a.a(false);
            }
        }

        private void a() {
            if (this.f150a.l != null) {
                this.f150a.l.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f149a;
        private i b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public void a(i iVar) {
            i d = this.f149a.b.d();
            if (d != null && this.f149a.isShown()) {
                d.unregisterObserver(this.f149a.i);
            }
            this.b = iVar;
            if (iVar != null && this.f149a.isShown()) {
                iVar.registerObserver(this.f149a.i);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a2 = this.b.a();
            if (!this.d && this.b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.c);
            if (this.f) {
                return min + 1;
            }
            return min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.d && this.b.b() != null) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != a.e.list_item) {
                        view = LayoutInflater.from(this.f149a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f149a.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(a.e.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(a.e.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        android.support.v4.g.p.b(view, true);
                        return view;
                    }
                    android.support.v4.g.p.b(view, false);
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(this.f149a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(a.e.title)).setText(this.f149a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.c = i;
            return i2;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.b.a();
        }

        public i d() {
            return this.b;
        }

        public void a(boolean z, boolean z2) {
            if (this.d != z || this.e != z2) {
                this.d = z;
                this.e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean e() {
            return this.d;
        }
    }

    /* loaded from: classes.dex */
    public static class InnerLayout extends android.support.v7.widget.e {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f148a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ac a2 = ac.a(context, attributeSet, f148a);
            setBackgroundDrawable(a2.a(0));
            a2.b();
        }
    }
}
