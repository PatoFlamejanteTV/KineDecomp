package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.b.a;
import android.support.v7.internal.widget.AbsSpinnerCompat;
import android.support.v7.internal.widget.j;
import android.support.v7.widget.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SpinnerCompat extends AbsSpinnerCompat implements DialogInterface.OnClickListener {
    int E;
    private f.b F;
    private d G;
    private b H;
    private int I;
    private boolean J;
    private Rect K;
    private final ab L;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        boolean b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpinnerCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        u uVar = null;
        this.K = new Rect();
        ac a2 = ac.a(context, attributeSet, a.i.Spinner, i, 0);
        if (a2.d(a.i.Spinner_android_background)) {
            setBackgroundDrawable(a2.a(a.i.Spinner_android_background));
        }
        switch (i2 == -1 ? a2.a(a.i.Spinner_spinnerMode, 0) : i2) {
            case 0:
                this.G = new a(this, uVar);
                break;
            case 1:
                c cVar = new c(context, attributeSet, i);
                this.E = a2.e(a.i.Spinner_android_dropDownWidth, -2);
                cVar.a(a2.a(a.i.Spinner_android_popupBackground));
                this.G = cVar;
                this.F = new u(this, this, cVar);
                break;
        }
        this.I = a2.a(a.i.Spinner_android_gravity, 17);
        this.G.a(a2.c(a.i.Spinner_prompt));
        this.J = a2.a(a.i.Spinner_disableChildrenWhenDisabled, false);
        a2.b();
        if (this.H != null) {
            this.G.a(this.H);
            this.H = null;
        }
        this.L = a2.c();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.support.v7.internal.widget.j
    /* renamed from: a */
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        this.i.a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        }
        if (this.G != null) {
            this.G.a(new b(spinnerAdapter));
        } else {
            this.H = new b(spinnerAdapter);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int baseline;
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.f142a != null && this.f142a.getCount() > 0) {
            view = c(0, false);
            this.i.a(0, view);
        }
        if (view == null || (baseline = view.getBaseline()) < 0) {
            return -1;
        }
        return view.getTop() + baseline;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.j, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.G != null && this.G.b()) {
            this.G.a();
        }
    }

    @Override // android.support.v7.internal.widget.j
    public void setOnItemClickListener(j.b bVar) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j.b bVar) {
        super.setOnItemClickListener(bVar);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.F == null || !this.F.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.G != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.j, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.q = true;
        a(0, false);
        this.q = false;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat
    void a(int i, boolean z) {
        int i2 = this.h.left;
        int right = ((getRight() - getLeft()) - this.h.left) - this.h.right;
        if (this.u) {
            g();
        }
        if (this.z == 0) {
            a();
            return;
        }
        if (this.v >= 0) {
            setSelectedPositionInt(this.v);
        }
        b();
        removeAllViewsInLayout();
        this.j = this.x;
        if (this.f142a != null) {
            View c2 = c(this.x, true);
            int measuredWidth = c2.getMeasuredWidth();
            switch (android.support.v4.g.b.a(this.I, android.support.v4.g.p.a(this)) & 7) {
                case 1:
                    i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                    break;
                case 5:
                    i2 = (i2 + right) - measuredWidth;
                    break;
            }
            c2.offsetLeftAndRight(i2);
        }
        this.i.a();
        invalidate();
        h();
        this.u = false;
        this.o = false;
        setNextSelectedPositionInt(this.x);
    }

    private View c(int i, boolean z) {
        View a2;
        if (!this.u && (a2 = this.i.a(i)) != null) {
            a(a2, z);
            return a2;
        }
        View view = this.f142a.getView(i, null, this);
        a(view, z);
        return view;
    }

    private void a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.c, this.h.left + this.h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.b, this.h.top + this.h.bottom, layoutParams.height));
        int measuredHeight = this.h.top + ((((getMeasuredHeight() - this.h.bottom) - this.h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.G.b()) {
                this.G.c();
            }
        }
        return performClick;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view2 = null;
        int i = 0;
        int i2 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
                view = view2;
            }
            view2 = spinnerAdapter.getView(max2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view2.getMeasuredWidth());
            max2++;
            i2 = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.K);
        return this.K.left + this.K.right + i;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.G != null && this.G.b();
        return savedState;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.c && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new v(this));
        }
    }

    /* loaded from: classes.dex */
    static class SavedState extends AbsSpinnerCompat.SavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new x();
        boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, u uVar) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readByte() != 0;
        }

        @Override // android.support.v7.internal.widget.AbsSpinnerCompat.SavedState, android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.c ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f155a;
        private ListAdapter b;

        public b(SpinnerAdapter spinnerAdapter) {
            this.f155a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f155a == null) {
                return 0;
            }
            return this.f155a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f155a == null) {
                return null;
            }
            return this.f155a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f155a == null) {
                return -1L;
            }
            return this.f155a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f155a == null) {
                return null;
            }
            return this.f155a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f155a != null && this.f155a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f155a != null) {
                this.f155a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f155a != null) {
                this.f155a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* loaded from: classes.dex */
    private class a implements DialogInterface.OnClickListener, d {
        private AlertDialog b;
        private ListAdapter c;
        private CharSequence d;

        private a() {
        }

        /* synthetic */ a(SpinnerCompat spinnerCompat, u uVar) {
            this();
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public void a() {
            if (this.b != null) {
                this.b.dismiss();
                this.b = null;
            }
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public boolean b() {
            if (this.b != null) {
                return this.b.isShowing();
            }
            return false;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public void a(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public void c() {
            if (this.c != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SpinnerCompat.this.getContext());
                if (this.d != null) {
                    builder.setTitle(this.d);
                }
                this.b = builder.setSingleChoiceItems(this.c, SpinnerCompat.this.getSelectedItemPosition(), this).create();
                this.b.show();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SpinnerCompat.this.setSelection(i);
            if (SpinnerCompat.this.s != null) {
                SpinnerCompat.this.a((View) null, i, this.c.getItemId(i));
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends android.support.v7.widget.f implements d {
        private CharSequence c;
        private ListAdapter d;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a(SpinnerCompat.this);
            a(true);
            a(0);
            a(new w(this, SpinnerCompat.this));
        }

        @Override // android.support.v7.widget.f, android.support.v7.internal.widget.SpinnerCompat.d
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.d = listAdapter;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.d
        public void a(CharSequence charSequence) {
            this.c = charSequence;
        }
    }
}
