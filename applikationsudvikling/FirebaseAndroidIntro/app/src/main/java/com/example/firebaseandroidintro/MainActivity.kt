package com.example.firebaseandroidintro

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseandroidintro.ui.theme.FirebaseAndroidIntroTheme

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.DocumentId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAndroidIntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val db = Firebase.firestore

                    /*val yellowCar = Car("yellow", 6)

                    db.collection("cars")
                        .add(yellowCar)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: $documentReference")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }*/

                    db.collection("cars")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result) {
                                val car = document.toObject(Car::class.java)
                                Log.d(TAG, "${document.id} => ${car}")
                                Log.d(TAG, "${document.id} => ${car.color}")
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(TAG, "Error getting documents.", exception)
                        }
                }
            }
        }
    }
}

data class Car(
    val color: String = "",
    val numberOfWheels: Int = 0,
    @DocumentId var documentId: String? = null
) {}
