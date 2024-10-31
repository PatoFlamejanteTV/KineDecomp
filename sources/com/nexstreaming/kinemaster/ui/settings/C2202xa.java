package com.nexstreaming.kinemaster.ui.settings;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.util.ArrayList;

/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.xa */
/* loaded from: classes2.dex */
public class C2202xa extends Fragment implements I.a, VideoEditor.e {

    /* renamed from: a */
    private Toolbar f23227a;

    /* renamed from: b */
    private TextView f23228b;

    /* renamed from: c */
    private TextView f23229c;

    /* renamed from: d */
    private TextView f23230d;

    /* renamed from: e */
    private View f23231e;

    /* renamed from: f */
    private View f23232f;

    /* renamed from: g */
    private View f23233g;

    /* renamed from: h */
    private int f23234h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private View mContainer;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private NexVideoClipItem.CropMode r;
    private boolean s;
    private int t;
    private NexTimeline u;
    private c v;
    private View.OnClickListener w = new ViewOnClickListenerC2175ja(this);
    private AdapterView.OnItemClickListener x = new C2177ka(this);
    private View.OnClickListener y = new ViewOnClickListenerC2179la(this);
    private View.OnTouchListener z = new ViewOnTouchListenerC2181ma(this);

    /* compiled from: NewSettingFragment.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.settings.xa$a */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a */
        String f23235a;

        /* renamed from: b */
        NexVideoClipItem.CropMode f23236b;

