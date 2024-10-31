package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* compiled from: ProjectEditingFragmentBase.java */
/* loaded from: classes.dex */
public abstract class kp extends Fragment implements a {
    private WeakReference<View> c;
    private String d;
    private String e;

    /* renamed from: a, reason: collision with root package name */
    private NexTimelineItem f4040a = null;
    private UUID b = null;
    private boolean f = false;
    private boolean g = false;

    public kp a(NexTimelineItem nexTimelineItem) {
        if (isAdded()) {
            this.f4040a = nexTimelineItem;
            f();
        } else {
            if (this.f4040a != null) {
                throw new IllegalStateException();
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("ProjectEditingFragmentBase_TimelineItemUUID", nexTimelineItem.getUniqueId().toString());
            setArguments(arguments);
        }
        return this;
    }

    public boolean k_() {
        return false;
    }

    public boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        View findViewById = view.findViewById(R.id.optmenu_header);
        this.g = false;
        if (findViewById == null && (findViewById = view.findViewById(R.id.optmenu_tabheader)) != null) {
            this.g = true;
        }
        if (findViewById != null) {
            this.c = new WeakReference<>(findViewById);
            findViewById.findViewById(R.id.optionMenuDone).setOnClickListener(new kq(this));
            kr krVar = new kr(this);
            if (!this.g) {
                ks ksVar = new ks(this);
                findViewById.findViewById(R.id.optmenu_back).setOnClickListener(krVar);
                findViewById.findViewById(R.id.descTitle).setOnClickListener(krVar);
                findViewById.findViewById(R.id.descTitleSm).setOnClickListener(krVar);
                findViewById.findViewById(R.id.descSubtitleSm).setOnClickListener(krVar);
                findViewById.findViewById(R.id.optmenu_back).setOnTouchListener(ksVar);
                findViewById.findViewById(R.id.descTitle).setOnTouchListener(ksVar);
                findViewById.findViewById(R.id.descTitleSm).setOnTouchListener(ksVar);
                findViewById.findViewById(R.id.descSubtitleSm).setOnTouchListener(ksVar);
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(this);
        }
        super.onActivityCreated(bundle);
    }

    public Class<? extends NexTimelineItem> g() {
        NexTimelineItem m = m();
        if (m != null) {
            return m.getClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        View view = this.c.get();
        if (view != null) {
            ((ImageButton) view.findViewById(R.id.optionMenuDone)).setImageResource(z ? R.drawable.optmenu_cancel : R.drawable.optmenu_done);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        View view = this.c.get();
        if (view != null) {
            view.findViewById(R.id.optionMenuDone).setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        View view = this.c.get();
        if (view != null) {
            view.findViewById(R.id.optionMenuDone).setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i) {
        View view = this.c.get();
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.optmenu_icon);
            if (i == 0) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z) {
        this.f = z;
        View view = this.c.get();
        if (view != null) {
            view.findViewById(R.id.optmenu_back).setVisibility(z ? 0 : 8);
        }
    }

    private void c() {
        View view = this.c.get();
        if (view != null && !this.g) {
            if (this.e != null && this.e.trim().length() > 0) {
                ((TextView) view.findViewById(R.id.descTitle)).setText("");
                ((TextView) view.findViewById(R.id.descTitleSm)).setText(this.d);
                ((TextView) view.findViewById(R.id.descSubtitleSm)).setText(this.e);
            } else {
                ((TextView) view.findViewById(R.id.descTitle)).setText(this.d);
                ((TextView) view.findViewById(R.id.descTitleSm)).setText("");
                ((TextView) view.findViewById(R.id.descSubtitleSm)).setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i) {
        this.d = getResources().getString(i);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        this.d = str;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.e = str;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CharSequence charSequence, int i) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(charSequence, i);
        }
    }

    public NexTimelineItem m() {
        Bundle arguments;
        String string;
        if (this.f4040a == null) {
            if (this.b == null && (arguments = getArguments()) != null && (string = arguments.getString("ProjectEditingFragmentBase_TimelineItemUUID")) != null) {
                this.b = UUID.fromString(string);
            }
            if (o().f() == null) {
                return null;
            }
            if (this.b != null) {
                this.f4040a = o().f().a().findItemByUniqueId(this.b);
            }
        }
        return this.f4040a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i, boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(i, z);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        if (bundle != null && (string = bundle.getString("ProjectEditingFragmentBase_TimelineItemUUID")) != null) {
            this.b = UUID.fromString(string);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f4040a != null) {
            bundle.putString("ProjectEditingFragmentBase_TimelineItemUUID", this.f4040a.getUniqueId().toString());
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int... iArr) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(iArr, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).b(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, int i3) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VideoEditor o() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return null;
        }
        return ((ProjectEditActivity) activity).p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(NexTimelineItem nexTimelineItem) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).d(nexTimelineItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(NexTimelineItem nexTimelineItem) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).c(nexTimelineItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(MSID msid) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(msid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(MSID msid, Bitmap bitmap) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(msid, p().a(msid), bitmap);
        }
    }

    public void a(MSID msid, Bitmap bitmap, ProjectEditActivity.InsertPosition insertPosition, boolean z, boolean z2) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(msid, (MediaStoreItem) null, bitmap, insertPosition, z, z2, (ProjectEditActivity.c) null);
        }
    }

    public void a(MSID msid, MediaStoreItem mediaStoreItem, Bitmap bitmap, ProjectEditActivity.InsertPosition insertPosition, boolean z, boolean z2) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(msid, mediaStoreItem, bitmap, insertPosition, z, z2, (ProjectEditActivity.c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaStore p() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return null;
        }
        return ((ProjectEditActivity) activity).x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(NexTimelineItem nexTimelineItem) {
        o().a(nexTimelineItem);
        o().n();
        o().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FragmentTransaction b(FragmentTransaction fragmentTransaction) {
        return ProjectEditActivity.a(fragmentTransaction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int q() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0;
        }
        return ((ProjectEditActivity) activity).l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0;
        }
        return ((ProjectEditActivity) activity).m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).e(m());
        }
    }

