package com.example.alertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var nom : EditText
    lateinit var prenom : EditText
    lateinit var mail : EditText
    lateinit var btn : Button
    lateinit var btn2 : Button
    lateinit var webV:WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nom = findViewById(R.id.nom)
        prenom = findViewById(R.id.prenom)
        mail = findViewById(R.id.email)
        btn = findViewById(R.id.btn)
        btn2 = findViewById(R.id.btn2)


        btn.setOnClickListener {
            if (nom.text.length == 0 || prenom.text.length == 0 || mail.text.length == 0) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Les champs ne doivent pas être vide")
                builder.setTitle("Error")
                builder.setIcon(android.R.drawable.btn_dialog)
                builder.setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                builder.show()
            }

        }



        val builderP = AlertDialog.Builder(this)
        val dialog = builderP.create()
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog , null)
        val txtView = dialogView.findViewById<TextView>(R.id.message)
        //  txtView.text = R.string.messagewait.toString()
        txtView.setText(R.string.messagewait)
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()} , 5000)

        Toast.makeText(getApplicationContext(), "Hello" , Toast.LENGTH_LONG).show()


        btn2.setOnClickListener {
            val snack = Snackbar.make(it,"This is a simple Snackbar",Snackbar.LENGTH_LONG)
            snack.show()
        }

            webV = findViewById(R.id.webview)
            webV.webViewClient = WebViewClient()
            webV.loadUrl("http://google.com")

    }


}