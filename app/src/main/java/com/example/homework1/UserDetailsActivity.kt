package com.example.homework1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework1.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Person", Person::class.java) as Person
        } else {
            intent.getSerializableExtra("Person") as Person
        }

        with(binding) {
            firstName.text = getString(R.string.first_name_format, person.firstName)
            lastName.text = person.lastName
            dateOfBirth.text = person.dateOfBirth
            login.text = person.login
            password.text = person.password
        }
    }
}