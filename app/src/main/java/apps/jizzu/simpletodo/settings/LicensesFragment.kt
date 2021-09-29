package apps.jizzu.simpletodo.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment

import apps.jizzu.simpletodo.R

import android.content.Intent.ACTION_VIEW

/**
 * Fragment which contains information about used open source libraries.
 */
class LicensesFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.about_licences)
        addLicenses()
    }

    private fun addLicenses() {
        findPreference("Devop_1").onPreferenceClickListener = createPreferenceClickListener("https://github.com/Kaizu7")
        findPreference("Devop_2").onPreferenceClickListener = createPreferenceClickListener("https://github.com/NAEEMGHADAI")

    }

    private fun createPreferenceClickListener(uriString: String): Preference.OnPreferenceClickListener {
        return Preference.OnPreferenceClickListener {
            val uri = Uri.parse(uriString)
            val intent = Intent(ACTION_VIEW, uri)
            startActivity(intent)
            true
        }
    }
}
