package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.QueryParams;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.a.a.a;
import com.nextreaming.nexeditorui.ba;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* loaded from: classes.dex */
public class MediaBrowserFragment extends Fragment implements VideoEditor.e, ba.a {
    private ViewTreeObserver.OnGlobalLayoutListener C;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.a> D;
    private View N;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private View i;
    private View j;
    private GridView k;
    private TextView l;
    private Toolbar m;
    private MediaStoreItem n;
    private MediaViewerMode o;
    private ProgressBar p;
    private List<MediaStoreItem> q;
    private Stack<MediaStoreItem> r;
    private MediaStore s;
    private b t;
    private com.nexstreaming.kinemaster.mediastore.v2.b u;
    private com.nextreaming.nexeditorui.newproject.mediabrowser.a w;
    private MediaStoreItem x;
    private boolean y;
    private boolean z;
    private ResultTask<List<MediaStoreItem>> v = null;
    private boolean A = false;
    private boolean B = false;
    private View.OnClickListener E = new com.nextreaming.nexeditorui.newproject.mediabrowser.b(this);
    private boolean F = false;
    private Runnable G = new l(this);
    private int H = 0;
    private a.InterfaceC0083a I = new p(this);
    private View.OnClickListener J = new q(this);
    private View.OnClickListener K = new r(this);
    private AdapterView.OnItemClickListener L = new s(this);
    private AdapterView.OnItemLongClickListener M = new u(this);

    /* renamed from: a */
    int f4692a = -1;
    private AbsListView.OnScrollListener O = new ax(this);
    private Bitmap P = null;
    private Paint Q = null;
    private MediaStore.a R = new ay(this);
    private View.OnLayoutChangeListener S = new az(this);
    private ViewTreeObserver.OnGlobalLayoutListener T = new ba(this);

    /* loaded from: classes.dex */
    public interface b {
        void a(MediaStoreItem mediaStoreItem, int i);

        boolean b(MediaStoreItem mediaStoreItem, int i);

