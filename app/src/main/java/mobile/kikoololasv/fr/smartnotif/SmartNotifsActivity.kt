package mobile.kikoololasv.fr.smartnotif

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mobile.kikoololasv.fr.smartnotif.view.SmartNotifItemView
import mobile.kikoololasv.fr.smartnotif.view.SmartNotifViewHolder
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SmartNotifsActivity : AppCompatActivity(), SmartNotifsView {

    lateinit var presenter: SmartNotifsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_smart_notifs)
        //smartNotifsRecyclerView.adapter = SmartNotifsAdapter()


        var smartNotifs = listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1482239496000L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)), SmartNotif(title = "Go buy Omelette du fromage 2", creationDate = 1482239496000L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)))


        frameLayout {
            lparams {
                width = matchParent
                height = matchParent
                bottomMargin = dip(10)
                topMargin = dip(10)
            }
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = SmartNotifsAdapter(smartNotifs)
            }
        }


        presenter = SmartNotifsPresenter(this)
        //SMApplication.GRAPH.inject(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.getSmartNotifs()

    }

    override fun displaySmartNotifs(smartNotifsViewModel: List<SmartNotifViewModel>) {
    }

}

class SmartNotifsAdapter(var smartNotifs: List<SmartNotif<*>>) : RecyclerView.Adapter<SmartNotifViewHolder>() {

    override fun onBindViewHolder(holder: SmartNotifViewHolder?, position: Int) = holder!!.bind(smartNotifs.get(position))

    override fun getItemCount() = smartNotifs.count()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = SmartNotifViewHolder(SmartNotifItemView().createView(AnkoContext.create(parent!!.context, parent)))


}


