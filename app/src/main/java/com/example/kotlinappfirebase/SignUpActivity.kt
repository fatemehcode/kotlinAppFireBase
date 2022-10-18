package com.example.kotlinappfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinappfirebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity(){

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView2.setOnClickListener(){
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignIn.setOnClickListener{
            val txtEmail=binding.txtEmailInpit.text.toString()
            val txtPass=binding.txtPass.text.toString()
            val txtPass2=binding.txtPass2.text.toString()
            if (txtEmail.isNotEmpty() && txtPass.isNotEmpty() && txtPass2.isNotEmpty()){
                if(txtPass==txtPass2){
                    firebaseAuth.createUserWithEmailAndPassword(txtEmail,txtPass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent=Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                        }
                        else{Toast.makeText(this,"error",Toast.LENGTH_LONG).show()}
                    }
                    Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
                    }else{Toast.makeText(this,"Password is not matching",Toast.LENGTH_LONG).show()}
            }else{Toast.makeText(this,"Pleas Fill All Fields",Toast.LENGTH_LONG).show()}
            }
        }
    }
