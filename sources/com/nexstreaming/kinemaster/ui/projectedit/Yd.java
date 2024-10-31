package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import kotlin.TypeCastException;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Yd implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yd(Bd bd) {
        this.f22181a = bd;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.f22181a.getActivity() == null || !(this.f22181a.getActivity() instanceof ProjectEditActivity)) {
            return false;
        }
        FragmentActivity activity = this.f22181a.getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
        }
        ((ProjectEditActivity) activity).h(R.id.action_play_pause);
        return true;
    }
}
