package mobile.kikoololasv.fr.smartnotif

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import javax.inject.Inject

class SmartNotifsPresenter(var smartNotifsView: SmartNotifsView) : SmartNotifCallBack {

    val cd = CompositeDisposable()

    @Inject
    lateinit var smartNotifUseCase : SmartNotifUseCase

    init {
        GRAPH.injectThat(this)
    }

    override fun onSuccess(smartNotifs: List<SmartNotif<*>>) {

        smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }

    fun getSmartNotifs() {

        val smartNotifs:Observable<List<SmartNotif<*>>> = smartNotifUseCase
                .getSmartNotifs()
        //smartNotifs = Observable.just(listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1484513045753L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L))))
        smartNotifs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : Observer<List<SmartNotif<*>>>{
                    override fun onNext(value: List<SmartNotif<*>>) {
                        onSuccess(value)
                    }

                    override fun onSubscribe(d: Disposable?) {
                        cd.add(d)
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("aa","onError",e);
                    }

                    override fun onComplete() {
                    }

                })
    }

    override fun onError() {

    }

    fun onDestroy(){
        cd.clear()
    }
}
