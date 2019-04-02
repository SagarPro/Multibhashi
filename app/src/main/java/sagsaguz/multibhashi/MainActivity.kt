package sagsaguz.multibhashi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sagsaguz.multibhashi.R
import sagsaguz.multibhashi.category.CategoryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, CategoryFragment.newInstance(this)).commit()

    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount != 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}
