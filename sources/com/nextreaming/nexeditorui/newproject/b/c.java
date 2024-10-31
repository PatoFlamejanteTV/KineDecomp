package com.nextreaming.nexeditorui.newproject.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes3.dex */
public class c extends BaseAdapter implements View.OnClickListener {

    /* renamed from: b */
    private Context f24340b;

    /* renamed from: c */
    private List<c.d.b.i.a> f24341c;

    /* renamed from: e */
    private int f24343e = -1;

    /* renamed from: f */
    private boolean f24344f = false;

    /* renamed from: g */
    private Runnable f24345g = null;

    /* renamed from: h */
    private MediaPlayer.OnCompletionListener f24346h = new b(this);

    /* renamed from: a */
    private WeakHashMap<TextureView, Surface> f24339a = new WeakHashMap<>();

    /* renamed from: d */
    private MediaPlayer f24342d = null;

    /* compiled from: ThemeBrowserAdapter.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        TextView f24347a;

        /* renamed from: b */
        ImageView f24348b;

        /* renamed from: c */
        View f24349c;

        /* renamed from: d */
        ImageButton f24350d;

        /* renamed from: e */
        ImageButton f24351e;

        /* renamed from: f */
        ProgressBar f24352f;

        private a() {
        }

        /* synthetic */ a(com.nextreaming.nexeditorui.newproject.b.a aVar) {
            this();
        }
    }

    public c(Context context, List<c.d.b.i.a> list) {
        this.f24340b = context;
        this.f24341c = list;
    }

    public void a(int i) {
        if (this.f24343e == i) {
            return;
        }
        this.f24343e = i;
    }

    public void b() {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24341c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24341c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f24340b).inflate(R.layout.panel_theme_browser_item, viewGroup, false);
            aVar = new a(null);
            aVar.f24347a = (TextView) view.findViewById(R.id.textView_theme_item_title);
            aVar.f24348b = (ImageView) view.findViewById(R.id.imageView_theme_item);
            aVar.f24349c = view.findViewById(R.id.linear_theme_item_button_holder);
            aVar.f24350d = (ImageButton) view.findViewById(R.id.imageButton_theme_item_play);
            aVar.f24351e = (ImageButton) view.findViewById(R.id.imageButton_theme_item_download);
            aVar.f24352f = (ProgressBar) view.findViewById(R.id.progressBar_theme_item_download);
            view.setTag(R.id.theme_browser_tag_key_view_holder, aVar);
        } else {
            aVar = (a) view.getTag(R.id.theme_browser_tag_key_view_holder);
        }
        aVar.f24348b.setBackgroundResource(R.drawable.n2_missingfile_icon_small);
        aVar.f24350d.setOnClickListener(this);
        aVar.f24351e.setOnClickListener(this);
        c.d.b.i.a aVar2 = this.f24341c.get(i);
        view.setTag(R.id.theme_browser_tag_key_theme, aVar2);
        aVar.f24347a.setText(aVar2.getName(this.f24340b));
        aVar.f24349c.setVisibility(8);
        aVar.f24352f.setVisibility(8);
        aVar.f24352f.setProgress(0);
        aVar2.a(this.f24340b).onResultAvailable(new com.nextreaming.nexeditorui.newproject.b.a(this, aVar));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a() {
        b();
    }
}
