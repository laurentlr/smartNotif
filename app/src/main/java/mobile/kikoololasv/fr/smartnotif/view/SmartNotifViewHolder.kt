package mobile.kikoololasv.fr.smartnotif.view

import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.text.format.DateUtils.FORMAT_ABBREV_WEEKDAY
import android.view.View
import android.widget.TextView
import mobile.kikoololasv.fr.smartnotif.R
import mobile.kikoololasv.fr.smartnotif.SmartNotifViewModel
import org.jetbrains.anko.find

class SmartNotifViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    var title: TextView = itemView.find(R.id.title)
    var creationDate: TextView = itemView.find(R.id.text)

    fun bind(smartNotifViewModel: SmartNotifViewModel) {
        title.text = smartNotifViewModel.title
        creationDate.text = DateUtils.formatDateTime(itemView.context, smartNotifViewModel.creationDate, FORMAT_ABBREV_WEEKDAY)
    }
}