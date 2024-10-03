package com.example.herman
// Mendefinisikan paket dari aplikasi ini

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herman.ui.theme.HermanTheme
// Mengimpor berbagai library Jetpack Compose yang diperlukan untuk membangun antarmuka pengguna (UI) aplikasi.
// Termasuk library untuk tata letak (layout), gambar (Image), teks (Text), dan tema aplikasi (HermanTheme).

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Menggunakan tema HermanTheme yang didefinisikan di dalam proyek.
            HermanTheme {
                // Surface digunakan sebagai kontainer utama dengan warna latar belakang dari tema.
                Surface(
                    modifier = Modifier.fillMaxSize(), // Mengisi seluruh ukuran layar.
                    color = MaterialTheme.colorScheme.background // Menggunakan warna latar dari tema.
                ) {
                    // Memanggil composable GreetingText untuk menampilkan teks ucapan selamat.
                    GreetingText(
                        message = "Happy Birthday Sam!", // Pesan yang ditampilkan.
                        from = "From Emma" // Tanda tangan pengirim.
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Column untuk menyusun elemen secara vertikal.
    Column(
        verticalArrangement = Arrangement.Center, // Mengatur elemen di tengah secara vertikal.
        modifier = modifier
    ) {
        // Teks utama pesan, dengan ukuran font yang sangat besar.
        Text(
            text = message,
            fontSize = 100.sp, // Ukuran font sebesar 100sp.
            lineHeight = 116.sp, // Jarak antar baris teks.
            textAlign = TextAlign.Center // Mengatur teks agar berada di tengah secara horizontal.
        )
        // Teks tambahan (dari siapa ucapan berasal).
        Text(
            text = from,
            fontSize = 36.sp, // Ukuran font yang lebih kecil untuk pengirim.
            modifier = Modifier
                .padding(16.dp) // Memberikan jarak di sekitar teks.
                .align(alignment = Alignment.CenterHorizontally) // Mengatur teks di tengah secara horizontal.
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Mengambil gambar dari resource drawable.
    val image = painterResource(R.drawable.androidparty)
    // Box digunakan untuk menumpuk elemen secara bebas, memungkinkan gambar dan teks ditampilkan bersama.
    Box(modifier) {
        // Menampilkan gambar dengan contentScale untuk mengisi area dan alpha untuk transparansi.
        Image(
            painter = image,
            contentDescription = null, // Tidak ada deskripsi gambar (null).
            contentScale = ContentScale.Crop, // Menyesuaikan gambar agar mengisi area.
            alpha = 0.5F // Menetapkan transparansi gambar.
        )
        // Menampilkan teks ucapan di atas gambar.
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize() // Mengisi seluruh ukuran layar.
                .padding(8.dp) // Memberikan jarak di sekitar teks.
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Menampilkan pratinjau composable menggunakan tema Herman.
    HermanTheme {
        // Memanggil composable GreetingImage dengan teks dan tanda tangan dari resource string.
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text), // Mengambil teks ucapan dari resource.
            from = stringResource(R.string.signature_text) // Mengambil teks pengirim dari resource.
        )
    }
}

