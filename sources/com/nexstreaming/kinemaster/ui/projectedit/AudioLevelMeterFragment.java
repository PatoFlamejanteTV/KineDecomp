package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class AudioLevelMeterFragment extends Fragment implements VideoEditor.c, VideoEditor.f, VideoEditor.g, ProjectEditActivity.c {

    /* renamed from: b */
    private com.nexstreaming.app.kinemasterfree.a.e f21766b;

    /* renamed from: c */
    private View f21767c;

    /* renamed from: d */
    private int f21768d;

    /* renamed from: h */
    private boolean f21772h;

    /* renamed from: a */
    private final Handler f21765a = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final int[] f21769e = new int[2];

    /* renamed from: f */
    private final AtomicInteger f21770f = new AtomicInteger(0);

    /* renamed from: g */
    private int f21771g = 3;

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f21767c = getActivity().findViewById(R.id.projectActionBar);
        if (getActivity() instanceof ProjectEditActivity) {
            ((ProjectEditActivity) getActivity()).a((ProjectEditActivity.c) this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21768d = getResources().getDimensionPixelSize(R.dimen.pedit_left_bar_width);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(AudioLevelMeterFragment.class.getName());
        this.f21766b = (com.nexstreaming.app.kinemasterfree.a.e) android.databinding.e.a(layoutInflater, R.layout.audio_level_meter_fragment, viewGroup, false);
        int i = this.f21771g;
        if (i == 0) {
            this.f21766b.z.setVisibility(8);
        } else if (i == 1) {
            this.f21766b.z.setVisibility(8);
            this.f21766b.z.setAlpha(0.0f);
        } else if (i == 2 || i == 3) {
            this.f21766b.z.setTranslationX(-this.f21768d);
        } else if (i == 4) {
            this.f21766b.z.setTranslationX(-this.f21768d);
            this.f21766b.z.setRotationY(-90.0f);
        }
        return this.f21766b.e();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (getActivity() instanceof ProjectEditActivity) {
            ((ProjectEditActivity) getActivity()).b((ProjectEditActivity.c) this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (getActivity() instanceof ProjectEditActivity) {
            VideoEditor ja = ((ProjectEditActivity) getActivity()).ja();
            ja.a((VideoEditor.c) this);
            ja.a((VideoEditor.g) this);
            ja.a((VideoEditor.f) this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f21765a.removeCallbacksAndMessages(null);
        if (getActivity() instanceof ProjectEditActivity) {
            VideoEditor ja = ((ProjectEditActivity) getActivity()).ja();
            ja.b((VideoEditor.c) this);
            ja.b((VideoEditor.g) this);
            ja.b((VideoEditor.f) this);
        }
        super.onStop();
    }

    private void b(boolean z) {
        this.f21766b.y.a();
        this.f21766b.A.a();
        if (z) {
            int i = this.f21771g;
            if (i == 0) {
                this.f21766b.z.setVisibility(0);
                return;
            }
            if (i == 1) {
                this.f21766b.z.setVisibility(0);
                this.f21766b.z.animate().alpha(1.0f).setDuration(300L).setListener(null).start();
                return;
            } else if (i == 2) {
                ViewCompat.animate(this.f21766b.z).translationX(0.0f).setDuration(300L).setUpdateListener(new G(this)).start();
                return;
            } else if (i == 3) {
                ViewCompat.animate(this.f21766b.z).translationX(0.0f).setDuration(300L).setUpdateListener(new H(this)).start();
                return;
            } else {
                if (i == 4) {
                    ViewCompat.animate(this.f21766b.z).translationX(0.0f).rotationY(0.0f).setDuration(300L).setListener(new J(this)).setUpdateListener(new I(this)).start();
                    return;
                }
                return;
            }
        }
        int i2 = this.f21771g;
        if (i2 == 0) {
            this.f21766b.z.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.f21766b.z.animate().alpha(0.0f).setDuration(300L).setListener(new K(this)).start();
            return;
        }
        if (i2 == 2) {
            ViewCompat.animate(this.f21766b.z).translationX(-this.f21768d).setDuration(300L).setUpdateListener(new L(this)).start();
        } else if (i2 == 3) {
            ViewCompat.animate(this.f21766b.z).translationX(-this.f21768d).setDuration(300L).setUpdateListener(new M(this)).start();
        } else if (i2 == 4) {
            ViewCompat.animate(this.f21766b.z).translationX(-this.f21768d).rotationY(-90.0f).setDuration(300L).setListener(new E(this)).setUpdateListener(new N(this)).start();
        }
    }

    public void c(int i, int i2) {
        this.f21766b.a(i);
        this.f21766b.b(i2);
        this.f21766b.d();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.c
    public void a(int i, int i2, int i3) {
        int[] iArr = this.f21769e;
        if (iArr[0] == i2 && iArr[1] == i3) {
            return;
        }
        int[] iArr2 = this.f21769e;
        iArr2[0] = i2;
        iArr2[1] = i3;
        int i4 = i - this.f21770f.get();
        if (i4 > 0) {
            this.f21765a.postDelayed(new F(this, i2, i3), i4);
        } else {
            c(i2, i3);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        if (getActivity() == null) {
            return;
        }
        if (!this.f21772h && state.isPlaying()) {
            b(true);
        } else {
            b(false);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        this.f21770f.set(i2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.c
    public void a(VideoEditor videoEditor, boolean z) {
        this.f21772h = z;
        if (!z && videoEditor.w().isPlaying()) {
            b(true);
        } else {
            b(false);
        }
    }
}
