package com.nexstreaming.kinemaster.ui.audiobrowser;

import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public enum AudioCategory {
    MUSIC_ASSETS(R.string.amediabrowser_category_assets, R.drawable.amedia_music_asset_icon),
    SFX_ASSETS(R.string.amediabrowser_category_sfx, R.drawable.amedia_sfx_asset_icon),
    RECORDED(R.string.amediabrowser_category_recorded, R.drawable.amedia_recorded_icon),
    SONGS(R.string.amediabrowser_category_songs, R.drawable.amedia_songs_icon),
    ALBUMS(R.string.amediabrowser_category_albums, R.drawable.amedia_albums_icon),
    ARTISTS(R.string.amediabrowser_category_artists, R.drawable.amedia_artists_icon),
    GENRES(R.string.amediabrowser_category_genres, R.drawable.amedia_genres_icon),
    FOLDER(R.string.amediabrowser_category_folder, R.drawable.amedia_folder_icon);

    public final int icon_id;
    public final int label_id;
    private WeakReference<t> listerRef;
    public static final AudioCategory[] ALL_UI_CATEGORIES = {MUSIC_ASSETS, SFX_ASSETS, RECORDED, SONGS, ALBUMS, ARTISTS, GENRES, FOLDER};

    AudioCategory(int i, int i2) {
        this.label_id = i;
        this.icon_id = i2;
    }

    public t getLister() {
        t tVar;
        WeakReference<t> weakReference = this.listerRef;
        if (weakReference != null && (tVar = weakReference.get()) != null) {
            return tVar;
        }
        t tVar2 = null;
        switch (r.f21456a[ordinal()]) {
            case 1:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.o();
                break;
            case 2:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.a();
                break;
            case 3:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.i();
                break;
            case 4:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.b();
                break;
            case 5:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.j();
                break;
            case 6:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.n();
                break;
            case 7:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.g(false);
                break;
            case 8:
                tVar2 = new com.nexstreaming.kinemaster.ui.audiobrowser.a.g(true);
                break;
        }
        this.listerRef = new WeakReference<>(tVar2);
        return tVar2;
    }
}
