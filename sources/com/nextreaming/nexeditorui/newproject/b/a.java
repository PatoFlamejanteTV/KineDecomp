package com.nextreaming.nexeditorui.newproject.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
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
import com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private WeakReference<View> b;
    private View c;
    private Context d;
    private ArrayList<Theme> e;
    private int h = -1;
    private boolean i = false;
    private Runnable j = null;
    private MediaPlayer.OnCompletionListener k = new e(this);

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<TextureView, Surface> f4662a = new WeakHashMap<>();
    private MediaPlayer f = null;
    private EffectPreviewPlayer g = new EffectPreviewPlayer();

    public a(Context context, ArrayList<Theme> arrayList) {
        this.d = context;
        this.e = arrayList;
        this.g.a(context);
    }

    public void a(int i) {
        if (this.h != i) {
            this.h = i;
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.a((Surface) null);
            this.g.b();
            this.g = null;
            this.c = null;
        }
        b();
    }

    public void b() {
        View view;
        if (this.f != null) {
            this.f.stop();
            this.f.reset();
            this.f.setSurface(null);
            this.f.release();
            this.f = null;
            if (this.b != null && (view = this.b.get()) != null) {
                view.findViewById(R.id.textureView_theme_preview).setVisibility(8);
                view.findViewById(R.id.textView_theme_item_title).setVisibility(0);
                view.findViewById(R.id.imageView_theme_item).setVisibility(0);
                view.findViewById(R.id.linear_theme_item_button_holder).setVisibility(0);
            }
            this.b = null;
            this.i = false;
            this.j = null;
            this.f4662a = null;
        }
    }

    public int c() {
        return this.h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.e.get(i).a();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.panel_theme_browser_item, viewGroup, false);
        } else {
            view.findViewById(R.id.imageView_theme_item).setBackgroundResource(R.drawable.n2_missingfile_icon_small);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView_theme_item_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_theme_item);
        TextureView textureView = (TextureView) view.findViewById(R.id.textureView_theme_preview);
        View findViewById = view.findViewById(R.id.linear_theme_item_button_holder);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton_theme_item_play);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.imageButton_theme_item_download);
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        textureView.setOpaque(false);
        if (this.f == null) {
            this.f = new MediaPlayer();
            this.f.setOnCompletionListener(this.k);
        }
        if (this.g == null) {
            this.g = new EffectPreviewPlayer();
            this.g.a(this.d);
        }
        Theme theme = this.e.get(i);
        view.setTag(theme);
        textView.setText(theme.a(this.d));
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar_theme_item_download);
        if (theme.r()) {
            findViewById.setVisibility(8);
            progressBar.setVisibility(0);
            progressBar.setProgress((theme.s() * 100) / theme.t());
        } else if (theme.p()) {
            findViewById.setVisibility(8);
            progressBar.setVisibility(8);
            progressBar.setProgress(0);
            textureView.setVisibility(0);
        } else {
            findViewById.setVisibility(0);
            progressBar.setVisibility(8);
        }
        theme.f().onResultAvailable(new b(this, imageView));
        if (this.h == i && theme.p()) {
            Surface a2 = a(textureView);
            if (a2 != null) {
                this.g.a(a2);
                this.g.a(theme);
                this.c = view;
            }
        } else if (this.c == view) {
            this.g.a((Surface) null);
            this.c = null;
        }
        if (this.b != null) {
            View view2 = this.b.get();
            if (view2 != null && view == view2) {
                this.f.reset();
                this.f.setSurface(null);
                textureView.setVisibility(8);
                imageView.setVisibility(0);
                findViewById.setVisibility(0);
                this.b = null;
                this.i = false;
                this.j = null;
            }
        } else {
            textureView.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.e.get(i).p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton_theme_item_play /* 2131821353 */:
                c cVar = new c(this, view);
                if (this.i) {
                    this.j = cVar;
                    return;
                } else {
                    cVar.run();
                    this.j = null;
                    return;
                }
            case R.id.imageButton_theme_item_download /* 2131821354 */:
                View view2 = (View) view.getParent();
                View view3 = (View) view2.getParent();
                View findViewById = view3.findViewById(R.id.progressBar_theme_item_download);
                view2.setVisibility(8);
                findViewById.setVisibility(0);
                Theme theme = (Theme) view3.getTag();
                theme.u();
                try {
                    KMUsage.getMixpanelInstanceFromContext(this.d).a("Theme Download", new JSONObject().put("Theme Id", theme.i()));
                    return;
                } catch (JSONException e) {
                    Log.e("ThemeBrowserAdapter", "MixPanel json err", e);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Surface a(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        if (this.f4662a == null) {
            this.f4662a = new WeakHashMap<>();
        }
        Surface surface = this.f4662a.get(textureView);
        if (surface == null && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            Surface surface2 = new Surface(surfaceTexture);
            this.f4662a.put(textureView, surface2);
            return surface2;
        }
        return surface;
    }
}
