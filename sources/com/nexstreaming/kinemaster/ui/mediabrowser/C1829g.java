package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.api.services.drive.DriveScopes;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.umeng.analytics.pro.k;
import java.io.File;
import java.util.HashMap;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1829g extends Fragment implements InterfaceC1828f, I.a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f21680a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private int f21681b;

    /* renamed from: c, reason: collision with root package name */
    private int f21682c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21683d;

    /* renamed from: e, reason: collision with root package name */
    private View f21684e;

    /* renamed from: f, reason: collision with root package name */
    private com.nexstreaming.kinemaster.ui.a.r f21685f;

    /* renamed from: g, reason: collision with root package name */
    private MediaViewerMode f21686g = MediaViewerMode.ALL;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC1827e f21687h;
    private InterfaceC1826d i;
    private T j;
    private boolean k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private VideoView p;
    private ImageButton q;
    private ImageButton r;
    private ImageButton s;
    private ImageButton t;
    private ImageButton u;
    private Context v;
    private HashMap w;

    /* compiled from: MediaBrowserFragment.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.g$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f21688a = new Bundle();

        public final a a(int i) {
            this.f21688a.putInt("PREF_BOTTOM_PADDING_SIZE", i);
            return this;
        }

        public final a b(int i) {
            this.f21688a.putInt("PREF_REQUEST_CODE", i);
            return this;
        }

        public final a a(boolean z) {
            this.f21688a.putBoolean("PREF_DONE_BUTTON", z);
            return this;
        }

        public final a b(boolean z) {
            this.f21688a.putBoolean("PREF_SUB_LAYER", z);
            return this;
        }

        public final C1829g a() {
            C1829g c1829g = new C1829g();
            c1829g.setArguments(this.f21688a);
            return c1829g;
        }
    }

    /* compiled from: MediaBrowserFragment.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.g$b */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public final a a() {
            return new a();
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final a A() {
        return f21680a.a();
    }

    private final void B() {
        RecyclerView recyclerView = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        int dimensionPixelSize = KineMasterApplication.f24058f.c().getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        int dimensionPixelSize2 = this.f21681b + KineMasterApplication.f24058f.c().getResources().getDimensionPixelSize(R.dimen.mediabrowser_gridview_padding_bottom);
        RecyclerView recyclerView2 = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView2 != null) {
            recyclerView2.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        }
        C1823a c1823a = new C1823a();
        this.i = c1823a;
        InterfaceC1827e interfaceC1827e = this.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.a(c1823a);
        }
        RecyclerView recyclerView3 = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(c1823a);
        }
        RecyclerView recyclerView4 = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView4 != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a((Object) context, "context!!");
            recyclerView4.setLayoutManager(new GridAutoFitLayoutManager(context, 120));
        }
        c1823a.a(new ViewOnClickListenerC1831i(this));
        c1823a.a(new ViewOnLongClickListenerC1832j(this));
    }

    private final void C() {
        Toolbar toolbar = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar != null) {
            toolbar.b(R.menu.menu_media_browser);
        }
        Toolbar toolbar2 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar2 != null) {
            toolbar2.setLogo(R.drawable.icon_media_browser_title_logo);
        }
        Toolbar toolbar3 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar3 != null) {
            MediaViewerMode mediaViewerMode = this.f21686g;
            if (mediaViewerMode == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            toolbar3.setSelectedMenuPosition(mediaViewerMode.ordinal());
        }
        Toolbar toolbar4 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar4 != null) {
            toolbar4.setMenuBtnVisiblity(false);
        }
        Toolbar toolbar5 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar5 != null) {
            toolbar5.setTitleMode(Toolbar.TitleMode.Title);
        }
        Toolbar toolbar6 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar6 != null) {
            toolbar6.setTitle(KineMasterApplication.f24058f.c().getString(R.string.new_project_toolbar_title_media_browser));
        }
        Toolbar toolbar7 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar7 != null) {
            toolbar7.setClickListener(new ViewOnClickListenerC1833k(this));
        }
        if (this.f21683d) {
            Toolbar toolbar8 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
            if (toolbar8 != null) {
                toolbar8.setExitButtonMode(Toolbar.ExitButtonMode.Done);
            }
        } else {
            Toolbar toolbar9 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
            if (toolbar9 != null) {
                toolbar9.setExitButtonMode(Toolbar.ExitButtonMode.None);
            }
        }
        Toolbar toolbar10 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar10 != null) {
            toolbar10.setMenuItemClickListener(new C1834l(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void finish() {
        FragmentManager fragmentManager;
        if (getFragmentManager() == null || (fragmentManager = getFragmentManager()) == null) {
            return;
        }
        fragmentManager.popBackStack();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void j() {
        ImageButton imageButton = this.t;
        if (imageButton != null) {
            imageButton.setActivated(true);
        }
        InterfaceC1826d interfaceC1826d = this.i;
        if (interfaceC1826d != null) {
            interfaceC1826d.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void l() {
        C();
        B();
        InterfaceC1827e interfaceC1827e = this.f21687h;
        if (interfaceC1827e != null) {
            MediaViewerMode mediaViewerMode = this.f21686g;
            if (mediaViewerMode != null) {
                interfaceC1827e.a(mediaViewerMode);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    public View m(int i) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.w.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public boolean m() {
        View view = this.f21684e;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void n() {
        VideoView videoView = this.p;
        if (videoView != null) {
            videoView.setVisibility(8);
        }
        VideoView videoView2 = this.p;
        if (videoView2 != null) {
            videoView2.stopPlayback();
        }
        View view = this.f21684e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        InterfaceC1827e interfaceC1827e;
        if (i != 8200 || (interfaceC1827e = this.f21687h) == null) {
            return;
        }
        interfaceC1827e.a(getActivity(), intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.v = context;
    }

    @Override // com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        View view = this.f21684e;
        Integer valueOf = view != null ? Integer.valueOf(view.getVisibility()) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (valueOf.intValue() == 0) {
            InterfaceC1827e interfaceC1827e = this.f21687h;
            if (interfaceC1827e != null) {
                return interfaceC1827e.b();
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        InterfaceC1827e interfaceC1827e2 = this.f21687h;
        if (interfaceC1827e2 != null) {
            return interfaceC1827e2.d();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f21681b = arguments.getInt("PREF_BOTTOM_PADDING_SIZE");
            this.f21682c = arguments.getInt("PREF_REQUEST_CODE");
            this.k = arguments.getBoolean("PREF_SUB_LAYER");
            this.f21683d = arguments.getBoolean("PREF_DONE_BUTTON");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        String name = C1829g.class.getName();
        kotlin.jvm.internal.h.a((Object) name, "this.javaClass.name");
        com.nexstreaming.kinemaster.usage.analytics.b.a(name);
        View inflate = layoutInflater.inflate(R.layout.fragment_mediabrowser_mvp, viewGroup, false);
        inflate.setOnTouchListener(ViewOnTouchListenerC1835m.f21695a);
        this.f21684e = inflate.findViewById(R.id.detailView);
        this.l = (TextView) inflate.findViewById(R.id.textView_content_title);
        this.m = (TextView) inflate.findViewById(R.id.textView_content_info);
        this.n = (ImageView) inflate.findViewById(R.id.imageView_content);
        this.p = (VideoView) inflate.findViewById(R.id.videoView_content);
        this.o = (ImageView) inflate.findViewById(R.id.imageButton_media_detail_play);
        this.q = (ImageButton) inflate.findViewById(R.id.imageButton_media_detail_close);
        this.r = (ImageButton) inflate.findViewById(R.id.imageButton_media_detail_previous);
        this.s = (ImageButton) inflate.findViewById(R.id.imageButton_media_detail_next);
        this.t = (ImageButton) inflate.findViewById(R.id.imageButton_media_detail_favorite);
        this.u = (ImageButton) inflate.findViewById(R.id.imageButton_media_detail_add);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.b(view, "view");
        super.onViewCreated(view, bundle);
        this.f21687h = new S();
        InterfaceC1827e interfaceC1827e = this.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.a(this);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void p() {
        RecyclerView recyclerView = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        TextView textView = (TextView) m(com.nexstreaming.app.kinemasterfree.b.messageView);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.messageView);
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void r() {
        com.nexstreaming.kinemaster.ui.a.r rVar = this.f21685f;
        if (rVar != null) {
            rVar.dismiss();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void t() {
        C();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public GoogleSignInClient u() {
        GoogleSignInOptions a2 = new GoogleSignInOptions.Builder(GoogleSignInOptions.f10565f).b().a(new Scope(DriveScopes.DRIVE_READONLY), new Scope[0]).a();
        Context context = this.v;
        if (context != null) {
            GoogleSignInClient a3 = GoogleSignIn.a(context, a2);
            startActivityForResult(a3 != null ? a3.a() : null, k.a.u);
            kotlin.jvm.internal.h.a((Object) a3, "googleSignInClient");
            return a3;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public void z() {
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private final boolean f(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        boolean a2;
        boolean a3;
        if ((cVar.g() != MediaSupportType.Supported || !cVar.g().needsTranscode()) && cVar.h()) {
            String path = cVar.getPath();
            if (path == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            a2 = kotlin.text.v.a(path, ".mov", false, 2, null);
            if (a2) {
                String path2 = cVar.getPath();
                if (path2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                a3 = kotlin.text.v.a(path2, ".MOV", false, 2, null);
                if (a3) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(T t) {
        kotlin.jvm.internal.h.b(t, "listener");
        this.j = t;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void b(String str) {
        Toolbar toolbar;
        Toolbar toolbar2 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar2 != null) {
            toolbar2.a();
        }
        if (str != null && (toolbar = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar)) != null) {
            toolbar.setTitle(str);
        }
        Toolbar toolbar3 = (Toolbar) m(com.nexstreaming.app.kinemasterfree.b.toolbar);
        if (toolbar3 != null) {
            toolbar3.setMenuBtnVisiblity(true);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        e.a aVar = new e.a(this.v);
        aVar.e(R.string.video_editing_warning_title);
        aVar.c(R.string.video_editing_warning);
        aVar.b(KineMasterApplication.f24058f.c().getString(R.string.video_editing_warning_sub));
        aVar.c(R.string.button_ok, new DialogInterfaceOnClickListenerC1836n(this, cVar));
        aVar.a().show();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void d(String str) {
        kotlin.jvm.internal.h.b(str, "errorCode");
        e.a aVar = new e.a(this.v);
        aVar.b(str);
        aVar.c(R.string.button_ok, DialogInterfaceOnClickListenerC1837o.f21698a);
        aVar.a().show();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void e(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        if (cVar.getType() == MediaItemType.VIDEO) {
            VideoView videoView = this.p;
            Boolean valueOf = videoView != null ? Boolean.valueOf(videoView.isPlaying()) : null;
            if (valueOf == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (valueOf.booleanValue()) {
                VideoView videoView2 = this.p;
                if (videoView2 != null) {
                    videoView2.stopPlayback();
                }
                VideoView videoView3 = this.p;
                if (videoView3 != null) {
                    videoView3.setVisibility(8);
                }
                ImageView imageView = this.n;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void g() {
        ProgressBar progressBar = (ProgressBar) m(com.nexstreaming.app.kinemasterfree.b.progress);
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void h() {
        ProgressBar progressBar = (ProgressBar) m(com.nexstreaming.app.kinemasterfree.b.progress);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z, boolean z2, boolean z3) {
        SurfaceHolder holder;
        kotlin.jvm.internal.h.b(cVar, "item");
        View view = this.f21684e;
        if (view != null) {
            view.setVisibility(0);
        }
        VideoView videoView = this.p;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        VideoView videoView2 = this.p;
        if (videoView2 != null) {
            videoView2.setVisibility(8);
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.requestFocus();
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(cVar.c());
        }
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setOnLongClickListener(new ViewOnLongClickListenerC1838p(this, cVar));
        }
        int i = C1830h.f21689a[cVar.getType().ordinal()];
        if (i == 1) {
            ImageButton imageButton = this.t;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.u;
            if (imageButton2 != null) {
                imageButton2.setVisibility(0);
            }
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            String a2 = EditorGlobal.a(KineMasterApplication.f24058f.c(), cVar.a());
            kotlin.jvm.internal.h.a((Object) a2, "EditorGlobal.formatFileS…instance, item.getSize())");
            try {
                if (!kotlin.jvm.internal.h.a((Object) cVar.getNamespace(), (Object) "Backgrounds")) {
                    TextView textView4 = this.m;
                    if (textView4 != null) {
                        textView4.setText(a2 + ", " + cVar.getWidth() + FragmentC2201x.f23219a + cVar.getHeight());
                    }
                } else {
                    TextView textView5 = this.m;
                    if (textView5 != null) {
                        textView5.setText("");
                    }
                }
            } catch (MediaStore.UnavailableDataException unused) {
                TextView textView6 = this.m;
                if (textView6 != null) {
                    textView6.setText("");
                }
            }
            TextView textView7 = this.m;
            if (textView7 != null) {
                textView7.setText("");
            }
        } else if (i != 2) {
            TextView textView8 = this.m;
            if (textView8 != null) {
                textView8.setText("");
            }
            ImageButton imageButton3 = this.t;
            if (imageButton3 != null) {
                imageButton3.setVisibility(8);
            }
            ImageButton imageButton4 = this.u;
            if (imageButton4 != null) {
                imageButton4.setVisibility(8);
            }
            ImageView imageView2 = this.o;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else {
            ImageButton imageButton5 = this.t;
            if (imageButton5 != null) {
                imageButton5.setVisibility(0);
            }
            ImageButton imageButton6 = this.u;
            if (imageButton6 != null) {
                imageButton6.setVisibility(0);
            }
            ImageView imageView3 = this.o;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (!cVar.h()) {
                ImageView imageView4 = this.o;
                if (imageView4 != null) {
                    imageView4.setEnabled(f(cVar));
                }
                ImageView imageView5 = this.o;
                if (imageView5 != null) {
                    imageView5.setOnClickListener(new ViewOnClickListenerC1839q(this));
                }
                VideoView videoView3 = this.p;
                if (videoView3 != null) {
                    videoView3.setOnCompletionListener(new r(this));
                }
                if (cVar.getPath() != null) {
                    String path = cVar.getPath();
                    if (path != null) {
                        Uri fromFile = Uri.fromFile(new File(path));
                        if (fromFile != null) {
                            VideoView videoView4 = this.p;
                            if (videoView4 != null) {
                                videoView4.setVideoURI(fromFile);
                            }
                        } else {
                            VideoView videoView5 = this.p;
                            if (videoView5 != null) {
                                videoView5.setVideoPath(cVar.getPath());
                            }
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                VideoView videoView6 = this.p;
                if (videoView6 != null && (holder = videoView6.getHolder()) != null) {
                    holder.setFormat(1);
                }
                VideoView videoView7 = this.p;
                if (videoView7 != null) {
                    videoView7.setZOrderOnTop(true);
                }
            } else {
                ImageView imageView6 = this.o;
                if (imageView6 != null) {
                    imageView6.setEnabled(false);
                }
            }
            TextView textView9 = this.m;
            if (textView9 != null) {
                textView9.setText(R.string.media_browser_cloud_file_loading);
            }
            try {
                String a3 = EditorGlobal.a(KineMasterApplication.f24058f.c(), cVar.a());
                kotlin.jvm.internal.h.a((Object) a3, "EditorGlobal.formatFileS…instance, item.getSize())");
                TextView textView10 = this.m;
                if (textView10 != null) {
                    textView10.setText(EditorGlobal.a(cVar.getDuration()) + ", " + a3 + ", " + cVar.getWidth() + FragmentC2201x.f23219a + cVar.getHeight() + ", " + cVar.b() + "FPS");
                }
            } catch (MediaStore.UnavailableDataException unused2) {
                ResultTask<MediaSupportType> e2 = cVar.e();
                if (e2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                e2.onComplete((Task.OnTaskEventListener) new C1840s(this, cVar));
            }
        }
        ImageView imageView7 = this.n;
        if (imageView7 != null) {
            imageView7.setVisibility(0);
        }
        MediaStore p = KineMasterApplication.f24058f.c().p();
        if (p != null) {
            p.a(cVar, this.n, R.drawable.n2_loading_image_1_img);
        }
        if (z2) {
            ImageButton imageButton7 = this.r;
            if (imageButton7 != null) {
                imageButton7.setVisibility(0);
            }
        } else {
            ImageButton imageButton8 = this.r;
            if (imageButton8 != null) {
                imageButton8.setVisibility(4);
            }
        }
        if (z3) {
            ImageButton imageButton9 = this.s;
            if (imageButton9 != null) {
                imageButton9.setVisibility(0);
            }
        } else {
            ImageButton imageButton10 = this.s;
            if (imageButton10 != null) {
                imageButton10.setVisibility(4);
            }
        }
        if (z) {
            j();
        } else {
            e();
        }
        ImageButton imageButton11 = this.q;
        if (imageButton11 != null) {
            imageButton11.setOnClickListener(new ViewOnClickListenerC1841t(this));
        }
        ImageButton imageButton12 = this.r;
        if (imageButton12 != null) {
            imageButton12.setOnClickListener(new u(this, cVar));
        }
        ImageButton imageButton13 = this.s;
        if (imageButton13 != null) {
            imageButton13.setOnClickListener(new v(this, cVar));
        }
        ImageButton imageButton14 = this.t;
        if (imageButton14 != null) {
            imageButton14.setOnClickListener(new w(this, cVar));
        }
        ImageButton imageButton15 = this.u;
        if (imageButton15 != null) {
            imageButton15.setOnClickListener(new x(this, cVar));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void j(int i) {
        com.nexstreaming.kinemaster.ui.a.r rVar = this.f21685f;
        if (rVar != null) {
            rVar.j(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void l(int i) {
        RecyclerView recyclerView = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        TextView textView = (TextView) m(com.nexstreaming.app.kinemasterfree.b.messageView);
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) m(com.nexstreaming.app.kinemasterfree.b.messageView);
        if (textView2 != null) {
            textView2.setText(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        T t = this.j;
        if (t == null || t == null) {
            return;
        }
        t.a(cVar, this.f21682c);
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void b() {
        RecyclerView recyclerView = (RecyclerView) m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        InterfaceC1826d interfaceC1826d = this.i;
        if (interfaceC1826d != null) {
            interfaceC1826d.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a0  */
    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.nexstreaming.kinemaster.mediastore.item.c r12) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.mediabrowser.C1829g.d(com.nexstreaming.kinemaster.mediastore.item.c):void");
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void e() {
        ImageButton imageButton = this.t;
        if (imageButton != null) {
            imageButton.setActivated(false);
        }
        InterfaceC1826d interfaceC1826d = this.i;
        if (interfaceC1826d != null) {
            interfaceC1826d.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void a(String str) {
        String string = KineMasterApplication.f24058f.c().getString(R.string.button_cancel);
        e.a aVar = new e.a(this.v);
        aVar.a(str);
        aVar.a(string, F.f21649a);
        aVar.a().show();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        this.f21685f = new com.nexstreaming.kinemaster.ui.a.r(this.v);
        com.nexstreaming.kinemaster.ui.a.r rVar = this.f21685f;
        if (rVar != null) {
            rVar.setTitle(R.string.cloud_media_download);
        }
        com.nexstreaming.kinemaster.ui.a.r rVar2 = this.f21685f;
        if (rVar2 != null) {
            rVar2.a(getString(R.string.button_cancel), new A(this, cVar));
        }
        com.nexstreaming.kinemaster.ui.a.r rVar3 = this.f21685f;
        if (rVar3 != null) {
            rVar3.setOnCancelListener(new B(this, cVar));
        }
        com.nexstreaming.kinemaster.ui.a.r rVar4 = this.f21685f;
        if (rVar4 != null) {
            rVar4.show();
        }
        InterfaceC1827e interfaceC1827e = this.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.g(cVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1828f
    public void a(F.b bVar) {
        kotlin.jvm.internal.h.b(bVar, com.umeng.analytics.pro.b.L);
        e.a aVar = new e.a(this.v);
        aVar.e(R.string.mediabrowser_cloudstorage);
        aVar.a(KineMasterApplication.f24058f.c().getString(R.string.cloud_service) + " " + KineMasterApplication.f24058f.c().getString(R.string.sns_service_gdrive) + "\n" + KineMasterApplication.f24058f.c().getString(R.string.cloud_account) + " " + bVar.c() + "\n");
        aVar.c(R.string.button_ok, y.f21714a);
        aVar.a(R.string.button_remove_acct, new z(this, bVar));
        aVar.a().show();
    }
}
