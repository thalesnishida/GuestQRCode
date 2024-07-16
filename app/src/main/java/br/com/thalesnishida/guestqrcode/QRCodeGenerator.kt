package br.com.thalesnishida.guestqrcode

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.nio.file.FileSystems
import java.nio.file.Path

class QRCodeGenerator {

    var qrCodePath = "C:\\Users\\thale\\OneDrive\\Imagens\\QRCode"
    var qrCodeName = "$qrCodePath+nishida-teste-QRCODE.png"

    var qrCodeWriter = QRCodeWriter()
    var bitMatrix: BitMatrix = qrCodeWriter.encode(
        "ID  :" + "2" + "\n" + "FirstName: Thales", BarcodeFormat.QR_CODE, 400, 400
    )
    @RequiresApi(Build.VERSION_CODES.O)
    var path: Path = FileSystems.getDefault().getPath(qrCodeName);
}