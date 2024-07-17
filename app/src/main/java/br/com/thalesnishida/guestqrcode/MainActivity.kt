package br.com.thalesnishida.guestqrcode

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGenerate: Button = findViewById(R.id.btnGenerate)
        val etText: EditText = findViewById(R.id.etText)
        val imageCode: ImageView = findViewById(R.id.imageCode)

        btnGenerate.setOnClickListener {
            val textTyped = etText.text.toString().trim()
            val mWrite = MultiFormatWriter()
            try {
                val bitMatrix: BitMatrix = mWrite.encode(textTyped, BarcodeFormat.QR_CODE, 400, 400)
                val mEncoder = BarcodeEncoder()
                val bitmap = mEncoder.createBitmap(bitMatrix)
                imageCode.setImageBitmap(bitmap)
                val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(etText.applicationWindowToken, 0)
            } catch (e: Exception) {
                println(e)
            }

        }

    }
}