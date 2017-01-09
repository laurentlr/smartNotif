package mobile.kikoololasv.fr.smartnotif

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import javax.inject.Inject

class SmartNotifsActivity : AppCompatActivity(), SmartNotifsView {
    @Inject
    lateinit var presenter: SmartNotifsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_smart_notifs)
        //smartNotifsRecyclerView.adapter = SmartNotifsAdapter()

        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
            }
        }
        //SMApplication.GRAPH.inject(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.getSmartNotifs()

    }

    override fun displaySmartNotifs(smartNotifsViewModel: List<SmartNotifViewModel>) {
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


