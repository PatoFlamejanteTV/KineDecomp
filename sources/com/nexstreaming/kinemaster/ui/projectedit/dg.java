package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.kt */
/* loaded from: classes2.dex */
public final class Dg implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bg f21820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dg(Bg bg) {
        this.f21820a = bg;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int color;
        WeakReference weakReference;
        View view2;
        z = this.f21820a.f21793h;
        if (!z) {
            return false;
        }
        kotlin.jvm.internal.h.a((Object) motionEvent, NotificationCompat.CATEGORY_EVENT);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 3) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Resources resources = this.f21820a.getResources();
                FragmentActivity activity = this.f21820a.getActivity();
                if (activity == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a((Object) activity, "activity!!");
                color = resources.getColor(R.color.km_white, activity.getTheme());
            } else {
                color = this.f21820a.getResources().getColor(R.color.km_white);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            Resources resources2 = this.f21820a.getResources();
            FragmentActivity activity2 = this.f21820a.getActivity();
            if (activity2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a((Object) activity2, "activity!!");
            color = resources2.getColor(R.color.km_red, activity2.getTheme());
        } else {
            color = this.f21820a.getResources().getColor(R.color.km_red);
        }
        weakReference = this.f21820a.f21790e;
        if (weakReference != null && (view2 = (View) weakReference.get()) != null) {
            View findViewById = view2.findViewById(R.id.optmenu_back);
            if (findViewById != null) {
                ((IconView) findViewById).setIconColor(color);
                View findViewById2 = view2.findViewById(R.id.descTitle);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setTextColor(color);
                    View findViewById3 = view2.findViewById(R.id.descTitleSm);
                    if (findViewById3 != null) {
                        ((TextView) findViewById3).setTextColor(color);
                        View findViewById4 = view2.findViewById(R.id.descSubtitleSm);
                        if (findViewById4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                        }
                        ((TextView) findViewById4).setTextColor(color);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.app.general.util.IconView");
            }
        }
        return false;
    }
}
