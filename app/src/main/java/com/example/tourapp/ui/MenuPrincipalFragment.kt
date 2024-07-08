package com.example.tourapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tourapp.R
import com.example.tourapp.databinding.FragmentMenuPrincipalBinding
import com.example.tourapp.repositories.PurchaseRepository
import com.example.tourapp.repositories.UserService


class MenuPrincipalFragment : Fragment() {

    private lateinit var binding: FragmentMenuPrincipalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        binding = FragmentMenuPrincipalBinding.inflate(inflater,container,false)
        val currentUser = UserService.getCurrentUser()
        (activity as? AppCompatActivity)?.supportActionBar?.show()
        (activity as? AppCompatActivity)?.supportActionBar?.title = " Welcome ${ currentUser!!.name} ${ currentUser.surname}"

        val viewAccountMoney = binding.btnAccountMoney
        val selectAndListTourPackage = binding.btnSelectTourPack
        val viewPurchaseHistory = binding.btnHistory
        val logOut = binding.btnLogOut


        selectAndListTourPackage.setOnClickListener{
            findNavController().navigate(R.id.action_menuPrincipalFragment_to_tourPackageListFragment)
        }

        viewPurchaseHistory.setOnClickListener {
            if ((PurchaseRepository.getPurchasesHistoryCurrenUser(UserService.getCurrentUser()!!)).isNotEmpty()) {
                findNavController().navigate(R.id.action_menuPrincipalFragment_to_purchaseHistoryFragment)
            }else{
                Toast.makeText(requireContext(),"It cannot be displayed because your history is empty.", Toast.LENGTH_SHORT).show()
            }
        }

        viewAccountMoney.setOnClickListener{
            findNavController().navigate(R.id.action_menuPrincipalFragment_to_showMoneyCurrentUserFragment)
        }

        logOut.setOnClickListener {
            showExitConfirmationDialog()
        }

        chargeImage()

        inflateMenu()

        return binding.root
    }

    private fun chargeImage() {
        val urlLogoPrincipal = "https://w0.peakpx.com/wallpaper/869/542/HD-wallpaper-world-traver-sky-travel.jpg"
        Glide.with(requireContext())
            .load(urlLogoPrincipal)
            .into(binding.ivWallpaperFondo)
    }

    private fun inflateMenu() {
        val menuHost = requireActivity() as MenuHost

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.userProfile -> {
                        findNavController().navigate(R.id.action_menuPrincipalFragment_to_userProfileFragment)
                        return true
                    }

                    R.id.userMoney -> {
                        findNavController().navigate(R.id.action_menuPrincipalFragment_to_showMoneyCurrentUserFragment)
                        return true
                    }

                    R.id.purchaseHistoryUser -> {
                        if ((PurchaseRepository.getPurchasesHistoryCurrenUser(UserService.getCurrentUser()!!)).isNotEmpty()) {
                            findNavController().navigate(R.id.action_menuPrincipalFragment_to_purchaseHistoryFragment)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "It cannot be displayed because your history is empty.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        return true
                    }

                    R.id.aboutUs -> {
                        findNavController().navigate(R.id.action_menuPrincipalFragment_to_aboutAsFragment)
                        return true
                    }

                    R.id.action_bar_logOut -> {
                        showExitConfirmationDialog()

                        return true
                    }

                    android.R.id.home -> {
                        showExitConfirmationDialog()
                        return true
                    }

                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Confirmar salida")
            .setMessage("¿ Desea volver al Login ?")
            .setPositiveButton("Yes") { _, _ ->
                UserService.setCurrentUser(null)
                findNavController().navigate(R.id.action_menuPrincipalFragment_to_loginFragment)

            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .show()
    }


}