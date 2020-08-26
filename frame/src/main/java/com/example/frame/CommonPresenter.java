package com.example.frame;

import android.app.Activity;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class CommonPresenter<V extends ICommonView, M extends ICommonModel> implements ICommonPresenter {
    private SoftReference<V> mView;
    private SoftReference<M> mModel;
    private List<Disposable> mDisposableList;
    private WeakReference<Activity> mActivityWeakReference;

    public CommonPresenter(V pView, M pModel) {
        mView = new SoftReference<>(pView);//软引用包裹，当内存不足的时候确保能够回收，避免内存溢出
        mModel = new SoftReference<>(pModel);
    }

    @Override
    public void getData(int whichApi, Object... pPS) {
        if (mModel != null && mModel.get() != null) mModel.get().getData(this, whichApi, pPS);
    }

    @Override
    public void addObserver(Disposable pDisposable) {
        if (mDisposableList == null) return;
        mDisposableList.add(pDisposable);
    }

    @Override
    public void onSuccess(int whichApi, Object[] pD) {
        if (mView != null && mView.get() != null) mView.get().onSuccess(whichApi, pD);
    }

    @Override
    public void onFailed(int whichApi, Throwable pThrowable) {
        if (mView != null && mView.get() != null) mView.get().onFailed(whichApi, pThrowable);
    }

    public void clear() {
        for (Disposable dis : mDisposableList) {
            if (dis != null && !dis.isDisposed()) dis.dispose();
        }
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        if (mModel != null) {
            mModel.clear();
            mModel = null;
        }

        if (mActivityWeakReference != null) {
            mActivityWeakReference.clear();
            mActivityWeakReference = null;
        }
    }
}
