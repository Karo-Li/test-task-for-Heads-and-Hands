package game.npc_and_player

class Monster : Entities() {    // класс, определяющий монстра

    fun monster_random_or_no(p_att: Int, p_sh: Int, p_heal: Int){
        println("Ты хочешь,чтобы Ра́ндом определил твоего противника? Если нет, он будет равным тебе")
        Thread.sleep(1000)
        println("Да или нет, друг мой")
        val yes = readln()
        if (agree_list.contains(yes)) {
            attack = god_is_Random()
            shield = god_is_Random()
            health =god_is_Random()
            println("Характеристики твоего противника:")
            println()
            Thread.sleep(500)
            println("Его атака: ${attack}")
            Thread.sleep(500)
            println("Его защита: ${shield}")
            Thread.sleep(500)
            println("И его здоровье: ${health}")
            Thread.sleep(500)
            println()

        }else {
            attack = p_att
            shield = p_sh
            health = p_heal
            println("Характеристики твоего противника:")
            println()
            Thread.sleep(1000)
            println("Его атака: ${attack}")
            Thread.sleep(1000)
            println("Его защита: ${shield}")
            Thread.sleep(1000)
            println("И его здоровье: ${health}")
            println()
            Thread.sleep(1000)
        }
    }
}