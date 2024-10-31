package android.support.constraint.solver.widgets;

import java.util.Arrays;

/* compiled from: Helper.java */
/* loaded from: classes.dex */
public class k extends ConstraintWidget {
    protected ConstraintWidget[] va = new ConstraintWidget[4];
    protected int wa = 0;

    public void J() {
        this.wa = 0;
    }

    public void b(ConstraintWidget constraintWidget) {
        int i = this.wa + 1;
        ConstraintWidget[] constraintWidgetArr = this.va;
        if (i > constraintWidgetArr.length) {
            this.va = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.va;
        int i2 = this.wa;
        constraintWidgetArr2[i2] = constraintWidget;
        this.wa = i2 + 1;
    }
}
