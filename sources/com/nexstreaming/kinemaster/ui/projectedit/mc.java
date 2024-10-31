package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;

/* compiled from: OptionExpressionOverallFragment.java */
/* loaded from: classes2.dex */
public class Mc extends Jc {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Jc
    public LayerExpression.Type sa() {
        return LayerExpression.Type.Overall;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Jc
    protected String ua() {
        return getString(R.string.opt_expression);
    }
}
