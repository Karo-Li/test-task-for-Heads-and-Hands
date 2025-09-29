package game.npc_and_player

import game.print.Prints

class Player : Entities() {      // класс, определяющий игрока

    fun i_know_rules(){
        var prints = Prints()
        println("Хочешь для начала узнать правила игры?")

        val yes = readln()
        if (agree_list.contains(yes)) prints.rules()
        else println("Тогда начинаем")
    }
    fun begin() {
        println("Кто ты, воин? Назовись!")
        name = readln()
        i_know_rules()
        println("О, великий рыцарь $name, тебе нужно ввести свои характеристики: свою силу, свою защиту и сколько у тебя жизней ")
        Thread.sleep(400)
        println("Или хочешь оставить это на волю Бога Ра́ндома? Да или нет?")
        val agreement = readln()
        if (agree_list.contains(agreement)) {
            attack = god_is_Random()
            shield = god_is_Random()
            health = god_is_Random()


            println("Смелый ты, однако")
            Thread.sleep(1000)
            println("Твоя атака: ${attack}")
            Thread.sleep(1000)
            println("Твоя защита: ${shield}")
            Thread.sleep(1000)
            println("Твои жизни: ${health}")
            println()
        } else {
            println("Тогда вводи сам и помни: нужны целые числа от 1 до 30")
            stats_enter()
            attack = stat_enter_list[0]
            shield = stat_enter_list[1]
            health = stat_enter_list[2]

            println()
        }
    }

    fun stats_enter() {                  // метод ввода самих характеристик
        while (stat_counter <= 2) {
            val stats_list = listOf("атаки", "защиты", "жизней")
            print("Вводи, сколько у тебя ${stats_list[stat_counter]}: ")
            var stat_ent = readln()
            if (stat_ent.toIntOrNull() == null) {            // проверка на корректность ввода
                println("Нет, нет, вводи ЦЕЛОЕ число от 1 до 30, включая 30")
                Thread.sleep(500)
                println("Пробуй еще раз")
                println()
                continue
            } else if (stat_ent.toInt() !in stat_corrected) {
                println("Нет, нет, вводи ЦЕЛОЕ число от 1 до 30, включая 30")
                Thread.sleep(500)
                println("Пробуй еще раз")
                println()
                continue
            } else {
                stat_enter_list.add(stat_ent.toInt())
                stat_counter += 1
            }
        }
    }
}