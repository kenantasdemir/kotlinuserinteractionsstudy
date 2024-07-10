package com.kenant42.kotlinuserinteractionstudy

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar
import com.kenant42.kotlinuserinteractionstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT).show()
        }

        binding.buttonPopupMenu.setOnClickListener {
            val popupMenu = PopupMenu(this@MainActivity, binding.buttonPopupMenu)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.actionEdit -> {
                        Toast.makeText(this@MainActivity, "EDİT clicked", Toast.LENGTH_LONG).show()
                        true
                    }

                    R.id.actionDelete -> {
                        Toast.makeText(this@MainActivity, "DELETE clicked", Toast.LENGTH_LONG)
                            .show()
                        true
                    }

                    else -> false
                }
            }

            popupMenu.show()
        }


        binding.buttonAlertNormal.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@MainActivity)

            alertDialog.setMessage("MESSAGE")
            alertDialog.setTitle("TITLE")
            alertDialog.setIcon(R.drawable.ic_launcher_background)

            alertDialog.setPositiveButton("OK") { dialogInterface, i ->
                Toast.makeText(applicationContext, "OK Button", Toast.LENGTH_LONG).show()
            }

            alertDialog.setNegativeButton("Cancel") { dialogInterface, i ->
                Toast.makeText(applicationContext, "Cancel Button", Toast.LENGTH_LONG).show()
            }
            alertDialog.create().show()

        }

        binding.buttonCustomAlert.setOnClickListener{
            val design = layoutInflater.inflate(R.layout.custom_alert,null)
            val editTextAlert = design.findViewById(R.id.editTextText) as EditText
            val ad = AlertDialog.Builder(this@MainActivity)


            ad.setMessage("MESSAGE")
            ad.setTitle("TITLE")
            ad.setIcon(R.drawable.ic_launcher_background)
            ad.setView(design)

            ad.setPositiveButton("Save") { dialogInterface, i ->
                val editTextData = editTextAlert.text.toString()
                Toast.makeText(applicationContext, "Save Button $editTextData", Toast.LENGTH_LONG).show()
            }

            ad.setNegativeButton("Cancel") { dialogInterface, i ->
                Toast.makeText(applicationContext, "Cancel Button", Toast.LENGTH_LONG).show()
            }
            ad.create().show()
        }


        binding.buttonNormal.setOnClickListener{x->
            Snackbar.make(x,"Snackbar normal ",Snackbar.LENGTH_SHORT).show()
        }

        binding.buttonBack.setOnClickListener{obj->
            Snackbar.make(obj,"Delete messages? ",Snackbar.LENGTH_LONG)
                .setAction("YES"){y->
                        Snackbar.make(y,"Deleting messages...",Snackbar.LENGTH_LONG).show()
                }.show()
        }

        binding.buttonCustomSnackbar.setOnClickListener{z->
val sb = Snackbar.make(z,"NO CONNECTION ",Snackbar.LENGTH_SHORT)
            sb.setAction("RETRY"){

            }
            sb.setActionTextColor(Color.RED)
            sb.setTextColor(Color.BLUE)
            sb.setBackgroundTint(Color.WHITE)

            sb.show()
        }

    }
}