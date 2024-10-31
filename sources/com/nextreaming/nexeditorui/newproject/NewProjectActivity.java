package com.nextreaming.nexeditorui.newproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.widget.AutoResizeTextView;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.aw;
import com.nextreaming.nexeditorui.bp;
import com.nextreaming.nexeditorui.newproject.a.a;
import com.nextreaming.nexeditorui.newproject.b.f;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class NewProjectActivity extends aw implements MediaPrepManager.a, bp, a.InterfaceC0084a, f.a, MediaBrowserFragment.b {
    private boolean B;
    private String D;
    private ArrayList<MediaStoreItem> e;
    private Theme f;
    private ArrayList<String> g;
    private ArrayList<Integer> h;
    private String i;
    private File j;
    private WindowManager k;
    private Step l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private AutoResizeTextView r;
    private LinearLayout s;
    private LinearLayout t;
    private HorizontalScrollView u;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: a, reason: collision with root package name */
    private final int f4657a = R.id.container;
    private int[] v = new int[2];
    private boolean A = true;
    private int C = -1;
    private HashMap<Step, Fragment.SavedState> E = new HashMap<>();
    private View.OnLongClickListener F = new i(this);
    private View.OnDragListener G = new j(this);
    private View.OnClickListener H = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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

        public int getId() {
            return this.id;
        }

        public static Step findStepById(int i) {
            for (Step step : values()) {
                if (step.id == i) {
                    return step;
                }
            }
            return null;
        }
    }

    private String[] b(ArrayList<MediaStoreItem> arrayList) {
        String[] strArr = new String[arrayList.size()];
        Iterator<MediaStoreItem> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().c().toString();
            i++;
        }
        return strArr;
    }

    @Override // com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a
    public void a(MSID msid, com.nexstreaming.kinemaster.mediaprep.a aVar) {
        MediaStoreItem.MediaSupportType mediaSupportType = aVar.e;
        if ((mediaSupportType != null && mediaSupportType.isNotSupported()) || aVar.f3523a == MediaPrepState.FailNotSupported) {
            String str = null;
            if (mediaSupportType != null) {
                str = mediaSupportType.getNotSupportedReason(this);
            }
            if (str == null) {
                str = getString(R.string.media_nosupport_unknown);
            }
            new a.C0074a(D()).a(str).a(R.string.theme_change_warning_ok, new a(this)).a().show();
            if (this.e.size() > 0) {
                this.t.removeViewAt(this.e.size() - 1);
                a(this.w);
                if (this.e.size() <= 0) {
                    this.q.setEnabled(false);
                    this.r.setEnabled(false);
                }
                c();
                return;
            }
            return;
        }
        if (aVar.f3523a == MediaPrepState.UserInterventionRequired && aVar.f != null) {
            aVar.f.run();
            return;
        }
        if (aVar.f3523a == MediaPrepState.UserInterventionCancel && this.e.size() > 0) {
            this.t.removeViewAt(this.e.size() - 1);
            a(this.w);
            if (this.e.size() <= 0) {
                this.q.setEnabled(false);
                this.r.setEnabled(false);
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.container);
            if (findFragmentById != null && this.l != null) {
                this.E.put(this.l, getFragmentManager().saveFragmentInstanceState(findFragmentById));
            }
            Bundle bundle2 = new Bundle();
            for (Map.Entry<Step, Fragment.SavedState> entry : this.E.entrySet()) {
                bundle2.putParcelable(entry.getKey().name(), entry.getValue());
            }
            bundle.putInt("CurrentStep", this.l.getId());
            bundle.putBundle("FragmentState", bundle2);
            bundle.putSerializable("ProjectPath", this.j);
            bundle.putStringArray("SaveMediaItems", b(this.e));
            if (this.f != null) {
                bundle.putString("selectedThemeId", this.f.i());
            }
            if (this.g.size() > 0) {
                bundle.putStringArrayList("Titles", this.g);
            }
            if (this.i != null) {
                bundle.putString("musicPath", this.i);
                bundle.putString("musicName", this.D);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        File file;
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_project);
        this.k = (WindowManager) getSystemService("window");
        this.e = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.m = findViewById(R.id.linear_step_media);
        this.n = findViewById(R.id.linear_step_theme);
        this.o = findViewById(R.id.linear_step_text);
        this.p = findViewById(R.id.linear_step_music);
        this.q = findViewById(R.id.linear_step_next);
        this.r = (AutoResizeTextView) findViewById(R.id.textView_new_project_step_next);
        this.u = (HorizontalScrollView) findViewById(R.id.horizontal_selected_items);
        this.t = (LinearLayout) findViewById(R.id.linear_selected_items);
        this.s = (LinearLayout) findViewById(R.id.bottombar_holder);
        if (bundle == null) {
            this.l = Step.MEDIA_BROWSER;
            if (getIntent() != null && getIntent().getExtras() != null && (file = (File) getIntent().getExtras().get("ProjectPath")) != null) {
                this.j = file;
            }
        } else {
            Step findStepById = Step.findStepById(bundle.getInt("CurrentStep"));
            if (findStepById != null) {
                this.l = findStepById;
            }
            Bundle bundle2 = bundle.getBundle("FragmentState");
            if (bundle2 != null) {
                for (String str : bundle2.keySet()) {
                    this.E.put(Step.valueOf(str), (Fragment.SavedState) bundle2.getParcelable(str));
                }
            }
            File file2 = (File) bundle.getSerializable("ProjectPath");
            if (file2 != null) {
                this.j = file2;
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
                    if (x().c(str2) == null) {
                        this.e.clear();
                        break;
                    } else {
                        a(x().c(str2));
                        i++;
                    }
                }
            }
            String string = bundle.getString("selectedThemeId");
            if (string != null) {
                EffectLibrary.a(D()).b().onComplete(new c(this, string));
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("Titles");
            if (stringArrayList != null) {
                this.g = stringArrayList;
            }
            String string2 = bundle.getString("musicPath");
            String string3 = bundle.getString("musicName");
            if (string2 != null && string3 != null) {
                this.i = string2;
                this.D = string3;
            }
        }
        this.m.setOnClickListener(this.H);
        this.n.setOnClickListener(this.H);
        this.o.setOnClickListener(this.H);
        this.p.setOnClickListener(this.H);
        this.q.setOnClickListener(this.H);
        this.s.setOnDragListener(this.G);
        if (this.e.size() <= 0) {
            this.q.setEnabled(false);
            this.r.setEnabled(false);
        }
        if (bundle == null) {
            a(this.l);
        } else {
            b(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_GettingStarted.begin();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        KMUsage.Activity_GettingStarted.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (this.B) {
            View childAt = this.t.getChildAt(this.C);
            childAt.findViewById(R.id.deleteView).setVisibility(8);
            childAt.findViewById(R.id.deleteBorderView).setVisibility(8);
            this.B = false;
            return;
        }
        Step[] values = Step.values();
        this.l.ordinal();
        if (this.l.ordinal() > Step.MEDIA_BROWSER.ordinal()) {
            a(values[this.l.ordinal() - 1]);
        } else {
            super.onBackPressed();
        }
    }

    public void a(Step step) {
        Fragment a2;
        Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.container);
        if (findFragmentById != null && this.l != null) {
            this.E.put(this.l, getFragmentManager().saveFragmentInstanceState(findFragmentById));
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height);
        switch (step) {
            case MEDIA_BROWSER:
                a2 = MediaBrowserFragment.b().a(dimensionPixelSize).b(0).a();
                break;
            case THEME_BROWSER:
                a2 = com.nextreaming.nexeditorui.newproject.b.f.a(this.f != null ? this.f.i() : null, false);
                break;
            case INPUT_TEXT:
                a2 = com.nextreaming.nexeditorui.newproject.a.a.a(com.nexstreaming.kinemaster.f.d.a(this.f).a(), this.g);
                break;
            case MUSIC_BROWSER:
                a2 = com.nexstreaming.kinemaster.ui.audiobrowser.a.a(0, dimensionPixelSize, this.i, this.D);
                break;
            default:
                a2 = null;
                break;
        }
        Fragment.SavedState savedState = this.E.get(step);
        if (savedState != null) {
            a2.setInitialSavedState(savedState);
        }
        beginTransaction.replace(R.id.container, a2);
        beginTransaction.commit();
        b(step);
        this.l = step;
    }

    private void a(MediaStoreItem mediaStoreItem) {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal_selected_items);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_selected_items);
        View inflate = getLayoutInflater().inflate(R.layout.panel_new_project_bottom_bar_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview_Selected_Item);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.deleteView);
        View findViewById = inflate.findViewById(R.id.deleteBorderView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.n2_no_thumb_avail));
        inflate.setOnLongClickListener(this.F);
        inflate.setOnClickListener(new d(this, imageView2, findViewById));
        imageView2.setOnTouchListener(new e(this));
        imageView2.setOnClickListener(new f(this, imageView2, findViewById));
        x().b(mediaStoreItem).onResultAvailable(new g(this, imageView));
        linearLayout.addView(inflate, EditorGlobal.a((Context) D(), 80), EditorGlobal.a((Context) D(), 42));
        this.e.add(mediaStoreItem);
        c();
        linearLayout.postDelayed(new h(this, horizontalScrollView), 200L);
        if (this.e.size() > 0) {
            this.q.setEnabled(true);
            this.r.setEnabled(true);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.B) {
            int[] iArr = new int[2];
            View childAt = this.t.getChildAt(this.C);
            childAt.getLocationOnScreen(iArr);
            if (!new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                childAt.findViewById(R.id.deleteView).setVisibility(8);
                childAt.findViewById(R.id.deleteBorderView).setVisibility(8);
                this.B = false;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Log.i("NewProjectActivity", "move : " + i + "  >>  " + i2);
        if (i != i2) {
            MediaStoreItem mediaStoreItem = this.e.get(i);
            if (i > i2) {
                for (int i3 = i; i3 > i2; i3--) {
                    this.e.set(i3, this.e.get(i3 - 1));
                }
            }
            if (i < i2) {
                while (i < i2) {
                    this.e.set(i, this.e.get(i + 1));
                    i++;
                }
            }
            this.e.set(i2, mediaStoreItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Log.i("NewProjectActivity", "remove : " + i);
        this.e.remove(i);
        ComponentCallbacks2 findFragmentById = getFragmentManager().findFragmentById(R.id.container);
        if (findFragmentById != null && (findFragmentById instanceof VideoEditor.e)) {
            ((VideoEditor.e) findFragmentById).a();
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public boolean b(String str) {
        if (this.e == null || str == null) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (this.e.get(i).h().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public void a(MediaStoreItem mediaStoreItem, int i) {
        a(mediaStoreItem);
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public boolean b(MediaStoreItem mediaStoreItem, int i) {
        return true;
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.f.a
    public void a(Theme theme) {
        this.f = theme;
        if (this.A) {
            EffectLibrary a2 = EffectLibrary.a(D());
            if (a2.h(theme.i()) != null) {
                this.i = a2.h(theme.i()).getPath();
                this.D = theme.a(D());
            } else {
                this.i = null;
                this.D = null;
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.f.a
    public void b() {
        this.f = null;
        if (this.A) {
            this.i = null;
            this.D = null;
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.a.a.InterfaceC0084a
    public void a(ArrayList<String> arrayList) {
        this.g = arrayList;
    }

    @Override // com.nextreaming.nexeditorui.bp
    public void a(String str, String str2, int i) {
        this.i = str;
        this.D = str2;
        this.A = false;
    }

    private void b(Step step) {
        KMUsage.GetStarted_Step.logEvent("step", step.name());
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }
}
