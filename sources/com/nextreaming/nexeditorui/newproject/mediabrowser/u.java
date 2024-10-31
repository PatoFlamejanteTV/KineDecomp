package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MediaBrowserFragment mediaBrowserFragment) {
        this.f4743a = mediaBrowserFragment;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Stack stack;
        MediaStore mediaStore;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        View view2;
        View view3;
        View view4;
        View.OnClickListener onClickListener;
        Toolbar toolbar;
        Toolbar toolbar2;
        Toolbar toolbar3;
        View view5;
        View view6;
        int i2;
        int i3;
        View view7;
        View view8;
        View view9;
        View.OnClickListener onClickListener2;
        View view10;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        stack = this.f4743a.r;
        if (stack.size() > 1) {
            KMUsage.MediaBrowser_ShowDetails.logEvent();
            MediaStoreItem mediaStoreItem = (MediaStoreItem) view.getTag();
            switch (mediaStoreItem.b()) {
                case IMAGE:
                case VIDEO:
                    view2 = this.f4743a.j;
                    if (view2 == null) {
                        view5 = this.f4743a.i;
                        this.f4743a.j = ((ViewStub) view5.findViewById(R.id.stub_media_detail)).inflate();
                        view6 = this.f4743a.j;
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view6.getLayoutParams();
                        i2 = this.f4743a.e;
                        if (i2 != 0) {
                            this.f4743a.c = 0;
                        } else {
                            this.f4743a.c = this.f4743a.getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height);
                        }
                        i3 = this.f4743a.c;
                        marginLayoutParams.setMargins(0, 0, 0, i3);
                        view7 = this.f4743a.j;
                        view7.setLayoutParams(marginLayoutParams);
                        this.f4743a.e();
                        this.f4743a.A = true;
                        view8 = this.f4743a.j;
                        view8.findViewById(R.id.linear_detail_body);
                        this.f4743a.a(i);
                        view9 = this.f4743a.j;
                        onClickListener2 = this.f4743a.J;
                        view9.setOnClickListener(onClickListener2);
                        this.f4743a.C = new ab(this);
                        view10 = this.f4743a.j;
                        ViewTreeObserver viewTreeObserver = view10.getViewTreeObserver();
                        onGlobalLayoutListener = this.f4743a.C;
                        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    } else {
                        this.f4743a.A = true;
                        view3 = this.f4743a.j;
                        view3.setVisibility(0);
                        this.f4743a.a(i);
                        view4 = this.f4743a.j;
                        onClickListener = this.f4743a.J;
                        view4.setOnClickListener(onClickListener);
                    }
                    toolbar = this.f4743a.m;
                    if (toolbar != null) {
                        toolbar2 = this.f4743a.m;
                        toolbar2.setHiddenMenuPopup(true);
                        toolbar3 = this.f4743a.m;
                        toolbar3.a();
                        break;
                    }
                    break;
                case FOLDER:
                    mediaStore = this.f4743a.s;
                    com.nexstreaming.kinemaster.mediastore.v2.l h = mediaStore.h(mediaStoreItem);
                    if ((h instanceof com.nexstreaming.kinemaster.mediastore.v2.providers.l) && mediaStoreItem.c().toString().endsWith("root")) {
                        Resources resources = this.f4743a.getActivity().getResources();
                        String f = ((com.nexstreaming.kinemaster.mediastore.v2.providers.l) h).f();
                        new a.C0074a(this.f4743a.getActivity()).f(R.string.mediabrowser_cloudstorage).a(resources.getString(R.string.cloud_service) + " " + resources.getString(R.string.sns_service_gdrive) + "\n" + resources.getString(R.string.cloud_account) + " " + f + "\n").a(R.string.button_ok, new w(this)).b(R.string.button_remove_acct, new v(this, h, f)).a().show();
                        break;
                    } else if ((h instanceof AndroidMediaStoreProvider) && ((AndroidMediaStoreProvider) h).e()) {
                        bVar = this.f4743a.u;
                        if (bVar.a(mediaStoreItem.c())) {
                            new a.C0074a(this.f4743a.getActivity()).d("Folder").a(mediaStoreItem.a(this.f4743a.getActivity())).a(R.string.button_ok, new y(this)).b("Remove from favorites", new x(this, mediaStoreItem)).a().show();
                            break;
                        } else {
                            new a.C0074a(this.f4743a.getActivity()).d("Folder").a(mediaStoreItem.a(this.f4743a.getActivity())).a(R.string.button_ok, new aa(this)).b("Add to favorites", new z(this, mediaStoreItem)).a().show();
                            break;
                        }
                    }
                    break;
            }
        }
        return true;
    }
}
