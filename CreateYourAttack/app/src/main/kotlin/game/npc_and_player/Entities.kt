package game.npc_and_player

import game.main_and_methods.Methods
import game.print.Prints

open class Entities(): Methods() {      // класс, определяющий действия всех существ

    fun heal(plus_heal: Int, plus_aura: Int, max: Int): Int {   // функция лечения
        val prints = Prints()
        if (plus_aura == 4){
            prints.over_heal()
            return plus_heal
        }
        result_heal += (result_heal * 0.3).toInt()  // Сама формула лечения
        println("<Здоровье увеличено на 30%>")
        if (result_heal > max) {
            println("Здоровье увеличено до максимального!")
            result_heal = max
        }
        return result_heal
    }

    fun who_hits_round_player(name: String, m_heal: Int, m_sh: Int, p_att: Int): MutableList<Int> { // метод, определяющий ход игрока
        val prints = Prints()
        println()
        println("-".repeat(55))
        println("РАУНД $round")
        println("Ход за тобой, $name!!")
        println()
        round += 1
        fight(m_heal, m_sh, p_att)
        if (char_list_result_monstr[0] == result_heal && char_list_result_monstr[1] == result_shield){
            prints.the_enemy_dodged()
            println("У противника осталось здоровья: $result_heal")
            println("У противника осталось защиты: $result_shield")
            Thread.sleep(2000)
            return char_list_result_monstr
        }else {
            char_list_result_monstr[0] = result_heal
            char_list_result_monstr[1] = result_shield
            println("У противника осталось здоровья: $result_heal")
            println("У противника осталось защиты: $result_shield")
            println()
            Thread.sleep(2000)
        }
        if (result_heal != 0) return char_list_result_monstr
        println("$name, ты победил!")
        return char_list_result_monstr
    }


  fun who_hits_round_monster(p_heal: Int, p_sh: Int, m_att: Int): MutableList<Int>{ // метод, определяющий ход монстра
        max_heal = p_heal
        println()
        println("-".repeat(55))
        println("РАУНД $round")
        println("Ходит противник. Удачи.")
        println()
        round ++
        fight(p_heal,p_sh, m_att)
        if (char_list_result_player[0] == result_heal && char_list_result_player[1] == result_shield) {
            println("Тебе повезло, противник не смог тебя атаковать")
            println()
            println("У тебя осталось здоровья: $result_heal")
            println("У тебя осталось защиты: $result_shield")
            println()
            Thread.sleep(2000)
            return char_list_result_player
        } else{
            char_list_result_player[0] = result_heal
            char_list_result_player[1] = result_shield
            println("У тебя осталось здоровья: $result_heal")
            println("У тебя осталось защиты: $result_shield")
            println()
            Thread.sleep(2000)
        }
        if (result_heal == 0) {
            println("Ты проиграл...")
            return char_list_result_player
        }
        if (result_shield == 0 && result_heal < max_heal) {
            println("Ты хочешь подлечиться?")
            val yes = readln()
            if (agree_list.contains(yes)) {
                char_list_result_player[0] = heal(result_heal, plus_aura, max_heal)
                Thread.sleep(500)
                plus_aura ++
                println()
                Thread.sleep(500)
                println("У тебя осталось здоровья: $result_heal")
                println("У тебя осталось защиты: $result_shield")
                println()
                Thread.sleep(2000)
            }
        }
        return char_list_result_player
    }

    fun fight( heal: Int, shield: Int, attack_mon: Int) {       // метод боя
        val prints = Prints()
        prints.fight_begin()
        var cubs = (attack_mon - shield) + 1  // Формула модификатора атаки
            if(cubs <= 0) cubs = 1
        Thread.sleep(1000)
        println("Выпало кубиков: $cubs")
        var cube_list = ArrayList<Int>()
        var cube_count = 0
        println("На кубиках выпало: ")
        while (cubs > 0) {
            val cube_rand = (1..6).random()
            cube_list.add(cube_rand)
            cubs--
        }
        for (i in cube_list)
            if (cube_count == cube_list.count() - 1)
                println("$i")
            else {
                print("$i, ")
                Thread.sleep(300)
                cube_count ++
            }

        if (cube_list.contains(5) || cube_list.contains(6)){
            println("Удар успешен!!")
            val dam_rand = damage.random()
            Thread.sleep(400)
            println("Оо, нанесен урон! Целых $dam_rand единиц!")
            println()
            if (shield > 0) {
                result_shield = shield - dam_rand
                result_heal = heal
                if (result_shield <= 0){
                    result_heal = heal + result_shield
                    result_shield = 0
                    }
            }else {
                result_heal = heal - dam_rand
                if (result_heal <  0) result_heal = 0
                result_shield = 0
            }
        }else{
            result_heal = heal
            result_shield = shield
        }
    }

    fun who_hits(name: String, p_att: Int, p_sh: Int, p_heal: Int, m_att: Int, m_sh: Int, m_heal: Int){     // очередность ходов
        val prints = Prints()
        char_list_result_monstr[0] = m_heal
        char_list_result_player[0]= p_heal
        char_list_result_player[1] = p_sh
        char_list_result_monstr[1] = m_sh
        prints.random_fight_or_no(name)
        val yes = readln()
        if (agree_list.contains(yes)) {
            println("Да поможет тебе Ра́ндом")
            println()
            while (result_heal > 0) {
                val rand = (1..2).random()
                if (rand == 1) {
                   who_hits_round_player(name, char_list_result_monstr[0], char_list_result_monstr[1], p_att)
                } else {
                   who_hits_round_monster(char_list_result_player[0], char_list_result_player[1], m_att)
                }
            }
        }else {
            println("Ты хочешь ходить первым?")
            val yes = readln()
            if (agree_list.contains(yes)){
                var rand = 1
                while (result_heal > 0){
                    if (rand == 1){
                       who_hits_round_player(name, char_list_result_monstr[0], char_list_result_monstr[1], p_att)
                        rand ++
                    } else {
                        who_hits_round_monster(char_list_result_player[0], char_list_result_player[1], m_att)
                        rand --
                    }
                }
            }else{
                var rand = 2
                while (result_heal > 0){
                    if (rand == 2){
                        who_hits_round_monster(char_list_result_player[0], char_list_result_player[1], m_att)
                        rand --
                    } else {
                        who_hits_round_player(name, char_list_result_monstr[0], char_list_result_monstr[1], p_att)
                        rand ++
                    }
                }
            }
        }
    }
}