        public a(String str, NexVideoClipItem.CropMode cropMode) {
            this.f23235a = str;
            this.f23236b = cropMode;
        }
    }

    /* compiled from: NewSettingFragment.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.settings.xa$b */
    /* loaded from: classes2.dex */
    public class b extends BaseAdapter {

        /* renamed from: a */
        ArrayList<a> f23238a = new ArrayList<>();

        /* renamed from: b */
        int f23239b;

        public b() {
            String[] stringArray = C2202xa.this.getResources().getStringArray(R.array.img_crop_items);
            NexVideoClipItem.CropMode[] values = NexVideoClipItem.CropMode.values();
            for (int i = 0; i < values.length; i++) {
                this.f23238a.add(new a(stringArray[i], values[i]));
            }
        }

        public void a(int i) {
            this.f23239b = i;
            notifyDataSetInvalidated();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23238a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f23238a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_settings_croppping_item, viewGroup, false);
            }
            IconView iconView = (IconView) view.findViewById(R.id.icon);
            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setText(this.f23238a.get(i).f23235a);
            if (this.f23239b == i) {
                iconView.setActivated(true);
                textView.setActivated(true);
            } else {
                iconView.setActivated(false);
                textView.setActivated(false);
            }
            return view;
        }
    }

    /* compiled from: NewSettingFragment.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.settings.xa$c */
    /* loaded from: classes2.dex */
    public interface c {
        void c(boolean z);
    }

    private void A() {
        DurationSpinner durationSpinner = (DurationSpinner) this.f23233g.findViewById(R.id.duration_spinner_clip);
        durationSpinner.setMaxValue(15.0f);
        durationSpinner.setMinValue(0.1f);
        durationSpinner.setScrollMaxValue(15.0f);
        int i = 0;
        durationSpinner.a(this.p / 1000.0f, false);
        durationSpinner.setOnValueChangeListener(new C2163da(this));
        durationSpinner.setOnKeyListener(new ViewOnKeyListenerC2165ea(this, durationSpinner));
        DurationSpinner durationSpinner2 = (DurationSpinner) this.f23233g.findViewById(R.id.duration_spinner_layer);
        durationSpinner2.setMaxValue(15.0f);
        durationSpinner2.setMinValue(0.1f);
        durationSpinner2.setScrollMaxValue(15.0f);
        durationSpinner2.a(this.q / 1000.0f, false);
        durationSpinner2.setOnValueChangeListener(new C2167fa(this));
        durationSpinner2.setOnKeyListener(new ViewOnKeyListenerC2169ga(this, durationSpinner2));
        ListView listView = (ListView) this.f23233g.findViewById(R.id.cropping_listview);
        b bVar = new b();
        NexVideoClipItem.CropMode cropMode = this.r;
        while (true) {
            if (i >= bVar.getCount()) {
                break;
            }
            if (((a) bVar.getItem(i)).f23236b == cropMode) {
                bVar.a(i);
                break;
            }
            i++;
        }
        listView.setAdapter((ListAdapter) bVar);
        listView.setOnItemClickListener(new C2173ia(this, bVar));
    }

    private void B() {
        Slider slider = (Slider) this.f23232f.findViewById(R.id.slider_video_fade_in);
        Slider slider2 = (Slider) this.f23232f.findViewById(R.id.slider_video_fade_out);
        SwitchCompat switchCompat = (SwitchCompat) this.f23232f.findViewById(R.id.video_switch_fade_in);
        switchCompat.setChecked(this.n);
        slider.setEnabled(switchCompat.isChecked());
        slider.setValue(this.j / 1000.0f);
        switchCompat.setOnCheckedChangeListener(new X(this, slider, switchCompat));
        slider.setListener(new Y(this, slider));
        slider.setOnKeyListener(new Z(this, slider));
        SwitchCompat switchCompat2 = (SwitchCompat) this.f23232f.findViewById(R.id.video_switch_fade_out);
        switchCompat2.setChecked(this.o);
        slider2.setEnabled(switchCompat2.isChecked());
        slider2.setValue(this.k / 1000.0f);
        switchCompat2.setOnCheckedChangeListener(new C2157aa(this, slider2, switchCompat2));
        slider2.setListener(new C2159ba(this, slider2));
        slider2.setOnKeyListener(new ViewOnKeyListenerC2161ca(this, slider2));
    }

    private void z() {
        Slider slider = (Slider) this.f23231e.findViewById(R.id.slider_audio_fade_in);
        Slider slider2 = (Slider) this.f23231e.findViewById(R.id.slider_audio_fade_out);
        Slider slider3 = (Slider) this.f23231e.findViewById(R.id.slider_project_master);
        slider3.setMinValue(0.0f);
        slider3.setMaxValue(100.0f);
        slider3.setValue(this.t);
        slider3.setListener(new C2171ha(this, slider3));
        slider3.setOnKeyListener(new ViewOnKeyListenerC2183na(this, slider3));
        View findViewById = this.f23231e.findViewById(R.id.project_master_vol_holder);
        SwitchCompat switchCompat = (SwitchCompat) this.f23231e.findViewById(R.id.switch_auto_master);
        switchCompat.setChecked(this.s);
        if (!switchCompat.isChecked()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        switchCompat.setOnCheckedChangeListener(new C2189qa(this, findViewById));
        SwitchCompat switchCompat2 = (SwitchCompat) this.f23231e.findViewById(R.id.audio_switch_fade_in);
        switchCompat2.setChecked(this.l);
        slider.setEnabled(switchCompat2.isChecked());
        slider.setValue(this.f23234h / 1000.0f);
        switchCompat2.setOnCheckedChangeListener(new C2190ra(this, slider, switchCompat2));
        SwitchCompat switchCompat3 = (SwitchCompat) this.f23231e.findViewById(R.id.audio_switch_fade_out);
        switchCompat3.setChecked(this.m);
        slider2.setEnabled(switchCompat3.isChecked());
        slider2.setValue(this.i / 1000.0f);
        switchCompat3.setOnCheckedChangeListener(new C2192sa(this, slider2, switchCompat3));
        slider.setListener(new C2194ta(this, slider));
        slider.setOnKeyListener(new ViewOnKeyListenerC2196ua(this, slider));
        slider2.setListener(new C2198va(this, slider2));
        slider2.setOnKeyListener(new ViewOnKeyListenerC2200wa(this, slider2));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void a(File file) {
    }

    @Override // com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        c cVar = this.v;
        if (cVar != null) {
            cVar.c(false);
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @TargetApi(21)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(C2202xa.class.getName());
        if (getActivity() != null && (getActivity() instanceof ProjectEditActivity)) {
            ProjectEditActivity projectEditActivity = (ProjectEditActivity) getActivity();
            if (projectEditActivity.ja() != null && projectEditActivity.ja().s() != null) {
                this.u = projectEditActivity.ja().s().a();
                a(projectEditActivity);
            }
        }
        this.mContainer = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        this.f23227a = (Toolbar) this.mContainer.findViewById(R.id.toolbar_new_settings);
        this.f23227a.setClickListener(this.w);
        this.f23227a.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        this.f23228b = (TextView) this.mContainer.findViewById(R.id.setting_category_audio);
        this.f23229c = (TextView) this.mContainer.findViewById(R.id.setting_category_video);
        this.f23230d = (TextView) this.mContainer.findViewById(R.id.setting_category_editing);
        this.f23231e = this.mContainer.findViewById(R.id.audio_setting);
        this.f23232f = this.mContainer.findViewById(R.id.video_setting);
        this.f23233g = this.mContainer.findViewById(R.id.editing_setting);
        this.f23228b.setOnClickListener(this.y);
        this.f23229c.setOnClickListener(this.y);
        this.f23230d.setOnClickListener(this.y);
        this.f23228b.setOnTouchListener(this.z);
        this.f23229c.setOnTouchListener(this.z);
        this.f23230d.setOnTouchListener(this.z);
        a(bundle);
        z();
        B();
        A();
        m(R.id.setting_category_audio);
        if (getResources().getConfiguration().smallestScreenWidthDp >= 600.0f && Build.VERSION.SDK_INT > 21) {
            this.mContainer.setClipToOutline(true);
        }
        this.f23228b.requestFocus();
        return this.mContainer;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("ProjectAudioFadeInTime", this.f23234h);
            bundle.putInt("ProjectAudioFadeOutTime", this.i);
            bundle.putInt("ProjectVideoFadeInTime", this.j);
            bundle.putInt("ProjectVideoFadeOutTime", this.k);
            bundle.putBoolean("ProjectAudioFadeInOn", this.l);
            bundle.putBoolean("ProjectAudioFadeOutOn", this.m);
            bundle.putBoolean("ProjectVideoFadeInOn", this.n);
            bundle.putBoolean("ProjectVideoFadeOutOn", this.o);
            bundle.putInt("ProjectDefaultPhotoDuration", this.p);
            bundle.putInt("ProjectDefaultLayerDuration", this.q);
            NexVideoClipItem.CropMode cropMode = this.r;
            bundle.putString("ProjectDefaultCropMode", cropMode != null ? cropMode.toString() : null);
            bundle.putBoolean("ProjectAutoMaster", this.s);
            bundle.putInt("ProjectMasterVolume", this.t);
        }
        super.onSaveInstanceState(bundle);
    }

    public void m(int i) {
        switch (i) {
            case R.id.setting_category_audio /* 2131363378 */:
                this.f23228b.setSelected(true);
                this.f23229c.setSelected(false);
                this.f23230d.setSelected(false);
                this.f23231e.setVisibility(0);
                this.f23232f.setVisibility(8);
                this.f23233g.setVisibility(8);
                this.f23228b.requestFocus();
                return;
            case R.id.setting_category_editing /* 2131363379 */:
                this.f23228b.setSelected(false);
                this.f23229c.setSelected(false);
                this.f23230d.setSelected(true);
                this.f23231e.setVisibility(8);
                this.f23232f.setVisibility(8);
                this.f23233g.setVisibility(0);
                this.f23230d.requestFocus();
                return;
            case R.id.setting_category_export /* 2131363380 */:
                this.f23228b.setSelected(false);
                this.f23229c.setSelected(false);
                this.f23230d.setSelected(false);
                this.f23231e.setVisibility(8);
                this.f23232f.setVisibility(8);
                this.f23233g.setVisibility(8);
                return;
            case R.id.setting_category_video /* 2131363381 */:
                this.f23228b.setSelected(false);
                this.f23229c.setSelected(true);
                this.f23230d.setSelected(false);
                this.f23231e.setVisibility(8);
                this.f23232f.setVisibility(0);
                this.f23233g.setVisibility(8);
                this.f23229c.requestFocus();
                return;
            default:
                return;
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void c() {
        if (this.u == null && getActivity() != null && (getActivity() instanceof ProjectEditActivity)) {
            ProjectEditActivity projectEditActivity = (ProjectEditActivity) getActivity();
            if (projectEditActivity.ja() == null || projectEditActivity.ja().s() == null) {
                return;
            }
            this.u = projectEditActivity.ja().s().a();
            a(projectEditActivity);
            z();
            B();
            A();
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.l = bundle.getBoolean("ProjectAudioFadeInOn");
            this.m = bundle.getBoolean("ProjectAudioFadeOutOn");
            this.f23234h = bundle.getInt("ProjectAudioFadeInTime");
            this.i = bundle.getInt("ProjectAudioFadeOutTime");
            this.s = bundle.getBoolean("ProjectAutoMaster");
            this.t = bundle.getInt("ProjectMasterVolume");
            this.n = bundle.getBoolean("ProjectVideoFadeInOn");
            this.o = bundle.getBoolean("ProjectVideoFadeOutOn");
            this.j = bundle.getInt("ProjectVideoFadeInTime");
            this.k = bundle.getInt("ProjectVideoFadeInTime");
            if (bundle.getString("ProjectDefaultCropMode") != null) {
                this.r = NexVideoClipItem.CropMode.fromString(bundle.getString("ProjectDefaultCropMode"));
            }
            this.q = bundle.getInt("ProjectDefaultLayerDuration");
            this.p = bundle.getInt("ProjectDefaultPhotoDuration");
            return;
        }
        this.l = this.u.isProjectAudioFadeInTimeOn();
        this.m = this.u.isProjectAudioFadeOutTimeOn();
        this.f23234h = this.u.getProjectAudioFadeInTimeMillis();
        this.i = this.u.getProjectAudioFadeOutTimeMillis();
        this.s = this.u.isAutoMaster();
        this.t = this.u.getProjectMasterVolume();
        this.n = this.u.isProjectVideoFadeInTimeOn();
        this.o = this.u.isProjectVideoFadeOutTimeOn();
        this.j = this.u.getProjectVideoFadeInTimeMillis();
        this.k = this.u.getProjectVideoFadeOutTimeMillis();
        this.r = this.u.getProjectDefaultCropMode();
        this.q = this.u.getProjectDefaultLayerDuration();
        this.p = this.u.getProjectDefaultPhotoDuration();
    }

    public void a(c cVar) {
        this.v = cVar;
    }
}
