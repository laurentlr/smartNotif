package mobile.kikoololasv.fr.smartnotif.login

import android.view.View
import com.facebook.login.widget.LoginButton
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by pierrecastex on 14/01/2017.
 */
class LoginButtonCompat : AnkoComponent<LoginButton>  {
    override fun createView(ui: AnkoContext<LoginButton>): View {
        return LoginButton(ui.ctx)
    }
}