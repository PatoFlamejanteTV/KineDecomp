package com.nextreaming.nexeditorui.fontbrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.fonts.Font;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FontBrowserActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final LruCache<String, Bitmap> f24251a = new com.nextreaming.nexeditorui.fontbrowser.a(4096);

    /* renamed from: b */
    private Context f24252b;

    /* renamed from: c */
    private ListView f24253c;

    /* renamed from: d */
    private ListView f24254d;

    /* renamed from: e */
    private Toolbar f24255e;

    /* renamed from: f */
    private List<com.nexstreaming.kinemaster.fonts.c> f24256f;

    /* renamed from: g */
    private List<Font> f24257g;

    /* renamed from: h */
    private int f24258h;
    private ResultTask<List<com.nexstreaming.kinemaster.fonts.c>> l;
    private String i = null;
    private String j = null;
    private int k = 0;
    private View.OnClickListener m = new b(this);
    private final BroadcastReceiver n = new c(this);
    private AdapterView.OnItemClickListener o = new f(this);
    private AdapterView.OnItemClickListener p = new g(this);

    /* loaded from: classes2.dex */
    class a implements com.nexstreaming.kinemaster.fonts.c {

        /* renamed from: a */
        final String f24259a;

        /* renamed from: b */
        final Map<String, String> f24260b;

        /* renamed from: c */
        final List<Font> f24261c = new ArrayList();

        public a(String str, Map<String, String> map) {
            this.f24259a = str;
            this.f24260b = map;
        }

        public void a(Font font) {
            this.f24261c.add(font);
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public String getId() {
            return this.f24259a;
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public String getName(Context context) {
            return J.a(context, this.f24260b);
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public List<Font> a() {
            return this.f24261c;
        }
    }

    private ResultTask<List<com.nexstreaming.kinemaster.fonts.c>> t() {
        if (this.l == null) {
            this.l = new ResultTask<>();
            new e(this).execute(new Void[0]);
        }
        return this.l;
    }

    public void u() {
        t().onResultAvailable(new d(this));
    }

    public void v() {
        String str = this.i;
        if (str == null) {
            return;
        }
        Font c2 = c(str);
        if (c2 != null) {
            Bitmap bitmap = f24251a.get(this.i);
            if (bitmap != null) {
                this.f24255e.a(bitmap, 1);
                return;
            } else {
                new h(this).execute(c2);
                return;
            }
        }
        Toolbar toolbar = this.f24255e;
        toolbar.a(toolbar.getCurrentDepth());
        this.i = null;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        this.f24252b = this;
        setContentView(R.layout.activity_font_browser);
        this.f24256f = new ArrayList();
        if (getIntent() != null) {
            this.i = getIntent().getStringExtra("selected_font_id");
            this.j = getIntent().getStringExtra("SELECTED_PROJECT");
        }
        this.f24255e = (Toolbar) findViewById(R.id.toolbar_fontbrowser);
        this.f24253c = (ListView) findViewById(R.id.listViewFontCategory);
        this.f24254d = (ListView) findViewById(R.id.listViewFont);
        this.f24253c.setOnItemClickListener(this.o);
        this.f24255e.setTitle(getString(R.string.toolbar_title_font_browser));
        this.f24255e.setLogo(R.drawable.icon_input_text_title_logo);
        this.f24255e.setClickListener(this.m);
        this.f24255e.setTitleMode(Toolbar.TitleMode.Title);
        this.f24255e.setSubTitleMode(Toolbar.SubTitleMode.SelectItem);
        this.f24255e.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        this.f24255e.setRightButtonVisiblity(true);
        u();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.nextreaming.kinemaster.asset.install.completed");
        intentFilter.addAction("com.nextreaming.kinemaster.asset.uninstall.completed");
        registerReceiver(this.n, intentFilter);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.n);
        super.onDestroy();
    }

    public int d(String str) {
        for (int i = 0; i < this.f24256f.size(); i++) {
            if (this.f24256f.get(i).getId().equals(str)) {
                return i;
            }
        }
        return 0;
    }

    public Font c(String str) {
        List<Font> list = this.f24257g;
        if (list != null) {
            for (Font font : list) {
                if (font.getId().equals(str)) {
                    return font;
                }
            }
        }
        List<com.nexstreaming.kinemaster.fonts.c> list2 = this.f24256f;
        if (list2 == null) {
            return null;
        }
        Iterator<com.nexstreaming.kinemaster.fonts.c> it = list2.iterator();
        while (it.hasNext()) {
            for (Font font2 : it.next().a()) {
                if (font2.getId().equals(str)) {
                    return font2;
                }
            }
        }
        return null;
    }

    public static void b(Context context, List<com.nexstreaming.kinemaster.fonts.c> list) {
        Collections.sort(list, new i(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3, com.nexstreaming.app.general.nexasset.assetpackage.r r4) {
        /*
            r0 = 0
            java.lang.String r1 = r4.getPackageURI()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            java.lang.String r2 = r4.getId()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader r3 = com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            java.lang.String r4 = r4.getFilePath()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L35
            java.io.File r4 = r3.e(r4)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L35
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L35
            if (r3 == 0) goto L1e
            r3.close()     // Catch: java.io.IOException -> L1e
        L1e:
            return r4
        L1f:
            r4 = move-exception
            goto L26
        L21:
            r4 = move-exception
            r3 = r0
            goto L36
        L24:
            r4 = move-exception
            r3 = r0
        L26:
            java.lang.String r1 = "FontBrowserActivity"
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> L35
            android.util.Log.e(r1, r2, r4)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L34
        L34:
            return r0
        L35:
            r4 = move-exception
        L36:
            if (r3 == 0) goto L3b
            r3.close()     // Catch: java.io.IOException -> L3b
        L3b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity.b(android.content.Context, com.nexstreaming.app.general.nexasset.assetpackage.r):java.lang.String");
    }

    public void a(com.nexstreaming.kinemaster.fonts.c cVar) {
        this.f24257g = new ArrayList(cVar.a());
        Collections.sort(this.f24257g);
        this.f24254d.setAdapter((ListAdapter) new m(this, this.f24257g));
        this.f24254d.setOnItemClickListener(this.p);
    }

    public int a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        while (true) {
            width--;
            if (width < 0) {
                return 0;
            }
            for (int i = 0; i < height; i++) {
                if (Color.alpha(bitmap.getPixel(width, i)) > 5) {
                    return width + 1;
                }
            }
        }
    }
}
