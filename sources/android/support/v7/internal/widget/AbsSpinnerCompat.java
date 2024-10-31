package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.internal.widget.j;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
abstract class AbsSpinnerCompat extends j<SpinnerAdapter> {
    private DataSetObserver E;

    /* renamed from: a, reason: collision with root package name */
    SpinnerAdapter f142a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    final Rect h;
    final a i;

    abstract void a(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsSpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = new Rect();
        this.i = new a();
        k();
    }

    private void k() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // android.support.v7.internal.widget.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f142a != null) {
            this.f142a.unregisterDataSetObserver(this.E);
            a();
        }
        this.f142a = spinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f142a != null) {
            this.A = this.z;
            this.z = this.f142a.getCount();
            e();
            this.E = new j.a();
            this.f142a.registerDataSetObserver(this.E);
            int i = this.z > 0 ? 0 : -1;
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.z == 0) {
                h();
            }
        } else {
            e();
            a();
            h();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.u = false;
        this.o = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.AbsSpinnerCompat.onMeasure(int, int):void");
    }

    int a(View view) {
        return view.getMeasuredHeight();
    }

    int b(View view) {
        return view.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int childCount = getChildCount();
        a aVar = this.i;
        int i = this.j;
        for (int i2 = 0; i2 < childCount; i2++) {
            aVar.a(i + i2, getChildAt(i2));
        }
    }

    @Override // android.support.v7.internal.widget.j
    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    @Override // android.support.v7.internal.widget.j
    public View getSelectedView() {
        if (this.z <= 0 || this.x < 0) {
            return null;
        }
        return getChildAt(this.x - this.j);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.D) {
            super.requestLayout();
        }
    }

    @Override // android.support.v7.internal.widget.j
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SpinnerAdapter getAdapter() {
        return this.f142a;
    }

    @Override // android.support.v7.internal.widget.j
    public int getCount() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* renamed from: a, reason: collision with root package name */
        long f143a;
        int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            super(parcel);
            this.f143a = parcel.readLong();
            this.b = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f143a);
            parcel.writeInt(this.b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f143a + " position=" + this.b + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f143a = getSelectedItemId();
        if (savedState.f143a >= 0) {
            savedState.b = getSelectedItemPosition();
        } else {
            savedState.b = -1;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f143a >= 0) {
            this.u = true;
            this.o = true;
            this.m = savedState.f143a;
            this.l = savedState.b;
            this.p = 0;
            requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class a {
        private final SparseArray<View> b = new SparseArray<>();

        a() {
        }

        public void a(int i, View view) {
            this.b.put(i, view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(int i) {
            View view = this.b.get(i);
            if (view != null) {
                this.b.delete(i);
            }
            return view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            SparseArray<View> sparseArray = this.b;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    AbsSpinnerCompat.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }
    }
}
