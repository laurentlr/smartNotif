package mobile.kikoololasv.fr.smartnotif

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_smart_notifs.*

class SmartNotifsActivity : AppCompatActivity() , SmartNotifsView{
    override fun displaySmartNotifs(smartNotifsViewModel: List<SmartNotifViewModel>) {
        textView.text = smartNotifsViewModel[0].title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_notifs)
        val presenter = SmartNotifsPresenter(this)
        presenter.getSmartNotifs()

    }
}
