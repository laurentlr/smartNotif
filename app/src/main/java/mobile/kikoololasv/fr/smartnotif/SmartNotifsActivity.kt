package mobile.kikoololasv.fr.smartnotif

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SmartNotifsActivity : AppCompatActivity(), SmartNotifsView {
    override fun displaySmartNotifs(smartNotifsViewModel: List<SmartNotifViewModel>) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_notifs)
        //smartNotifsRecyclerView.adapter = SmartNotifsAdapter()


        val presenter = SmartNotifsPresenter(this)
        presenter.getSmartNotifs()

    }

}

/*class SmartNotifsAdapter : RecyclerView.Adapter<SmartNotifsAdapter.SmartNotifsVH>() {
    override fun onBindViewHolder(holder: SmartNotifsVH?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SmartNotifsVH? {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SmartNotifsVH(layoutInflater.inflate(R.layout.main_item, parent, false))
    }


    override fun getItemCount(): Int {
    }

    class SmartNotifsVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.card
        val container = itemView.container
        val title = itemView.title
        val date = itemView.date
    }
}*/