        boolean b(String str);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void a() {
        if (this.j != null && this.j.getVisibility() == 0) {
            boolean a2 = a(this.q.get(this.d));
            ImageButton imageButton = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_delete);
            if (a2) {
                imageButton.setEnabled(false);
                imageButton.setAlpha(0.5f);
            } else {
                imageButton.setEnabled(true);
                imageButton.setAlpha(1.0f);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void a(File file) {
    }

    /* loaded from: classes.dex */
    public enum MediaViewerMode {
        ALL(MediaItemType.FOLDER, MediaItemType.IMAGE, MediaItemType.VIDEO, MediaItemType.SPECIAL),
        IMAGES(MediaItemType.FOLDER, MediaItemType.IMAGE),
        VIDEO(MediaItemType.FOLDER, MediaItemType.VIDEO);

        final MediaItemType[] mediaMode;

        MediaViewerMode(MediaItemType... mediaItemTypeArr) {
            this.mediaMode = mediaItemTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private static final String[] f4694a = {"RequestCode"};
        private final Bundle b;

        /* synthetic */ a(com.nextreaming.nexeditorui.newproject.mediabrowser.b bVar) {
            this();
        }

        private a() {
            this.b = new Bundle();
        }

        public a a(MediaViewerMode mediaViewerMode) {
            this.b.putInt("MediaViewerMode", mediaViewerMode.ordinal());
            return this;
        }

        public a a(int i) {
            this.b.putInt("BottomPaddingSize", i);
            return this;
        }

        public a b(int i) {
            this.b.putInt("RequestCode", i);
            return this;
        }

        public a a(int i, int i2) {
            this.b.putInt("ExtraTitleResource", i);
            this.b.putInt("ExtraTitleResource2", i2);
            return this;
        }

        public a a(boolean z) {
            this.b.putBoolean("LayerMode", z);
            return this;
        }

        public MediaBrowserFragment a() {
            for (String str : f4694a) {
                if (!this.b.containsKey(str)) {
                    throw new IllegalArgumentException("Missing required key: " + str);
                }
            }
            MediaBrowserFragment mediaBrowserFragment = new MediaBrowserFragment();
            mediaBrowserFragment.setArguments(this.b);
            return mediaBrowserFragment;
        }
    }

    public static a b() {
        return new a(null);
    }

    @Override // android.app.Fragment
    public void onStart() {
        if (this.z && this.y && this.x != null) {
            this.t.a(this.x, this.e);
            getFragmentManager().popBackStack();
        }
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.z = true;
        super.onStop();
    }

    private String[] a(Stack<MediaStoreItem> stack) {
        String[] strArr = new String[stack.size()];
        Iterator<MediaStoreItem> it = stack.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().c().toString();
            i++;
        }
        return strArr;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Log.i("MediaBrowserFragment", "onSaveInstanceState()");
        if (bundle != null) {
            bundle.putStringArray("FolderHistroy", a(this.r));
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.j != null && this.j.getVisibility() == 0) {
            VideoView videoView = (VideoView) this.j.findViewById(R.id.videoView_content);
            ImageView imageView = (ImageView) this.j.findViewById(R.id.imageButton_media_detail_play);
            ImageView imageView2 = (ImageView) this.j.findViewById(R.id.imageView_content);
            if (videoView.isPlaying()) {
                videoView.stopPlayback();
                imageView2.setVisibility(0);
                videoView.setVisibility(8);
                imageView.setVisibility(0);
                a(this.d);
            }
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        this.z = false;
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = new Stack<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.o = MediaViewerMode.values()[arguments.getInt("MediaViewerMode", MediaViewerMode.ALL.ordinal())];
            this.b = Math.max(arguments.getInt("TopPaddingSize", 0), getResources().getDimensionPixelSize(R.dimen.toolbar_height));
            this.c = arguments.getInt("BottomPaddingSize", 0);
            this.e = arguments.getInt("RequestCode", 0);
            this.f = arguments.getInt("ExtraTitleResource", 0);
            this.g = arguments.getInt("ExtraTitleResource2", 0);
            this.h = arguments.getBoolean("LayerMode", false);
            return;
        }
        this.o = MediaViewerMode.ALL;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = layoutInflater.inflate(R.layout.fragment_mediabrowser, viewGroup, false);
        this.k = (GridView) this.i.findViewById(R.id.gridView_mediabrowser);
        this.m = (Toolbar) this.i.findViewById(R.id.toolbar);
        this.l = (TextView) this.i.findViewById(R.id.gridview_empty);
        this.p = (ProgressBar) this.i.findViewById(R.id.progressBar_mediabrowser_loading);
        this.u = new com.nexstreaming.kinemaster.mediastore.v2.b(getActivity());
        return this.i;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.i.setOnClickListener(this.J);
        this.s = ((com.nextreaming.nexeditorui.aw) getActivity()).x();
        this.t = (b) getActivity();
        this.r.clear();
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray("FolderHistroy");
            if (stringArray == null) {
                this.n = this.s.d();
                this.r.push(this.n);
            } else {
                for (String str : stringArray) {
                    if (this.s.c(str) == null) {
                        break;
                    }
                    this.r.push(this.s.c(str));
                }
                if (this.r.size() <= 0) {
                    this.n = this.s.d();
                    this.r.push(this.n);
                } else {
                    this.n = this.r.peek();
                }
            }
        } else {
            this.n = this.s.d();
            this.r.push(this.n);
        }
        this.m.setLogo(R.drawable.icon_media_browser_title_logo);
        this.m.setSelectedMenuPosition(this.o.ordinal());
        this.m.setClickListener(this.E);
        this.m.b(R.menu.menu_media_browser);
        this.m.setMenuItemClickListener(this.I);
        if (this.r.size() < 1 || this.n.c().getNamespace().equals("Backgrounds") || this.h) {
            this.m.setMenuBtnVisiblity(false);
        }
        if (this.e != 0) {
            this.m.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        }
        this.k.setPadding(0, this.b + getResources().getDimensionPixelSize(R.dimen.mediabrowser_gridview_padding_top), 0, this.c + getResources().getDimensionPixelSize(R.dimen.mediabrowser_gridview_padding_bottom));
        this.k.setOnScrollListener(this.O);
        c();
    }

    public void c() {
        this.k.setVisibility(8);
        this.p.setVisibility(8);
        this.l.setVisibility(8);
        this.p.removeCallbacks(this.G);
        this.p.postDelayed(this.G, 250L);
        this.F = true;
        this.v = this.s.a(this.n.c(), new QueryParams(this.o.mediaMode));
        this.v.onUpdateOrResultAvailable(new aq(this)).onFailure((Task.OnFailListener) new ad(this));
    }

    public void d() {
        if (getActivity() != null) {
            if (this.r.size() > 1) {
                this.m.setTitleMode(Toolbar.TitleMode.Back);
                this.m.setLogo(0);
                if (!this.h && !this.n.c().getNamespace().equals("Backgrounds")) {
                    this.m.setMenuBtnVisiblity(true);
                }
                this.m.setTitle(this.n.a(getActivity()));
                return;
            }
            this.m.setTitleMode(Toolbar.TitleMode.Title);
            this.m.setLogo(R.drawable.icon_media_browser_title_logo);
            this.m.setMenuBtnVisiblity(false);
            if (this.f != 0 && this.g != 0) {
                this.m.setTitle(getActivity().getString(R.string.new_project_toolbar_title_media_browser) + " — " + getActivity().getString(this.f) + " (" + getActivity().getString(this.g) + ")");
            } else if (this.f != 0) {
                this.m.setTitle(getActivity().getString(R.string.new_project_toolbar_title_media_browser) + " — " + getActivity().getString(this.f));
            } else {
                this.m.setTitle(getActivity().getString(R.string.new_project_toolbar_title_media_browser));
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.ba.a
    public boolean l_() {
        if (this.N != null) {
            return true;
        }
        if (this.A) {
            this.d = 0;
            ImageView imageView = (ImageView) this.j.findViewById(R.id.imageView_content);
            VideoView videoView = (VideoView) this.j.findViewById(R.id.videoView_content);
            ImageView imageView2 = (ImageView) this.j.findViewById(R.id.imageButton_media_detail_play);
            videoView.stopPlayback();
            imageView.setVisibility(0);
            videoView.setVisibility(8);
            imageView2.setVisibility(0);
            this.j.setVisibility(8);
            this.A = false;
            if (this.m != null) {
                this.m.setHiddenMenuPopup(false);
            }
            return true;
        }
        if (this.r.size() <= 1) {
            return false;
        }
        if (this.r.isEmpty() || !isVisible()) {
            return false;
        }
        this.r.pop();
        this.n = this.r.peek();
        c();
        return true;
    }

    public void e() {
        ImageButton imageButton = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_close);
        IconButton iconButton = (IconButton) this.j.findViewById(R.id.imageButton_media_detail_previous);
        IconButton iconButton2 = (IconButton) this.j.findViewById(R.id.imageButton_media_detail_next);
        ImageButton imageButton2 = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_favorite);
        ImageButton imageButton3 = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_add);
        ImageButton imageButton4 = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_delete);
        imageButton.setOnClickListener(this.K);
        iconButton.setOnClickListener(this.K);
        iconButton2.setOnClickListener(this.K);
        imageButton2.setOnClickListener(this.K);
        imageButton3.setOnClickListener(this.K);
        imageButton4.setOnClickListener(this.K);
    }

