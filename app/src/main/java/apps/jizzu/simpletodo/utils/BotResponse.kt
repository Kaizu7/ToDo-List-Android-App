package apps.jizzu.simpletodo.utils

import apps.jizzu.simpletodo.utils.Constants.OPEN_GOOGLE
import apps.jizzu.simpletodo.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


object BotResponse {
    val random = (0..2).random()
    fun basicResponses(_message: String): String {
        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hello") || message.contains("hii") || message.contains("hi")-> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "How do you do!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            message.contains("how to add new task") || message.contains("how to add new task?") || message.contains("add")-> {
                when (random) {
                    0 -> "Click the + button given on the main screen."
                    1 -> "Click the + blue button"
                    2 -> "Click the +"
                    else -> "error"
                }
            }

            message.contains("how to update task") || message.contains("how to update todo list?") || message.contains("how to update task?") || message.contains("update")-> {
                val random1 = 0
                when (random1) {
                    0 -> "Just click on the particular task,edit and click on update task."

                    else -> "error"
                }
            }


            message.contains("how to delete task") || message.contains("how to delete todo list?") || message.contains("how to delete task?") || message.contains("delete") -> {
                val random1 = 0
                when (random1) {
                    0 -> "Just click on the particular task,and on the right corner click on dustbin icon"

                    else -> "error"
                }
            }
            message.contains("extra features") || message.contains("extra feature")-> {
                val random1 = 0
                when (random1) {
                    0 -> "You can add remainder to your task while creating it by " +
                            "clicking on set reminder."

                    else -> "error"
                }
            }


            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}


