package uz.revolution.dialogstask1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom.view.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alert.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val alertDialog = dialog.create()

            dialog
                .setTitle("Dialog")
                .setMessage("This is AlertDialog")
                .setPositiveButton("Positive", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        alertDialog.dismiss()
                    }

                })
                .setNegativeButton("Negative", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        alertDialog.dismiss()
                    }

                })
                .setNeutralButton("Neutral", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        alertDialog.dismiss()
                    }

                })
                .show()
        }

        custom.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val alertDialog = dialog.create() as AlertDialog
            alertDialog.setTitle("Custom Dialog")

            val view = layoutInflater.inflate(R.layout.dialog_custom, null, false)

            alertDialog.setView(view)
            alertDialog.show()

            view.ok.setOnClickListener {

                alertDialog.dismiss()
            }

        }

        fragment.setOnClickListener {

            val beginTransaction = supportFragmentManager.beginTransaction()

            val fragment = Dialog.newInstance("Dialog1", "Dialog2")

            fragment.setOnSaveClick(object : Dialog.OnSaveClick {
                override fun onClick(str: String) {
                    Toast.makeText(this@MainActivity, str, Toast.LENGTH_SHORT).show()
                    Log.d("AAAA", "onClick: $str")
                }

            })

            fragment.show(beginTransaction, "dialog1")

        }

        date_picker.setOnClickListener {
            val dialog=DatePickerDialog(this)

            dialog.datePicker.setOnDateChangedListener { datePicker, i, i2, i3 ->
                dialog.dismiss()
                Toast.makeText(this, "$i3.${i2+1}.$i", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }

        time_picker.setOnClickListener {
            val dialog = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@MainActivity, "$p1:$p2", Toast.LENGTH_SHORT).show()
                }

            }, 24, 60, true)

            dialog.updateTime(23,59)

            dialog.show()
        }

        bottom_sheet.setOnClickListener {
            val dialog = BottomSheetDialog(this,R.style.SheetDialog)

            val view = layoutInflater.inflate(R.layout.item_bottom_sheet, null, false)

            dialog.setContentView(view)

            view.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        snackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "SnackBar", Snackbar.LENGTH_LONG)
            snackbar.show()
        }

    }
}