package game.print

import game.npc_and_player.Entities

 class Prints() :Entities(){        // здесь большие либо многократно используемые текстовые выдержки


     fun rules(){
         println("Как ты заметил, иногда тебе нужно будет отвечать 'да' или 'нет'")
         Thread.sleep(1500)
         println("Если захочешь ответить да - нужно будет прописать именно это.")
         Thread.sleep(1500)
         println("Все остальное будет засчитано за 'нет'.")
         Thread.sleep(1500)
         println("Сейчас тебе нужно ввести свои характеристики или положиться на волю Ра́ндома.")
         Thread.sleep(1500)
         println("Из твоих характеристик тебе не понадобится только 'атака'")
         Thread.sleep(1500)
         println("Лишь одному Создателю известно, для чего она...")
         Thread.sleep(2000)
         println("После определения ваших с противником характеристик, начнется бой.")
         Thread.sleep(1500)
         println("Бой происходит после подбрасывания игральных кубиков. Ты их не увидишь ;)")
         Thread.sleep(1500)
         println("(Но я покажу тебе, что на них выпало)")
         Thread.sleep(1500)
         println("Наверно, ты хочешь узнать, как определяется число кубиков? Да?")
         val yes = readln()
         Thread.sleep(600)
         if (agree_list.contains(yes)) println("Тогда смотри в код, умник")
         else println("Ну.. нет, так нет")
         Thread.sleep(1500)
         println("Если хотя бы на одном кубике выпадает 5 или 6 - то кто-то из вас сможет сделать удар.")
         Thread.sleep(1500)
         println("Урон от удара будет случайным, но не больше 10, чтоб игра не закончилась слишком быстро.")
         Thread.sleep(1500)
         println("Если у тебя закончится защита и ты потратишь здоровье - то сможешь подлечиться.")
         Thread.sleep(1500)
         println("Но не больше 3-ех раз. Не факт, что это тебе поможет :)")
         Thread.sleep(1500)
         println("Кто быстрее обнулит здоровье соперника - тот победил.")
         Thread.sleep(1500)
         println("Что ж, теперь ты знаешь. Начинаем.")
         println()
         Thread.sleep(1500)
     }

    fun over_heal(){
        println("Упс, но ты больше не можешь :)")
        Thread.sleep(600)
        println("У тебя закончились хилки")
    }

    fun the_enemy_dodged(){
        println()
        Thread.sleep(400)
        println("Противник увернулся от удара")
        Thread.sleep(600)
        println("...")
        Thread.sleep(500)
        println("Лузер")
        println()
    }

    fun fight_begin(){
        println("ДА НАЧНЕТСЯ БОЙ!")
        println()
        Thread.sleep(1000)
        println("<Встряхиваем стаканчик с кубиками>")
        Thread.sleep(1000)
        println("Все готовы? Начинаем бросать")
        println()
        Thread.sleep(300)
    }

    fun random_fight_or_no(n: String){
        println("$n, ты хочешь случайную очередность боя?")
        Thread.sleep(1000)
        println("Сначала кое-что объясню, мой воин, но только потому, что ты мне нравишься")
        Thread.sleep(1000)
        println("Если выберешь случайную очередность - она будет случайной до конца всего боя")
        Thread.sleep(1000)
        println("А теперь дай четкий ответ, о рыцарь, да или нет?")
    }

}