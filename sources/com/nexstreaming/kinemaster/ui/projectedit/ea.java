package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;

/* compiled from: OptionExpressionInFragment.java */
/* loaded from: classes.dex */
public class ea extends dt {
    @Override // com.nexstreaming.kinemaster.ui.projectedit.dt
    public LayerExpression.Type a() {
        return LayerExpression.Type.In;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.dt
    protected String c() {
        return getString(R.string.opt_in_expression);
    }
}
