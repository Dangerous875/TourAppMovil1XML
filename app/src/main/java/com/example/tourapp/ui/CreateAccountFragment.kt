package com.example.tourapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.tourapp.R
import com.example.tourapp.data.User
import com.example.tourapp.databinding.FragmentCreateAccountBinding
import com.example.tourapp.kotlin.InvalidValueException
import com.example.tourapp.repositories.UserRepository
import java.time.LocalDate

class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as? AppCompatActivity)?.supportActionBar?.show()
        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - User Registration."

        binding = FragmentCreateAccountBinding.inflate(inflater,container,false)

        binding.Register.setOnClickListener {
            val nickname = binding.nickname.text
            val passFirstEntry = binding.pass1.text
            val passSecondEntry = binding.pass2.text
            val name = binding.name.text
            val surname = binding.surname.text
            try {
                if (nickname.isNotEmpty() && passFirstEntry.isNotEmpty()&& passSecondEntry.isNotEmpty() && name.isNotEmpty() && surname.isNotEmpty()){
                    if(!UserRepository.containUser(nickname.toString())){
                        if (binding.pass1.text.toString() == binding.pass2.text.toString()) {
                            val id = ((Math.random() * 9999) + 1).toLong()
                            val money = 300000.0
                            val todayDate: LocalDate = LocalDate.now()
                            val newUser = User(
                                id,
                                binding.nickname.text.toString(),
                                binding.pass1.text.toString(),
                                binding.name.text.toString(),
                                binding.surname.text.toString(),
                                money,
                                todayDate.toString()
                            )

                            UserRepository.addUser(newUser)
                            Toast.makeText(requireContext(), "Successful Registration", Toast.LENGTH_LONG).show()

                        } else {
                            Toast.makeText(requireContext(), "Password Does Not Match", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(requireContext(), "The user already exists, please choose another username", Toast.LENGTH_LONG).show()
                    }

                } else {
                    throw InvalidValueException()
                }
            }catch (exception : InvalidValueException){
                Toast.makeText(requireContext(), exception.message, Toast.LENGTH_LONG).show()
            }

        }

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_createAccountFragment_to_loginFragment)
            onDestroyView()
        }

        return binding.root
    }


}