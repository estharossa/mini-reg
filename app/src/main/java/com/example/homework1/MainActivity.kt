package com.example.homework1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            registerBtn.setOnClickListener {
                val firstName = firstName.text.toString()
                val lastName = lastName.text.toString()
                val dateOfBirth = dateOfBirth.text.toString()
                val login = login.text.toString()
                val password = password.text.toString()

                val person = Person(
                    firstName = firstName,
                    lastName = lastName,
                    dateOfBirth = dateOfBirth,
                    login = login,
                    password = password
                )

                if (validate(person)) {
                    val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
                    intent.putExtra("Person", person)
                    startActivity(intent)
                }
            }
        }
    }

    private fun validate(person: Person): Boolean {
        if (person.firstName.isBlank()) {
            binding.firstName.setBackgroundResource(R.drawable.background_edit_text_error_state)
            binding.firstNameValidation.isVisible = true
            return false
        }

        return true
    }
}