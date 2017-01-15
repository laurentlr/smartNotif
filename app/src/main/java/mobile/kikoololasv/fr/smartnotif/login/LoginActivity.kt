package mobile.kikoololasv.fr.smartnotif.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.facebook.login.widget.LoginButton
import com.google.android.gms.common.SignInButton
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.tintedButton
import org.jetbrains.anko.custom.customView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            verticalLayout {
                customView<LoginButton> {}.lparams(height = dip(100)) { margin = dip(10) }
                customView<SignInButton> {}.lparams(width = matchParent) { margin = dip(10) }

                textView("ou si vous êtes courageux:").lparams(width = matchParent) {
                    gravity = Gravity.CENTER
                    margin = dip(10)
                }
                tintedButton("inscrivez-vous tout seuls").lparams(width = matchParent) {
                    margin = dip(10)
                }

            }.lparams {
                centerInParent()
                centerHorizontally()
                gravity = Gravity.CENTER_HORIZONTAL
            }
        }
    }
}
