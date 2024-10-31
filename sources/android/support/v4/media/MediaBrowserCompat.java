package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi23;
import android.support.v4.media.MediaBrowserCompatApi26;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";

    /* renamed from: a, reason: collision with root package name */
    static final boolean f1197a = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: b, reason: collision with root package name */
    private final MediaBrowserImpl f1198b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CallbackHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<MediaBrowserServiceCallbackImpl> f1199a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f1200b;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.f1199a = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        void a(Messenger messenger) {
            this.f1200b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f1200b;
            if (weakReference == null || weakReference.get() == null || this.f1199a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            data.setClassLoader(MediaSessionCompat.class.getClassLoader());
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.f1199a.get();
            Messenger messenger = this.f1200b.get();
            try {
                int i = message.what;
                if (i == 1) {
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS));
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ConnectionCallback {

        /* renamed from: a, reason: collision with root package name */
        final Object f1201a;

        /* renamed from: b, reason: collision with root package name */
        ConnectionCallbackInternal f1202b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        /* loaded from: classes.dex */
        private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f1202b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f1202b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f1202b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1201a = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
            } else {
                this.f1201a = null;
            }
        }

        void a(ConnectionCallbackInternal connectionCallbackInternal) {
            this.f1202b = connectionCallbackInternal;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final String f1204d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f1205e;

        /* renamed from: f, reason: collision with root package name */
        private final CustomActionCallback f1206f;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.f1204d = str;
            this.f1205e = bundle;
            this.f1206f = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            CustomActionCallback customActionCallback = this.f1206f;
            if (customActionCallback == null) {
                return;
            }
            if (i == -1) {
                customActionCallback.onError(this.f1204d, this.f1205e, bundle);
                return;
            }
            if (i == 0) {
                customActionCallback.onResult(this.f1204d, this.f1205e, bundle);
                return;
            }
            if (i != 1) {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f1205e + ", resultData=" + bundle + ")");
                return;
            }
            customActionCallback.onProgressUpdate(this.f1204d, this.f1205e, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback {

        /* renamed from: a, reason: collision with root package name */
        final Object f1207a;

        /* loaded from: classes.dex */
        private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            StubApi23() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(String str) {
                ItemCallback.this.onError(str);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(Parcel parcel) {
                if (parcel == null) {
                    ItemCallback.this.onItemLoaded(null);
                    return;
                }
                parcel.setDataPosition(0);
                MediaItem createFromParcel = MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                ItemCallback.this.onItemLoaded(createFromParcel);
            }
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f1207a = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
            } else {
                this.f1207a = null;
            }
        }

        public void onError(String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ItemReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final String f1209d;

        /* renamed from: e, reason: collision with root package name */
        private final ItemCallback f1210e;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.f1209d = str;
            this.f1210e = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                if (parcelable != null && !(parcelable instanceof MediaItem)) {
                    this.f1210e.onError(this.f1209d);
                    return;
                } else {
                    this.f1210e.onItemLoaded((MediaItem) parcelable);
                    return;
                }
            }
            this.f1210e.onError(this.f1209d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String str, Bundle bundle, SearchCallback searchCallback);

        void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback);

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    /* loaded from: classes.dex */
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {

        /* renamed from: a, reason: collision with root package name */
        final Context f1211a;

        /* renamed from: b, reason: collision with root package name */
        protected final Object f1212b;

        /* renamed from: c, reason: collision with root package name */
        protected final Bundle f1213c;

        /* renamed from: d, reason: collision with root package name */
        protected final CallbackHandler f1214d = new CallbackHandler(this);

        /* renamed from: e, reason: collision with root package name */
        private final ArrayMap<String, Subscription> f1215e = new ArrayMap<>();

        /* renamed from: f, reason: collision with root package name */
        protected int f1216f;

        /* renamed from: g, reason: collision with root package name */
        protected ServiceBinderWrapper f1217g;

        /* renamed from: h, reason: collision with root package name */
        protected Messenger f1218h;
        private MediaSessionCompat.Token i;

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.f1211a = context;
            bundle = bundle == null ? new Bundle() : bundle;
            bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.f1213c = new Bundle(bundle);
            connectionCallback.a(this);
            this.f1212b = MediaBrowserCompatApi21.createBrowser(context, componentName, connectionCallback.f1201a, this.f1213c);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.f1217g;
            if (serviceBinderWrapper != null && (messenger = this.f1218h) != null) {
                try {
                    serviceBinderWrapper.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            MediaBrowserCompatApi21.disconnect(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String str, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback != null) {
                if (!MediaBrowserCompatApi21.isConnected(this.f1212b)) {
                    Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                    this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
                if (this.f1217g == null) {
                    this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
                try {
                    this.f1217g.a(str, new ItemReceiver(str, itemCallback, this.f1214d), this.f1218h);
                    return;
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
            }
            throw new IllegalArgumentException("cb is null");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (this.i == null) {
                this.i = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.f1212b));
            }
            return this.i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.f1212b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Bundle extras = MediaBrowserCompatApi21.getExtras(this.f1212b);
            if (extras == null) {
                return;
            }
            this.f1216f = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (binder != null) {
                this.f1217g = new ServiceBinderWrapper(binder, this.f1213c);
                this.f1218h = new Messenger(this.f1214d);
                this.f1214d.a(this.f1218h);
                try {
                    this.f1217g.b(this.f1218h);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (asInterface != null) {
                this.i = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.f1212b), asInterface);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.f1217g = null;
            this.f1218h = null;
            this.i = null;
            this.f1214d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
            if (this.f1218h != messenger) {
                return;
            }
            Subscription subscription = this.f1215e.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.f1197a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(this.f1211a, bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    } else {
                        callback.onChildrenLoaded(str, list);
                        return;
                    }
                }
                if (list == null) {
                    callback.onError(str, bundle);
                } else {
                    callback.onChildrenLoaded(str, list, bundle);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String str, final Bundle bundle, final SearchCallback searchCallback) {
            if (isConnected()) {
                if (this.f1217g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                    this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                        @Override // java.lang.Runnable
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
                try {
                    this.f1217g.a(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f1214d), this.f1218h);
                    return;
                } catch (RemoteException e2) {
                    Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e2);
                    this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                        @Override // java.lang.Runnable
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String str, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (isConnected()) {
                if (this.f1217g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                            @Override // java.lang.Runnable
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                    }
                }
                try {
                    this.f1217g.b(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f1214d), this.f1218h);
                    return;
                } catch (RemoteException e2) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e2);
                    if (customActionCallback != null) {
                        this.f1214d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                            @Override // java.lang.Runnable
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f1215e.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.f1215e.put(str, subscription);
            }
            subscriptionCallback.a(subscription);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(this.f1211a, bundle2, subscriptionCallback);
            ServiceBinderWrapper serviceBinderWrapper = this.f1217g;
            if (serviceBinderWrapper == null) {
                MediaBrowserCompatApi21.subscribe(this.f1212b, str, subscriptionCallback.f1283a);
                return;
            }
            try {
                serviceBinderWrapper.a(str, subscriptionCallback.f1284b, bundle2, this.f1218h);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f1215e.get(str);
            if (subscription == null) {
                return;
            }
            ServiceBinderWrapper serviceBinderWrapper = this.f1217g;
            if (serviceBinderWrapper != null) {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.a(str, (IBinder) null, this.f1218h);
                    } else {
                        List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                        List<Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == subscriptionCallback) {
                                this.f1217g.a(str, subscriptionCallback.f1284b, this.f1218h);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else if (subscriptionCallback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.f1212b, str);
            } else {
                List<SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                List<Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == subscriptionCallback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    MediaBrowserCompatApi21.unsubscribe(this.f1212b, str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.f1215e.remove(str);
            }
        }
    }

    /* loaded from: classes.dex */
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String str, ItemCallback itemCallback) {
            if (this.f1217g == null) {
                MediaBrowserCompatApi23.getItem(this.f1212b, str, itemCallback.f1207a);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    /* loaded from: classes.dex */
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (this.f1217g != null && this.f1216f >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                MediaBrowserCompatApi21.subscribe(this.f1212b, str, subscriptionCallback.f1283a);
            } else {
                MediaBrowserCompatApi26.subscribe(this.f1212b, str, bundle, subscriptionCallback.f1283a);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            if (this.f1217g != null && this.f1216f >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.f1212b, str);
            } else {
                MediaBrowserCompatApi26.unsubscribe(this.f1212b, str, subscriptionCallback.f1283a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* renamed from: a, reason: collision with root package name */
        final Context f1244a;

        /* renamed from: b, reason: collision with root package name */
        final ComponentName f1245b;

        /* renamed from: c, reason: collision with root package name */
        final ConnectionCallback f1246c;

        /* renamed from: d, reason: collision with root package name */
        final Bundle f1247d;

        /* renamed from: e, reason: collision with root package name */
        final CallbackHandler f1248e = new CallbackHandler(this);

        /* renamed from: f, reason: collision with root package name */
        private final ArrayMap<String, Subscription> f1249f = new ArrayMap<>();

        /* renamed from: g, reason: collision with root package name */
        int f1250g = 1;

        /* renamed from: h, reason: collision with root package name */
        MediaServiceConnection f1251h;
        ServiceBinderWrapper i;
        Messenger j;
        private String k;
        private MediaSessionCompat.Token l;
        private Bundle m;

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback != null) {
                this.f1244a = context;
                this.f1245b = componentName;
                this.f1246c = connectionCallback;
                this.f1247d = bundle == null ? null : new Bundle(bundle);
                return;
            }
            throw new IllegalArgumentException("connection callback must not be null");
        }

        private static String a(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i;
        }

        void b() {
            MediaServiceConnection mediaServiceConnection = this.f1251h;
            if (mediaServiceConnection != null) {
                this.f1244a.unbindService(mediaServiceConnection);
            }
            this.f1250g = 1;
            this.f1251h = null;
            this.i = null;
            this.j = null;
            this.f1248e.a(null);
            this.k = null;
            this.l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i = this.f1250g;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f1250g) + ")");
            }
            this.f1250g = 2;
            this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    if (mediaBrowserImplBase.f1250g == 0) {
                        return;
                    }
                    mediaBrowserImplBase.f1250g = 2;
                    if (MediaBrowserCompat.f1197a && mediaBrowserImplBase.f1251h != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.f1251h);
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    if (mediaBrowserImplBase2.i == null) {
                        if (mediaBrowserImplBase2.j == null) {
                            Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                            intent.setComponent(MediaBrowserImplBase.this.f1245b);
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.f1251h = new MediaServiceConnection();
                            boolean z = false;
                            try {
                                z = MediaBrowserImplBase.this.f1244a.bindService(intent, MediaBrowserImplBase.this.f1251h, 1);
                            } catch (Exception unused) {
                                Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserImplBase.this.f1245b);
                            }
                            if (!z) {
                                MediaBrowserImplBase.this.b();
                                MediaBrowserImplBase.this.f1246c.onConnectionFailed();
                            }
                            if (MediaBrowserCompat.f1197a) {
                                Log.d("MediaBrowserCompat", "connect...");
                                MediaBrowserImplBase.this.a();
                                return;
                            }
                            return;
                        }
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.j);
                    }
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.i);
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.f1250g = 0;
            this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.j;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.i.a(messenger);
                        } catch (RemoteException unused) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f1245b);
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i = mediaBrowserImplBase2.f1250g;
                    mediaBrowserImplBase2.b();
                    if (i != 0) {
                        MediaBrowserImplBase.this.f1250g = i;
                    }
                    if (MediaBrowserCompat.f1197a) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.a();
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            if (isConnected()) {
                return this.m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + a(this.f1250g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String str, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback != null) {
                if (!isConnected()) {
                    Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                    this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
                try {
                    this.i.a(str, new ItemReceiver(str, itemCallback, this.f1248e), this.j);
                    return;
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                    return;
                }
            }
            throw new IllegalArgumentException("cb is null");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            if (isConnected()) {
                return this.k;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + a(this.f1250g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.f1245b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f1250g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f1250g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.f1250g == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f1245b);
            if (a(messenger, "onConnectFailed")) {
                if (this.f1250g != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f1250g) + "... ignoring");
                    return;
                }
                b();
                this.f1246c.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f1197a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f1245b + " id=" + str);
                }
                Subscription subscription = this.f1249f.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.f1197a) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback callback = subscription.getCallback(this.f1244a, bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        } else {
                            callback.onChildrenLoaded(str, list);
                            return;
                        }
                    }
                    if (list == null) {
                        callback.onError(str, bundle);
                    } else {
                        callback.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.f1250g != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f1250g) + "... ignoring");
                    return;
                }
                this.k = str;
                this.l = token;
                this.m = bundle;
                this.f1250g = 3;
                if (MediaBrowserCompat.f1197a) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    a();
                }
                this.f1246c.onConnected();
                try {
                    for (Map.Entry<String, Subscription> entry : this.f1249f.entrySet()) {
                        String key = entry.getKey();
                        Subscription value = entry.getValue();
                        List<SubscriptionCallback> callbacks = value.getCallbacks();
                        List<Bundle> optionsList = value.getOptionsList();
                        for (int i = 0; i < callbacks.size(); i++) {
                            this.i.a(key, callbacks.get(i).f1284b, optionsList.get(i), this.j);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String str, final Bundle bundle, final SearchCallback searchCallback) {
            if (isConnected()) {
                try {
                    this.i.a(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f1248e), this.j);
                    return;
                } catch (RemoteException e2) {
                    Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e2);
                    this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                        @Override // java.lang.Runnable
                        public void run() {
                            searchCallback.onError(str, bundle);
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("search() called while not connected (state=" + a(this.f1250g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String str, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (isConnected()) {
                try {
                    this.i.b(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f1248e), this.j);
                    return;
                } catch (RemoteException e2) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e2);
                    if (customActionCallback != null) {
                        this.f1248e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                            @Override // java.lang.Runnable
                            public void run() {
                                customActionCallback.onError(str, bundle, null);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f1249f.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.f1249f.put(str, subscription);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(this.f1244a, bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.i.a(str, subscriptionCallback.f1284b, bundle2, this.j);
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f1249f.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback == null) {
                    if (isConnected()) {
                        this.i.a(str, (IBinder) null, this.j);
                    }
                } else {
                    List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    List<Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.i.a(str, subscriptionCallback.f1284b, this.j);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                }
            } catch (RemoteException unused) {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.f1249f.remove(str);
            }
        }

        private boolean a(Messenger messenger, String str) {
            int i;
            if (this.j == messenger && (i = this.f1250g) != 0 && i != 1) {
                return true;
            }
            int i2 = this.f1250g;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.f1245b + " with mCallbacksMessenger=" + this.j + " this=" + this);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            private void a(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.f1248e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.f1248e.post(runnable);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f1197a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            MediaBrowserImplBase.this.a();
                        }
                        if (MediaServiceConnection.this.a("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.i = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.f1247d);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.j = new Messenger(mediaBrowserImplBase2.f1248e);
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.f1248e.a(mediaBrowserImplBase3.j);
                            MediaBrowserImplBase.this.f1250g = 2;
                            try {
                                if (MediaBrowserCompat.f1197a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.a();
                                }
                                MediaBrowserImplBase.this.i.a(MediaBrowserImplBase.this.f1244a, MediaBrowserImplBase.this.j);
                            } catch (RemoteException unused) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f1245b);
                                if (MediaBrowserCompat.f1197a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.a();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f1197a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.f1251h);
                            MediaBrowserImplBase.this.a();
                        }
                        if (MediaServiceConnection.this.a("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.i = null;
                            mediaBrowserImplBase.j = null;
                            mediaBrowserImplBase.f1248e.a(null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.f1250g = 4;
                            mediaBrowserImplBase2.f1246c.onConnectionSuspended();
                        }
                    }
                });
            }

            boolean a(String str) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.f1251h == this && (i = mediaBrowserImplBase.f1250g) != 0 && i != 1) {
                    return true;
                }
                int i2 = MediaBrowserImplBase.this.f1250g;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + MediaBrowserImplBase.this.f1245b + " with mServiceConnection=" + MediaBrowserImplBase.this.f1251h + " this=" + this);
                return false;
            }
        }

        void a() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f1245b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f1246c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f1247d);
            Log.d("MediaBrowserCompat", "  mState=" + a(this.f1250g));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f1251h);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.i);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.j);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.l);
        }
    }

    /* loaded from: classes.dex */
    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public static abstract class SearchCallback {
        public void onError(String str, Bundle bundle) {
        }

        public void onSearchResult(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final String f1276d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f1277e;

        /* renamed from: f, reason: collision with root package name */
        private final SearchCallback f1278f;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.f1276d = str;
            this.f1277e = bundle;
            this.f1278f = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
                ArrayList arrayList = null;
                if (parcelableArray != null) {
                    arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                }
                this.f1278f.onSearchResult(this.f1276d, this.f1277e, arrayList);
                return;
            }
            this.f1278f.onError(this.f1276d, this.f1277e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Subscription {

        /* renamed from: a, reason: collision with root package name */
        private final List<SubscriptionCallback> f1281a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List<Bundle> f1282b = new ArrayList();

        public SubscriptionCallback getCallback(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.f1282b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f1282b.get(i), bundle)) {
                    return this.f1281a.get(i);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.f1281a;
        }

        public List<Bundle> getOptionsList() {
            return this.f1282b;
        }

        public boolean isEmpty() {
            return this.f1281a.isEmpty();
        }

        public void putCallback(Context context, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.f1282b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f1282b.get(i), bundle)) {
                    this.f1281a.set(i, subscriptionCallback);
                    return;
                }
            }
            this.f1281a.add(subscriptionCallback);
            this.f1282b.add(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SubscriptionCallback {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1283a;

        /* renamed from: b, reason: collision with root package name */
        private final IBinder f1284b = new Binder();

        /* renamed from: c, reason: collision with root package name */
        WeakReference<Subscription> f1285c;

        /* loaded from: classes.dex */
        private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            StubApi21() {
            }

            List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i >= 0 && i2 >= 1 && i3 < list.size()) {
                    if (i4 > list.size()) {
                        i4 = list.size();
                    }
                    return list.subList(i3, i4);
                }
                return Collections.EMPTY_LIST;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(String str, List<?> list) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.f1285c;
                Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                List<Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, a(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        /* loaded from: classes.dex */
        private class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            StubApi26() {
                super();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(String str, List<?> list, Bundle bundle) {
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(String str, Bundle bundle) {
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                this.f1283a = MediaBrowserCompatApi26.a(new StubApi26());
            } else if (i >= 21) {
                this.f1283a = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
            } else {
                this.f1283a = null;
            }
        }

        public void onChildrenLoaded(String str, List<MediaItem> list) {
        }

        public void onChildrenLoaded(String str, List<MediaItem> list, Bundle bundle) {
        }

        public void onError(String str) {
        }

        public void onError(String str, Bundle bundle) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Subscription subscription) {
            this.f1285c = new WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f1198b = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
            return;
        }
        if (i >= 23) {
            this.f1198b = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (i >= 21) {
            this.f1198b = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.f1198b = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.f1198b.connect();
    }

    public void disconnect() {
        this.f1198b.disconnect();
    }

    public Bundle getExtras() {
        return this.f1198b.getExtras();
    }

    public void getItem(String str, ItemCallback itemCallback) {
        this.f1198b.getItem(str, itemCallback);
    }

    public String getRoot() {
        return this.f1198b.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.f1198b.getServiceComponent();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f1198b.getSessionToken();
    }

    public boolean isConnected() {
        return this.f1198b.isConnected();
    }

    public void search(String str, Bundle bundle, SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback != null) {
            this.f1198b.search(str, bundle, searchCallback);
            return;
        }
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.f1198b.sendCustomAction(str, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f1198b.subscribe(str, null, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void unsubscribe(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1198b.unsubscribe(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ServiceBinderWrapper {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f1279a;

        /* renamed from: b, reason: collision with root package name */
        private Bundle f1280b;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.f1279a = new Messenger(iBinder);
            this.f1280b = bundle;
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f1280b);
            a(1, bundle, messenger);
        }

        void b(Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f1280b);
            a(6, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            a(7, (Bundle) null, messenger);
        }

        void b(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            a(9, bundle2, messenger);
        }

        void a(Messenger messenger) throws RemoteException {
            a(2, (Bundle) null, messenger);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            a(3, bundle2, messenger);
        }

        void a(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            a(4, bundle, messenger);
        }

        void a(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            a(5, bundle, messenger);
        }

        void a(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            a(8, bundle2, messenger);
        }

        private void a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f1279a.send(obtain);
        }
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f1198b.unsubscribe(str, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.f1198b.subscribe(str, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;

        /* renamed from: a, reason: collision with root package name */
        private final int f1274a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaDescriptionCompat f1275b;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Flags {
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                    this.f1274a = i;
                    this.f1275b = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(obj)), MediaBrowserCompatApi21.MediaItem.getFlags(obj));
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.f1275b;
        }

        public int getFlags() {
            return this.f1274a;
        }

        public String getMediaId() {
            return this.f1275b.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.f1274a & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.f1274a & 2) != 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f1274a + ", mDescription=" + this.f1275b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1274a);
            this.f1275b.writeToParcel(parcel, i);
        }

        MediaItem(Parcel parcel) {
            this.f1274a = parcel.readInt();
            this.f1275b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
