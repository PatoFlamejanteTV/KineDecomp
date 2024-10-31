package com.nextreaming.nexeditorui.newproject.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4664a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, View view) {
        this.b = aVar;
        this.f4664a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        WeakReference weakReference;
        Surface a2;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        Context context;
        MediaPlayer mediaPlayer4;
        MediaPlayer mediaPlayer5;
        MediaPlayer mediaPlayer6;
        MediaPlayer mediaPlayer7;
        WeakReference weakReference2;
        MediaPlayer mediaPlayer8;
        MediaPlayer mediaPlayer9;
        MediaPlayer mediaPlayer10;
        MediaPlayer mediaPlayer11;
        MediaPlayer.OnCompletionListener onCompletionListener;
        mediaPlayer = this.b.f;
        if (mediaPlayer == null) {
            this.b.f = new MediaPlayer();
            mediaPlayer11 = this.b.f;
            onCompletionListener = this.b.k;
            mediaPlayer11.setOnCompletionListener(onCompletionListener);
        }
        weakReference = this.b.b;
        if (weakReference != null) {
            weakReference2 = this.b.b;
            View view = (View) weakReference2.get();
            if (view != null) {
                mediaPlayer8 = this.b.f;
                if (mediaPlayer8 != null) {
                    mediaPlayer9 = this.b.f;
                    mediaPlayer9.reset();
                    mediaPlayer10 = this.b.f;
                    mediaPlayer10.setSurface(null);
                }
                view.findViewById(R.id.textView_theme_item_title).setVisibility(0);
                view.findViewById(R.id.imageView_theme_item).setVisibility(0);
                view.findViewById(R.id.textureView_theme_preview).setVisibility(8);
                view.findViewById(R.id.linear_theme_item_button_holder).setVisibility(0);
                this.b.b = null;
                this.b.i = false;
            }
        }
        View view2 = (View) this.f4664a.getParent();
        View view3 = (View) view2.getParent();
        URI e = ((Theme) view3.getTag()).e();
        if (e != null) {
            View findViewById = view3.findViewById(R.id.imageView_theme_item);
            TextureView textureView = (TextureView) view3.findViewById(R.id.textureView_theme_preview);
            textureView.setVisibility(0);
            view2.setVisibility(8);
            a2 = this.b.a(textureView);
            this.b.b = new WeakReference(view3);
            try {
                mediaPlayer2 = this.b.f;
                mediaPlayer2.reset();
                mediaPlayer3 = this.b.f;
                context = this.b.d;
                mediaPlayer3.setDataSource(context, Uri.parse(e.toString()));
                mediaPlayer4 = this.b.f;
                mediaPlayer4.setVolume(0.0f, 0.0f);
                mediaPlayer5 = this.b.f;
                mediaPlayer5.setSurface(a2);
                mediaPlayer6 = this.b.f;
                mediaPlayer6.setOnPreparedListener(new d(this, findViewById, textureView, view2));
                this.b.i = true;
                mediaPlayer7 = this.b.f;
                mediaPlayer7.prepareAsync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
