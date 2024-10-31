package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;

/* compiled from: OptionExpressionOutFragment.java */
/* loaded from: classes2.dex */
public class Lc extends Jc {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Jc
    public LayerExpression.Type sa() {
        return LayerExpression.Type.Out;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Jc
    protected String ua() {
        return getString(R.string.opt_out_expression);
    }
}
