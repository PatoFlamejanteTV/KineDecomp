package com.nexstreaming.kinemaster.ui.welcome;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import c.d.b.m.n;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: WelcomeViewPager.kt */
/* loaded from: classes2.dex */
public final class g extends PagerAdapter {

    /* renamed from: c */
    private final VideoView[] f23706c;

    /* renamed from: d */
    private final c f23707d;

    /* renamed from: e */
    private final ArrayList<b> f23708e;

    /* renamed from: f */
    private final kotlin.jvm.a.a<k> f23709f;

    public g(c cVar, ArrayList<b> arrayList, kotlin.jvm.a.a<k> aVar) {
        h.b(cVar, "fragment");
        h.b(arrayList, "welcomeItems");
        h.b(aVar, "onClickStartButton");
        this.f23707d = cVar;
        this.f23708e = arrayList;
        this.f23709f = aVar;
        this.f23706c = new VideoView[4];
    }

    public final void c() {
        this.f23709f.invoke();
    }

    public final void b() {
        for (VideoView videoView : this.f23706c) {
            if (videoView != null && videoView.isPlaying()) {
                videoView.pause();
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        h.b(viewGroup, "container");
        h.b(obj, "object");
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f23708e.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a2;
        h.b(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f23707d.getContext()).inflate(R.layout.fragment_welcome_page, viewGroup, false);
        Context context = this.f23707d.getContext();
        if (context != null) {
            h.a((Object) context, "fragment.context!!");
            Resources resources = context.getResources();
            b bVar = this.f23708e.get(i);
            h.a((Object) bVar, "welcomeItems[position]");
            b bVar2 = bVar;
            Context context2 = viewGroup.getContext();
            h.a((Object) context2, "container.context");
            a(context2, bVar2.c(), bVar2.d());
            h.a((Object) inflate, "rootView");
            TextView textView = (TextView) inflate.findViewById(com.nexstreaming.app.kinemasterfree.b.textview_welcome_title);
            if (bVar2.b() == -1) {
                textView.setVisibility(8);
            } else {
                textView.setText(resources.getString(bVar2.b()));
                n.a(textView, 12, 18);
            }
            TextView textView2 = (TextView) inflate.findViewById(com.nexstreaming.app.kinemasterfree.b.textview_welcome_content);
            textView2.setText(resources.getString(bVar2.a()));
            n.a(textView2, 10, 14);
            Button button = (Button) inflate.findViewById(com.nexstreaming.app.kinemasterfree.b.button_start);
            a2 = kotlin.collections.k.a((List) this.f23708e);
            if (i == a2) {
                button.setVisibility(0);
                button.setOnClickListener(new e(this, i));
            }
            VideoView videoView = (VideoView) inflate.findViewById(com.nexstreaming.app.kinemasterfree.b.video_view);
            VideoView[] videoViewArr = this.f23706c;
            if (videoViewArr[i] == null) {
                videoViewArr[i] = videoView;
            }
            StringBuilder sb = new StringBuilder();
            Context context3 = videoView.getContext();
            h.a((Object) context3, com.umeng.analytics.pro.b.Q);
            File filesDir = context3.getFilesDir();
            h.a((Object) filesDir, "context.filesDir");
            sb.append(filesDir.getAbsolutePath());
            sb.append('/');
            sb.append(bVar2.d());
            String sb2 = sb.toString();
            Log.d("videoPath", sb2);
            videoView.setVideoPath(sb2);
            videoView.requestFocus();
            videoView.setOnPreparedListener(new f(videoView));
            viewGroup.addView(inflate);
            return inflate;
        }
        h.a();
        throw null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        h.b(view, "view");
        h.b(obj, "object");
        return h.a(obj, view);
    }

    public final void a(int i) {
        int b2;
        for (VideoView videoView : this.f23706c) {
            b2 = kotlin.collections.g.b(this.f23706c, videoView);
            if (b2 == i) {
                if (videoView != null) {
                    videoView.start();
                }
            } else if (videoView != null) {
                videoView.pause();
            }
        }
    }

    private final void a(Context context, int i, String str) throws Exception {
        a(context, context.getResources().openRawResource(i), str);
    }

    private final void a(Context context, InputStream inputStream, String str) throws Exception {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[1024];
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            while (inputStream != null) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            inputStream.close();
                            return;
                        } else {
                            h.a();
                            throw null;
                        }
                    }
                    if (fileOutputStream == null) {
                        h.a();
                        throw null;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (Exception e2) {
                    e = e2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                            throw e;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
            h.a();
            throw null;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        }
    }
}
