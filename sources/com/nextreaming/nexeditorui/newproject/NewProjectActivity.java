package com.nextreaming.nexeditorui.newproject;

import android.arch.lifecycle.s;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.mediabrowser.C1829g;
import com.nexstreaming.kinemaster.ui.mediabrowser.T;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.ui.widget.AutoResizeTextView;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.InterfaceC2301ca;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.newproject.a.a;
import com.nextreaming.nexeditorui.newproject.b.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class NewProjectActivity extends I implements T, g.a, a.InterfaceC0118a, InterfaceC2301ca, MediaPrepManager.a, tb.a, tb.b, com.nexstreaming.app.general.iab.a.a {
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean O;
    private ArrayList<com.nexstreaming.kinemaster.mediastore.item.c> Q;
    private c.d.b.i.a R;
    private ArrayList<String> S;
    private ArrayList<Integer> T;
    private String U;
    private File V;
    private Step W;
    private View X;
    private View Y;
    private View Z;
    private View aa;
    private View ba;
    private AutoResizeTextView ca;
    private LinearLayout da;
    private LinearLayout ea;
    private HorizontalScrollView fa;
    private String ga;
    private final int H = R.id.container;
    private int[] I = new int[2];
    private boolean N = true;
    private int P = -1;
    private HashMap<Step, Fragment.SavedState> ha = new HashMap<>();
    private View.OnLongClickListener ia = new g(this);
    private View.OnDragListener ja = new h(this);
    private View.OnClickListener ka = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Step {
        MEDIA_BROWSER(R.id.linear_step_media),
        THEME_BROWSER(R.id.linear_step_theme),
        INPUT_TEXT(R.id.linear_step_text),
        MUSIC_BROWSER(R.id.linear_step_music),
        NEXT(R.id.linear_step_next);

        private final int id;

        Step(int i) {
            this.id = i;
        }

        public static Step findStepById(int i) {
            for (Step step : values()) {
                if (step.id == i) {
                    return step;
                }
            }
            return null;
        }

        public int getId() {
            return this.id;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Step[] values = Step.values();
        int ordinal = this.W.ordinal() + 1;
        if (ordinal > values.length) {
            ordinal = values.length;
        }
        if (ordinal <= values.length - 2) {
            a(values[ordinal]);
            return;
        }
        String str = this.U;
        String str2 = str != null ? str : null;
        String str3 = this.ga;
        String str4 = str3 != null ? str3 : null;
        Iterator<String> it = this.S.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                next.trim().length();
            }
        }
        if (this.Q.size() > 1) {
            Collections.reverse(this.Q);
        }
        Intent a2 = ProjectEditActivity.a(u(), this.Q, this.S, str2, str4, this.R, this.V);
        a2.addFlags(33554432);
        startActivity(a2);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return false;
    }

    @Nullable
    public MediaStore G() {
        return KineMasterApplication.f24056d.p();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (keyEvent.hasModifiers(4096) && keyEvent.getKeyCode() == 42) {
            if (!this.ba.isEnabled()) {
                return true;
            }
            K();
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            int[] iArr = new int[2];
            View childAt = this.ea.getChildAt(this.P);
            childAt.getLocationOnScreen(iArr);
            if (!new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                childAt.findViewById(R.id.deleteView).setVisibility(8);
                childAt.findViewById(R.id.deleteBorderView).setVisibility(8);
                this.O = false;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.b
    public void i() {
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.O) {
            View childAt = this.ea.getChildAt(this.P);
            childAt.findViewById(R.id.deleteView).setVisibility(8);
            childAt.findViewById(R.id.deleteBorderView).setVisibility(8);
            this.O = false;
            return;
        }
        Step[] values = Step.values();
        if (this.W.ordinal() > Step.MEDIA_BROWSER.ordinal()) {
            a(values[this.W.ordinal() - 1]);
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        File file;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_project);
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        MediaStore.a(this);
        this.Q = new ArrayList<>();
        this.S = new ArrayList<>();
        this.T = new ArrayList<>();
        this.X = findViewById(R.id.linear_step_media);
        this.Y = findViewById(R.id.linear_step_theme);
        this.Z = findViewById(R.id.linear_step_text);
        this.aa = findViewById(R.id.linear_step_music);
        this.ba = findViewById(R.id.linear_step_next);
        this.ca = (AutoResizeTextView) findViewById(R.id.textView_new_project_step_next);
        this.fa = (HorizontalScrollView) findViewById(R.id.horizontal_selected_items);
        this.ea = (LinearLayout) findViewById(R.id.linear_selected_items);
        this.da = (LinearLayout) findViewById(R.id.bottombar_holder);
        if (bundle == null) {
            this.W = Step.MEDIA_BROWSER;
            if (getIntent() != null && getIntent().getExtras() != null && (file = (File) getIntent().getExtras().get("ProjectPath")) != null) {
                this.V = file;
            }
        } else {
            Step findStepById = Step.findStepById(bundle.getInt("CurrentStep"));
            if (findStepById != null) {
                this.W = findStepById;
            }
            Bundle bundle2 = bundle.getBundle("FragmentState");
            if (bundle2 != null) {
                for (String str : bundle2.keySet()) {
                    this.ha.put(Step.valueOf(str), bundle2.getParcelable(str));
                }
            }
            File file2 = (File) bundle.getSerializable("ProjectPath");
            if (file2 != null) {
                this.V = file2;
            }
            String[] stringArray = bundle.getStringArray("SaveMediaItems");
            if (stringArray != null) {
                int length = stringArray.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = stringArray[i];
                    if (G().a(str2) == null) {
                        this.Q.clear();
                        break;
                    } else {
                        a(G().a(str2));
                        i++;
                    }
                }
            }
            String string = bundle.getString("selectedThemeId");
            if (string != null) {
                this.R = c.d.b.i.b.a(string);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("Titles");
            if (stringArrayList != null) {
                this.S = stringArrayList;
            }
            String string2 = bundle.getString("musicPath");
            String string3 = bundle.getString("musicName");
            if (string2 != null && string3 != null) {
                this.U = string2;
                this.ga = string3;
            }
        }
        this.X.setOnClickListener(this.ka);
        this.Y.setOnClickListener(this.ka);
        this.Z.setOnClickListener(this.ka);
        this.aa.setOnClickListener(this.ka);
        this.ba.setOnClickListener(this.ka);
        this.da.setOnDragListener(this.ja);
        if (this.Q.size() <= 0) {
            this.ba.setEnabled(false);
            this.ca.setEnabled(false);
        }
        if (bundle == null) {
            a(this.W);
        } else {
            b(this.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        y().b((com.nexstreaming.app.general.iab.a.a) this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container);
            if (findFragmentById != null && this.W != null) {
                this.ha.put(this.W, getSupportFragmentManager().saveFragmentInstanceState(findFragmentById));
            }
            Bundle bundle2 = new Bundle();
            for (Map.Entry<Step, Fragment.SavedState> entry : this.ha.entrySet()) {
                bundle2.putParcelable(entry.getKey().name(), entry.getValue());
            }
            bundle.putInt("CurrentStep", this.W.getId());
            bundle.putBundle("FragmentState", bundle2);
            bundle.putSerializable("ProjectPath", this.V);
            bundle.putStringArray("SaveMediaItems", c(this.Q));
            c.d.b.i.a aVar = this.R;
            if (aVar != null) {
                bundle.putString("selectedThemeId", aVar.getId());
            }
            if (this.S.size() > 0) {
                bundle.putStringArrayList("Titles", this.S);
            }
            String str = this.U;
            if (str != null) {
                bundle.putString("musicPath", str);
                bundle.putString("musicName", this.ga);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.g.a
    public void r() {
        this.R = null;
        if (this.N) {
            this.U = null;
            this.ga = null;
        }
    }

    private String[] c(ArrayList<com.nexstreaming.kinemaster.mediastore.item.c> arrayList) {
        String[] strArr = new String[arrayList.size()];
        Iterator<com.nexstreaming.kinemaster.mediastore.item.c> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().getId().toString();
            i++;
        }
        return strArr;
    }

    private void d(int i) {
        Log.i("NewProjectActivity", "remove : " + i);
        this.Q.remove(i);
        s findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container);
        if (findFragmentById == null || !(findFragmentById instanceof VideoEditor.e)) {
            return;
        }
        ((VideoEditor.e) findFragmentById).c();
    }

    public /* synthetic */ void b(ImageView imageView, View view, View view2) {
        if (this.O && imageView.getVisibility() == 0) {
            imageView.setVisibility(8);
            view.setVisibility(8);
            this.ea.removeViewAt(this.P);
            d(this.P);
            if (this.Q.size() <= 0) {
                this.ba.setEnabled(false);
                this.ca.setEnabled(false);
            }
            L();
            this.O = false;
            this.P = -1;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a
    public void a(MediaStoreItemId mediaStoreItemId, C1803a c1803a) {
        MediaPrepState mediaPrepState;
        Runnable runnable;
        MediaSupportType mediaSupportType = c1803a.f20785e;
        if ((mediaSupportType != null && mediaSupportType.isNotSupported()) || (mediaPrepState = c1803a.f20781a) == MediaPrepState.FailNotSupported) {
            String notSupportedReason = mediaSupportType != null ? mediaSupportType.getNotSupportedReason(this) : null;
            if (notSupportedReason == null) {
                notSupportedReason = getString(R.string.media_nosupport_unknown);
            }
            e.a aVar = new e.a(u());
            aVar.a(notSupportedReason);
            aVar.c(R.string.theme_change_warning_ok, new DialogInterface.OnClickListener() { // from class: com.nextreaming.nexeditorui.newproject.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            aVar.a().show();
            if (this.Q.size() > 0) {
                this.ea.removeViewAt(this.Q.size() - 1);
                d(this.J);
                if (this.Q.size() <= 0) {
                    this.ba.setEnabled(false);
                    this.ca.setEnabled(false);
                }
                L();
                return;
            }
            return;
        }
        if (mediaPrepState == MediaPrepState.UserInterventionRequired && (runnable = c1803a.f20786f) != null) {
            runnable.run();
            return;
        }
        if (c1803a.f20781a != MediaPrepState.UserInterventionCancel || this.Q.size() <= 0) {
            return;
        }
        this.ea.removeViewAt(this.Q.size() - 1);
        d(this.J);
        if (this.Q.size() <= 0) {
            this.ba.setEnabled(false);
            this.ca.setEnabled(false);
        }
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        Log.i("NewProjectActivity", "move : " + i + "  >>  " + i2);
        if (i == i2) {
            return;
        }
        com.nexstreaming.kinemaster.mediastore.item.c cVar = this.Q.get(i);
        if (i > i2) {
            for (int i3 = i; i3 > i2; i3--) {
                this.Q.set(i3, this.Q.get(i3 - 1));
            }
        }
        if (i < i2) {
            while (i < i2) {
                int i4 = i + 1;
                this.Q.set(i, this.Q.get(i4));
                i = i4;
            }
        }
        this.Q.set(i2, cVar);
    }

    @Override // com.nextreaming.nexeditorui.newproject.a.a.InterfaceC0118a
    public void b(ArrayList<String> arrayList) {
        this.S = arrayList;
    }

    private void b(Step step) {
        View findViewById = findViewById(R.id.linear_step_media);
        View findViewById2 = findViewById(R.id.linear_step_theme);
        View findViewById3 = findViewById(R.id.linear_step_text);
        View findViewById4 = findViewById(R.id.linear_step_music);
        findViewById.setSelected(false);
        findViewById2.setSelected(false);
        findViewById3.setSelected(false);
        findViewById4.setSelected(false);
        int id = step.getId();
        if (id == R.id.linear_step_media) {
            findViewById(R.id.horizontal_selected_items).setVisibility(0);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
        } else {
            findViewById(R.id.horizontal_selected_items).setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            findViewById4.setVisibility(0);
        }
        findViewById(id).setSelected(true);
    }

    public void a(Step step) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.container);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (findFragmentById != null && this.W != null) {
            this.ha.put(this.W, getSupportFragmentManager().saveFragmentInstanceState(findFragmentById));
        }
        int i = j.f24372a[step.ordinal()];
        Fragment fragment = null;
        if (i == 1) {
            C1829g.a A = C1829g.A();
            A.a(getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height));
            A.b(0);
            A.a(false);
            C1829g a2 = A.a();
            a2.a(this);
            fragment = a2;
        } else if (i != 2) {
            if (i == 3) {
                c.d.b.i.a aVar = this.R;
                fragment = com.nextreaming.nexeditorui.newproject.a.a.a(aVar != null ? aVar.a() : 3, this.S);
            } else if (i == 4) {
                fragment = com.nexstreaming.kinemaster.ui.audiobrowser.a.f21406b.a(0, getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height), this.U, this.ga);
            }
        } else {
            c.d.b.i.a aVar2 = this.R;
            fragment = com.nextreaming.nexeditorui.newproject.b.g.a(aVar2 != null ? aVar2.getId() : null, false);
        }
        Fragment.SavedState savedState = this.ha.get(step);
        if (savedState != null) {
            fragment.setInitialSavedState(savedState);
        }
        beginTransaction.replace(R.id.container, fragment);
        beginTransaction.commit();
        b(step);
        this.W = step;
    }

    private void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal_selected_items);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_selected_items);
        View inflate = getLayoutInflater().inflate(R.layout.panel_new_project_bottom_bar_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview_Selected_Item);
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.deleteView);
        final View findViewById = inflate.findViewById(R.id.deleteBorderView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.n2_no_thumb_avail));
        inflate.setOnLongClickListener(this.ia);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.nextreaming.nexeditorui.newproject.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProjectActivity.this.a(imageView2, findViewById, view);
            }
        });
        imageView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.nextreaming.nexeditorui.newproject.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NewProjectActivity.a(view, motionEvent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.nextreaming.nexeditorui.newproject.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProjectActivity.this.b(imageView2, findViewById, view);
            }
        });
        G().a(cVar, new f(this, imageView));
        linearLayout.addView(inflate, EditorGlobal.a((Context) u(), 80), EditorGlobal.a((Context) u(), 42));
        this.Q.add(cVar);
        L();
        linearLayout.postDelayed(new Runnable() { // from class: com.nextreaming.nexeditorui.newproject.e
            @Override // java.lang.Runnable
            public final void run() {
                horizontalScrollView.fullScroll(66);
            }
        }, 200L);
        if (this.Q.size() > 0) {
            this.ba.setEnabled(true);
            this.ca.setEnabled(true);
        }
    }

    public /* synthetic */ void a(ImageView imageView, View view, View view2) {
        if (this.O || imageView.getVisibility() != 8) {
            return;
        }
        for (int i = 0; i < this.ea.getChildCount(); i++) {
            if (this.ea.getChildAt(i) == view2) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                this.P = i;
                this.O = true;
                return;
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.T
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, int i) {
        a(cVar);
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.g.a
    public void a(c.d.b.i.a aVar) {
        this.R = aVar;
        if (this.N) {
            String b2 = aVar.b();
            if (b2 != null) {
                this.U = b2;
                this.ga = aVar.getName(u());
            } else {
                this.U = null;
                this.ga = null;
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.InterfaceC2301ca
    public void a(String str, String str2, int i) {
        this.U = str;
        this.ga = str2;
        this.N = false;
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        i(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.a
    public void a(String str) {
        i(true);
    }
}