    public void e(int i, boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).b(i, z);
        }
    }

    public int e(boolean z) {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0;
        }
        return ((ProjectEditActivity) activity).g(z);
    }

    public void f(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).i(z);
        }
    }

    public void g(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).j(z);
        }
    }

    public void g(int i) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).k(i);
        }
    }

    public void a(cd cdVar) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(cdVar);
        }
    }

    public boolean t() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return false;
        }
        return ((ProjectEditActivity) activity).q();
    }

    public boolean u() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return false;
        }
        return ((ProjectEditActivity) activity).r();
    }

    public boolean v() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return false;
        }
        return ((ProjectEditActivity) activity).s();
    }

    public View w() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return null;
        }
        return ((ProjectEditActivity) activity).g();
    }

    public int x() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0;
        }
        return ((ProjectEditActivity) activity).h();
    }

    public int y() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0;
        }
        return ((ProjectEditActivity) activity).i();
    }

    public void h(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).h(z);
        }
    }

    public void i(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).b(z);
        }
    }

    public void j(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).c(z);
        }
    }

    public void k(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).d(z);
        }
    }

    public void l(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).e(z);
        }
    }

    public void m(boolean z) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).f(z);
        }
    }

    public void z() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).j();
        }
    }

    public void h(int i) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).a(i);
        }
    }

    public void A() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).c();
        }
    }

    public MediaPrepManager B() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return null;
        }
        return ((ProjectEditActivity) activity).t();
    }

    public boolean C() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return false;
        }
        return ((ProjectEditActivity) activity).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        d(m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SurfaceView D() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return null;
        }
        return ((ProjectEditActivity) activity).d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof com.nextreaming.nexeditorui.ba)) {
            return false;
        }
        return ((com.nextreaming.nexeditorui.ba) activity).B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float e(NexTimelineItem nexTimelineItem) {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return 0.0f;
        }
        return ((ProjectEditActivity) activity).b(nexTimelineItem);
    }

    public String G() {
        VideoEditor o = o();
        if (o == null || o.g() == null) {
            return null;
        }
        return com.nexstreaming.kinemaster.project.f.f(o.g().getName());
    }

    public boolean a(int i) {
        return false;
    }
}
