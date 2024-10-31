package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import java.io.File;
import java.util.List;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private Context b;
    private List<Font> c;

    /* renamed from: a, reason: collision with root package name */
    public int f4636a = 100;
    private View.OnClickListener d = new t(this);
    private View.OnLongClickListener e = new u(this);

    public l(Context context, List<Font> list) {
        this.b = context;
        this.c = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.panel_font_browser_font_item, (ViewGroup) null);
        }
        ListView listView = (ListView) viewGroup;
        Font font = (Font) getItem(i);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_font_thumbnail);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.button_font_install);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar_font_download);
        view.setTag(font.m());
        imageButton.setTag(font.m());
        imageButton.setOnClickListener(this.d);
        view.setOnClickListener(new m(this, listView, i));
        view.setOnLongClickListener(new n(this, listView, i));
        Bitmap c = font.c(this.b);
        if (c != null) {
            imageView.setImageBitmap(c);
        }
        if (font.d()) {
            progressBar.setVisibility(4);
            imageButton.setVisibility(4);
        } else if (font.f()) {
            imageButton.setVisibility(0);
            progressBar.setVisibility(0);
            imageButton.setEnabled(false);
            Task e = font.e();
            e.onProgress(new o(this, progressBar));
            e.onComplete(new p(this, progressBar));
        } else {
            progressBar.setVisibility(4);
            imageButton.setVisibility(0);
            imageButton.setEnabled(true);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str) {
        if (!com.nexstreaming.kinemaster.h.a.c(this.b)) {
            Toast.makeText(this.b, R.string.download_failed, 0).show();
            return;
        }
        if (!com.nexstreaming.app.general.util.i.a(new File(this.b.getFilesDir(), ".km_packages"), 10L)) {
            Toast.makeText(this.b, R.string.fail_enospc, 0).show();
            return;
        }
        View view2 = (View) view.getParent().getParent();
        ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progressBar_font_download);
        ImageButton imageButton = (ImageButton) view2.findViewById(R.id.button_font_install);
        Font f = EffectLibrary.a(this.b).f(str);
        if (f != null && !f.d()) {
            progressBar.setVisibility(0);
            imageButton.setEnabled(false);
            Task i = f.i();
            i.onProgress(new q(this, progressBar));
            i.onFailure(new r(this));
            i.onComplete(new s(this, progressBar, imageButton, view2));
        }
    }
}
