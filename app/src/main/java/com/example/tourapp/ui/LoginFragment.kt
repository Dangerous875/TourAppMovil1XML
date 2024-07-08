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
import com.example.tourapp.databinding.FragmentLoginBinding
import com.example.tourapp.kotlin.InvalidValueException
import com.example.tourapp.repositories.UserRepository
import com.example.tourapp.repositories.UserService
import com.squareup.picasso.Picasso

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        binding = FragmentLoginBinding.inflate(inflater,container,false)

        presentationApp()

        val registerButton = binding.btnRegister
        val startButton = binding.btnStart

        binding.etNickName.setText("Cris")
        binding.etPassword.setText("0000")


        registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_createAccountFragment)
        }

        startButton.setOnClickListener {
            try {
                val userName = binding.etNickName.text
                val userPassword = binding.etPassword.text
                if (userName.isNotEmpty() && userPassword.isNotEmpty()) {
                    val currentUser = UserRepository.login(userName.toString(), userPassword.toString())
                    if (currentUser != null) {
                        UserService.setCurrentUser(currentUser)
                        Toast.makeText(requireContext(), "Successful login, welcome ${currentUser.nickName} !! ", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_menuPrincipalFragment)
//                        userName.clear()
//                        userPassword.clear()

                    }else{
                        Toast.makeText(requireContext(), "*** ERROR, wrong username or password ***", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    throw InvalidValueException()
                }
            }catch (exception : InvalidValueException){
                Toast.makeText(requireContext(), exception.message, Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root



    }

    private fun presentationApp() {
        val urlLogoPrincipal = "https://w0.peakpx.com/wallpaper/869/542/HD-wallpaper-world-traver-sky-travel.jpg"
        Picasso.get()
            .load(urlLogoPrincipal)
            .into(binding.ivLogoPrincipal)
    }



}