    public void a(int i) {
        int i2;
        int i3;
        b(i);
        this.d = i;
        MediaStoreItem mediaStoreItem = this.q.get(i);
        MediaItemType b2 = mediaStoreItem.b();
        try {
            int j = mediaStoreItem.j();
            int k = mediaStoreItem.k();
            if (b2 == MediaItemType.VIDEO) {
                mediaStoreItem.m();
                mediaStoreItem.s();
            }
            i2 = k;
            i3 = j;
        } catch (MediaStore.UnavailableDataException e) {
            i2 = -1;
            i3 = -1;
        }
        boolean a2 = a(mediaStoreItem);
        ImageButton imageButton = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_favorite);
        if (this.u.a(mediaStoreItem.c())) {
            imageButton.setActivated(true);
        } else {
            imageButton.setActivated(false);
        }
        ImageButton imageButton2 = (ImageButton) this.j.findViewById(R.id.imageButton_media_detail_delete);
        if (a2) {
            imageButton2.setEnabled(false);
            imageButton2.setAlpha(0.5f);
        } else {
            imageButton2.setEnabled(true);
            imageButton2.setAlpha(1.0f);
        }
        if (!mediaStoreItem.r()) {
            imageButton2.setVisibility(8);
        } else {
            imageButton2.setVisibility(0);
        }
        TextView textView = (TextView) this.j.findViewById(R.id.textView_content_title);
        textView.setSelected(true);
        textView.setOnLongClickListener(new c(this, mediaStoreItem));
        TextView textView2 = (TextView) this.j.findViewById(R.id.textView_content_info);
        ImageView imageView = (ImageView) this.j.findViewById(R.id.imageView_content);
        VideoView videoView = (VideoView) this.j.findViewById(R.id.videoView_content);
        ImageView imageView2 = (ImageView) this.j.findViewById(R.id.imageButton_media_detail_play);
        textView.setText(mediaStoreItem.a(getActivity()));
        float f = getResources().getConfiguration().smallestScreenWidthDp;
        if (b2 == MediaItemType.IMAGE && !this.n.c().getNamespace().equals("Backgrounds") && !mediaStoreItem.n() && f >= 600.0f) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, imageView, mediaStoreItem));
        } else {
            this.s.a(mediaStoreItem, imageView, R.drawable.n2_loading_image_1_img, (MediaStore.a) null);
        }
        this.H++;
        int i4 = this.H;
        switch (b2) {
            case IMAGE:
                imageView.setVisibility(0);
                videoView.setVisibility(8);
                imageView2.setVisibility(8);
                String a3 = EditorGlobal.a(getActivity(), mediaStoreItem.i());
                if (i3 < 0 || i2 < 0) {
                    textView2.setText(getResources().getString(R.string.media_browser_cloud_file_loading));
                    mediaStoreItem.q().onComplete((Task.OnTaskEventListener) new e(this, i4, mediaStoreItem, textView2, a3));
                    return;
                } else if (!mediaStoreItem.o().equals("Backgrounds")) {
                    textView2.setText(a3 + ", " + i3 + "x" + i2);
                    return;
                } else {
                    textView2.setText("");
                    return;
                }
            case VIDEO:
                if ((mediaStoreItem.p() != MediaStoreItem.MediaSupportType.Supported && !mediaStoreItem.p().needsTranscode()) || mediaStoreItem.n() || mediaStoreItem.h().endsWith(".mov") || mediaStoreItem.h().endsWith(".MOV")) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setEnabled(true);
                }
                imageView2.setVisibility(0);
                imageView2.setOnClickListener(new f(this, videoView));
                if (videoView.isPlaying()) {
                    videoView.stopPlayback();
                    imageView.setVisibility(0);
                    videoView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
                videoView.setOnTouchListener(new g(this, videoView, imageView, imageView2));
                videoView.setOnPreparedListener(new h(this, videoView, imageView, imageView2));
                videoView.setOnCompletionListener(new k(this, videoView, imageView, imageView2));
                if (i3 < 0 || i2 < 0) {
                    textView2.setText(getResources().getString(R.string.media_browser_cloud_file_loading));
                    mediaStoreItem.q().onComplete((Task.OnTaskEventListener) new m(this, i4, mediaStoreItem, textView2));
                } else {
                    long m = mediaStoreItem.m();
                    textView2.setText(EditorGlobal.a((int) m) + ", " + EditorGlobal.a(getActivity(), mediaStoreItem.i()) + ", " + i3 + "x" + i2 + ", " + mediaStoreItem.s() + "FPS");
                }
                Uri fromFile = Uri.fromFile(new File(mediaStoreItem.h()));
                if (fromFile != null) {
                    videoView.setVideoURI(fromFile);
                } else {
                    videoView.setVideoPath(mediaStoreItem.h());
                }
                videoView.getHolder().setFormat(1);
                videoView.setZOrderOnTop(true);
                return;
            case FOLDER:
            default:
                return;
        }
    }

    private void b(int i) {
        if (this.B) {
            this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(8);
            this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(8);
            return;
        }
        if (this.q.size() == 1) {
            this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(8);
            this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(8);
            return;
        }
        if (i <= 0) {
            this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(8);
            this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(0);
            return;
        }
        if (i >= this.q.size() - 1) {
            this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(0);
            this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(8);
            return;
        }
        this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(8);
        this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(8);
        int i2 = i - 1;
        while (true) {
            if (i2 < 0) {
                break;
            }
            if (this.q.get(i2).b() == MediaItemType.FOLDER) {
                i2--;
            } else {
                this.j.findViewById(R.id.imageButton_media_detail_previous).setVisibility(0);
                break;
            }
        }
        int i3 = i + 1;
        while (true) {
            int i4 = i3;
            if (i4 <= this.q.size() - 1) {
                if (this.q.get(i4).b() == MediaItemType.FOLDER) {
                    i3 = i4 + 1;
                } else {
                    this.j.findViewById(R.id.imageButton_media_detail_next).setVisibility(0);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void f() {
        MediaStoreItem mediaStoreItem = this.q.get(this.d);
        String string = getActivity().getString(R.string.mediabrowser_file_delete_confirm);
        String string2 = getActivity().getString(R.string.button_delete);
        String string3 = getActivity().getString(R.string.mediabrowser_detaildialog_cancel);
        a.C0074a c0074a = new a.C0074a(getActivity());
        c0074a.a(string);
        c0074a.a(string2, new n(this, mediaStoreItem));
        c0074a.b(string3, new o(this));
        c0074a.a().show();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        HashSet hashSet;
        if (i == R.id.choose_google_drive_account && i2 == -1 && intent != null && (stringExtra = intent.getStringExtra("authAccount")) != null && getActivity() != null) {
            if (!this.s.a(com.nexstreaming.kinemaster.mediastore.v2.providers.l.a(stringExtra))) {
                this.s.a(new com.nexstreaming.kinemaster.mediastore.v2.providers.l(getActivity(), ((com.nextreaming.nexeditorui.ba) getActivity()).y(), stringExtra), com.nextreaming.nexeditorui.aw.b).a(true, 1800000L, 15000L);
                c();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                Set<String> stringSet = defaultSharedPreferences.getStringSet("com.kinemaster.cloud_folder_accts", null);
                if (stringSet == null) {
                    hashSet = new HashSet();
                } else {
                    hashSet = new HashSet(stringSet);
                }
                hashSet.add(stringExtra);
                defaultSharedPreferences.edit().putStringSet("com.kinemaster.cloud_folder_accts", hashSet).apply();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void a(int i, int i2) {
        a.C0074a c0074a = new a.C0074a(getActivity());
        c0074a.a(i);
        c0074a.a(i2, new t(this));
        c0074a.a().show();
    }

    private boolean b(MediaStoreItem mediaStoreItem) {
        MediaStoreItem.MediaSupportType p = mediaStoreItem.p();
        if (!p.isNotSupported()) {
            return true;
        }
        String notSupportedReason = p.getNotSupportedReason(getActivity());
        if (notSupportedReason == null) {
            notSupportedReason = getString(R.string.mediabrowser_video_notsupport);
        }
        new a.C0074a(getActivity()).a(notSupportedReason).a(R.string.button_ok, new ac(this)).a().show();
        return false;
    }

    private com.nexstreaming.kinemaster.ui.a.e c(MediaStoreItem mediaStoreItem) {
        boolean e = this.s.e(mediaStoreItem);
        com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(getActivity());
        eVar.setTitle("Downloading...");
        eVar.b(getString(R.string.button_cancel), new ae(this, e, mediaStoreItem));
        return eVar;
    }

    public boolean d(MediaStoreItem mediaStoreItem) {
        if (this.t.b(mediaStoreItem, this.e)) {
            MediaStoreItem.MediaSupportType p = mediaStoreItem.p();
            if (this.h && mediaStoreItem.n()) {
                com.nexstreaming.kinemaster.ui.a.e c = c(mediaStoreItem);
                c.show();
                this.s.g(mediaStoreItem).onProgress(new ah(this, c)).onComplete(new ag(this, c, mediaStoreItem)).onFailure(new af(this, c));
            } else if (!NexEditorDeviceProfile.getDeviceProfile().getUseMediaExtractor() && mediaStoreItem.n()) {
                com.nexstreaming.kinemaster.ui.a.e c2 = c(mediaStoreItem);
                c2.show();
                this.s.g(mediaStoreItem).onProgress(new ak(this, c2)).onComplete(new aj(this, mediaStoreItem, c2)).onFailure(new ai(this, c2));
            } else if (p == null || p == MediaStoreItem.MediaSupportType.CheckAsync) {
                a(true);
                mediaStoreItem.q().onResultAvailable(new ao(this, mediaStoreItem)).onFailure((Task.OnFailListener) new al(this, mediaStoreItem));
            } else {
                e(mediaStoreItem);
            }
        }
        return false;
    }

    public void e(MediaStoreItem mediaStoreItem) {
        String string;
        String str;
        if (b(mediaStoreItem)) {
            MediaStoreItem.MediaSupportType p = mediaStoreItem.p();
            if (!this.h && p.needsTranscode()) {
                boolean z = (mediaStoreItem.n() || mediaStoreItem.h() == null || !com.nexstreaming.kinemaster.g.a.a(getActivity(), new File(mediaStoreItem.h()), p).exists()) ? false : true;
                String string2 = getResources().getString(R.string.button_cancel);
                switch (p) {
                    case NeedTranscodeFPS:
                        if (z) {
                            str = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                            string = getResources().getString(R.string.mediabrowser_dialog_button_use_fps);
                            break;
                        } else {
                            str = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_fps);
                            string = getResources().getString(R.string.mediabrowser_dialog_button_convert_fps);
                            break;
                        }
                    case NeedTranscodeRes:
                        NexExportProfile transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i());
                        if (z) {
                            String string3 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_resolution, Integer.valueOf(mediaStoreItem.j()), Integer.valueOf(mediaStoreItem.k()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                            string = getResources().getString(R.string.mediabrowser_dialog_button_use_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                            str = string3;
                            break;
                        } else {
                            String string4 = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_resolution, Integer.valueOf(mediaStoreItem.j()), Integer.valueOf(mediaStoreItem.k()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                            string = getResources().getString(R.string.mediabrowser_dialog_button_convert_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                            str = string4;
                            break;
                        }
                    default:
                        throw new IllegalStateException(String.valueOf(p));
                }
                new a.C0074a(getActivity()).a(str).a(string, new as(this, mediaStoreItem)).b(string2, new ar(this)).a(new ap(this)).a().show();
                return;
            }
            if (this.h && this.z) {
                this.y = true;
                this.x = mediaStoreItem;
                return;
            }
            if (mediaStoreItem.n() ? false : bb.a(mediaStoreItem.h())) {
                com.nexstreaming.kinemaster.ui.a.a a2 = new a.C0074a(getActivity()).f(R.string.video_editing_warning_title).a(R.string.video_editing_warning).b(getResources().getString(R.string.video_editing_warning_sub)).a(new au(this, mediaStoreItem)).a(R.string.button_ok, new at(this, mediaStoreItem)).a();
                this.D = new WeakReference<>(a2);
                a2.setOnDismissListener(new av(this));
                a2.setOnShowListener(new aw(this));
                a2.show();
                return;
            }
            this.t.a(mediaStoreItem, this.e);
            if (!mediaStoreItem.p().isNotSupported() && this.h) {
                getFragmentManager().popBackStack();
            }
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null && (getActivity() instanceof b)) {
            this.t = (b) getActivity();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.N = AdapterView.inflate(getActivity(), R.layout.loading_progress, null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            layoutParams.flags = 904;
            layoutParams.windowAnimations = 0;
            layoutParams.format = -3;
            getActivity().getWindowManager().addView(this.N, layoutParams);
            return;
        }
        if (this.N != null) {
            getActivity().getWindowManager().removeView(this.N);
            this.N = null;
        }
    }

    public Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        int i;
        int i2;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (this.Q == null) {
            this.Q = new Paint();
            this.Q.setAntiAlias(true);
            this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        float f = width / height;
        if (width2 / f > height2) {
            i2 = (int) (width2 / f);
            i = width2;
        } else {
            i = (int) (f * height2);
            i2 = height2;
        }
        int i3 = (i - width2) / 2;
        int i4 = (i2 - height2) / 2;
        canvas.drawBitmap(bitmap2, new Rect(0, 0, width, height), new Rect(-i3, -i4, i3 + width2, i4 + height2), this.Q);
        return createBitmap;
    }

    public Bitmap a(Drawable drawable) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mediabrowser_item_layout_width);
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicHeight() == dimensionPixelSize && drawable.getIntrinsicWidth() == dimensionPixelSize2) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public int c(int i) {
        if (getActivity() != null) {
            return (int) (i * getActivity().getResources().getDisplayMetrics().density);
        }
        return -1;
    }

    public boolean a(MediaStoreItem mediaStoreItem) {
        if (mediaStoreItem == null || getActivity() == null || this.t == null || mediaStoreItem.n()) {
            return false;
        }
        try {
            return this.t.b(mediaStoreItem.h());
        } catch (MediaStore.UnavailableDataException e) {
            return false;
        }
    }
}
