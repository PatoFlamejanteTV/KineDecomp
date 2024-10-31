package com.nextreaming.nexeditorui.newproject.b;

import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f4666a = aVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        WeakReference weakReference;
        WeakReference weakReference2;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        weakReference = this.f4666a.b;
        if (weakReference != null) {
            weakReference2 = this.f4666a.b;
            View view = (View) weakReference2.get();
            if (view != null) {
                mediaPlayer2 = this.f4666a.f;
                mediaPlayer2.reset();
                mediaPlayer3 = this.f4666a.f;
                mediaPlayer3.setSurface(null);
                TextView textView = (TextView) view.findViewById(R.id.textView_theme_item_title);
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView_theme_item);
                TextureView textureView = (TextureView) view.findViewById(R.id.textureView_theme_preview);
                View findViewById = view.findViewById(R.id.linear_theme_item_button_holder);
                textView.setVisibility(0);
                imageView.setVisibility(0);
                textureView.setVisibility(8);
                findViewById.setVisibility(0);
                this.f4666a.b = null;
                this.f4666a.i = false;
            }
        }
    }
}
