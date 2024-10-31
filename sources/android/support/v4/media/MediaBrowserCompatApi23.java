package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* loaded from: classes.dex */
class MediaBrowserCompatApi23 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ItemCallback {
        void onError(String str);

        void onItemLoaded(Parcel parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {

        /* renamed from: a */
        protected final T f1290a;

        public ItemCallbackProxy(T t) {
            this.f1290a = t;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            this.f1290a.onError(str);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.f1290a.onItemLoaded(null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.f1290a.onItemLoaded(obtain);
        }
    }

    MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    public static void getItem(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }
}
