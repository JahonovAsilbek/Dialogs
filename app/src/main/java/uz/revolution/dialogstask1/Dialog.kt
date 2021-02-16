package uz.revolution.dialogstask1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_custom.view.*
import kotlinx.android.synthetic.main.fragment_dialog.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Dialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dialog : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_dialog, container, false)



        root.save.setOnClickListener {

            val email:String = root.ed1.text.toString()
            val password:String = root.ed2.text.toString()

            if (onSaveClick != null) {
                onSaveClick?.onClick("$email $password")
                dismiss()
            }

            Log.d("AAAA", "onfragment: $email")
        }





        return root
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Dialog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private var onSaveClick:OnSaveClick?=null

    interface OnSaveClick{
        fun onClick(str:String)
    }

    fun setOnSaveClick(onSaveClick: OnSaveClick) {
        this.onSaveClick=onSaveClick
    }
}