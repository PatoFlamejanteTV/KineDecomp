package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.j;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a */
    SparseArray<View> f162a;

    /* renamed from: b */
    private ArrayList<b> f163b;

    /* renamed from: c */
    private final ArrayList<ConstraintWidget> f164c;

    /* renamed from: d */
    android.support.constraint.solver.widgets.g f165d;

    /* renamed from: e */
    private int f166e;

    /* renamed from: f */
    private int f167f;

    /* renamed from: g */
    private int f168g;

    /* renamed from: h */
    private int f169h;
    private boolean i;
    private int j;
    private d k;
    private int l;
    private HashMap<String, Integer> m;
    private int n;
    private int o;
    int p;
    int q;
    int r;
    int s;
    private android.support.constraint.solver.f t;

    public ConstraintLayout(Context context) {
        super(context);
        this.f162a = new SparseArray<>();
        this.f163b = new ArrayList<>(4);
        this.f164c = new ArrayList<>(100);
        this.f165d = new android.support.constraint.solver.widgets.g();
        this.f166e = 0;
        this.f167f = 0;
        this.f168g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f169h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        a((AttributeSet) null);
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.f164c.clear();
            a();
        }
    }

    private void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof f) {
                ((f) childAt).a(this);
            }
        }
        int size = this.f163b.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f163b.get(i2).b(this);
            }
        }
    }

    public void a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.m == null) {
                this.m = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((parseInt / 1080.0f) * width);
                        int i3 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f2 = i2;
                        float f3 = i3;
                        float f4 = i2 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = i3 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.f169h;
    }

    public int getMaxWidth() {
        return this.f168g;
    }

    public int getMinHeight() {
        return this.f167f;
    }

    public int getMinWidth() {
        return this.f166e;
    }

    public int getOptimizationLevel() {
        return this.f165d.M();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = aVar.la;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.aa) {
                int g2 = constraintWidget.g();
                int h2 = constraintWidget.h();
                int s = constraintWidget.s() + g2;
                int i6 = constraintWidget.i() + h2;
                childAt.layout(g2, h2, s, i6);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(g2, h2, s, i6);
                }
            }
        }
        int size = this.f163b.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f163b.get(i7).a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget a2 = a(view);
        if ((view instanceof Guideline) && !(a2 instanceof j)) {
            a aVar = (a) view.getLayoutParams();
            aVar.la = new j();
            aVar.Y = true;
            ((j) aVar.la).v(aVar.S);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f163b.contains(bVar)) {
                this.f163b.add(bVar);
            }
        }
        this.f162a.put(view.getId(), view);
        this.i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f162a.remove(view.getId());
        ConstraintWidget a2 = a(view);
        this.f165d.c(a2);
        this.f163b.remove(view);
        this.f164c.remove(a2);
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.i = true;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
    }

    public void setConstraintSet(d dVar) {
        this.k = dVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f162a.remove(getId());
        super.setId(i);
        this.f162a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f169h) {
            return;
        }
        this.f169h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f168g) {
            return;
        }
        this.f168g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f167f) {
            return;
        }
        this.f167f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f166e) {
            return;
        }
        this.f166e = i;
        requestLayout();
    }

    public void setOptimizationLevel(int i) {
        this.f165d.u(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private final ConstraintWidget b(int i) {
        if (i == 0) {
            return this.f165d;
        }
        View view = this.f162a.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f165d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).la;
    }

    private void c(int i, int i2) {
        int i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i3 = Math.min(this.f168g, size) - paddingLeft;
                dimensionBehaviour = dimensionBehaviour2;
            }
            i3 = 0;
        } else {
            i3 = size;
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f169h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.f165d.l(0);
        this.f165d.k(0);
        this.f165d.a(dimensionBehaviour);
        this.f165d.o(i3);
        this.f165d.b(dimensionBehaviour2);
        this.f165d.g(size2);
        this.f165d.l((this.f166e - getPaddingLeft()) - getPaddingRight());
        this.f165d.k((this.f167f - getPaddingTop()) - getPaddingBottom());
    }

    public Object a(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.m.get(str);
    }

    private void a(AttributeSet attributeSet) {
        this.f165d.a(this);
        this.f162a.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_android_minWidth) {
                    this.f166e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f166e);
                } else if (index == h.ConstraintLayout_Layout_android_minHeight) {
                    this.f167f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f167f);
                } else if (index == h.ConstraintLayout_Layout_android_maxWidth) {
                    this.f168g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f168g);
                } else if (index == h.ConstraintLayout_Layout_android_maxHeight) {
                    this.f169h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f169h);
                } else if (index == h.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == h.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.k = new d();
                        this.k.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.k = null;
                    }
                    this.l = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f165d.u(this.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.b(int, int):void");
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f162a = new SparseArray<>();
        this.f163b = new ArrayList<>(4);
        this.f164c = new ArrayList<>(100);
        this.f165d = new android.support.constraint.solver.widgets.g();
        this.f166e = 0;
        this.f167f = 0;
        this.f168g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f169h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        a(attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:230:0x01d6, code lost:            if (r11 != (-1)) goto L371;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01e7  */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.support.constraint.ConstraintLayout, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.a():void");
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f162a = new SparseArray<>();
        this.f163b = new ArrayList<>(4);
        this.f164c = new ArrayList<>(100);
        this.f165d = new android.support.constraint.solver.widgets.g();
        this.f166e = 0;
        this.f167f = 0;
        this.f168g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f169h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = true;
        this.j = 7;
        this.k = null;
        this.l = -1;
        this.m = new HashMap<>();
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        a(attributeSet);
    }

    public final ConstraintWidget a(View view) {
        if (view == this) {
            return this.f165d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).la;
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* renamed from: a */
        public int f170a;
        boolean aa;

        /* renamed from: b */
        public int f171b;
        int ba;

        /* renamed from: c */
        public float f172c;
        int ca;

        /* renamed from: d */
        public int f173d;
        int da;

        /* renamed from: e */
        public int f174e;
        int ea;

        /* renamed from: f */
        public int f175f;
        int fa;

        /* renamed from: g */
        public int f176g;
        int ga;

        /* renamed from: h */
        public int f177h;
        float ha;
        public int i;
        int ia;
        public int j;
        int ja;
        public int k;
        float ka;
        public int l;
        ConstraintWidget la;
        public int m;
        public boolean ma;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.constraint.ConstraintLayout$a$a */
        /* loaded from: classes.dex */
        public static class C0002a {

            /* renamed from: a */
            public static final SparseIntArray f178a = new SparseIntArray();

            static {
                f178a.append(h.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f178a.append(h.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f178a.append(h.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f178a.append(h.ConstraintLayout_Layout_android_orientation, 1);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f178a.append(h.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f178a.append(h.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f178a.append(h.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f178a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.f170a = -1;
            this.f171b = -1;
            this.f172c = -1.0f;
            this.f173d = -1;
            this.f174e = -1;
            this.f175f = -1;
            this.f176g = -1;
            this.f177h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (C0002a.f178a.get(index)) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f170a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f170a);
                        break;
                    case 6:
                        this.f171b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f171b);
                        break;
                    case 7:
                        this.f172c = obtainStyledAttributes.getFloat(index, this.f172c);
                        break;
                    case 8:
                        this.f173d = obtainStyledAttributes.getResourceId(index, this.f173d);
                        if (this.f173d == -1) {
                            this.f173d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.f174e = obtainStyledAttributes.getResourceId(index, this.f174e);
                        if (this.f174e == -1) {
                            this.f174e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        this.f175f = obtainStyledAttributes.getResourceId(index, this.f175f);
                        if (this.f175f == -1) {
                            this.f175f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        this.f176g = obtainStyledAttributes.getResourceId(index, this.f176g);
                        if (this.f176g == -1) {
                            this.f176g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.f177h = obtainStyledAttributes.getResourceId(index, this.f177h);
                        if (this.f177h == -1) {
                            this.f177h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        this.i = obtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        if (this.J == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str = this.B;
                        if (str != null) {
                            int length = str.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.B.substring(i, indexOf2);
                                String substring3 = this.B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.D == 1) {
                                                this.C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            } else {
                                                this.C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.B.substring(i);
                                if (substring4.length() > 0) {
                                    this.C = Float.parseFloat(substring4);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 45:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).width == 0 || ((ViewGroup.MarginLayoutParams) this).width == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == 0 || ((ViewGroup.MarginLayoutParams) this).height == -1) {
                this.W = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f172c == -1.0f && this.f170a == -1 && this.f171b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.la instanceof j)) {
                this.la = new j();
            }
            ((j) this.la).v(this.S);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f170a = -1;
            this.f171b = -1;
            this.f172c = -1.0f;
            this.f173d = -1;
            this.f174e = -1;
            this.f175f = -1;
            this.f176g = -1;
            this.f177h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f170a = -1;
            this.f171b = -1;
            this.f172c = -1.0f;
            this.f173d = -1;
            this.f174e = -1;
            this.f175f = -1;
            this.f176g = -1;
            this.f177h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
        }
    }

    private void a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = aVar.la;
                if (!aVar.Y && !aVar.Z) {
                    constraintWidget.n(childAt.getVisibility());
                    int i4 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    boolean z3 = aVar.V;
                    if (z3 || aVar.W || (!z3 && aVar.I == 1) || ((ViewGroup.MarginLayoutParams) aVar).width == -1 || (!aVar.W && (aVar.J == 1 || ((ViewGroup.MarginLayoutParams) aVar).height == -1))) {
                        if (i4 == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (i4 == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = i4 == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, i4);
                        }
                        if (i5 == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (i5 == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = i5 == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        android.support.constraint.solver.f fVar = this.t;
                        if (fVar != null) {
                            fVar.f234a++;
                        }
                        constraintWidget.b(i4 == -2);
                        constraintWidget.a(i5 == -2);
                        i4 = childAt.getMeasuredWidth();
                        i5 = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    constraintWidget.o(i4);
                    constraintWidget.g(i5);
                    if (z) {
                        constraintWidget.q(i4);
                    }
                    if (z2) {
                        constraintWidget.p(i5);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.f(baseline);
                    }
                }
            }
        }
    }

    protected void a(String str) {
        this.f165d.K();
        android.support.constraint.solver.f fVar = this.t;
        if (fVar != null) {
            fVar.f236c++;
        }
    }

    public View a(int i) {
        return this.f162a.get(i);
    }
}
