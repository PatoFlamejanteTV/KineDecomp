package com.nexstreaming.kinemaster.ui.audiobrowser;

import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public enum AudioCategory {
    SFX(R.string.amediabrowser_category_sfx, 0),
    THEME(R.string.amediabrowser_category_theme, R.drawable.amedia_theme_icon),
    RECORDED(R.string.amediabrowser_category_recorded, R.drawable.amedia_recorded_icon),
    SONGS(R.string.amediabrowser_category_songs, R.drawable.amedia_songs_icon),
    ALBUMS(R.string.amediabrowser_category_albums, R.drawable.amedia_albums_icon),
    ARTISTS(R.string.amediabrowser_category_artists, R.drawable.amedia_artists_icon),
    GENRES(R.string.amediabrowser_category_genres, R.drawable.amedia_genres_icon),
    FOLDER(R.string.amediabrowser_category_folder, R.drawable.amedia_folder_icon);

    public final int icon_id;
    public final int label_id;
    private WeakReference<m> listerRef;
    public static final AudioCategory[] ALL_UI_CATEGORIES = {THEME, RECORDED, SONGS, ALBUMS, ARTISTS, GENRES, FOLDER};

    AudioCategory(int i, int i2) {
        this.label_id = i;
        this.icon_id = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m getLister() {
        m mVar;
        if (this.listerRef == null || (mVar = this.listerRef.get()) == null) {
            mVar = null;
            switch (this) {
                case SONGS:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.j();
                    break;
                case ALBUMS:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.a();
                    break;
                case FOLDER:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.c();
                    break;
                case ARTISTS:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.b();
                    break;
                case GENRES:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.e();
                    break;
                case RECORDED:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.i();
                    break;
                case THEME:
                    mVar = new com.nexstreaming.kinemaster.ui.audiobrowser.a.k();
                    break;
            }
            this.listerRef = new WeakReference<>(mVar);
        }
        return mVar;
    }
}
