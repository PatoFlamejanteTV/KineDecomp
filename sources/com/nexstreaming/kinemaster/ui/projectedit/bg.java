package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.qq.e.comm.constants.Constants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.TypeCastException;

/* compiled from: ProjectEditingFragmentBase.kt */
/* loaded from: classes2.dex */
public abstract class Bg extends Fragment implements InterfaceC1976p, I.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f21786a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private com.nexstreaming.kinemaster.editorwrapper.Fa f21787b;

    /* renamed from: c, reason: collision with root package name */
    private UUID f21788c;

    /* renamed from: d, reason: collision with root package name */
    private int f21789d = -1;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<View> f21790e;

    /* renamed from: f, reason: collision with root package name */
    private String f21791f;

    /* renamed from: g, reason: collision with root package name */
    private String f21792g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21793h;
    private boolean i;
    private List<b<Fragment>> j;
    private HashMap k;

    /* compiled from: ProjectEditingFragmentBase.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final FragmentTransaction a(FragmentTransaction fragmentTransaction) {
            kotlin.jvm.internal.h.b(fragmentTransaction, "ft");
            FragmentTransaction a2 = ProjectEditActivity.a(fragmentTransaction);
            kotlin.jvm.internal.h.a((Object) a2, "ProjectEditActivity.optPanelAnim(ft)");
            return a2;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final FragmentTransaction a(FragmentTransaction fragmentTransaction, boolean z) {
            kotlin.jvm.internal.h.b(fragmentTransaction, "ft");
            FragmentTransaction a2 = ProjectEditActivity.a(fragmentTransaction, z);
            kotlin.jvm.internal.h.a((Object) a2, "ProjectEditActivity.optP…Anim(ft, isExpandedPanel)");
            return a2;
        }
    }

    /* compiled from: ProjectEditingFragmentBase.kt */
    /* loaded from: classes2.dex */
    public interface b<T extends Fragment> {
        void a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void ta() {
        List<b<Fragment>> list = this.j;
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                list.get(size).a(this);
            }
        }
    }

    private final void ua() {
        View view;
        WeakReference<View> weakReference = this.f21790e;
        if (weakReference == null || (view = weakReference.get()) == null || this.i) {
            return;
        }
        String str = this.f21792g;
        if (str != null) {
            if (str != null) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = str.charAt(!z ? i : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                if (str.subSequence(i, length + 1).toString().length() > 0) {
                    View findViewById = view.findViewById(R.id.descTitle);
                    if (findViewById != null) {
                        ((TextView) findViewById).setText("");
                        View findViewById2 = view.findViewById(R.id.descTitleSm);
                        if (findViewById2 != null) {
                            ((TextView) findViewById2).setText(this.f21791f);
                            View findViewById3 = view.findViewById(R.id.descSubtitleSm);
                            if (findViewById3 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                            }
                            ((TextView) findViewById3).setText(this.f21792g);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        View findViewById4 = view.findViewById(R.id.descTitle);
        if (findViewById4 != null) {
            ((TextView) findViewById4).setText(this.f21791f);
            View findViewById5 = view.findViewById(R.id.descTitleSm);
            if (findViewById5 != null) {
                ((TextView) findViewById5).setText("");
                View findViewById6 = view.findViewById(R.id.descSubtitleSm);
                if (findViewById6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                ((TextView) findViewById6).setText("");
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final boolean A() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.J();
        }
        return false;
    }

    public final boolean B() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.K();
        }
        return false;
    }

    public final boolean C() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.L();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.M();
        }
    }

    public final boolean E() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.N();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G() {
        a(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I() {
        View findViewById;
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || (findViewById = view.findViewById(R.id.optionMenuDone)) == null) {
            return;
        }
        findViewById.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J() {
        View findViewById;
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || (findViewById = view.findViewById(R.id.optionMenuDone)) == null) {
            return;
        }
        findViewById.setEnabled(true);
    }

    public boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Integer L() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        return Integer.valueOf(projectEditActivity != null ? projectEditActivity.T() : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ProjectEditActivity M() {
        FragmentActivity requireActivity = requireActivity();
        if (requireActivity != null) {
            return (ProjectEditActivity) requireActivity;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
    }

    public final MediaPrepManager N() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.V();
        }
        return null;
    }

    public final MediaStore O() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.W();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<com.nexstreaming.kinemaster.editorwrapper.Fa> P() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.X();
        }
        return null;
    }

    public final View Q() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.Y();
        }
        return null;
    }

    public final Integer R() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return Integer.valueOf(projectEditActivity.Z());
        }
        return null;
    }

    public final Integer S() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return Integer.valueOf(projectEditActivity.aa());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Integer T() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return Integer.valueOf(projectEditActivity.ca());
        }
        return null;
    }

    public final String U() {
        VideoEditor da = da();
        if (da == null || da.t() == null) {
            return null;
        }
        File t = da.t();
        kotlin.jvm.internal.h.a((Object) t, "editor.projectFile");
        return com.nexstreaming.kinemaster.project.k.b(t.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Integer V() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        return Integer.valueOf(projectEditActivity != null ? projectEditActivity.ea() : 0);
    }

    public final PurchaseType W() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.B();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SurfaceView X() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.fa();
        }
        return null;
    }

    public final NexTimelineItem Y() {
        com.nexstreaming.kinemaster.editorwrapper.Fa ca = ca();
        if (!(ca instanceof NexTimelineItem)) {
            ca = null;
        }
        return (NexTimelineItem) ca;
    }

    public Class<? extends NexTimelineItem> Z() {
        NexTimelineItem Y = Y();
        if (Y != null) {
            return Y.getClass();
        }
        return null;
    }

    public final com.nexstreaming.kinemaster.editorwrapper.Ea aa() {
        com.nexstreaming.kinemaster.editorwrapper.Fa ca = ca();
        if (!(ca instanceof com.nexstreaming.kinemaster.editorwrapper.Ea)) {
            ca = null;
        }
        return (com.nexstreaming.kinemaster.editorwrapper.Ea) ca;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final InterfaceC2025f ba() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.ia();
        }
        return null;
    }

    public final com.nexstreaming.kinemaster.editorwrapper.Fa ca() {
        Bundle arguments;
        String string;
        if (this.f21787b == null && da() != null) {
            VideoEditor da = da();
            if (da == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (da.s() != null) {
                if (this.f21788c == null && this.f21789d == -1 && (arguments = getArguments()) != null) {
                    if (arguments.containsKey("ProjectEditingFragmentBase_TimelineItemUUID")) {
                        String string2 = arguments.getString("ProjectEditingFragmentBase_TimelineItemUUID");
                        if (string2 != null) {
                            this.f21788c = UUID.fromString(string2);
                        }
                    } else if (arguments.containsKey("ProjectEditingFragmentBase_TimelineTrackID") && (string = arguments.getString("ProjectEditingFragmentBase_TimelineTrackID")) != null) {
                        Integer valueOf = Integer.valueOf(string);
                        kotlin.jvm.internal.h.a((Object) valueOf, "Integer.valueOf(trackId)");
                        this.f21789d = valueOf.intValue();
                    }
                }
                if (this.f21788c != null) {
                    VideoEditor da2 = da();
                    if (da2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    C1780za s = da2.s();
                    kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
                    this.f21787b = s.a().findItemByUniqueId(this.f21788c);
                } else if (this.f21789d != -1) {
                    VideoEditor da3 = da();
                    if (da3 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    C1780za s2 = da3.s();
                    kotlin.jvm.internal.h.a((Object) s2, "getVideoEditor()!!.project");
                    this.f21787b = s2.a().findTrackByUniqueId(this.f21789d);
                }
            }
        }
        return this.f21787b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.f(nexTimelineItem);
        }
    }

    public final VideoEditor da() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.ja();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(boolean z) {
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        View findViewById = view != null ? view.findViewById(R.id.optionMenuDone) : null;
        if (!(findViewById instanceof ImageButton)) {
            findViewById = null;
        }
        ImageButton imageButton = (ImageButton) findViewById;
        if (imageButton != null) {
            imageButton.setImageResource(z ? R.drawable.optmenu_cancel : R.drawable.optmenu_done);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ea() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.C();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(boolean z) {
        View findViewById;
        this.f21793h = z;
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || (findViewById = view.findViewById(R.id.optmenu_back)) == null) {
            return;
        }
        findViewById.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fa() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.ka();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(boolean z) {
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || !z) {
            return;
        }
        View findViewById = view.findViewById(R.id.optionStoreButton);
        if (findViewById != null) {
            ImageButton imageButton = (ImageButton) findViewById;
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new Fg(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageButton");
    }

    public final void ga() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.la();
        }
    }

    public final void h(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.o(z);
        }
    }

    public boolean h(int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ha() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.e(Y());
        }
    }

    public final void i(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.p(z);
        }
    }

    public final void ia() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.ma();
        }
    }

    public final void j(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.q(z);
        }
    }

    public boolean ja() {
        return false;
    }

    public final void k(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.r(z);
        }
    }

    public final Boolean ka() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return Boolean.valueOf(projectEditActivity.na());
        }
        return null;
    }

    public final void l(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.s(z);
        }
    }

    public final Boolean la() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return Boolean.valueOf(projectEditActivity.pa());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(int i) {
        WeakReference<View> weakReference = this.f21790e;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            View findViewById = view.findViewById(R.id.optmenu_icon);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }
            ImageView imageView = (ImageView) findViewById;
            if (i == 0) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(i);
            }
        }
    }

    public boolean ma() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(int i) {
        this.f21791f = getResources().getString(i);
        ua();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void na() {
    }

    public final void o(int i) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.m(i);
        }
    }

    public void oa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
            return;
        }
        if (Y() instanceof NexVideoClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_duplicate_clip_as_layer, R.string.action_duplicate_layer);
            return;
        }
        if (Y() instanceof NexAudioClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (Y() instanceof NexTransitionItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_share, R.drawable.action_icon_share, R.id.action_settings, R.drawable.action_icon_settings);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(this);
        }
        if (M().pa()) {
            pa();
        } else {
            oa();
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        super.onAttach(context);
        ta();
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        if (bundle != null) {
            if (bundle.containsKey("ProjectEditingFragmentBase_TimelineItemUUID")) {
                String string2 = bundle.getString("ProjectEditingFragmentBase_TimelineItemUUID");
                if (string2 != null) {
                    this.f21788c = UUID.fromString(string2);
                }
            } else if (bundle.containsKey("ProjectEditingFragmentBase_TimelineTrackID") && (string = bundle.getString("ProjectEditingFragmentBase_TimelineTrackID")) != null) {
                Integer valueOf = Integer.valueOf(string);
                kotlin.jvm.internal.h.a((Object) valueOf, "Integer.valueOf(trackId)");
                this.f21789d = valueOf.intValue();
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        List<b<Fragment>> list = this.j;
        if (list != null) {
            list.clear();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.b(bundle, "outState");
        com.nexstreaming.kinemaster.editorwrapper.Fa fa = this.f21787b;
        if (fa instanceof NexTimelineItem) {
            if (fa == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.NexTimelineItem");
            }
            bundle.putString("ProjectEditingFragmentBase_TimelineItemUUID", ((NexTimelineItem) fa).getUniqueId().toString());
        } else if (fa instanceof com.nexstreaming.kinemaster.editorwrapper.Ea) {
            if (fa == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.editorwrapper.TimelineTrack");
            }
            bundle.putString("ProjectEditingFragmentBase_TimelineTrackID", String.valueOf(((com.nexstreaming.kinemaster.editorwrapper.Ea) fa).c()));
        }
        super.onSaveInstanceState(bundle);
    }

    public final void p(int i) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.o(i);
        }
    }

    public void pa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
            return;
        }
        if (Y() instanceof NexVideoClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_duplicate_clip_as_layer, R.string.action_duplicate_layer);
            return;
        }
        if (Y() instanceof NexAudioClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (Y() instanceof NexTransitionItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qa() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.ua();
        }
    }

    public final void ra() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.va();
        }
    }

    public void z() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final <T extends com.nexstreaming.kinemaster.editorwrapper.Fa> Bg a(T t) {
        kotlin.jvm.internal.h.b(t, "timelineItem");
        if (isAdded()) {
            this.f21787b = t;
            na();
            return this;
        }
        if (this.f21787b == null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            if (t instanceof NexTimelineItem) {
                arguments.putString("ProjectEditingFragmentBase_TimelineItemUUID", ((NexTimelineItem) t).getUniqueId().toString());
            } else if (t instanceof com.nexstreaming.kinemaster.editorwrapper.Ea) {
                arguments.putString("ProjectEditingFragmentBase_TimelineTrackID", String.valueOf(((com.nexstreaming.kinemaster.editorwrapper.Ea) t).c()));
            }
            setArguments(arguments);
            return this;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i, int i2, int i3) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i, boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.b(i, z);
        }
    }

    public final int d(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.n(z);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(NexTimelineItem nexTimelineItem) {
        VideoEditor da = da();
        if (da != null) {
            da.c(nexTimelineItem);
            da.H();
            da.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i, int i2) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.b(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.g(nexTimelineItem);
        }
    }

    public final void n(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.u(z);
        }
    }

    public final void c(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.m(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(String str) {
        this.f21792g = str;
        ua();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float c(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            return projectEditActivity.d(nexTimelineItem);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "item");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.i(nexTimelineItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(String str) {
        this.f21791f = str;
        ua();
    }

    public final void b(int i, boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.t(z);
        }
    }

    public final void b(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.l(z);
        }
    }

    public final <T extends Fragment> void b(b<? super T> bVar) {
        kotlin.jvm.internal.h.b(bVar, Constants.LANDSCAPE);
        List<b<Fragment>> list = this.j;
        if (list != null) {
            list.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(View view) {
        kotlin.jvm.internal.h.b(view, "contentView");
        View findViewById = view.findViewById(R.id.optmenu_header);
        this.i = false;
        if (findViewById == null && (findViewById = view.findViewById(R.id.optmenu_tabheader)) != null) {
            this.i = true;
        }
        if (findViewById != null) {
            this.f21790e = new WeakReference<>(findViewById);
            findViewById.findViewById(R.id.optionMenuDone).setOnClickListener(new Cg(this));
            Eg eg = new Eg(this);
            if (this.i) {
                return;
            }
            Dg dg = new Dg(this);
            findViewById.findViewById(R.id.optmenu_back).setOnClickListener(eg);
            findViewById.findViewById(R.id.descTitle).setOnClickListener(eg);
            findViewById.findViewById(R.id.descTitleSm).setOnClickListener(eg);
            findViewById.findViewById(R.id.descSubtitleSm).setOnClickListener(eg);
            findViewById.findViewById(R.id.optmenu_back).setOnTouchListener(dg);
            findViewById.findViewById(R.id.descTitle).setOnTouchListener(dg);
            findViewById.findViewById(R.id.descTitleSm).setOnTouchListener(dg);
            findViewById.findViewById(R.id.descSubtitleSm).setOnTouchListener(dg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(CharSequence charSequence, int i) {
        kotlin.jvm.internal.h.b(charSequence, "text");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(charSequence, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int... iArr) {
        kotlin.jvm.internal.h.b(iArr, "buttonAndIconIds");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(iArr, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(NexTimelineItem nexTimelineItem) {
        kotlin.jvm.internal.h.b(nexTimelineItem, "addedItem");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.b(nexTimelineItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(MediaStoreItemId mediaStoreItemId) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(mediaStoreItemId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(MediaStoreItemId mediaStoreItemId, Bitmap bitmap) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            MediaStore O = O();
            if (O != null) {
                projectEditActivity.a(mediaStoreItemId, O.b(mediaStoreItemId), bitmap);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    public final void a(MediaStoreItemId mediaStoreItemId, Bitmap bitmap, ProjectEditActivity.InsertPosition insertPosition, boolean z, boolean z2) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
        kotlin.jvm.internal.h.b(bitmap, "thumbnail");
        kotlin.jvm.internal.h.b(insertPosition, "insertPosition");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(mediaStoreItemId, (com.nexstreaming.kinemaster.mediastore.item.c) null, bitmap, insertPosition, z, z2);
        }
    }

    public final void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, Bitmap bitmap, ProjectEditActivity.InsertPosition insertPosition, boolean z, boolean z2, boolean z3) {
        kotlin.jvm.internal.h.b(mediaStoreItemId, "itemId");
        kotlin.jvm.internal.h.b(cVar, "item");
        kotlin.jvm.internal.h.b(bitmap, "thumbnail");
        kotlin.jvm.internal.h.b(insertPosition, "insertPosition");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(mediaStoreItemId, cVar, bitmap, insertPosition, z, z2, z3);
        }
    }

    public static /* synthetic */ void a(Bg bg, NexTimelineItem nexTimelineItem, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: commitChanges");
        }
        if ((i & 1) != 0) {
            nexTimelineItem = bg.Y();
        }
        bg.b(nexTimelineItem);
    }

    public final void a(Tb tb) {
        kotlin.jvm.internal.h.b(tb, "listener");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(tb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(UniformTimelineView.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "listener");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ProjectEditActivity)) {
            activity = null;
        }
        ProjectEditActivity projectEditActivity = (ProjectEditActivity) activity;
        if (projectEditActivity != null) {
            projectEditActivity.a(cVar);
        }
    }

    public final <T extends Fragment> void a(b<T> bVar) {
        kotlin.jvm.internal.h.b(bVar, Constants.LANDSCAPE);
        if (this.j == null) {
            this.j = new ArrayList();
        }
        List<b<Fragment>> list = this.j;
        if (list != null) {
            list.add(bVar);
        }
    }
}
