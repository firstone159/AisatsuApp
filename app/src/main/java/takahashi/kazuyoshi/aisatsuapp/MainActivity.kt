
package takahashi.kazuyoshi.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                textView.text = "$hour:$minute"
                if (2 <= hour && hour <= 9) {
                    textView.text = "おはよう"
                }
                else if (10 <= hour && hour <= 17) {
                    textView.text = "こんにちわ"
                }
                else {
                    textView.text = "こんばんわ"
                }
            },
            13, 0, true
        )
        timePickerDialog.show()
    }
}


