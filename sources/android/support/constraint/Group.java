package android.support.constraint;

import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class Group extends b {
    public Group(Context context) {
        super(context);
    }

    @Override // android.support.constraint.b
    protected void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f185e = false;
    }

    @Override // android.support.constraint.b
    public void c(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i = 0; i < this.f182b; i++) {
            View a2 = constraintLayout.a(this.f181a[i]);
            if (a2 != null) {
                a2.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    a2.setElevation(elevation);
                }
            }
        }
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.support.constraint.b
    public void a(ConstraintLayout constraintLayout) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.la.o(0);
        aVar.la.g(0);
    }
}
