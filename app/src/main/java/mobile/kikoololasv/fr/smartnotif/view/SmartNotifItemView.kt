package mobile.kikoololasv.fr.smartnotif.view

import android.content.res.ColorStateList
import android.graphics.Typeface.ITALIC
import android.view.Gravity
import android.view.ViewGroup
import mobile.kikoololasv.fr.smartnotif.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView


class SmartNotifItemView : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        val attrs = intArrayOf(android.R.attr.selectableItemBackground /* index 0 */)
        val ta = ui.ctx.obtainStyledAttributes(attrs)
        val drawableFromTheme = ta.getDrawable(0 /* index */)
        ta.recycle()

        verticalLayout {
            lparams {
                width = matchParent

            }
            cardView {
                cardElevation = 5f
                cardBackgroundColor = ColorStateList.valueOf(android.R.color.holo_red_dark)
                foreground = drawableFromTheme
                isClickable = true
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