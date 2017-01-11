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

    lateinit private var smartNotifRecyclerView: RecyclerView

    lateinit private var adapter: SmartNotifsAdapter

    lateinit private var smartNotifAdapter: SmartNotifsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //var smartNotifs = listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1482239496000L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)), SmartNotif(title = "Go buy Omelette du fromage 2", creationDate = 1482239496000L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)))

        smartNotifAdapter = SmartNotifsAdapter()
        frameLayout {
            lparams {
                width = matchParent
                height = matchParent
                bottomMargin = dip(10)
                topMargin = dip(10)
            }
            smartNotifRecyclerView = recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = smartNotifAdapter


            }
        }

        presenter = SmartNotifsPresenter(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.getSmartNotifs()

    }

    override fun displaySmartNotifs(smartNotifsViewModel: List<SmartNotifViewModel>) {
        smartNotifAdapter.putData(smartNotifsViewModel)
    }

}

class SmartNotifsAdapter : RecyclerView.Adapter<SmartNotifViewHolder>() {
    private var smartNotifsViewmodel: List<SmartNotifViewModel> = emptyList()

    fun putData(smartNotifs: List<SmartNotifViewModel>) {
        smartNotifsViewmodel = smartNotifs
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SmartNotifViewHolder, position: Int) = holder.bind(smartNotifsViewmodel.get(position))

    override fun getItemCount() = smartNotifsViewmodel.count()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = SmartNotifViewHolder(SmartNotifItemView().createView(AnkoContext.create(parent!!.context, parent)))


}


