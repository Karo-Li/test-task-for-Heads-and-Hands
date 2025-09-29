package game.main_and_methods

abstract class Methods {    // класс, хранящий в себе все используемые многоразовые переменные

    var attack = 0    // атака
    var shield = 0    // защита
    var health = 0    // здоровье

    var stat_counter = 0                        // - количество введенных статов с клавиатуры
    var stat_enter_list = ArrayList<Int>()      // - лист для ввода статов игрока
    val stat_corrected = (1..30)          // - диапазон для проверки на корректность введенных с клавиатуры статов

    var char_list_result_monstr = mutableListOf(0, 0)        // - массивы для сохранения в них характеристик при их изменении
    var char_list_result_player = mutableListOf(0, 0)        //

    var result_heal = 1             // -
    var result_shield = 1           // - эти 2 нужны для взаимозамены значений в характеристиках при их изменении
    var damage = (1..10)     // - урон
    var plus_aura = 0               // - количество использованных возможностей, чтоб подлечиться

    var round = 1                   // - номер раунда

    var max_heal = 0               // максимальное здоровье игрока
    val agree_list = listOf("Да", "да", "ДА", "дА", "lf", "Lf", "lF", "LF") // - лист согласия
    lateinit var name: String       // имя игрока


    fun god_is_Random(): Int {              // метод для рандомного определения характеристик
        val rand = (1..30).random()
        return rand
    }


}