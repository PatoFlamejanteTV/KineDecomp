package com.nexstreaming.kinemaster.help;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.I;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class HelpActivity extends I {
    private WebView H;
    private Toolbar I;
    private ArrayList<f> K;
    private f L;
    private int M;
    private g N;
    private g O;
    private GridView P;
    private boolean J = false;
    private View.OnClickListener Q = new a(this);

    private g K() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_clip_mediabrowser), d("file:///android_asset/help/help_clip_mediabrowser.html"), false, getResources().getDrawable(R.drawable.help_media_browser_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_layer), d("file:///android_asset/help/help_clip_layer.html"), false, getResources().getDrawable(R.drawable.help_layer_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_pin), d("file:///android_asset/help/help_clip_pin.html"), false, getResources().getDrawable(R.drawable.help_pin_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_delete), d("file:///android_asset/help/help_clip_delete.html"), false, getResources().getDrawable(R.drawable.help_delete_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_camera), d("file:///android_asset/help/help_clip_camera.html"), false, getResources().getDrawable(R.drawable.help_camera_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_audio), d("file:///android_asset/help/help_clip_audio.html"), false, getResources().getDrawable(R.drawable.help_audio_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_voice), d("file:///android_asset/help/help_clip_voice.html"), false, getResources().getDrawable(R.drawable.help_voice_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_move), d("file:///android_asset/help/help_clip_move.html"), false, getResources().getDrawable(R.drawable.help_move_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_copy), d("file:///android_asset/help/help_clip_duplicate.html"), false, getResources().getDrawable(R.drawable.help_action_icon)));
        return new g(arrayList);
    }

    private g L() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_option_rotate), d("file:///android_asset/help/help_option_menu_rotate_mirroring.html"), false, getResources().getDrawable(R.drawable.help_rotate_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_cropping), d("file:///android_asset/help/help_option_menu_cropping.html"), false, getResources().getDrawable(R.drawable.help_cropping_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_clipeffects), d("file:///android_asset/help/help_option_menu_clip_effect.html"), false, getResources().getDrawable(R.drawable.help_clip_effects_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_trim_split), d("file:///android_asset/help/help_option_menu_trim_split.html"), false, getResources().getDrawable(R.drawable.help_trim_split_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_vol_env), d("file:///android_asset/help/help_option_menu_volume_envelope.html"), false, getResources().getDrawable(R.drawable.help_volume_env_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_action_menu), d("file:///android_asset/help/help_option_menu_action_menu.html"), false, getResources().getDrawable(R.drawable.help_action_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_color_adj), d("file:///android_asset/help/help_option_menu_color_adjustments.html"), false, getResources().getDrawable(R.drawable.help_color_adj_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_volume), d("file:///android_asset/help/help_option_menu_volume.html"), false, getResources().getDrawable(R.drawable.help_volume_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_speed_control), d("file:///android_asset/help/help_option_menu_speed_control.html"), false, getResources().getDrawable(R.drawable.help_speed_control_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_color), d("file:///android_asset/help/help_option_menu_color.html"), false, getResources().getDrawable(R.drawable.help_color_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_capture), d("file:///android_asset/help/help_option_menu_capture.html"), false, getResources().getDrawable(R.drawable.help_capture_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_colortint), d("file:///android_asset/help/help_option_menu_color_filter.html"), false, getResources().getDrawable(R.drawable.help_color_filter_icon)));
        return new g(arrayList);
    }

    private g M() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_other_animation), d("file:///android_asset/help/help_other_features_animation.html"), false, getResources().getDrawable(R.drawable.help_animation_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_background), d("file:///android_asset/help/help_other_features_bgm.html"), false, getResources().getDrawable(R.drawable.help_background_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_share), d("file:///android_asset/help/help_other_features_share.html"), false, getResources().getDrawable(R.drawable.help_share_icon)));
        arrayList.add(new f(getResources().getString(R.string.project_settings_title), d("file:///android_asset/help/help_other_features_project_settings.html"), false, getResources().getDrawable(R.drawable.help_settings_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_theme), d("file:///android_asset/help/help_other_features_theme.html"), false, getResources().getDrawable(R.drawable.help_theme_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_transition), d("file:///android_asset/help/help_other_features_transition_effects.html"), false, getResources().getDrawable(R.drawable.help_transition_icon)));
        return new g(arrayList);
    }

    private g N() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_timeline_expand), d("file:///android_asset/help/help_timeline_expand.html"), false, getResources().getDrawable(R.drawable.help_timeline_expand_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_preview), d("file:///android_asset/help/help_timeline_preview.html"), false, getResources().getDrawable(R.drawable.help_preview_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_bookmark), d("file:///android_asset/help/help_timeline_bookmark.html"), false, getResources().getDrawable(R.drawable.help_bookmark_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_zoom), d("file:///android_asset/help/help_timeline_expand_and_contract.html"), false, getResources().getDrawable(R.drawable.help_zoom_icon)));
        return new g(arrayList);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.H.canGoBack()) {
            this.H.goBack();
            return;
        }
        if (this.P.getVisibility() == 8) {
            this.H.clearCache(true);
            this.P.setVisibility(0);
            this.H.setVisibility(8);
            if (this.N != this.O) {
                this.I.a(2);
                return;
            } else {
                this.I.a(1);
                return;
            }
        }
        g gVar = this.N;
        g gVar2 = this.O;
        if (gVar != gVar2) {
            this.L = null;
            this.N = gVar2;
            this.M = -1;
            this.P.setAdapter((ListAdapter) this.N);
            this.I.a(1);
            this.N.notifyDataSetInvalidated();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        int a2;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_help);
        this.I = (Toolbar) findViewById(R.id.toolbar_help);
        this.I.setClickListener(this.Q);
        this.I.setTitle(getResources().getString(R.string.help_toolbar_title));
        this.K = new ArrayList<>();
        this.K.add(new f(getResources().getString(R.string.help_start), d("file:///android_asset/help/help_start.html"), true, R.id.help_start));
        this.K.add(new f(getResources().getString(R.string.help_clip), K(), false, R.id.help_clip));
        this.K.add(new f(getResources().getString(R.string.help_timeline), N(), false, R.id.help_timeline));
        this.K.add(new f(getResources().getString(R.string.help_option_menu), L(), false, R.id.help_option_menu));
        this.K.add(new f(getResources().getString(R.string.help_other_features), M(), false, R.id.help_other_features));
        this.O = new g(this.K);
        this.N = this.O;
        this.M = -1;
        this.P = (GridView) findViewById(R.id.sectionGridView);
        this.P.setAdapter((ListAdapter) this.O);
        this.P.setOnItemClickListener(new b(this));
        this.H = (WebView) findViewById(R.id.webView);
        this.H.setVisibility(4);
        this.H.setBackgroundColor(getResources().getColor(R.color.new_project_background));
        int i = getResources().getDisplayMetrics().densityDpi;
        if (Build.VERSION.SDK_INT <= 19 && i >= 640) {
            this.H.setLayerType(1, new Paint());
        } else {
            this.H.setLayerType(2, new Paint());
        }
        this.H.setWebViewClient(new d(this));
        this.H.getSettings().setJavaScriptEnabled(true);
        if (bundle != null) {
            this.H.restoreState(bundle);
            int i2 = bundle.getInt("CURRENT_SECTION_ID");
            if (i2 != -1 && this.O != null) {
                for (int i3 = 0; i3 < this.O.getCount(); i3++) {
                    f fVar = (f) this.O.getItem(i3);
                    if (i2 == fVar.d()) {
                        if (!fVar.g() && fVar.f()) {
                            this.M = fVar.d();
                            this.N = fVar.c();
                            this.P.setAdapter((ListAdapter) this.N);
                            this.I.a(fVar.e().replace('\n', ' '), 1);
                            this.N.notifyDataSetInvalidated();
                        } else if (fVar.g()) {
                            this.M = fVar.d();
                        }
                    }
                }
            }
        }
        Intent intent = getIntent();
        if (intent != null && (intExtra = intent.getIntExtra("DEPTH_FIRST", 0)) != 0 && (a2 = this.N.a(intExtra, u())) != -1) {
            this.P.post(new e(this, a2, intent));
        }
        new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.H.saveState(bundle);
            bundle.putInt("CURRENT_SECTION_ID", this.M);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        KMEvents.VIEW_HELP.trackScreen(this);
        super.onStart();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private boolean c(String str) {
        try {
            getAssets().open(str).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private String d(String str) {
        Locale locale = getResources().getConfiguration().locale;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        for (String str2 : new String[]{"help-" + lowerCase + "-r" + locale.getCountry().toUpperCase(Locale.US), "help-" + lowerCase, "help"}) {
            String replaceFirst = str.replaceFirst("/help[^/]*/", "/" + str2 + "/");
            if (c(replaceFirst.replaceFirst("#[^#]*$", "").replaceFirst("file:///android_asset/", ""))) {
                return replaceFirst;
            }
        }
        return str;
    }
}
