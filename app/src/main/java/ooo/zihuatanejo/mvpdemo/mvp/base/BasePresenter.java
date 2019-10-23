package ooo.zihuatanejo.mvpdemo.mvp.base;


public abstract class BasePresenter<V extends BaseView> {
    private V view;

    public V getView() {
        return view;
    }
    //绑定
    void attachView(V view) {
        this.view = view;
    }
    //解绑
    void detachView() {
        view = null;
    }
}
