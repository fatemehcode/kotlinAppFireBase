package com.example.kotlinappfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinappfirebase.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener(){
            val intent= Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{
            val txtEmail=binding.txtEmail.text.toString()
            val txtPass=binding.txtPass.text.toString()

            if (txtEmail.isNotEmpty() && txtPass.isNotEmpty()){firebaseAuth.signInWithEmailAndPassword(txtEmail,txtPass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"error", Toast.LENGTH_LONG).show()}
                } }
            else{Toast.makeText(this,"Pleas Fill All Fields", Toast.LENGTH_LONG).show()}
        }
    }
}