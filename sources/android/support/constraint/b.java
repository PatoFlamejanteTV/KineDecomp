package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: a */
    protected int[] f181a;

    /* renamed from: b */
    protected int f182b;

    /* renamed from: c */
    protected Context f183c;

    /* renamed from: d */
    protected k f184d;

    /* renamed from: e */
    protected boolean f185e;

    /* renamed from: f */
    private String f186f;

    public b(Context context) {
        super(context);
        this.f181a = new int[32];
        this.f185e = false;
        this.f183c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f186f = obtainStyledAttributes.getString(index);
                    setIds(this.f186f);
                }
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f186f);
        }
        k kVar = this.f184d;
        if (kVar == null) {
            return;
        }
        kVar.J();
        for (int i = 0; i < this.f182b; i++) {
            View a2 = constraintLayout.a(this.f181a[i]);
            if (a2 != null) {
                this.f184d.b(constraintLayout.a(a2));
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f181a, this.f182b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f185e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f182b = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.f182b + 1;
        int[] iArr = this.f181a;
        if (i2 > iArr.length) {
            this.f181a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f181a;
        int i3 = this.f182b;
        iArr2[i3] = i;
        this.f182b = i3 + 1;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f181a = new int[32];
        this.f185e = false;
        this.f183c = context;
        a(attributeSet);
    }

    public void a() {
        if (this.f184d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).la = this.f184d;
        }
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f181a = new int[32];
        this.f185e = false;
        this.f183c = context;
        a(attributeSet);
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str == null || this.f183c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i = g.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = this.f183c.getResources().getIdentifier(trim, "id", this.f183c.getPackageName());
        }
        if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
            i = ((Integer) a2).intValue();
        }
        if (i != 0) {
            setTag(i, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }
}
