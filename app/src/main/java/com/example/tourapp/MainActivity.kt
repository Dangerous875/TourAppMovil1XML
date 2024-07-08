package com.example.tourapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tourapp.data.FragmentsShowExit
import com.example.tourapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val homeFragment = R.id.loginFragment
    private val exitConfirmationFragmentIds : List<FragmentsShowExit> =
        listOf(
            FragmentsShowExit(R.id.purchasePackageFragment,"¿Desea cancelar la compra ?"),
            FragmentsShowExit(R.id.createAccountFragment,"¿Desea volver al Login?"),
            FragmentsShowExit(R.id.loginFragment,"¿ Desea salir de la aplicación ?"),
            FragmentsShowExit(R.id.menuPrincipalFragment,"¿ Desea volver al Login ?")
        )

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment).navController
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment
        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }


    override fun onSupportNavigateUp(): Boolean {
        val currentDestinationId = navController.currentDestination?.id
        return if (currentDestinationId in exitConfirmationFragmentIds.map { it.fragmentID }){
            val currentFragment = exitConfirmationFragmentIds.find { it.fragmentID == currentDestinationId }
            showExitConfirmationDialog(currentFragment)
            true
        }else{
            navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val currentDestinationId = navController.currentDestination?.id
        return if (keyCode == KeyEvent.KEYCODE_BACK && currentDestinationId in exitConfirmationFragmentIds.map { it.fragmentID }) {
            val currentFragment = exitConfirmationFragmentIds.find { it.fragmentID == currentDestinationId }
            showExitConfirmationDialog(currentFragment)
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    private fun showExitConfirmationDialog(currentFragment: FragmentsShowExit?) {
        AlertDialog.Builder(this)
            .setTitle("Confirmar salida")
            .setMessage(currentFragment!!.message)
            .setPositiveButton("Yes") { _, _ ->
                if(homeFragment==currentFragment.fragmentID){
                    finish()
                }else{
                    navController.navigateUp()
                }
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}