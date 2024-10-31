package com.nextreaming.nexeditorui.fontbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener;
import com.nexstreaming.kinemaster.kmpackage.y;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class FontBrowserActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private Context f4624a;
    private ListView b;
    private ListView c;
    private Toolbar d;
    private List<y> e;
    private List<Font> f;
    private int g;
    private String h = null;
    private View.OnClickListener i = new a(this);
    private AdapterView.OnItemClickListener j = new c(this);
    private AdapterView.OnItemClickListener k = new d(this);
    private AdapterView.OnItemLongClickListener l = new e(this);
    private OnFontChangeListener m = new i(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Font f;
        String stringExtra;
        super.onCreate(bundle);
        this.f4624a = this;
        setContentView(R.layout.activity_font_browser);
        EffectLibrary a2 = EffectLibrary.a(this);
        String string = PreferenceManager.getDefaultSharedPreferences(this.f4624a).getString("shared_default_font", null);
        if (EditorGlobal.g(this.f4624a)) {
            a2.a(false);
        }
        a2.a(this.m);
        this.e = new ArrayList(a2.a());
        Collections.sort(this.e, new b(this));
        if (getIntent() != null && (stringExtra = getIntent().getStringExtra("selected_font_id")) != null && a2.f(stringExtra) != null) {
            this.h = stringExtra;
        }
        Log.i("FontBrowserActivity", "load currentCollectionId : " + string);
        int a3 = a(string);
        this.d = (Toolbar) findViewById(R.id.toolbar_fontbrowser);
        this.b = (ListView) findViewById(R.id.listViewFontCategory);
        this.c = (ListView) findViewById(R.id.listViewFont);
        this.b.setAdapter((ListAdapter) new k(this, this.e));
        this.b.setOnItemClickListener(this.j);
        this.b.performItemClick(this.b, a3, a3);
        this.d.setTitle(getString(R.string.toolbar_title_font_browser));
        this.d.setLogo(R.drawable.icon_input_text_title_logo);
        this.d.setClickListener(this.i);
        this.d.setTitleMode(Toolbar.TitleMode.Title);
        this.d.setSubTitleMode(Toolbar.SubTitleMode.SelectItem);
        this.d.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        if (this.h != null && (f = a2.f(this.h)) != null && f.c(this.f4624a) != null) {
            Bitmap c = f.c(this.f4624a);
            int a4 = a(c);
            Bitmap createBitmap = Bitmap.createBitmap(a4, f.c(this.f4624a).getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(c, 0.0f, 0.0f, new Paint());
            int integer = getResources().getInteger(R.integer.font_toolbar_title_scale);
            if (integer > 0) {
                this.d.a(Bitmap.createScaledBitmap(createBitmap, a4 / integer, f.c(this.f4624a).getHeight() / integer, true), 1);
            } else {
                this.d.a(createBitmap, 1);
            }
        }
    }

    private int a(String str) {
        for (int i = 0; i < this.e.size(); i++) {
            if (this.e.get(i).b().equals(str)) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        this.f = new ArrayList(yVar.a());
        Collections.sort(this.f);
        this.c.setAdapter((ListAdapter) new l(this, this.f));
        this.c.setOnItemClickListener(this.k);
        this.c.setOnItemLongClickListener(this.l);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        EffectLibrary.a(this).b(this.m);
        String b = this.e.get(this.b.getCheckedItemPosition()).b();
        Log.i("FontBrowserActivity", "save currentCollectionId : " + b);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4624a).edit();
        edit.putString("shared_default_font", b);
        edit.commit();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i = width - 1; i >= 0; i--) {
            for (int i2 = 0; i2 < height; i2++) {
                if (Color.alpha(bitmap.getPixel(i, i2)) > 5) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}
