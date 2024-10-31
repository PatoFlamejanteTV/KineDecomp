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
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ba;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class HelpActivity extends ba {

    /* renamed from: a, reason: collision with root package name */
    private WebView f3395a;
    private Toolbar b;
    private ArrayList<f> e;
    private f f;
    private int g;
    private g h;
    private g i;
    private GridView j;
    private boolean c = false;
    private View.OnClickListener k = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f3395a.saveState(bundle);
            bundle.putInt("CURRENT_SECTION_ID", this.g);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (this.f3395a.canGoBack()) {
            this.f3395a.goBack();
            return;
        }
        if (this.j.getVisibility() == 8) {
            this.f3395a.clearCache(true);
            this.j.setVisibility(0);
            this.f3395a.setVisibility(8);
            if (this.h != this.i) {
                this.b.a(2);
                return;
            } else {
                this.b.a(1);
                return;
            }
        }
        if (this.h != this.i) {
            this.f = null;
            this.h = this.i;
            this.g = -1;
            this.j.setAdapter((ListAdapter) this.h);
            this.b.a(1);
            this.h.notifyDataSetInvalidated();
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        int a2;
        super.onCreate(bundle);
        setContentView(R.layout.activity_help);
        this.b = (Toolbar) findViewById(R.id.toolbar_help);
        this.b.setClickListener(this.k);
        this.b.setTitle(getResources().getString(R.string.help_toolbar_title));
        this.e = new ArrayList<>();
        this.e.add(new f(getResources().getString(R.string.help_start), a("file:///android_asset/help/help_start.html"), true, R.id.help_start));
        this.e.add(new f(getResources().getString(R.string.help_clip), c(), false, R.id.help_clip));
        this.e.add(new f(getResources().getString(R.string.help_timeline), d(), false, R.id.help_timeline));
        this.e.add(new f(getResources().getString(R.string.help_option_menu), e(), false, R.id.help_option_menu));
        this.e.add(new f(getResources().getString(R.string.help_other_features), f(), false, R.id.help_other_features));
        this.i = new g(this.e);
        this.h = this.i;
        this.g = -1;
        this.j = (GridView) findViewById(R.id.sectionGridView);
        this.j.setAdapter((ListAdapter) this.i);
        this.j.setOnItemClickListener(new b(this));
        this.f3395a = (WebView) findViewById(R.id.webView);
        this.f3395a.setVisibility(4);
        this.f3395a.setBackgroundColor(getResources().getColor(R.color.new_project_background));
        int i = getResources().getDisplayMetrics().densityDpi;
        if (Build.VERSION.SDK_INT <= 19 && i >= 640) {
            this.f3395a.setLayerType(1, new Paint());
        } else {
            this.f3395a.setLayerType(2, new Paint());
        }
        this.f3395a.setWebViewClient(new c(this));
        this.f3395a.getSettings().setJavaScriptEnabled(true);
        if (bundle != null) {
            this.f3395a.restoreState(bundle);
            int i2 = bundle.getInt("CURRENT_SECTION_ID");
            if (i2 != -1 && this.i != null) {
                for (int i3 = 0; i3 < this.i.getCount(); i3++) {
                    f fVar = (f) this.i.getItem(i3);
                    if (i2 == fVar.g()) {
                        if (!fVar.e() && fVar.f()) {
                            this.g = fVar.g();
                            this.h = fVar.d();
                            this.j.setAdapter((ListAdapter) this.h);
                            this.b.a(fVar.a().replace('\n', ' '), 1);
                            this.h.notifyDataSetInvalidated();
                        } else if (fVar.e()) {
                            this.g = fVar.g();
                        }
                    }
                }
            }
        }
        Intent intent = getIntent();
        if (intent != null && (intExtra = intent.getIntExtra("DEPTH_FIRST", 0)) != 0 && (a2 = this.h.a(intExtra, D())) != -1) {
            this.j.post(new e(this, a2, intent));
        }
        new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    private String a(String str) {
        Locale locale = getResources().getConfiguration().locale;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        String[] strArr = {"help-" + lowerCase + "-r" + locale.getCountry().toUpperCase(Locale.US), "help-" + lowerCase, "help"};
        for (String str2 : strArr) {
            String replaceFirst = str.replaceFirst("/help[^/]*/", "/" + str2 + "/");
            if (b(replaceFirst.replaceFirst("#[^#]*$", "").replaceFirst("file:///android_asset/", ""))) {
                return replaceFirst;
            }
        }
        return str;
    }

    private boolean b(String str) {
        try {
            getAssets().open(str).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_Help.begin();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        KMUsage.Activity_Help.end();
        super.onStop();
    }

    private g c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_clip_mediabrowser), a("file:///android_asset/help/help_clip_mediabrowser.html"), false, getResources().getDrawable(R.drawable.help_media_browser_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_layer), a("file:///android_asset/help/help_clip_layer.html"), false, getResources().getDrawable(R.drawable.help_layer_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_pin), a("file:///android_asset/help/help_clip_pin.html"), false, getResources().getDrawable(R.drawable.help_pin_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_delete), a("file:///android_asset/help/help_clip_delete.html"), false, getResources().getDrawable(R.drawable.help_delete_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_camera), a("file:///android_asset/help/help_clip_camera.html"), false, getResources().getDrawable(R.drawable.help_camera_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_audio), a("file:///android_asset/help/help_clip_audio.html"), false, getResources().getDrawable(R.drawable.help_audio_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_voice), a("file:///android_asset/help/help_clip_voice.html"), false, getResources().getDrawable(R.drawable.help_voice_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_move), a("file:///android_asset/help/help_clip_move.html"), false, getResources().getDrawable(R.drawable.help_move_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_clip_copy), a("file:///android_asset/help/help_clip_duplicate.html"), false, getResources().getDrawable(R.drawable.help_action_icon)));
        return new g(arrayList);
    }

    private g d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_timeline_expand), a("file:///android_asset/help/help_timeline_expand.html"), false, getResources().getDrawable(R.drawable.help_timeline_expand_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_preview), a("file:///android_asset/help/help_timeline_preview.html"), false, getResources().getDrawable(R.drawable.help_preview_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_bookmark), a("file:///android_asset/help/help_timeline_bookmark.html"), false, getResources().getDrawable(R.drawable.help_bookmark_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_timeline_zoom), a("file:///android_asset/help/help_timeline_expand_and_contract.html"), false, getResources().getDrawable(R.drawable.help_zoom_icon)));
        return new g(arrayList);
    }

    private g e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_option_rotate), a("file:///android_asset/help/help_option_menu_rotate_mirroring.html"), false, getResources().getDrawable(R.drawable.help_rotate_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_cropping), a("file:///android_asset/help/help_option_menu_cropping.html"), false, getResources().getDrawable(R.drawable.help_cropping_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_clipeffects), a("file:///android_asset/help/help_option_menu_clip_effect.html"), false, getResources().getDrawable(R.drawable.help_clip_effects_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_trim_split), a("file:///android_asset/help/help_option_menu_trim_split.html"), false, getResources().getDrawable(R.drawable.help_trim_split_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_vol_env), a("file:///android_asset/help/help_option_menu_volume_envelope.html"), false, getResources().getDrawable(R.drawable.help_volume_env_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_action_menu), a("file:///android_asset/help/help_option_menu_action_menu.html"), false, getResources().getDrawable(R.drawable.help_action_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_color_adj), a("file:///android_asset/help/help_option_menu_color_adjustments.html"), false, getResources().getDrawable(R.drawable.help_color_adj_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_volume), a("file:///android_asset/help/help_option_menu_volume.html"), false, getResources().getDrawable(R.drawable.help_volume_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_speed_control), a("file:///android_asset/help/help_option_menu_speed_control.html"), false, getResources().getDrawable(R.drawable.help_speed_control_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_color), a("file:///android_asset/help/help_option_menu_color.html"), false, getResources().getDrawable(R.drawable.help_color_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_capture), a("file:///android_asset/help/help_option_menu_capture.html"), false, getResources().getDrawable(R.drawable.help_capture_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_option_colortint), a("file:///android_asset/help/help_option_menu_color_filter.html"), false, getResources().getDrawable(R.drawable.help_color_filter_icon)));
        return new g(arrayList);
    }

    private g f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(getResources().getString(R.string.help_other_animation), a("file:///android_asset/help/help_other_features_animation.html"), false, getResources().getDrawable(R.drawable.help_animation_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_background), a("file:///android_asset/help/help_other_features_bgm.html"), false, getResources().getDrawable(R.drawable.help_background_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_share), a("file:///android_asset/help/help_other_features_share.html"), false, getResources().getDrawable(R.drawable.help_share_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_project_setting), a("file:///android_asset/help/help_other_features_project_settings.html"), false, getResources().getDrawable(R.drawable.help_settings_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_theme), a("file:///android_asset/help/help_other_features_theme.html"), false, getResources().getDrawable(R.drawable.help_theme_icon)));
        arrayList.add(new f(getResources().getString(R.string.help_other_transition), a("file:///android_asset/help/help_other_features_transition_effects.html"), false, getResources().getDrawable(R.drawable.help_transition_icon)));
        return new g(arrayList);
    }
}
