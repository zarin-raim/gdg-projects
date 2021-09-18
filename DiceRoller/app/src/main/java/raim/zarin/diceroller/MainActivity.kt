package raim.zarin.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            /* // HOW TO SHOW A TOAST
               // 1. Long version
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
               // 2. Shortened version*/
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            rollDice()
        }

        // roll a dice on start
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create a new 6-sided dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Create second 6-sided dice and roll it
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Update the screen with the correct drawable resource
        diceImage.setImageResource(determineResource(diceRoll))
        diceImage2.setImageResource(determineResource(diceRoll2))

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }

    /**
     * Determine which drawable resource ID to use
     */
    private fun determineResource(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
    }
}

/**
 * Dice logic class
 */
class Dice(private val numSides: Int = 6) {
    /**
     * Rolls the dice and returns a result
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
