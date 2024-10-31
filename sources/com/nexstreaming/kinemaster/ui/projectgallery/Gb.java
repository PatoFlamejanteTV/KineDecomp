package com.nexstreaming.kinemaster.ui.projectgallery;

import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.Eb;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;
import kotlin.TypeCastException;

/* compiled from: ProjectGalleryAdapter.kt */
/* loaded from: classes2.dex */
final class Gb implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Eb f22836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb(Eb eb) {
        this.f22836a = eb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        RecyclerView.LayoutManager layoutManager;
        View view2;
        TransparentTextButton transparentTextButton;
        Eb.b g2;
        boolean a2;
        boolean a3;
        boolean a4;
        View view3;
        boolean a5;
        View view4;
        if (!(view instanceof RecyclerView)) {
            view = null;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            kotlin.jvm.internal.h.a((Object) keyEvent, NotificationCompat.CATEGORY_EVENT);
            if (keyEvent.getAction() == 0) {
                if (layoutManager != null) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    int spanCount = gridLayoutManager.getSpanCount();
                    if (i == 61) {
                        view2 = this.f22836a.o;
                        view2.requestFocus();
                        this.f22836a.f();
                    } else if (i != 62 && i != 66 && i != 160) {
                        switch (i) {
                            case 19:
                                a2 = this.f22836a.a(layoutManager, -spanCount);
                                return a2;
                            case 20:
                                a3 = this.f22836a.a(layoutManager, spanCount);
                                return a3;
                            case 21:
                                if (this.f22836a.i() == 0) {
                                    view3 = this.f22836a.n;
                                    view3.requestFocus();
                                    this.f22836a.f();
                                    break;
                                } else {
                                    a4 = this.f22836a.a(layoutManager, -1);
                                    return a4;
                                }
                            case 22:
                                if (this.f22836a.i() == gridLayoutManager.getItemCount() - 1) {
                                    view4 = this.f22836a.o;
                                    view4.requestFocus();
                                    this.f22836a.f();
                                    break;
                                } else {
                                    a5 = this.f22836a.a(layoutManager, 1);
                                    return a5;
                                }
                            default:
                                return false;
                        }
                    } else {
                        Eb eb = this.f22836a;
                        switch (eb.getItemViewType(eb.i())) {
                            case R.layout.project_list_ad_item /* 2131493230 */:
                                View findViewByPosition = layoutManager.findViewByPosition(this.f22836a.i());
                                if (findViewByPosition != null && (transparentTextButton = (TransparentTextButton) findViewByPosition.findViewById(R.id.appinstall_call_to_action)) != null) {
                                    transparentTextButton.performClick();
                                }
                                return true;
                            case R.layout.project_list_item /* 2131493231 */:
                                if (this.f22836a.i() == -1) {
                                    return false;
                                }
                                View findViewByPosition2 = layoutManager.findViewByPosition(this.f22836a.i());
                                if (findViewByPosition2 != null && (g2 = this.f22836a.g()) != null) {
                                    g2.a(findViewByPosition2, this.f22836a.i());
                                }
                                return true;
                            default:
                                return true;
                        }
                    }
                    return true;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
            }
        }
        return false;
    }
}
