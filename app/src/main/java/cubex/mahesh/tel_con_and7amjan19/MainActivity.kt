package cubex.mahesh.tel_con_and7amjan19

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tManager = getSystemService(
            Context.TELEPHONY_SERVICE) as TelephonyManager
        var cManager = getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var list = mutableListOf<String>()
        list.add("IMEI :"+ tManager.imei)
        list.add("Sim Sno :"+ tManager.simSerialNumber)
        list.add("Sim Name :"+ tManager.simOperatorName)
        list.add("Sim Country  :"+ tManager.simCountryIso)
        list.add("Phone Type  :"+ tManager.phoneType)
        if(cManager.activeNetwork == null)
        {
            list.add("Data Enabled : false")
        }else{
            list.add("Data Enabled : true")
        }
        var myadapter = ArrayAdapter<String>(
            this@MainActivity,
            android.R.layout.simple_list_item_single_choice,
            list)
        lview.adapter = myadapter

    }
}
