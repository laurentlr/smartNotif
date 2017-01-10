package mobile.kikoololasv.fr.smartnotif.view

import android.content.res.ColorStateList
import android.graphics.Typeface.ITALIC
import android.text.TextUtils
import android.view.Gravity
import android.view.ViewGroup
import mobile.kikoololasv.fr.smartnotif.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class SmartNotifItemView : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams {
                width = matchParent

            }
            cardView {
                cardElevation = 5f
                cardBackgroundColor = ColorStateList.valueOf(android.R.color.holo_red_dark)
                lparams {
                    width = matchParent
                    margin = dip(10)

                }

                verticalLayout {
                    lparams {
                        padding = dip(10)
                    }
                    textView {
                        lparams {
                            gravity = Gravity.CENTER_VERTICAL
                            weight = 1.0f
                        }
                        id = R.id.title
                        singleLine = true
                        ellipsize = TextUtils.TruncateAt.END
                        textSize = 20f
                    }
                    textView {
                        id = R.id.text
                        textSize = 16f
                        setTypeface(null, ITALIC)

                    }
                }
            }
        }
    }


}